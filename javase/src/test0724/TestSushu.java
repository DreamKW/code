package test0724;

import java.util.Scanner;

public class TestSushu {
    public static void main(String[] args) {
        int nu = 0;
        int s = 0;
        System.out.println("请输入一个判断是否为素数的数？");
        Scanner input = new Scanner(System.in);
        while (true){
            if (input.hasNextInt()){
                nu = input.nextInt();
                if(nu > 1){
                    for (int i = 2 ;i < nu ;i++){


//                        if (nu % i == 0){
//                           s = 1;
//                            break;
//                        }else {
//                            s = 2;
//                        }
                    }

                    System.out.println(s == 1 ?"不是素数":"是素数");
//                    以下注释语句与 （System.out.println(s == 1 ?"不是素数":"是素数");）作用相同


//
//                    if (s == 1){
//                        System.out.println("不是素数");
//                        break;
//
//                    }else {
//                        System.out.println("是素数");
//                        break;
//
//                    }
                }else {
                    System.out.println("不是素数");
//                    break;
                }

            }else {
                System.out.println("请输入数字：");
                input =new  Scanner(System.in);
            }

        }

    }
}
