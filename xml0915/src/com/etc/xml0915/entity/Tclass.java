package com.etc.xml0915.entity;

import java.util.ArrayList;
import java.util.List;

public class Tclass {
    private int id;
    private String name;
    private School school;
    private List<Student> studentList;
    public Tclass(){
        studentList = new ArrayList<Student>();
    }

    public Tclass(int id, String name, School school) {
        this.id = id;
        this.name = name;
        this.school = school;
//        创建班级对象的时候将自己添加到学校的集合中
        school.getTclassList().add(this);
        studentList = new ArrayList<Student>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
