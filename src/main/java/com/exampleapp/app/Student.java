package com.exampleapp.app;

public class Student {

    public long id;
    public String name, group, number;

    public Student(long id, String name, String number, String group)
    {
        this.id = id;
        this.name = name;
        this.group = group;
        this.number = number;
    }
}