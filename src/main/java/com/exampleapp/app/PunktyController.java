package com.exampleapp.app;
import com.exampleapp.app.StudentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/punkty")
public class PunktyController
{

    private StudentService service = new StudentService();


    private CopyOnWriteArrayList<String> users= new CopyOnWriteArrayList<>();
    {
        this.users.addAll(Arrays.asList("Artur Osmanowski","Janusz Mikke","Andrzej Nowak","Karol Krawczyk","Tadeusz Norek"));
    }

    @RequestMapping( value = "/students", method = RequestMethod.GET)
    public List<Student> getUsers()
    {
        return service.getStudents().asJava();
    }


    @PostMapping( value ="/students/add",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Student addStudent(@RequestBody NewStudent student)
    {
        return service.addStudent(student);
    }


}