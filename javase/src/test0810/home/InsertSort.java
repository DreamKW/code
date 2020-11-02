package test0810.home;
//插入排序法
public class InsertSort {

    public static void insertSort(int[] arr) {
        // 空数组 或 只有一个元素的数组，则什么都不做。
        if (arr == null || arr.length == 0) return;
        // 外层循环的 i 代表有序区的最后一个元素。
        for (int i = 0; i < arr.length - 1; i++) {
            // 待插入的元素暂存到value.
            int value = arr[i + 1];
            int j = i;
            // j < 0 时退出循环，说明 j 是最小的元素的索引值。
            // 或者 arr[j] <= value 时退出循环，说明 j 是比value小的元素的索引值。
            for (; j >= 0 && arr[j] > value; j--) {
                // 把元素往后挪。
                arr[j + 1] = arr[j];
            }
            // 把待插入元素，放到正确位置。
            arr[j + 1] = value;

            // 把每一趟排序的结果也输出一下。
            System.out.print("第 "+ (i+1) + " 趟: ");
            print(arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 9, 1, 4, 5, 8, 7, 0, 2, 3};

        System.out.print("排序前:  ");
        print(arr);

        insertSort(arr);

        System.out.print("排序后:  ");
        print(arr);
    }

    // 打印数组
    public static void print(int[] arr) {
        if (arr == null)    return;

        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
