package test0811;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest2 {
    public static void main(String[] args) {
        ArrayList<Float> list = new ArrayList<>();
        list.add(11.0f);
        list.add(11.0f);
        list.add(11.0f);
        list.add(11.0f);
        for (Float f :
                list) {
            if (f != null){
                System.out.println(f);
            }
        }
        //第三种遍历方式，使用迭代器
        Iterator it = list.iterator();
        while(it.hasNext()){
            Student student = (Student) it.next();
            if (student != null)
                System.out.println(student.getAge());
            else System.out.println("学生不存在");
        }





        ArrayList list1 = new ArrayList();
        list1.add(11.0f);
//        list.remove(11);
        list1.remove(11.0);
        Student stu = null;
        list1.add(stu);
        list1.remove(stu);
        stu = new Student();
        list1.remove(stu);

    }
}
