package test0724;

public class ClassTest {
    //没有构造方法

    //无参的方法
    public void test (){
        System.out.println("无参的方法执行啦");
    }
    //基本数据类型做参数
    public void test (int age){
        System.out.println("年龄："+age);
    }
    //引用数据类型做参数
    public void test (String name){
        System.out.println("姓名："+name);
    }
    //对象做参数
    public void test (Person person){
        System.out.println("身高："+person.height +"体重："+person.weight);
        System.out.print("学习？");
        person.study();
    }
    //数组做参数
    public void test (int [] score){
        for (int s : score) {
            System.out.print(s+" ");
        }
    }
    //对象数组做参数
    public void test (Person[] ps){
        for (Person p : ps) {
            System.out.print("\n身高："+p.height+"体重："+p.weight);
        }
    }
}
