package test0810.home;
//选择排序法
public class SelectSort  {
    public static void main(String[] args) {
        int[] arr = {23,56,42,32,22,17,46};
        for (int i = 0;i < arr.length - 1;i++){ ;
            for (int j = i + 1;j < arr.length;j++){
                if (arr[j] < arr[i]){
                    int k = arr[j];
                    arr[j] = arr[i];
                    arr[i] = k;
                }
            }
        }
        for (int i: arr ) {
            System.out.print(i + " ");
        }
    }

}
