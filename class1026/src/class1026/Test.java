package class1026;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
public class Test {





    @org.junit.Test
    public void testSpring(){
//        创建容器实例
        ApplicationContext context =new ClassPathXmlApplicationContext("/applicationContext.xml");

//        没有使用容器的时候，我们需要使用new来创建实例
        System.out.println("使用容器前");
        Dog dog = new Dog();
        dog.setAge(2);
        dog.setName("erha");
        System.out.println(dog);
//        使用容器后
//        从容器中取出dog对象
        Dog dog1 = (Dog) context.getBean("dog");
//        dog1.setName("ggg");
//        dog1.setAge(1);
        System.out.println(dog1);

    }
    @org.junit.Test
    public void testFactory(){
        //        创建容器实例
        ApplicationContext context =new ClassPathXmlApplicationContext("/applicationContext.xml");
        Product product = (Product) context.getBean("product");
        product.test();
        System.out.println("测试普通工厂");
        Product product1 = (Product) context.getBean("pro");
        product1.test();
    }
@org.junit.Test
    public void testSingleton(){
        ApplicationContext context =new ClassPathXmlApplicationContext("/applicationContext.xml");
        Dog dog1 = (Dog) context.getBean("dog");
        Dog dog2 = (Dog) context.getBean("dog");
        System.out.println(dog1 == dog2);
    }
// 依赖注入
  @org.junit.Test
  public void getDog(){
        ApplicationContext context =new ClassPathXmlApplicationContext("/applicationContext.xml");
        Boy boy = (Boy)context.getBean("boy");
        System.out.println("对象注入");
        System.out.println(boy.getDog().getName());
        System.out.println(boy.getProduct());
        System.out.println("基本数据类型的依赖注入");
        System.out.println(boy.getAddress());

        System.out.println("list集合的依赖注入");
          List ll =  boy.getList();
          for (int i = 0; i < ll.size(); i++) {
              Object obj = ll.get(i);
              if (obj instanceof Dog){
                  System.out.println(obj);
              }else {
                  System.out.println(obj);
              }
          }
      System.out.println("set集合的依赖注入");
      Boy boy1 = (Boy)context.getBean("boy1");
      Set hs = boy1.getSet();
      for (Object s:
           hs) {
          if (s instanceof Dog){
              System.out.println(s);
          }else {
              System.out.println(s);
          }
      }
//作业三
// map 的依赖注入测试
      System.out.println("map 的依赖注入测试");
      Map map = boy.getMap();
          Set set = map.keySet();
      Iterator it = set.iterator();
      while (it.hasNext()){
          Object obj = it.next();
          System.out.print("key:");
          if (obj instanceof Dog){
              System.out.println(((Dog) obj).getName());
          }else {
              System.out.println(obj);
          }
          System.out.print("value:");
          if ( map.get(obj) instanceof Dog){
              System.out.println(((Dog) map.get(obj)).getName());
          }else {
              System.out.println(obj);
          }
//          System.out.println(obj .toString() + "   " + map.get(obj));
      }
      System.out.println("map泛型依赖注入");
      Map<Integer,Dog> dogMap =  boy1.getDogMap();
      for (int i = 0; i < dogMap.size(); i++) {
          Object obj = dogMap.get(i);
          System.out.println(((Dog) obj).getName());
      }
    }
}
