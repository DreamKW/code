package Test0818.home;

import Test0818.Student;

import java.io.*;
import java.util.ArrayList;

public class ArrayObj {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
 /*        Student [] stus = new Student[10];
         stus[1] = new Student("a","a");
         stus[0] = new Student("b","b");
         stus[2] = new Student("3","3");*/
//集合
        ArrayList <Student> arrayList = new ArrayList<>();
        arrayList.add(new Student("v","v"));
        arrayList.add(new Student("v","v"));
        arrayList.add(new Student("v","v"));

         File file = new File("d:\\stus.txt");
        FileOutputStream fos  = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        //java 中一切皆对象  对象数组也是对象
//        oos.writeObject(stus);
        oos.writeObject(arrayList);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        //数组
      /*  stus = (Student[]) ois.readObject();
        for (int i = 0; i < stus.length; i++) {
            if (stus[i] != null && !"".equals(stus[i])){
                System.out.println(stus[i].toString());
            }
        }*/
//        集合
        arrayList = (ArrayList<Student>) ois.readObject();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) != null && !"".equals(arrayList.get(i))){
                System.out.println(arrayList.get(i));
            }
        }
        ois.close();

    }
}
