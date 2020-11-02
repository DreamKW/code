package test0731;

public class IntegerTest {
    public static void main(String[] args) {
        Integer no1 = 120;
        Integer no2 = 120;
        System.out.println(no1);
        System.out.println(no1 == no2);
        no1 = 130;
        no2 = 130;
        System.out.println(no1 == no2);
//        ？
        int no3 = 130;
        int no4 = 130;
        System.out.println(no3 ==  no4 );


        System.out.println("max:"+Integer.MAX_VALUE);
        System.out.println("min:"+Integer.MIN_VALUE);
        System.out.println(Integer.SIZE);
        System.out.println(Integer.parseInt("123"+1));//字符串+数字 会自动把数字转换为然后拼接起来字符
        System.out.println(Integer.parseInt("123"+"1"));
        System.out.println(Integer.parseInt("123")+1);

    }
}
