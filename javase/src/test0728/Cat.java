package test0728;

public class Cat extends  Animal {
    public Cat(){
        System.out.println("cat的构造方法");

    }
    public Cat (String name){
        this();
        this.name = name;
    }
//    public Cat (){
//        super();
//    }
public void show(){
    System.out.println("我是子类mao的方法");
}
    public void eat(){
        System.out.println(name +"爱吃鱼");
//        System.out.println("调用父类的方法：");
//        super.eat();
//        this.show();
//        show();

    }
}
