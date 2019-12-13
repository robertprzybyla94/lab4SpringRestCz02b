package com.exampleapp.app;

public class Student {

    public long id;
    public String name, stdgroup, number;


    public Student(long id, String name, String number, String stdgroup)
    {
        this.id = id;
        this.name = name;
        this.stdgroup = stdgroup;
        this.number = number;
    }

}