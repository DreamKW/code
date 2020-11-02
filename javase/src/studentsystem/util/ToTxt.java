package studentsystem.util;

import studentsystem.entity.Student;

import java.io.*;
import java.util.HashMap;

import static studentsystem.daoIimpl.MapStuDao.studentHashMap;

public class ToTxt {

    public ToTxt() throws IOException {
    }

    public static void  Totxt() throws IOException, ClassNotFoundException {
//        写入
        File file = new File("D:\\practice\\2020如皋\\正式\\code\\javase\\src\\studentsystem\\daoIimpl\\stus.txt");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(studentHashMap);
        oos.close();
        fos.close();
    }
    public static HashMap<Integer, Student> ToMap () throws IOException, ClassNotFoundException {
        File file = new File("D:\\practice\\2020如皋\\正式\\code\\javase\\src\\studentsystem\\daoIimpl\\stus.txt");
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        studentHashMap = (HashMap<Integer, Student>) ois.readObject();
        ois.close();
        fis.close();
        return studentHashMap;

    }
}
