package test0722;

public class Home1 {
    public static void main(String[] args) {
        int a= 1;
        int b = 5;
        if(a++< 3 || b-->5){
            System.out.println(a);
            System.out.println(b);
            System.out.println("=====");
        }
        if(a++ < 3 | b-->5){
            System.out.println(a);
            System.out.println(b);
        }
    }
}
