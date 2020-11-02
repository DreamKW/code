package class1027;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
//    测试前置通知
@org.junit.Test
public void doBefore(){
    ApplicationContext ac = new ClassPathXmlApplicationContext("aop.xml");
    Target target = (Target) ac.getBean("target");
    target.getTar("hello");
}
//    测试注解
//    @org.junit.Test
//    public void testAvo(){
//        ApplicationContext ac =  new ClassPathXmlApplicationContext("applicationContext.xml");
//        Gril gril =(Gril) ac.getBean("gril");
//        gril.setAge(20);
//        gril.setName("qq");
//        System.out.println(gril);
//        ((ClassPathXmlApplicationContext) ac).close();
//    }
}
