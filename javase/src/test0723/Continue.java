package test0723;

public class Continue {
    public static void main(String[] args) {

        System.out.println("逢3和3的倍数过 的游戏");
        for(int i = 0 ;i <= 10;i++){
            if (i % 3  == 0){
                continue;
            }
            System.out.println(i);

        }
    }
}
