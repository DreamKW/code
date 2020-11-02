package test0723;

import java.util.Scanner;

public class Homerunnian1 {
    public static void main(String[] args) {
        int n  = 0;
        Scanner input = new Scanner(System.in );
        while(true){
            System.out.println("判断是否为闰年的年份：");
            while(true){
                if(input.hasNextInt()){
                    n = input.nextInt();
                    break;
                }else{
                    System.out.println("请输入数字：");
                    input = new Scanner(System.in);
                }
            }
            if(((n % 4 == 0) & (n%100 != 0))|| n % 400 == 0 ){
                System.out.println(n+"年为闰年");
            }else{
                System.out.println(n+"年不是闰年");
            }
            System.out.println("是否继续判断？ 继续请输入 ：1   退出 ：0");
            int j = 0;
            while (true){
                if (input.hasNextInt()) {
                    j = input.nextInt();
                    if ( j ==1 | j ==0){
                        break;
                    }else{
                        System.out.println("请输入正确的选项：");
                        input = new Scanner(System.in);
                    }
                }else{
                    System.out.println("请输入正确的选项：");
                    input = new Scanner(System.in);
                }
            }
            //怎样判断输入的数字是正确的选项
            if (j == 0){
                break;
            }

        }



    }
}
