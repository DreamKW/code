package test0803;

public class ThrowsAndTry  {

    public  void test () throws Exception{
        System.out.println(10/0);
    }
    public void show (){
        try{
            System.out.println(10/0);
        }catch (Exception e){
//            e.printStackTrace();
            System.exit(0);
        }finally {
            System.out.println("000000");
        }
    }

    public static void main(String[] args) {
        new ThrowsAndTry().show();
    }
}
