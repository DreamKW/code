package test0723;

import java.util.Scanner;

public class Homegrade3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您的等级：");
        char g = input.next().charAt(0);
        switch (g){
            case 'A':
                System.out.println("获得特等奖");
                break;
            case 'B':
                System.out.println("获得一等奖");
                break;
            case 'C':
                System.out.println("获得二等奖");
                default:
        }
    }
}
