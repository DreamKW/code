package test0812;

import java.util.HashSet;
import java.util.Iterator;

public class SetListTest {
    public static void main(String[] args) {
            HashSet a = new HashSet();
            a.add("d");
            a.add("a");
            a.add("c");
            a.add(2);
            a.add("e");
            Iterator it = a.iterator();
            while (it.hasNext()){
                System.out.println(it.next());
            }
            HashSet<Student> stu = new HashSet<>();
            Student stu1 = new Student("a",12);
            Student stu2 = new Student("b",12);
            Student stu3 = new Student("g",12);
            stu.add(stu1);
            stu.add(stu2);
            stu.add(stu3);
            System.out.println("前： " + stu.size());
            stu1.setAge(14);
            stu.remove(stu1);//修改以后计算的hash的值不一样
            System.out.println("后： " + stu.size());
    }
}
