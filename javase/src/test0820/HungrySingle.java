package test0820;
//饿汉
public class HungrySingle {
    private HungrySingle(){
        System.out.println("HungrySingle");
    }
    private static HungrySingle hungrySingle = new HungrySingle();
    public static  HungrySingle getInstance(){
        return hungrySingle;
    }
}
