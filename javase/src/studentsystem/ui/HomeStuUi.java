package studentsystem.ui;
import studentsystem.service.StudentService;
import studentsystem.serviceImpl.ReflectSvImpl;
import test0722.JudgeNo;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class HomeStuUi {
    public void home() throws Exception {
        StudentService sv = new ReflectSvImpl();

        Scanner input = new Scanner(System.in);
        int c =1;
        while( c== 1) {
            System.out.println("------------学生主页----------");
            System.out.println("-----------1.专业查询----------");
            System.out.println("-----------2.成绩查询----------");
            System.out.println("-----------3.学费查询----------");
            System.out.println("-----------4.信息查询 ---------");
            System.out.println("-----------5.信息修改 ---------");
            System.out.println("-----------6.返回上级 ---------");
            int b = JudgeNo.judge();
            StudentUi studentUi = new StudentUi();

            switch (b) {
                case 1:
                    System.out.println("-----------1.专业查询---------");
                    System.out.println("\n\n\n\n");
                    break;
                case 2:
                    System.out.println("-----------2.成绩查询---------");
                    System.out.println("\n\n\n\n");
                    break;

                case 3:
                    System.out.println("-----------3.学费查询---------");
                    System.out.println("\n\n\n\n");
                    break;
                case 4:
                    System.out.println("-----------4.信息查询---------");
                    studentUi.select();
                    break;
                case 5:
                   studentUi.update();
                    break;

                case 6:
                    c = 0;
                    break;
            }
            if(c == 0 ){
                break;
            }

        }
    }
}
