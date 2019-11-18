package com.exampleapp.app;

import com.exampleapp.app.db.StudentRepozytory;
import com.exampleapp.app.db.StudentRow;
import  io.vavr.collection.List;
import org.springframework.stereotype.Service;

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
            //return this.students;
            this.repository.findAll();
                 return   List.ofAll(this.repository.findAll())
                         .map(getStudentRowStudentFunction()
                    );
        }

    private Function<StudentRow, Student> getStudentRowStudentFunction() {
        return dbObj->
         new Student(
          dbObj.getId(),
          dbObj.getName(),
           dbObj.getNumber(),
           dbObj.getStdgroup() );
    }


    Student addStudent(final NewStudent newStudent)
        {
          //  Student created = new Student(students.size()+1,newStudent.name, newStudent.number, newStudent.stdgroup);
           // students = students.prepend(created);
            //return created;
            StudentRow created= this.repository.save(new StudentRow(
                    newStudent.name,
                    newStudent.number,
                    newStudent.stdgroup
            ));

            return getStudentRowStudentFunction().apply(created);



            //throw new UnsupportedOperationException();

        }
    }
