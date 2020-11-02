package test0731;

public class OuterClass {
    String name= "asd";
    int age;
    public class InnerClass{
        public  void test(){
            name = "测试";
            age = 18;
            System.out.println(name + " " + age);
        }

    }

    public static void main(String[] args) {
        OuterClass oc = new OuterClass();
        OuterClass.InnerClass innerClass = oc.new InnerClass();

        OuterClass.InnerClass innerClass2 = new OuterClass().new InnerClass();
        innerClass.test();
        innerClass2.test();
    }

}
