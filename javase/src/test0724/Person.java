package test0724;

public class Person {
    public double height;
    public   double weight;


    public Person() {
        System.out.println("无参的构造方法调用了");
    }

    public Person(double height, double weight) {
        this.height = height;
        this.weight = weight;
        System.out.println("有参的构造方法调用了");
    }

    public void study (){
        System.out.println("学习不是学生特有的特征！！！");
    }


}
