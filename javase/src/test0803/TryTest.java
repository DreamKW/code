package test0803;

public class TryTest {
    public static void main(String[] args) {
        try {
            System.out.println(10/1);
            System.exit(0);

        }catch (Exception e){
            System.out.println("0");
            e.printStackTrace();
            System.out.println("========");
        }finally {
            System.out.println("对错都来");
        }
    }
}
