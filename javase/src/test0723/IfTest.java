package test0723;

import java.util.Scanner;

public class IfTest {
    public static void main(String[] args) {
        int  o1 = 1;

        while(o1 == 1) {
            System.out.println("请输入判断是否为水仙花的数？");
            int a = new Scanner(System.in).nextInt();
            int result = 0;
            int a1 = a;
            //方法一
            for (int i = 100; i > 0; i /= 10) {
                int r  = a1 /i;
                result += r*r*r;
                a1 = a1 - r * i;

            }


//              方法二
//            for (int i = 100; i > 0; i /= 10) {
//                int b = a /100;
//                int s = a % 100 /10;
//                int g = a % 10;
//                 result = b*b*b + s*s*s + g*g*g;
//
//                }

            System.out.println(a == result ?"为水仙花数":"不是，请重新输入");
//            if (a == result) {
//                System.out.println("为水仙花数");
//            }else{
//                System.out.println("不是，请重新输入");
//
//            }

            System.out.println("  继续 请输入 1  退出 请输入 0");
             o1 = new Scanner(System.in).nextInt();
        }






    }

}
