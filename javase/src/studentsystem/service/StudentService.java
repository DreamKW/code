package studentsystem.service;


import studentsystem.entity.Student;

import java.lang.reflect.InvocationTargetException;

public interface StudentService {
    public boolean addStuent(Student student) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, Exception;
    public boolean update(Student stuup) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
    public void selectXx(Student stu) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
    public void delete(Student stux) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
    public Student loginStuent(Student stu) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, Exception;
    public  void dianMin() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException;
}
