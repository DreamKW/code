package com.etc.jdbc.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class Tclass {
    private int tclass;
    private String tclassname;
    private List<Student> students;
    public Tclass(){
        students = new ArrayList<>();
    }
    public Tclass (String tclassname){
        this.tclassname = tclassname;
        students = new ArrayList<>();
    }

    public Tclass(int tclass, String tclassname) {
        this.tclass = tclass;
        this.tclassname = tclassname;
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getTclass() {
        return tclass;
    }

    public void setTclass(int tclass) {
        this.tclass = tclass;
    }

    public String getTclassname() {
        return tclassname;
    }

    public void setTclassname(String tclassname) {
        this.tclassname = tclassname;
    }
}
