package class1027;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Gril {
    private String name;
    private int age;
    @Value("jack")

/*    @PostConstruct
    public void first(){
        System.out.println("初始化方法");
    }
    @PreDestroy
    public void second(){
        System.out.println("销毁方法");
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Gril{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
