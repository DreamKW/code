package test0807;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
//内省
public class TestIntrospector {
    public static void main(String[] args) throws IntrospectionException, IllegalAccessException, InstantiationException, NoSuchFieldException {
       //通过内省对象得到Student 的Bean(类)信息
       BeanInfo beanInfo =  Introspector.getBeanInfo(Student.class);
       //通过当前的Bean信息获取所有的 属性
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        //遍历所有属性，得到所有的属性名称
        for (PropertyDescriptor p:propertyDescriptors
             ) {
            System.out.println(p.getName());
        }
        System.out.println("----测试getField 方法能否获取只有get/set方法的 属性  结果为不能---------");
        Class  c = Student.class;
        Student student = (Student) c.newInstance();
        Field f = c.getDeclaredField("score");
//        f.setAccessible(true);
//        f.set(student,100);
        System.out.println(f);
    }
}
