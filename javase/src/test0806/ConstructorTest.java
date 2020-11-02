package test0806;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //    创建Student 对象
        System.out.println("创建对象");
//    非反射技术
        Student student = new Student();
        student.show();
//    反射技术创建对象
        Class c = Student.class;
        student = (Student) c.newInstance();
        student.show();
        System.out.println("--------------");

        System.out.println("--------测试构造方法-----------");
//        获取所有的公共的Constructor对象没有用public修饰的不能获取
        Constructor [] cs = c.getConstructors();
        for (Constructor cc :
                cs) {
            System.out.println(cc);
        }
        System.out.println("--------------");
//        获取所有声明的Constructor对象 所有的
        cs  = c.getDeclaredConstructors();
        for (Constructor cc:
             cs) {
            System.out.println(cc);
        }
        //没有使用反射之前创建对象调用有参方法
         student = new Student("rose",11,"男");
        //使用反射创建对象调用有参方法
        System.out.println("--------使用反射技术调用有参构造方法---------");
        //找到对应的constructor对象
//        获取单个的构造方法 如果没有用public修饰 则也要用有Declared 的 get 方法如：
//        Constructor constructor = c.getDeclaredConstructor(new Class[]{String.class,int.class,String.class});
        //3.如果要获取的单个构造方法有public 修饰 则用下面这个即可
        Constructor constructor = c.getConstructor(new Class[]{String.class,int.class,String.class});
        //4.创建studnet对象
        student = (Student) constructor.newInstance(new Object[]{"a",1,"v"});
        System.out.println(student.getName() +" " + student.getAge() + " " + student.getSex());

    }
}
