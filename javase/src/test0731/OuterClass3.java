package test0731;

public class OuterClass3 {
    public static String name ;
    public  int age ;
    //static 不可以修饰类 但是可以修饰内部类
    public  static class InnerClass{
        public static String ok;
        public void test(){
            name = "xx";
            System.out.println(name);
        }
    }
    public void show(){
        new OuterClass3.InnerClass().test();
    }

    public static void main(String[] args) {
        OuterClass3 outerClass3 = new OuterClass3();
        outerClass3.show();

    }
}
