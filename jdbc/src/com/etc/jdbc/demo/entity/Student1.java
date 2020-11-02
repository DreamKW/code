package com.etc.jdbc.demo.entity;

import java.util.Objects;

public class Student1 {
    private int sid;
    private String stuname;
    private int age;
    private String pwd;

    public Student1() {
    }

    public Student1(String name, String pwd) {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student1 student = (Student1) o;
        return sid == student.sid &&
                age == student.age &&
                Objects.equals(stuname, student.stuname) &&
                Objects.equals(pwd, student.pwd);
    }

    @Override
    public String toString() {
        return "Student1{" +
                "sid=" + sid +
                ", stuname='" + stuname + '\'' +
                ", age=" + age +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, stuname, age, pwd);
    }
}
