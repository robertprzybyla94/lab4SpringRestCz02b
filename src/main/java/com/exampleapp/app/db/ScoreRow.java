package com.exampleapp.app.db;

import javax.persistence.*;
import java.util.Set;


@Entity
public class ScoreRow
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private  int score;
    private  String  comment;

    public ScoreRow(int score, String comment, StudentRow student) {
        this.score = score;
        this.comment = comment;
        this.student = student;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getScore() {return score; }
    public void getScore(int score) {
        this.score = score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public StudentRow getStudent() {
        return student;
    }

    public void setStudent(StudentRow student) {
        this.student = student;
    }

    public Set<ScoreRow> getScores() {
        return scores;
    }

    public void setScores(Set<ScoreRow> scores) {
        this.scores = scores;
    }

    @ManyToOne
    private StudentRow student;


    protected ScoreRow() {}


    @OneToMany (mappedBy = "student")
    private Set<ScoreRow> scores;




}






