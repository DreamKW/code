package test0807;

import java.lang.reflect.Method;

public class TestMethod {
    public static void main(String[] args) throws Exception {
        //1.构建Class对象
        Class stuc = Student.class;
        //2.创建student 实例
        Student stu = (Student) stuc.newInstance();

        System.out.println("------------");
        //查看所有的方法
        Method [] ms = stuc.getMethods();
        for (Method mm :
                ms) {
            System.out.println(mm.getName());
        }
        System.out.println("-------declare-----------");
        //查看所有声明的方法
        ms = stuc.getDeclaredMethods();
        for (Method mm :
                ms) {
            System.out.println(mm.getName());
        }
        System.out.println("------------");


        //3.获取对应的方法
        Method method = stuc.getDeclaredMethod("show",new Class[]{String.class,int.class});
        //4.调用方法
        method.invoke(stu,new Object[]{"hello",18});
    }
}
