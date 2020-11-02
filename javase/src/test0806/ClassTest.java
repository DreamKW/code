package test0806;

import java.lang.reflect.Field;

public class ClassTest {
    public static void main(String[] args) {
         Class stuc = Student.class;

         Field [] fs1= stuc.getDeclaredFields();
        for ( Field f:fs1
        ) {
            System.out.println(f);
        }
        System.out.println("-----------");
         //获取public属性
        Field [] fs = stuc.getFields();
        for ( Field f:fs
             ) {
            System.out.println(f);
        }




//创建class对象的方法
//1
        Class c = ClassTest.class;
//2
        try {
            c = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

//        3
        ClassTest ct = new ClassTest();
        c = ct.getClass();
//        4
        c = Integer.TYPE;
    }
}
