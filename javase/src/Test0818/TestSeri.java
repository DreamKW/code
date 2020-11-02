package Test0818;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestSeri {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


//        存取 序列化 读取 反序列化
        System.out.println("=====序列化==存取======");
        Student stuent = new Student("1","A");
        Student stuent1 = new Student("1","b");
        Student student2 = new Student("1","C");
//       序列化
//1.	若创建文件时设置为可追加，虽然可以后面继续追加存储，但是在读取的时候，只读取第一个，后面的数据不能识别类型
//2.	若为不可追加则，数据会被覆盖。

        File file = new File("d:\\stu.txt");
        file.createNewFile();
        //流
        FileOutputStream fos = new FileOutputStream(file);
        //创建对象的输出流  包装流
        ObjectOutputStream oos = new ObjectOutputStream(fos);
//
        oos.writeObject(stuent);
        oos.writeObject(stuent1);
        oos.writeObject(student2);
        fos.flush();
        oos.close();
        fos.close();
        System.out.println("======反序列化==读取=====");
//        List<Student> list = new ArrayList<Student>();
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
//
//        while (fis.available() > 0){
//            list.add((Student)ois.readObject());
//        }
//        int i = 0;
//        while (i < list.size()){
//            System.out.println(list.get(i));
//        }

//
//

//        int len = 0;

//
        while (fis.available() > 0){
            Student stu1 = (Student) ois.readObject();
            System.out.println(stu1);
        }

        ois.close();
        fis.close();
    }
}
