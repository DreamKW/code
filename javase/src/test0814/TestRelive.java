package test0814;

public class TestRelive {
    public static void main(String[] args) throws InterruptedException {

        //创建relive对象
        Relive.relive = new Relive() ;
        System.out.println(Relive.relive);
        Relive.relive = null ;
        System.out.println(Relive.relive);
        //调用gc方法希望清理relive对象
        System.gc();
        //添加一个休眠时间希望能够等到垃圾回收
        Thread.sleep(2000);
        System.out.println(Relive.relive);
        Relive.relive = null ;
    }

}
