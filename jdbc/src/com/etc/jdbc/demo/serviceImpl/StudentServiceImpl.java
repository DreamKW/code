package com.etc.jdbc.demo.serviceImpl;

import com.etc.jdbc.demo.dao.StudentDao;
import com.etc.jdbc.demo.daoImpl.BaseDaoImpl;
import com.etc.jdbc.demo.daoImpl.StuOracleDaoImpl;
import com.etc.jdbc.demo.daoImpl.StudentDaoImpl;
import com.etc.jdbc.demo.entity.Student;
import com.etc.jdbc.demo.entity.Student1;
import com.etc.jdbc.demo.entity.Tclass;
import com.etc.jdbc.demo.service.StudentService;

import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import com.etc.jdbc.demo.util.Log;

public class StudentServiceImpl implements StudentService {
    StudentDao dao = new StudentDaoImpl();

    /**
     * 添加学生班级信息
     */
//    public int addStudentClass(Student student) throws SQLException{
//        int no = 0;
//        try {
//            //打开事务
//            ((StudentDaoImpl)dao).openTransaction();
//            //添加班级信息
//            int cid = dao.addClass(student.getTclass());
//            //修改student对象里的班级信息
//            student.getTclass().setTclass(cid);
//            //添加学生信息
//           no = dao.addStudent(student);
//            //提交事务
//            ((StudentDaoImpl)dao).commitTransaction();
//        } catch (Exception e) {
//            //回滚事务
//            ((StudentDaoImpl)dao).rollbackTransaction();
//            e.printStackTrace();
//            Log.mylog.debug("添加班级学生信息:" + e.getMessage());
//        } finally {
//            //关闭资源
//            ((StudentDaoImpl)dao).closeResoure();
//        }
//        return no;
//    }


    /**
     * 添加班级学生信息
     * @return
     * @throws SQLException
     */
    public int addClassStudent(Tclass tclass) throws SQLException {
        dao = new StuOracleDaoImpl();
        int no = 0;
        try {
            //打开事务
            ((StuOracleDaoImpl)dao).openTransaction();
            //添加班级信息
            int cid = dao.addClass(tclass);
            //添加学生信息
            List<Student> studentnews = tclass.getStudents();
            for (Student stu :
                    studentnews) {

               no = dao.addStudent(stu,cid);
            }
            //提交事务
            ((StuOracleDaoImpl)dao).commitTransaction();
        } catch (Exception e) {
            //回滚事务
            ((StuOracleDaoImpl)dao).rollbackTransaction();
            Log.mylog.debug("添加班级学生信息:" + e.getMessage());
        } finally {
            //关闭资源
            ((StuOracleDaoImpl)dao).closeResoure();
        }
        return no;
    }

    @Override
    public int deleteclass(String cname) throws SQLException {
        dao = new StuOracleDaoImpl();
        int no = 0 ;
        try{
            ((StuOracleDaoImpl) dao).openTransaction();
             if(dao.deleteStu(cname)> 0 ){
                 System.out.println("删除班级学生成功");
             }

             no = dao.deleteClass(cname);
            ((StuOracleDaoImpl) dao).commitTransaction();
        }catch (Exception e){
            ((StuOracleDaoImpl) dao).rollbackTransaction();
            Log.mylog.debug("删除班级学生信息:" + e.getMessage());
        }finally {
            ((StuOracleDaoImpl) dao).closeResoure();
        }
        return no;
    }
//    关闭资源

    @Override
    public Student1 login(String username, String pwd) throws SQLException {
        //在service层关闭资源
        dao = new StuOracleDaoImpl();
        Student1 stu  = null;
        try {
           stu =  dao.login(username,pwd);

        }catch (Exception e){
            Log.mylog.debug("异常"+e.getMessage());

            e.printStackTrace();
        }finally {
            //关闭资源
            ((StuOracleDaoImpl)dao).closeResoure();
        }
        return stu;
    }

    /**
     * 实现查询所有学生信息
     * @return
     */
    @Override
    public List<Student1> getAll() throws SQLException, ClassNotFoundException {
        dao = new StuOracleDaoImpl();
        List<Student1> students = null;
        try {
             students = dao.getAll();
        }catch (Exception e){
            Log.mylog.debug("异常"+e.getMessage());
            e.printStackTrace();
        }finally {
            ((StuOracleDaoImpl)dao).closeResoure();
        }
        return students;
    }

    @Override
    public boolean update(String name, int age) throws SQLException, IOException, URISyntaxException {
        boolean flag =false;
        try {
             flag = dao.update(name,age);
        } catch (Exception e) {
            Log.mylog.debug(e.getMessage());

            e.printStackTrace();
        }finally {
            ((StudentDaoImpl)dao).closeResoure();
        }
        return flag;
    }

    @Override
    public boolean delete(String name) throws SQLException {
        boolean flag =false;
        try {
            flag = dao.delete(name);
        } catch (Exception e) {
            Log.mylog.debug(e.getMessage());
            e.printStackTrace();
        }finally {
            ((StudentDaoImpl)dao).closeResoure();
        }
        return flag;

    }

    @Override
    public boolean add(String name, int age, String pwd) throws SQLException {
        boolean flag =false;
        try {
            flag = dao.add(name,age,pwd);
        } catch (Exception e) {
            Log.mylog.debug(e.getMessage());
            e.printStackTrace();
        }finally {
            ((StudentDaoImpl)dao).closeResoure();
        }
        return flag;

    }

    /**
     * 获取班级信息
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    @Override
    public List<Tclass> getClassStudent() throws SQLException, ClassNotFoundException {
        List<Tclass>  tclasses = null;
        try {
            tclasses = dao.getClassStudent();

        }catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());

        }finally {
            ((StudentDaoImpl)dao).closeResoure();
        }
        return tclasses;
    }


}
