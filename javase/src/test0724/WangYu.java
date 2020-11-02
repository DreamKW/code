package test0724;

import java.util.Scanner;

public class WangYu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] grade = new int[2][3];
        for (int i = 0; i < grade.length; i++) {
            if (i == 0) {
                System.out.println("输入一班成绩");
                for (int j = 0; j < grade[i].length; j++) {
                    System.out.println("输入第" + (j + 1) + "个学生的成绩:");
                    grade[i][j] = input.nextInt();
                }
                System.out.println(" ");
            }
            if (i == 1) {
                {
                    System.out.println("输入二班成绩");
                    for (int j = 0; j < grade[i].length; j++) {
                        System.out.println("输入第" + (j + 1) + "个学生的成绩:");
                        grade[i][j] = input.nextInt();
                    }
                    System.out.println(" ");
                }
            }
        }
        System.out.println("12班成绩结果如下");
        for (int i = 0; i < grade.length; i++) {
            if (i == 0) {
                System.out.print("一班的成绩:");
                for (int j = 0; j < grade[i].length; j++) {
                    System.out.print(grade[i][j] + "   ");
                }
            } else if (i == 1) {
                System.out.println();
                System.out.print("二班的成绩:");
                for (int j = 0; j < grade[i].length; j++) {
                    System.out.print(grade[i][j] + "   ");
                }
                System.out.println("");
            }
        }
    }
}


