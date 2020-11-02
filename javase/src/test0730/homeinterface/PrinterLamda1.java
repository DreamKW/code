package test0730.homeinterface;

public class PrinterLamda1 {

    public static void main(String[] args) {
        Papper A4 =() ->  System.out.println("使用A4纸");
        Papper B5 =() ->  System.out.println("使用B5纸");
        Color HB = () -> System.out.println("黑白墨水");
        Color cs = () -> System.out.println("彩色墨水");
        PrinterLamda1 printerLamda = new PrinterLamda1();
        printerLamda.printer(A4,HB);
    }

    public interface Papper{
//    使用lamda表达式 方法只能有一个
         public void size();
    }

    public interface Color{
        public void color();
    }

    public void printer(Papper papper,Color color){
        papper.size();
        color.color();
    }

}
