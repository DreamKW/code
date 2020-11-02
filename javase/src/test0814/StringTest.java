package test0814;

public class StringTest {
    public static void main(String[] args) {
        String str1 = new String(new char[]{'a','b'});
        String str2 = "sadf";
        String str3 = new String();
        System.out.println(str1.length());
        System.out.println(str2.length());
        System.out.println(str3.length());
        System.out.println( '下' == '下');
        System.out.println("x" == "X");
        System.out.println(Character.toUpperCase('A'));
        String s = str1.concat(str2);
    }
}
