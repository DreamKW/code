package test0810.home;

//冒泡排序法
import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int [] a = {1,6,4,9,4,44,3,3,56};
        BubbleSort bubbleSort = new BubbleSort();
        sort(a);
        System.out.println(Arrays.toString(a));
    }


    public static void sort(int[] a) {
        for(int i=a.length-1;i>=0;i--){ //i控制比较的轮数
            for(int j=0;j<i;j++){ //j每一轮比较的次数
                if(a[j]>a[j+1]){
                    int temp =a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
//                    a[j]=a[j]^a[j+1];
//                    a[j+1]=a[j]^a[j+1];
//                    a[j] = a[j]^a[j+1];
                }
            }
        }
    }
}
