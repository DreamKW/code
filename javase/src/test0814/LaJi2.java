package test0814;

public class LaJi2 {
    static LaJi l1;

    public static void main(String[] args) {
        LaJi2 l1 = new LaJi2();
        LaJi.l2 = l1;
        l1 = LaJi.l2;
    }
}
