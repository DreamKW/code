package test0724;
import java.util.Scanner;
public class WangTianLi {


        public static void main(String[]args) {
            WangTianLi shuzu = new WangTianLi();
            shuzu.scoreln();
        }
        public void scoreln(){
        int [] [] score ;
        Scanner input = new Scanner(System.in) ;
        score = new int [2] [3] ;
        System.out.println("--录入成绩-- ");
       // 录入成绩
        //班号
        for(int i=0 ; i< score.length ; i ++){
        //判断班级
        if(i == 0){
        System. out. println("录入一班成绩:");
         }
        else if(i == 1){
        System. out. println("录入二班成绩:");
        }
        //录班内域绩
        for(int j = 0; j < score[i]. length; j++) {
            score[i][j] = input.nextInt();
        }
        }
            System. out. println("--成绩结果一");
            for(int i= 0; i < score.length ; i++) {
            if(i == 0){
            System.out. print("一班成绩:");
                for (int j = 0; j < score[i].length; j++) {
                    System.out.print(score[i][j] + "   ");}
            }
        else if(i == 1) {
                System.out.println();
                    System.out.print("二班成绩:");
                    for (int j = 0; j < score[i].length; j++) {
                        System.out.print(score[i][j] + "   ");
                    }
                    System.out.println("");
                }
            }
         }
        }
