package test0724;

public class TwoDateTest {
    public static void main(String[] args) {
        int [] [] mi = {{1,0,0},{1,0}};
        System.out.println(mi.length);//mi的元素个数
        System.out.println(mi[0].length);//数组mi 第一个元素的元素个数
        System.out.println(mi[1].length);


        for(int i = 0 ; i < mi.length;i++){
            for (int j = 0; j < mi[i].length; j++) {
                System.out.print(mi[i][j]+" ");
            }
            System.out.println();
        }
    }
}
