package Test0817;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) throws ParseException {
        String str = "2020/08/08";
        //转换date格式
        Date date = new Date();
        System.out.println("转换前：" + date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");//大写的M
        String s = sdf.format(date); //把默认的date格式设置为自己设定的格式
        System.out.println("转换后："  + s);

        Date date1 = new Date(str);//底层使用的是parse方法  把String类型转换为date
        System.out.println(date1);

        Date date2 = new Date(s);  //底层使用的是parse方法  把自己设置的date格式 设置为parse方法的date格式
        System.out.println(date2);

        date = sdf.parse(str);//parse方法的特点是按照自己的格式显示日期
        System.out.println(date);


    }
}
