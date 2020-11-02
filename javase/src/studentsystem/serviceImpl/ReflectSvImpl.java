package studentsystem.serviceImpl;

import studentsystem.dao.StuDao;
import studentsystem.daoIimpl.MapStuDao;
import studentsystem.daoIimpl.SetStuDao;
import studentsystem.entity.Student;
import studentsystem.service.StudentService;
import studentsystem.daoIimpl.ReflectDaoImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ReflectSvImpl implements StudentService {
    Class c = MapStuDao.class;
    StuDao dao = (MapStuDao) c.newInstance();





//    StuDao dao = new StuDaoImpl();




    public ReflectSvImpl() throws Exception {
    }



    public boolean addStuent(Student student) throws Exception {
//        反射调用方法的过程
//        //1.构建Class对象
//        Class stuc = Student.class;
//        //2.创建student 实例
//        Student stu = (Student) stuc.newInstance();
//        //3.获取对应的方法
//        Method method = stuc.getDeclaredMethod("show",new Class[]{String.class,int.class});
//        //4.调用方法
//        method.invoke(stu,new Object[]{"hello",18});


//Map 存储
//        StuDao mapStuDao = new MapStuDao();
//       return mapStuDao.addStudent(student);

//      Set存储
//        StuDao setStuDao = new SetStuDao();
//        return  setStuDao.addStudent(student);


        //反射
        Method method = c.getDeclaredMethod("addStudent",new Class[]{Student.class});
         return (boolean)method.invoke(dao,new Object[]{student});
//原来
//        return dao.addStudent(student);
    }

    public Student loginStuent(Student stu) throws Exception {
        Method method = c.getDeclaredMethod("loginStudent",new Class[]{Student.class});
        return (Student) method.invoke(dao,new Object[]{stu});
//        return  dao.loginStudent(stu);
    }

    @Override
    public void dianMin() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = c.getDeclaredMethod("dianMin");
        method.invoke(dao);

    }

    public void selectXx(Student stu) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = c.getDeclaredMethod("selectXx",new Class[]{Student.class});
         method.invoke(dao,new Object[]{stu});
//        dao.selectXx(stu);
    }

    public void delete(Student stux) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = c.getDeclaredMethod("delete",new Class[]{Student.class});
         method.invoke(dao,new Object[]{stux});
//        dao.delete(stux);
    }

    public boolean update(Student stuup) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = c.getDeclaredMethod("update",new Class[]{Student.class});
        return (boolean) method.invoke(dao,new Object[]{stuup});
//        return dao.update(stuup);
    }
}
