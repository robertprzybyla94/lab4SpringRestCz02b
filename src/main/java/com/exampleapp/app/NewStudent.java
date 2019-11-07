package com.exampleapp.app;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class NewStudent
{
    @JsonProperty("name")  final String name;
    @JsonProperty("group") final String group;
    @JsonProperty("number") final String number;

    public NewStudent(long id, String name, String stud_group, String number)
    {
        this.name = name;
        this.group = stud_group;
        this.number = number;
    }

}
