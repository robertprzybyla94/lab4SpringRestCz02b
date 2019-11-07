package com.exampleapp.app;
import org.junit.Test;
import io.vavr.collection.List;
import static org.junit.Assert.*;

public class StudentServiceTest
{
    @Test
    public void getEmptyList() {
        final StudentService service = new StudentService();
        List<Student> students = service.getStudents();
        assertTrue(students.isEmpty());

    }

    @Test
    public void addStudent()
    {
        final StudentService service = new StudentService();
        final Student created = service.addStudent(new NewStudent(1,"Student1","IP","1"));
        assertNotNull(created);
    }

    @Test
    public void addStudentIsReturned()
    {
        final StudentService service = new StudentService();
        final Student student = service.addStudent(new NewStudent(1, "a", "b", "c"));
        final List<Student> all = service.getStudents();
        assertEquals(1, all.get(0).id);

        assertEquals(all.get().id, student.id);
        assertEquals(all.get().name, student.name);
        assertEquals(all.get().number, student.number);
        assertEquals(all.get().group, student.group);
    }

    @Test
    public void addStudentHasNewId()      // Double test
    {
        final StudentService service = new StudentService();
        service.addStudent(new NewStudent(1, "a", "b", "c"));
        service.addStudent(new NewStudent(1, "b", "b", "c"));
        final List<Student> all = service.getStudents();
        assertEquals(2,service.getStudents().size());
        assertNotEquals(all.get(0).id,all.get(1).id);
    }




}