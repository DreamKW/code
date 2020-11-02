package test0803;

import java.util.Arrays;

public class ExceptionTest {
    public static void main(String[] args) {
//        System.out.println(10/0);
        int [] test = new int[2];
        int [] test1 = new int[4];
        test = test1;
        System.out.println(test.length);
        System.out.println(test);
        System.out.println(test1.length);
        System.out.println(test1);
        System.out.println("============");
        int [] score = {20,10};
        int [] scores = new int[score.length*2];
        scores = score;
//        System.out.println(score.toString());这样写打印出来的仍然是地址
        System.out.println(Arrays.toString(score));
        System.out.println(Arrays.toString(scores));
        System.out.println(scores.length);
        System.out.println("===============");
        int [] score2 = new int[4];//4相当与score.length*2
        for (int i = 0; i < score.length; i++) {
            score2[i] = score[i];
        }
        System.out.println(Arrays.toString(score));
        System.out.println(Arrays.toString(score2));
        System.out.println("=============");
        Object obj =  new Object();
//        String str0 = (String) obj;
        obj = "";//方法一
        String str = (String) obj;
        if (obj instanceof String){//方法二
            String str1 = (String) obj;
        }



    }
}
