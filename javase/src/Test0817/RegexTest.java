package Test0817;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        String regex = "^((183)|(15[^4])|(182))\\d{8}$";
        //创建一个Pattern对象
        Pattern p = Pattern.compile(regex);
        //定义多个手机号，匹配
        String [] phoneNumbers = {"18215499930","18317363032"};
        String phoneNumber = "1999349102";
        //使用增强for循环迭代数组
        for (String x :
                phoneNumbers) {
            //使用Pattern对象，为每一个手机号码生成匹配器
            Matcher matcher = p.matcher(x);
            //使用匹配器的matches方法进行匹配，返回true表示匹配成功，
            // 格式正确；否则表示格式不正确
            boolean flag = matcher.matches();
            if (flag){
                System.out.println(x +"对");
            }else {
                System.out.println(x+"错");
            }
        }

    }
}
