package studentsystem.entity;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {
    private String sname;
    private String snum;//学号
    private int sage;
    private String sap;
    private String ss;
    private String semail;



    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public Student() {
    }

    public Student(String sname) {
        this.sname = sname;
    }

    public Student(String sname, String ss) {
        this.sname = sname;
        this.ss = ss;
    }

    public Student(String sname, int sage, String semail, String sap, String ss) {
        this.sname = sname;
        this.sage = sage;
        this.semail = semail;
        this.sap = sap;
        this.ss = ss;
    }
    public Student(String sname, int sage, String snum,String semail, String sap, String ss) {
        this.sname = sname;
        this.sage = sage;
        this.snum = snum;
        this.semail = semail;
        this.sap = sap;
        this.ss = ss;
    }
    public Student(String sname, int sage, String sap, String ss) {
        this.sname = sname;
        this.sage = sage;
        this.sap = sap;
        this.ss = ss;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        this.snum = snum;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSap() {
        return sap;
    }

    public void setSap(String sap) {
        this.sap = sap;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    @Override
    public String toString() {
//        return "Student{" +
//                "sname='" + sname + '\'' +
//                ", snum=" + snum +
//                ", sage=" + sage +
//                ", sap='" + sap + '\'' +
//                ", ss='" + ss + '\'' +
//                '}';
        return    "学号："+snum+"  姓名："+sname+ " 年龄："+sage+"邮箱："+semail+" 专业："+ sap  + "密码： " + "*********";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return sage == student.sage &&
                Objects.equals(sname, student.sname) &&
                Objects.equals(snum, student.snum) &&
                Objects.equals(sap, student.sap) &&
                Objects.equals(ss, student.ss);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sname, snum, sage, sap, ss);
    }
}
