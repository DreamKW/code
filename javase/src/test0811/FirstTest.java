package test0811;

import java.util.ArrayList;
import java.util.List;

public class FirstTest {
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        a.add("d");
        a.add(1);
        a.add("c");
        a.add("ddddddd");
        a.add("c");
        a.add("d");
        a.add("pp");
        a.remove("pp");
//        public E remove(int index) {
//            rangeCheck(index);
//
//            modCount++;
//            E oldValue = elementData(index);
//
//            int numMoved = size - index - 1; 3
//            if (numMoved > 0)
//                System.arraycopy(elementData, 3 index+1, elementData, index2,
//                        numMoved3);
//            elementData[--size] = null; // clear to let GC do its work
//
//            return oldValue;
//        }
//        a.add("c");
//        a.add("d");
//        a.add("c");
//        a.add("d");
//        a.add("c");
//        a.add("d");
//        a.add("c");
//        a.remove(5);

        System.out.println(a.size());

        Student stu1 = new Student();
        stu1.setName("111");
        Student stu2 = new Student();
        stu2.setName("222");
        System.out.println(a.get(2));

        for (int i = 0; i < a.size(); i++) {
            Object obj = new Object();
            if (obj instanceof  Student){
                System.out.println("姓名  "+ ((Student)obj).getName());
            }else{
                System.out.print(a.get(i) + "  ");
            }
        }
        System.out.println();

        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + "  ");
        }

    }

}
