package test0724;

public class DateEnd {
    public static void main(String[] args) {
        //定义数组的三种方式：
        int [] a1  = new int[3];
        int [] a2 = new int [] {1,2};
        int [] a3 ={1,2,3};



        //加强for循环
        for (int a : a3
             ) {
            System.out.print(a + " ");

        }
        System.out.println("\n============");

        //第一种方式

        int [] score;
        score = new int[3];
        for (int i = 0;i < score.length;i++){
            score[i] = i;
            System.out.print(score[i]+" ");
        }


    }
}
