package com.exampleapp.app;

import com.exampleapp.app.db.StudentRepozytory;
import com.exampleapp.app.db.StudentRow;
import  io.vavr.collection.List;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.function.Function;

@Service
public class StudentService
{

    private final StudentRepozytory repository;

    public StudentService(StudentRepozytory repository)
    {
        this.repository=repository;
    }

    List<Student> getStudents()
    {
        this.repository.findAll();
        return   List.ofAll(this.repository.findAll())
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
        return this.repository.save(new StudentRow
                        (newStudent.name,
                        newStudent.number,
                        newStudent.stdgroup)).toStudent();
    }
    @Transactional
    public Optional <Student> changeNumber(long studentId, String newNumber)
    {
        final Optional<StudentRow> student = this.repository.findById(studentId);
        return student.map(c -> {c.setNumber(newNumber);
        repository.save(c);
        return c.toStudent(); });
    }


}
