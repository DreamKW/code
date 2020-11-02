package com.etc.jdbc.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int  course_id;
    private String name;
    private List<Score>  scores;

    public Course(){
        scores = new ArrayList<>();
    }
    public Course(String name){
        this.name =name;
        scores =new ArrayList<>();
    }

    public List<Score> getScores() {
        return scores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }
}
