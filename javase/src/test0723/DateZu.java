package test0723;

import java.util.Scanner;

public class DateZu {
    public static void main(String[] args) {
        System.out.println("请输入数组的长度：");
        int a = new Scanner(System.in).nextInt();
        int score [] = new int [a];
        for(int i = 0;i < a;i++){
            score[i] = i * 10;
        }
        for (int i = 0; i < a; i++) {
            System.out.print(score[i]+" ");
        }
    }
}
