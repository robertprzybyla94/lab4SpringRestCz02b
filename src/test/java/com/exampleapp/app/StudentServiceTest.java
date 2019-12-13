
package com.exampleapp.app;
import com.exampleapp.app.db.ScoreRepository;
import com.exampleapp.app.db.StudentRepository;
import org.junit.After;
import org.junit.Test;
import io.vavr.collection.List;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest


public class StudentServiceTest


        {
        @After
        public void cleanAfterTest()
        {
        this.repository.deleteAll();
        }

        @Test
        public void getEmptyList() {
        final StudentService service = new StudentService(repository, scoreRepository);
        List<Student> students = service.getStudents();
        assertTrue(students.isEmpty());
        }

        @Test
        public void addStudent() {
        final StudentService service = new StudentService(repository, scoreRepository);
        final Student created = service.addStudent(new NewStudent(1, "Student1","IP", "1"));
        assertNotNull(created);
        }

        @Test
        public void addStudentIsReturned()
        {
        final StudentService controller = new StudentService(repository, scoreRepository);
        final Student student = controller.addStudent(new NewStudent(1, "TEst", "T", "1"));
        final List<Student> all = controller.getStudents();
        assertEquals(1, all.length());

        assertEquals(all.get().id, student.id);
        assertEquals(all.get().name, student.name);
        assertEquals(all.get().number, student.number);
        assertEquals(all.get().stdgroup, student.stdgroup);
        }

        @Test
        public void addStudentHasNewId()      // Double test
        {
        final StudentService service = new StudentService(repository, scoreRepository);
        service.addStudent(new NewStudent(1, "a", "b", "c"));
        service.addStudent(new NewStudent(1, "b", "b", "c"));
        final List<Student> all = service.getStudents();
        assertEquals(2,service.getStudents().size());
        assertNotEquals(all.get(0).id,all.get(1).id);
        }

        @Autowired
        private StudentRepository repository;
        @Autowired
        private ScoreRepository scoreRepository;
        }



