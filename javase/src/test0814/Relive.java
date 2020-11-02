package test0814;

public class Relive {
    public static Relive relive ;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("我要满血复活");
        relive = this ;//将定义的对象指向当前对象
        System.out.println("关闭资源。。。。。");
    }
}
