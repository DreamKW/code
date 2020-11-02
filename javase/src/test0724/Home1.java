package test0724;

import java.util.Scanner;

public class Home1 {
    public static void main(String[] args) {
        int g = 0;
        Scanner input = new Scanner(System.in);
        int [] [] stus =  new int[2][3];
        for (int i = 0; i < stus.length; i++) {
            System.out.println("请录入"+(i+1)+"班学生成绩");
            for (int j = 0; j < stus[i].length; j++) {
                System.out.println("请输入第"+(j+1)+"名学生的成绩");

//                stus [i] [j]  = input.nextInt();
                while (true) {
                    if (input.hasNextInt()) {
                        stus [i] [j]  = input.nextInt();
                        if (stus [i][j] < 0  ||  stus [i][j] > 100  ){
                            System.out.println("请输入正确的成绩：");
                        }else{
                            break;
                        }

                    } else {
                        System.out.println("请输入正确的成绩：");
                        input = new Scanner(System.in);
                    }
                }


            }
        }


        for(int i = 0 ; i < stus.length;i++){
            System.out.println((i+1)+"班学生成绩");
            for (int j = 0; j < stus[i].length; j++) {
                System.out.print("第"+(j+1)+"名学生成绩为："+stus[i][j]+" ");
            }
            System.out.println();
        }
    }
}
