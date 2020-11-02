package test0724;

import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
        int [] scores = {34,23,55,11,78,90,188};
        System.out.println("+++++++++++++排序前++++++++++++");
        for (int s :
                scores) {
            System.out.print(s+" ");
        }
        //排序方法
        Arrays.sort(scores);

        System.out.println("\n+++++++++++++排序后++++++++++++");
        for (int s:
        scores){
            System.out.print(s+" ");
        }
        //string方法
        System.out.println("\ntoString 测试");
        System.out.println(scores.toString());//地址
        System.out.println(Arrays.toString(scores));


    }
}
