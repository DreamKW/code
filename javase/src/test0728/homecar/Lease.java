package test0728.homecar;

import test0722.JudgeNo;

import java.util.Scanner;

public class Lease {
    Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int cost = 0;
        String type = "";

        System.out.println("=============汽车租赁系统=============");
        System.out.println("请输入你选择的车型 轿车 ：1   客车：2 \n");


        switch (JudgeNo.judge()){
            case 1:
                System.out.println("=========轿车车型=========");
                System.out.println("=======1.别克商务舱=======");
                System.out.println("=======2. 宝马550i =======");
                System.out.println("=======3.别克林荫大道=====");
                System.out.println("请输入你选择的轿车车型对应的数字:");
                switch (JudgeNo.judge()){
                    case 1:

                    case 2:
                    case 3:
                }

                break;

            case 2:
                System.out.println("=========客车车型=========");
                System.out.println("=======1.<= 16座  =======");
                System.out.println("=======2. > 16座  =======");
                System.out.println("请输入你选择的客车车型对应的数字:");
                switch (JudgeNo.judge()){
                    case 1:
                        XKeCar xKeCar= new XKeCar();
                       cost =  xKeCar.cost = 800;
                       type = xKeCar.type = "<16座客车";
                       break;
                    case 2:
                }

                break;
        }


        System.out.println("请输入您租车的天数：");
         int day = JudgeNo.judge();


        System.out.println("您租"+type+"车"+day+"天共需要花费"+cost*day+""+"元。");

    }
}
