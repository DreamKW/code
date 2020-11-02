package test0723;

import java.util.Scanner;

public class While {
    public static void main(String[] args) {
        String mima = "123";
        int i = 1;
//        int a;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入你的密码：");
        while (i < 4 ){
            String mi = input.next();
            if(mi.equals(mima) ){
                System.out.println("密码正确");
                break;
            }
//            a = 3 - i;
            System.out.println("输入错误 ！ 请重新输入： 你还有" +(3-i) +"次机会");
            i += 1 ;
        }





    }
}
