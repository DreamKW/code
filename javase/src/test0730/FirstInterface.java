package test0730;

public interface FirstInterface extends SecondInterface ,Role {
    //接口中只有常量没有变量
    public String NAME = "rose";

    public abstract  void eat ();
    public   void  show();
    //默认方法 可以有方法体
    default  void test(){
        System.out.println("我是JDK8以后的方法(第一个默认方法)");
    }
    default void test2(){
        System.out.println("第二个默认方法a");
    }
}
