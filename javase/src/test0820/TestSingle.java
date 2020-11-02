package test0820;

public class TestSingle {
    private TestSingle(){
        System.out.println("私有");
    }
    private static TestSingle testSingle;
//懒汉
    public static synchronized TestSingle getInstance(){
        if (testSingle == null)
            testSingle = new TestSingle();
        return testSingle;

    }
}
