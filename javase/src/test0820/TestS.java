package test0820;

public class TestS {
    public static void main(String[] args) {
        TestSingle testSingle = TestSingle.getInstance();
        TestSingle testSingle1 = TestSingle.getInstance();
        System.out.println(testSingle == testSingle1);
        HungrySingle hs1 = HungrySingle.getInstance();
        HungrySingle hs2 = HungrySingle.getInstance();
        System.out.println(hs1 == hs2);
    }

}
