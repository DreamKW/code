package test0814;

public class Home {
    public static void main(String[] args) {
        //concat() 字符串的拼接
        String s1 = "我随渺小，";
        String s2 = "却唯一";
        System.out.println(s1.concat(s2));
        //contains() 判断字符串a 中是否有a1字符串
        String a = "人 苇草";
        String a1 = "人";
        System.out.println(a);
        System.out.println(a1);
        System.out.println(a.contains(""));
        //split() 将字符串转换为字符数组 按指定的字符进行分割
        String f = "a,s,d,f";
        String [] fh = f.split(",",3);
        for (String s :
                fh) {
            System.out.println(s);
        }
        //trim()去掉字符串两端的空格
        String  k  = "    人是能思想的苇草     ";
        k = k.trim();
        System.out.println(k);
        System.out.println("=========");
        System.out.println('a' + 0);
        System.out.println('1' + 0);
        System.out.println('0' + 0);
        System.out.println("1" + 0 );
    }
}
