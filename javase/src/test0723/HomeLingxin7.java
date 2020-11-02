package test0723;

import java.util.Scanner;

public class HomeLingxin7 {
    public static void main(String[] args) {
        int a = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("菱形行数只能为奇数 请输入你想要显示的行数：");
              a = (input.nextInt()/2)+2;
//            a = (input.nextInt())+1;
            //行数
        for (int j = 0; j < a ; j++){
            System.out.println();
            //" "的数

            for (int k = 0; k < a - j; k++) {
                System.out.print(" ");
            }
        //*的个数
            for (int i = 0;i < 2 * j - 1;i++){
                System.out.print("*");
            }

        }
        for (int j = a - 2; j > 0 ;j--){
            System.out.println();

            for (int k = 0; k < a - j; k ++) {
                System.out.print(" ");
            }
            for (int i = 0; i < 2 * j - 1 ; i++) {
                System.out.print("*");
            }
        }

    }
}
