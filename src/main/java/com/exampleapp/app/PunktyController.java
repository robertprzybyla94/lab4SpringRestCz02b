package com.exampleapp.app;
import com.exampleapp.app.StudentService;
import com.exampleapp.app.db.StudentRepozytory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;



@RestController
@RequestMapping("/punkty")
public class PunktyController
{
    private final StudentService service;

    public PunktyController(StudentService service)
    {
        this.service = service;
    }

  //  private CopyOnWriteArrayList<String> users= new CopyOnWriteArrayList<>();
   // {
  //      this.users.addAll(Arrays.asList("A","J","A","K","T"));
  //  }

    @RequestMapping( value = "/students", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

    public List<Student> getUsers()
    {
        return service.getStudents().asJava();
    }
    @RequestMapping(value="/students/{id}/number/{number}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    @Transactional
    public Student setNumber(@PathVariable("id") long id, @PathVariable("number") String number)
    {
        return this.service.changeNumber(id, number).orElseThrow(() -> new IllegalArgumentException("Student oid: " + id + " does not exist")    );
    }

    @PostMapping( value ="/students",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Student addStudent(@RequestBody NewStudent student)
    {
        return service.addStudent(student);
    }




}
