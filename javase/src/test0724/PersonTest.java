package test0724;

public class PersonTest {
    public static void main(String[] args) {
        //无参数的构造方法 先创建 在对 属性赋值
        Person p1 = new Person();
        p1.height = 170;
        p1.weight = 120;
        System.out.println(p1.height + "  " + p1.weight);

        //有参数的构造方法 先创建 在对 属性赋值
        Person p2 = new Person(198,150);
        System.out.println(p2.height + "  " + p2.weight);
    }
}
