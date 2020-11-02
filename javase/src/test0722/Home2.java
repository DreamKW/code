package test0722;

import java.util.Scanner;

public class Home2 {

     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = 0;

        while(true) {
            System.out.println("------------学生管理系统--------------");
            System.out.println("---------------1.注 册----------------");
            System.out.println("---------------2.登 录----------------");
            System.out.println("---------------0.退 出----------------");
            System.out.print("请输入你的选择：");

            a = JudgeNo.judge();
//            while(true){
//                if (input.hasNextInt()){
//                    a = input.nextInt();
//                    break;
//                }else{
//                    System.out.println("请输入数字：");
//                    input = new Scanner(System.in);
//                }
//            }
            switch (a) {
                case 1:
                    System.out.println("---------------注册-------------");
                    System.out.println("--------请输入你的学号：----------");
                    int stunum = JudgeNo.judge();
                    System.out.println("--------请输入你的年龄：----------");
                    int stuage = JudgeNo.judge();
                    System.out.println("--------请输入你的专业：----------");
                    String stuap = input.next();
                    System.out.println("--------请输入你的密码：----------");
                    String stumi = input.next();
                    System.out.println("------------注册成功-------------");
                    break;



                case 2:
                    int c1 = 0;
                    int stunum1 =0;
                    while (c1 < 3){
                        System.out.println("--------------登录----------------");
                        System.out.println("--------请输入你的学号：----------");

                        stunum1 = JudgeNo.judge();
//                        while(true){
//                            if (input.hasNextInt()){
//                                stunum1  = input.nextInt();
//                                break;
//                            }else{
//                                System.out.println("请输入正确的学号：");
//                                input = new Scanner(System.in);
//                            }
//                        }

                        System.out.println("--------请输入你的密码：----------");
                        String stumi1 = input.next();
                        System.out.println("------------正在登录---------------");

                        if(stunum1 == 123 && stumi1.equals("123")){
                            System.out.println("------------登录成功-------------");
                            break;
                        }else{
                            System.out.println("登录失败，您剩余"+(2-c1)+"次机会");
                            c1 += 1;


                        }

                    };
                    if ( c1 ==  3){
                        break;
                    }


                    int c =1;
                    while( c== 1) {
                        System.out.println("-----------1.学费查询---------");
                        System.out.println("-----------2.成绩查询---------");
                        System.out.println("-----------3.专业查询---------");
                        System.out.println("-----------4.返回上级 ---------");
                        int b = JudgeNo.judge();
//                        while (true){
//                            if (input.hasNextInt()){
//                                b = input.nextInt();
//                                break;
//                            }else {
//                                input = new Scanner(System.in);
//                                System.out.println("请输入数字");
//                            }
//                        }

                        switch (b) {
                            case 1:
                                System.out.println("-----------1.学费查询---------");
                                System.out.println("\n\n\n\n");
                                break;
                            case 2:
                                System.out.println("-----------2.成绩查询---------");
                                System.out.println("\n\n\n\n");
                                break;

                            case 3:
                                System.out.println("-----------3.专业查询---------");
                                System.out.println("\n\n\n\n");
                                break;
                            case 4:
                                c = 0;
                                break;
                        }
                        if(c == 0 ){
                            break;
                        }

                    }
                    break;



                case 0:
                    System.out.println("退出成功...");
                    break;
            }
            if(a == 0 ){
                break;
            }


        }
    }

}
