package test0723;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        System.out.println("请输入要判断等级的成绩？");
        int c = new Scanner(System.in).nextInt();
        //多此一举
//       int g ;
//       if (c < 0 & c > 00){
//           System.out.println("输入错误");
//
//       }  else if(c >= 80){
//            g = 1;
//
//        }else if (c >= 70){
//            g = 2;
//
//        }else if(c >= 60){
//            g = 3;
//        }else{
//            g = 4;
//        }
//解决步骤  1.分析问题 几十几十  分级 2 .
        if (c<= 100 & c >= 0){
        switch (c/10){
            case 10 :
            case 9:
                System.out.println("A");
                break;
            case 8:
                System.out.println("B");
                break;
            case 7:
                System.out.println("C");
                break;
             default:
                 System.out.println("D");
        }
        }else{
            System.out.println("请输入正确的数字：");
        }
    }




}
