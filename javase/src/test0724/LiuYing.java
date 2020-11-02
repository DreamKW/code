package test0724;

import java.util.Scanner;

/**
 * 使用二维数组完成2个班，每个班级3个学生的成绩录入
 */
public class LiuYing {

    public static void main(String[] args) {

//        int[][] gradestu = new int[2][3];
//
//        // 第一个班级的三名学生的成绩
//        gradestu[0][0] = 95;
//        gradestu[0][1] = 98;
//        gradestu[0][2] = 100;
//
//        // 第二个班级的三名学生的成绩
//        gradestu[1][0] = 55;
//        gradestu[1][1] = 58;
//        gradestu[1][2] = 60;
//
//        for(int i = 0;i < gradestu.length;i++){
//            System.out.println("第" + (i+1) + "个班级的学生成绩如下:");
//            for(int j = 0;j < gradestu[i].length;j++){
//                System.out.println(gradestu[i][j] + "\t");
//            }
//            System.out.println(" ");
//        }



        int[][] result = new int[2][3];
        Scanner input = new Scanner(System.in);
        for(int i = 0;i < result.length;i++){
            System.out.println("请输入第" + (i + 1) + "个班级的学生的成绩:");
            for(int j = 0;j < result[i].length;j++) {
                System.out.println("请输入第" + (i + 1)  + "个班级第" + (j + 1) + "个学生的成绩:");
                result[i][j] = input.nextInt();
            }
            System.out.println(" ");
        }

        for(int i = 0;i < result.length;i++){
            System.out.println("第" + (i+1) + "个班级的学生成绩如下:");
            for(int j = 0;j < result[i].length;j++){
                System.out.println(result[i][j] + "\t");
            }
            System.out.println(" ");
        }
    }
}
