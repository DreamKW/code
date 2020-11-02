package Test0817.home;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailTest {
    public static void main(String[] args) {
        //定义邮箱正则表达式
        String email ="^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        //将正则表达式编译成Pattern对象
        Pattern pattern = Pattern.compile(email);
        //使用pattern对象，为每一个邮箱号生成匹配器
        Matcher matcher = pattern.matcher("123@qq.com");
        //使用匹配器的matchers 方法进行匹配
        boolean flag = matcher.matches();
        if( flag){
            System.out.println("√");
        }else {
            System.out.println("X");
        }
    }





}
