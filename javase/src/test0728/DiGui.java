package test0728;

public class DiGui {
    public int jieChen(int num){
        if(num == 1){
            return 1;
        }else {
            return jieChen(num - 1)*num;
        }
    }

    public static void main(String[] args) {
        System.out.println(new DiGui().jieChen(3));
    }
}
