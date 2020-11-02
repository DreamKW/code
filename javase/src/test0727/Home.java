package test0727;

public class Home {
    //可变参数
    public static int add(int x ,int... a){
        int sum = x;
        for (int i = 0; i < a.length; i++) {
            sum +=  a[i];
        }
        return sum;
    }
    public static  String add1(String a,String... b){
        String s = a;
        for (int i = 0; i < b.length; i++) {
            s += b[i];
        }
        return s;
    }
    public static void main(String[] a) {
        System.out.println(add(2));
        System.out.println(add(2,6));
        System.out.println(add(2,3,5,6,7,8));
        System.out.println(add1("wo"," ","ai"," ","zu"," ","guo"));

    }
}
