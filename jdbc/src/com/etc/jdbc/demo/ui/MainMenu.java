package com.etc.jdbc.demo.ui;

import com.etc.jdbc.demo.entity.Student;
import com.etc.jdbc.demo.entity.Student1;
import com.etc.jdbc.demo.entity.Tclass;
import com.etc.jdbc.demo.service.StudentService;
import com.etc.jdbc.demo.serviceImpl.StudentServiceImpl;
import com.etc.jdbc.demo.util.JudgeNo;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    Scanner input = new Scanner(System.in);
    StudentService studentService = new StudentServiceImpl();

    //查询学生班级信息
    public void getClassStudent() throws SQLException, ClassNotFoundException {
        StudentService ss = new StudentServiceImpl();
        List<Tclass> tclasses = ss.getClassStudent();
        for (Tclass tc :
                tclasses) {
            System.out.println("班级:" + tc.getTclassname() +
                    "班级ID:" + tc.getTclass()
            );
            for (Student stu :
                    tc.getStudents()) {
                System.out.println("姓名:" + stu.getSname() +
                        "学生年龄:" + stu.getAge()
                );
            }

        }
    }

//    public void addStudentClass() throws SQLException {
//        Tclass tc = new Tclass("java3班");
//        Student stu1 = new Student(tc,"解放了" , 20 , new Date(),90.9);
//        StudentService ss = new StudentServiceImpl();
//        int no = ((StudentServiceImpl)ss).addStudentClass(stu1);
//        if (no > 0) System.out.println("添加成功！");
//        else System.out.println("添加失败！");
//    }
    public static void main(String[] args) throws SQLException {
//        new MainMenu().deleteclass();
        new MainMenu().addClassStudent();
    }
    //添加班级学生的信息
    public void addClassStudent() throws SQLException {
        Tclass tc = new Tclass("java2");
        //学生信息
        Student stu1 = new Student(tc,"不困了" , 20 , new Date(),90.9);
        Student stu2 = new Student(tc,"特别困" , 30 , new Date(),90.6);
        Student stu3 = new Student(tc,"月亮不睡我不睡" , 25 , new Date(),88.2);
        StudentService ss = new StudentServiceImpl();
        int no = ((StudentServiceImpl)ss).addClassStudent(tc);
        if (no > 0) System.out.println("添加成功！");
        else System.out.println("添加失败！");
    }



    public void getAll () throws SQLException, ClassNotFoundException {
        System.out.println("查询所有学生信息");
        List<Student1> list = studentService.getAll();
        int size = list.size();
        if (list.size() > 0){
            for (int i = 0; i < size; i++) {
                Student1 stu = list.get(i);
                if (stu != null){
                    System.out.println("用户名:" + stu.getStuname() + "\t" + "密码:" + stu.getPwd() + "\t\t" + "年龄:" + stu.getAge() + "\t\t" + "序号:" + stu.getSid());
                }else{
                    System.out.println("无人");
                }
            }
        }else{
            System.out.println("此班级中无人");
        }
    }

    public void login() throws SQLException {
        System.out.println("用户名：");
        String name = input.next();
        System.out.println("密码：");
        String pwd = input.next();
       Student1 student = studentService.login(name,pwd);
        if (student != null){
            System.out.println(student);
        }
    }

    public void update() throws SQLException, ClassNotFoundException, IOException, URISyntaxException {
        System.out.println("请输入要修改信息的姓名：");
        String name = input.next();
        System.out.println("请输入你新的年龄：");
        int age = JudgeNo.judge();
       boolean flag  = studentService.update(name,age);
        if (flag){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }

    public void delete() throws SQLException {
        System.out.println("请输入你要删除人的姓名：");
        String name = input.next();
        studentService.delete(name);
    };

    public void deleteclass() throws SQLException{
        System.out.println("请输入你要删除的班级：");
        String cname = input.next();
        if (studentService.deleteclass(cname) > 0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }



    public void add() throws SQLException {
        System.out.println("姓名：");
        String name = input.next();
        System.out.println("年龄：");
        int age = JudgeNo.judge();
        System.out.println("密码：");
        String pwd = input.next();
        studentService.add(name,age,pwd);
    };


}
