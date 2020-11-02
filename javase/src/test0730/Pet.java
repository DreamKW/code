package test0730;

public abstract class Pet {
    int age;
    String name = "pet";
    public Pet(){
        System.out.println("无参的构造方法");
    }
    public Pet(String name){
        this.name = name ;
        System.out.println("有参的构造方法");
    }
    public final void show(){
        System.out.println("final");
    }
    public abstract void eat();
    public void test(){
        System.out.println("我是父类的普通方法测试");
    }
}
