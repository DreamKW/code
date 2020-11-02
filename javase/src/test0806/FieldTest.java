package test0806;

import java.lang.reflect.Field;

public class FieldTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
//       创建Class对象
        Class c = Student.class;
//        创建Studnet对象
        Student stu = (Student) c.newInstance();
//        获取到stu对象中的name Field Declared包括没有public修饰的属性
        Field f =c.getDeclaredField("name");
//        修改属性权限
        f.setAccessible(true);
//        给name 属性赋值
        f.set(stu,"rose");
//        查看是否正常赋值正常
        System.out.println(f.get(stu));

    }
}
