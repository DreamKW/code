package test0730.homeinterface;

public class TestPrinter {


    public static void main(String[] args) {

        //结果导向型  看最后要是怎样的实现 方法里面获取纸张颜色的（属性的表达） 方法return 返回 该表达式

        //这有两种方法 一种是在 创建打印机的时候就赋予参数 然后打印方法使用打印机里的参数
        //另外一种是 创建打印机时不传参数 调用打印方法时传入参数  好处 不用重复创建新的打印机对象

        //键盘输入颜色与纸张大小的方法：然后可以利用 switch 嵌套 或者 if else 嵌套 调用不同的方法
        //先判断纸张大小 A4 然后判断颜色

        Printer printer= new Printer();

        printer.printer(new A4Papper(),new ColorD());

        System.out.println("===================");
//        Printer printer1= new Printer();
        printer.printer(new B5Papper(),new Colors());





//lamda

//        PrinterLamda A4HB = ( ) -> System.out.println("使用A4纸");

    }


}
