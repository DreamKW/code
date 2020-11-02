package com.etc.jdbc.demo.entity;

public class Score {
    private int score_id;
    private Student student;
    private Course course;
    private double stuscore;

    public Score(){

    }

    public Score(int score_id, Student student, Course course, double stuscore) {
        this.score_id = score_id;
        this.student = student;
        this.course = course;
        this.stuscore = stuscore;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getScore_id() {
        return score_id;
    }

    public void setScore_id(int score_id) {
        this.score_id = score_id;
    }


    public double getStuscore() {
        return stuscore;
    }

    public void setStuscore(double stuscore) {
        this.stuscore = stuscore;
    }
}
