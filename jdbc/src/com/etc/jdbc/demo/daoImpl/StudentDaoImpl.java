package com.etc.jdbc.demo.daoImpl;


import com.etc.jdbc.demo.dao.StudentDao;
import com.etc.jdbc.demo.entity.*;
import com.etc.jdbc.demo.ui.MainMenu;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl extends BaseDaoImpl implements StudentDao  {
    boolean falg = false;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new MainMenu().login();

    }


    //    具体功能
    @Override
    public Student1 login(String username, String pwd) throws Exception {
        //打开数据库
        openDb();
        //        //添加驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        //数据库的连接
//        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8","root","2721kkww=-");
//
        //用问号表示占位符
        String sql = "select * from student where name = ? and pwd = ? ";
        //预编译
        ps = con.prepareStatement(sql);
        //当有占位符时，要对预编译的对象进行占位符处理
        ps.setString(1,username);
        ps.setString(2,pwd);
        //返回结果集
        rs = ps.executeQuery();
        Student1 stu = null;
        while (rs.next()){
            stu = new Student1();
            stu.setAge(rs.getInt("age"));
            stu.setPwd(rs.getString("pwd"));
            stu.setStuname(rs.getString("name"));
            stu.setSid(rs.getInt("sid"));
        }
        return stu;
    }
//添加班级信息
    @Override
    public int addClass(Tclass tclass) throws SQLException {
        //因为开启了事务，打开数据库在service 层中，此处不需要打开数据库
        String sql = "insert into tclass(tclassname) values(?)";
        //预编译
        ps = con.prepareStatement(sql);
        ps.setString(1,tclass.getTclassname());
          ps.executeUpdate();
        sql = "select tclass_id from tclass where tclassname = ? ";
        ps = con.prepareStatement(sql);
        ps.setString(1,tclass.getTclassname());
        rs = ps.executeQuery();
        int cid = 0;
        while (rs.next()){
            cid = rs.getInt(1);
        }
        return cid;
    }

    @Override
    public int addStudent(Student student, int cid) throws Exception {
        return 0;
    }



    /**
     * 查询所有学生信息
     * @return
     */
    @Override
    public List<Student1> getAll() throws Exception {
        openDb();
        String sql = "select * from student";
        //sql语句的预编译
        ps = con.prepareStatement(sql);
        //当有占位的时候，就需要对预编译的对象进行占位符的处理
        //执行SQL语句,返回值为一个结果集
        //增删改操作调用的是executeUpdate()，此方法的返回值为int类型
        rs = ps.executeQuery();
        List<Student1> list = new ArrayList<>();
        while (rs.next()){
            Student1 stu = new Student1();
            stu.setSid(rs.getInt("sid"));
            stu.setAge(rs.getInt("age"));
            stu.setPwd(rs.getString("pwd"));
            stu.setStuname(rs.getString("name"));
            list.add(stu);
        }
        return list;
    }

    @Override
    public boolean update(String name ,int age) throws Exception {
        openDb();
        String sql = "update student set age = ? where name = ?";
        ps = con.prepareStatement(sql);
        ps.setInt(1,age);
        ps.setString(2,name);
         int a  = ps.executeUpdate();

        if (a == 0){
            falg = false;
        }else {
            falg = true;
        }

        return falg;
    }

    @Override
    public boolean delete(String name) throws Exception {
        openDb();
        String sql = "delete from student where name = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1,name);
        int a  = ps.executeUpdate();
        if (a == 0){
            falg = false;
        }else {
            falg = true;
        }

        return falg;
    }

    @Override
    public boolean add(String name, int age, String pwd) throws Exception {
        openDb();
        String sql = "INSERT into student (name,age,pwd) VALUES(?,?,?)";
        ps = con.prepareStatement(sql);
        ps.setString(1,name);
        ps.setInt(2,age);
        ps.setString(3,pwd);
        int a  = ps.executeUpdate();

        if (a == 0){
            falg = false;
        }else {
            falg = true;
        }

        return falg;
    }

    /**
     * 获取班级学生信息
     * @return
     * @throws SQLException
     */

    @Override
    public List<Tclass> getClassStudent() throws Exception {
        openDb();
        String sql ="SELECT\n" +
                "\t*\n" +
                "FROM\n" +
                "\tdemo.student\n" +
                "\tINNER JOIN\n" +
                "\tdemo.tclass\n" +
                "\tON \n" +
                "\t\tdemo.student.tclass_id = demo.tclass.tclass_id";
        ps = con.prepareStatement(sql);
        rs =ps.executeQuery();
        List<Tclass> tclasses = new ArrayList<>();
        while (rs.next()){
            Tclass tclass = new Tclass();
            tclass.setTclass(rs.getInt(2));
            tclass.setTclassname(rs.getString(8));
            Student stu = new Student(tclass,rs.getString(3),rs.getInt(4),rs.getDate(5),rs.getDouble(6));
            tclasses.add(tclass);
        }
        return tclasses;
    }

    @Override
    public int deleteStu(String cname) {
        return 0;
    }

    @Override
    public int deleteClass(String cname) {
        return 0;
    }




}