package com.etc.xml0915.entity;

public class Student {
    private int id;
    private String name;
    private Tclass tclass;

    public Student(){};

    public Student(int id, String name, Tclass tclass) {
        this.id = id;
        this.name = name;
        this.tclass = tclass;
//        创建学生对象的时候将自己添加到班级的集合中
        tclass.getStudentList().add(this);
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

    public Tclass getTclass() {
        return tclass;
    }

    public void setTclass(Tclass tclass) {
        this.tclass = tclass;
    }
}
