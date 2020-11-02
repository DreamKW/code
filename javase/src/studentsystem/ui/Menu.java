package studentsystem.ui;

import studentsystem.util.ToTxt;
import test0722.JudgeNo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import static studentsystem.daoIimpl.MapStuDao.studentHashMap;

public class Menu {
    public static void start() throws Exception {

        try {
            studentHashMap = ToTxt.ToMap();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        File file = new File("D:\\practice\\2020如皋\\正式\\code\\javase\\src\\studentsystem\\see.txt");
        file.createNewFile();

        StudentUi stuui = new StudentUi();
        int a = 0;
        String o = "s";

        while(true) {
            FileOutputStream fos = new FileOutputStream(file,true);
            FileInputStream fis = new FileInputStream(file);
            fos.write(o.getBytes());
            fos.flush();
           int lenc = 0;
           int lc = 0;
           while ((lenc = fis.read()) != -1){
//               System.out.println(lenc);
               ++lc;
           }
           fos.close();
           fis.close();

            System.out.println("========学生管理系统被"+lc+"次访问====");
            System.out.println("-------------学生管理系统-------------");
            System.out.println("---------------1.注 册----------------");
            System.out.println("---------------2.登 录----------------");
            System.out.println("---------------0.退 出----------------");
            System.out.print("请输入你的选择：");
            a = JudgeNo.judge();

            switch (a) {
                case 1:
                   stuui.registed();
                   break;
                case 2:
                    stuui.login();
                    break;
                case 0:
                    System.out.println("退出成功...");
                    ToTxt.Totxt();
                    break;
                default:
                    System.out.println("\t\t\t！！！请输入正确的选项！！！");
            }
            if(a == 0 ){
                break;
            }
        }
    }

}
