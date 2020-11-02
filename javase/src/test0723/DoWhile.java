package test0723;

import java.util.Scanner;

public class DoWhile {
    public static void main(String[] args) {
        int i  = 1 ;
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("我是一个快乐的程序员吗 ？ 快乐 是 1 ");
            while(true){
                if (input.hasNextInt()){
                    i= input.nextInt();
                    break;
                }else{
                    System.out.println("请输入数字：");
                    input = new Scanner(System.in);
                }
            }


        }while( i == 1);

    }
}
