package com.etc.jdbc.demo.daoImpl;

import com.etc.jdbc.demo.dao.StudentDao;
import com.etc.jdbc.demo.entity.Student;
import com.etc.jdbc.demo.entity.Student1;
import com.etc.jdbc.demo.entity.Tclass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StuOracleDaoImpl extends BaseDaoImpl implements StudentDao {
    ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//   Student1 student = (Student1) ac.getBean("student1");
    boolean falg = false;
    public static void main(String[] args) throws Exception {

        Student1 student =  new StuOracleDaoImpl().login("1","1");
        System.out.println(student);
        //        Student student = new Student(4,"D",18,88.8,"D");
//        Tclass tclass = new Tclass(10,"java10");
//        new StuOracleDaoImpl().addClass(tclass);
//        new StuOracleDaoImpl().addStudent(student);
//        new StuOracleDaoImpl().deleteClass("d");
//        new StuOracleDaoImpl().deleteStu("java2");
    }
    @Override
    public Student1 login(String username, String pwd) throws Exception {
        //打开数据库
        openDb();
        //用问号表示占位符
        String sql = "select * from student where sname = '"+username+"'and  pwd = '"+pwd+"'";
        //预编译
        st = con.createStatement();
        rs = st.executeQuery(sql);
        Student1 stu = null;
        while (rs.next()){
            stu = (Student1) ac.getBean("student1");
//            stu.setAge(rs.getInt("age"));
            stu.setPwd(rs.getString(7));
            stu.setStuname(rs.getString(3));
//            stu.setSid(rs.getInt("sid"));
        }
        return stu;
    }

    @Override
    public int addClass(Tclass tclass) throws Exception {
        String sql ="select tclass_id  from class where tclassname = '"+ tclass.getTclassname()+"'";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        boolean flag =rs.next();
        if(!flag){
            sql = "insert into class (tclass_id,tclassname) VALUES (claseq.nextval,'"+tclass.getTclassname()+"')";
            st = con.createStatement();
            st.executeUpdate(sql);
        }
        int tid = 0;
        sql ="select tclass_id  from class where tclassname = '"+ tclass.getTclassname()+"'";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()){
            tid = rs.getInt(1);
        }

//        sql = "select * from class";
//        st = con.createStatement();
//        rs = st.executeQuery(sql);
//        while (rs.next()){
//            tid = rs.getInt(1);
//            System.out.println(tid + "----");
//        }
        return tid;
    }



    @Override
    public int addStudent(Student stu ,int cid) throws Exception {
        String sql ="insert into student (st_id,class_id,sname,pwd) values (stuseq.nextval,'"+cid+"','"+stu.getSname()+"','"+stu.getPwd()+"')";
        st = con.createStatement();
        int a =st.executeUpdate(sql);
        return a;
    }

    @Override
    public List<Student1> getAll() throws Exception {
        openDb();
        String sql = "select * from studnet ";
//使用Statement进行操作不需要预编译，需要先根据连接得到Statement
        st = con.createStatement();
//        执行SQL
        rs = st.executeQuery(sql);
        List<Student1> students = new ArrayList<>();
        while (rs.next()){
            Student1 stu = new Student1();
            stu.setStuname(rs.getString(2));
            stu.setSid(rs.getInt(1));
            stu.setAge(rs.getInt(5));
            students.add(stu);
        }
        return students;
    }

    @Override
    public boolean update(String name, int age) throws Exception {
        openDb();
        String sql = "update student set age =  '"+ name+"'  where name =  '"+ age +"'  ";
        st = con.createStatement();
        int a  = st.executeUpdate(sql);

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
        st = con.createStatement();
        int a  = st.executeUpdate(sql);
        if (a == 0){
            falg = false;
        }else {
            falg = true;
        }
        return falg;
    }

    @Override
    public boolean add(String name, int age, String pwd) throws Exception {
        return false;
    }

    @Override
    public List<Tclass> getClassStudent() throws Exception {
        return null;
    }

    @Override
    public int deleteStu(String cname) throws Exception {
//        openDb();
        int no = 0 ;
//      查出班级id
        String sql = "select tclass_id from class where tclassname = '"+cname+"'";
        st = con.createStatement();
         rs = st.executeQuery(sql);
         int cid = 0;
         if(rs.next()){
             cid = rs.getInt(1);
         }else{
             System.out.println("没有此班级");
         }
         sql = "delete from student where class_id = '"+cid+"'";
         st = con.createStatement();
         no = st.executeUpdate(sql);
         return  no ;

//         sql = "select st_id from student where class_id = '"+cid+"'";
//         st = con.createStatement();
//         rs = st.executeQuery(sql);
//         List<Integer> stids  = new ArrayList<>();
//         while (rs.next()){
//             stids.add(rs.getInt(1));
//         }

    }


    @Override
    public int deleteClass(String cname) throws Exception {

        String sql ="delete from class where tclassname = '"+cname+"' ";
        st = con.createStatement();
        int no =  st.executeUpdate(sql);
        return  no ;
    }
}
