package test0723;

import java.util.Scanner;

public class Home4 {
    public static void main(String[] args) {
        System.out.println("请输入你的成绩：");
        Scanner input = new Scanner(System.in);
        int c =0;
        while(true){
            if(input.hasNextInt()){
               c = input.nextInt();
                if (c < 0 || c > 100){
                    System.out.println("请输入正确的成绩：");
                    input = new Scanner(System.in);
                }else {
                    break;
                }
            }else{
                System.out.println("请输入正确的成绩：");
                input = new Scanner(System.in);
            }
        }


         if(c >= 80){
            System.out.println("优秀");

        }else if (c >= 70){
            System.out.println("良好");

        }else if(c >= 60){
            System.out.println("及格");

        }else{
            System.out.println("不及格");


        }
    }
}
