package com.exampleapp.app;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
@RestController
public class HelloController {



    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String Hallo()
    {
        return "hello time is: " + LocalDateTime.now();
    }
}