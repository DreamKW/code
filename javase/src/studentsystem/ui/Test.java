package studentsystem.ui;



import studentsystem.service.DataService;
import studentsystem.serviceImpl.DataServiceImpl;

public class Test {
    public  void getNo() throws Exception {
            DataService service =  new DataServiceImpl();
        System.out.println("数字："+ service.getNo());
    }



    public static void main(String[] args) throws Exception {
        //main方法只能是程序的入口，即main只是一个入口的调用
        new Test().getNo();

    }
}
