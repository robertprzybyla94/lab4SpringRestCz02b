package com.exampleapp.app;

import com.exampleapp.app.db.ScoreRepository;
import com.exampleapp.app.db.ScoreRow;
import com.exampleapp.app.db.StudentRepository;
import com.exampleapp.app.db.StudentRow;
import  io.vavr.collection.List;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class StudentService
{

    private final StudentRepository studentRepository;
    private final ScoreRepository scoreRepository;

    public StudentService(StudentRepository studentRepository, ScoreRepository scoreRepository)
    {
        this.studentRepository = studentRepository;
        this.scoreRepository = scoreRepository;
    }

    List<Student> getStudents()
    {
        this.studentRepository.findAll();
        return   List.ofAll(this.studentRepository.findAll())
                .map((StudentRow::toStudent));
    }

    //private Function<StudentRow, Student> getStudentRowStudentFunction() {
 //       return dbObj->
   //             new Student(
   //                     dbObj.getId(),
   //                     dbObj.getName(),
    //                    dbObj.getNumber(),
   //                     dbObj.getStdgroup());
  //  }

    Student addStudent(final NewStudent newStudent)
    {
        // Student created = new Student(students.size()+1,newStudent.name, newStudent.number, newStudent.stud_group);
        // students = students.prepend(created);
        // return created;
        //throw new UnsupportedOperationException();
        return this.studentRepository.save(new StudentRow
                        (newStudent.name,
                        newStudent.number,
                        newStudent.stdgroup)).toStudent();
    }
    @Transactional
    public Optional <Student> changeNumber(long studentId, String newNumber)
    {
        final Optional<StudentRow> student = this.studentRepository.findById(studentId);
        return student.map(c -> {c.setNumber(newNumber);
        studentRepository.save(c);
        return c.toStudent(); });
    }


    public Optional<Integer> addScore(final long studentId, final Score score) {
        final Optional<StudentRow> student =
                this.studentRepository.findById(studentId);
        return student.map(c->{
            int existingScore=List.ofAll(c.getScores())
                    .foldLeft(0,(p,s)->p+s.getScore());
            final ScoreRow newScore=new ScoreRow(score.score,score.comment,c);
            this.scoreRepository.save(newScore);
            return existingScore+score.score;});}


}
