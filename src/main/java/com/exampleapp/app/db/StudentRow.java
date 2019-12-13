package com.exampleapp.app.db;

import com.exampleapp.app.Student;

import javax.persistence.*;
import java.util.Set;

@Entity



public class StudentRow
{


    public Student toStudent()
    {
        return new Student(
                this.getId(),
                this.getName(),
                this.getNumber(),
                this.getStdgroup());    }

protected StudentRow()
{

}
public StudentRow(String name, String number, String stdgroup)
{ this.name = name;
this.number = number;
this.stdgroup = stdgroup;
}

    //alt+insert -> getter and setter -> zaznacz wszystko

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id private long id;
    private String name;
    private String number;
    private String stdgroup;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStdgroup() {
        return stdgroup;
    }

    public void setStdgroup(String stdgroup) {
        this.stdgroup = stdgroup;
    }

    public Set<ScoreRow> getScores() {
        return scores;
    }

    public void setScores(Set<ScoreRow> scores) {
        this.scores = scores;
    }

    @OneToMany(mappedBy = "student")private Set<ScoreRow> scores;



}
