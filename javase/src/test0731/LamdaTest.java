package test0731;

public class LamdaTest {
    //3.
    public static void main(String[] args) {
        LamdaTest lamdaTest = new LamdaTest();
        MathOperater jia = (int a ,int b) -> a+b;
        MathOperater jian = (int a, int b) -> a-b;
        MathOperater chen = ( a , b) -> a*b;

        System.out.println("10+20="+lamdaTest.getNo(10,20,jia));
        System.out.println("10-20="+lamdaTest.getNo(10,20,jian));
        System.out.println("10*20="+lamdaTest.getNo(10,20,chen));
    }
    //1.
    public interface MathOperater{
        public  int operater(int a, int b);
    }
    //2.定义一个方法，用来进行参数的传递
    public int getNo(int a, int b,MathOperater mathOperater){
        return mathOperater.operater(a,b);
    }
}
