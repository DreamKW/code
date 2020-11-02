package test0731;

public class OuterClass2 {
    String name  ;
    int age;
    public void test(){
         class InnerClass{
            public void show(){
                name ="a";
                age = 1;
                System.out.println(name + " "  + age );
            }
        }
        InnerClass innerClass = new InnerClass();
        innerClass.show();
    }
    public static void main(String[] args) {
        OuterClass2 outerClass2 = new OuterClass2();
        outerClass2.test();
    }
}
