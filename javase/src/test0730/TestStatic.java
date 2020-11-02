package test0730;

public class TestStatic {
    public static String name;
    public String oldname;
    public static void main(String[] args) {
        TestStatic ts1  =new TestStatic();
        ts1.name = "a";
        ts1.oldname = "oa";
        TestStatic ts2 = new TestStatic();
        ts2.name = "b";
        ts2.oldname = "ob";
        TestStatic.name = "测试一下";
        System.out.println("1."+ts1.name+"2."+ts1.oldname);

        System.out.println("1."+ts2.name+"2."+ts2.oldname);
    }
}
