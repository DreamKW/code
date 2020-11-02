package test0723;

import java.util.Scanner;

public class Chengfabiao {
    public static void main(String[] args) {
        System.out.println("请输入成绩");
        Scanner input = new Scanner(System.in);

        for(int i = 1 ; i < 4 ;i++){
            System.out.println("第"+i+"次");
//            int c = new Scanner(System.in).nextInt();
            int c = input.nextInt();
        }


    }
}
