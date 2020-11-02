package test0820.abstractFactory;

public class AbstractFactory {
    public static void main(String[] args) {
        // 告诉工厂是大车还是小车，即需要使用哪一个工厂
        Factory factory = new BigFactory();
        // 创建管理对象
        Manager manager = new Manager();
        Car car = manager.anpai(factory,"green");
        car.drive();
    }
}
// 定义汽车接口
interface Car{
    public void drive();
}
// 定义两个子接口
interface Green extends Car{
    public void green();
}
interface Black extends Car{
    public void black();
}
// 具体车的实现
class BigCarGreen implements Green{

    @Override
    public void drive() {
        System.out.println("开大车");
    }

    @Override
    public void green() {
        System.out.println("开绿色的大车");
    }
}
class BigCarBlack implements Black{

    @Override
    public void drive() {
        System.out.println("开大车");
    }

    @Override
    public void black() {
        System.out.println("开黑色的大车");
    }
}
class MiddleCarGreen implements Green{

    @Override
    public void drive() {
        System.out.println("开中车");
    }

    @Override
    public void green() {
        System.out.println("开蓝色的中车");
    }
}
class MiddleCarBlack implements Black{

    @Override
    public void drive() {
        System.out.println("开中车");
    }

    @Override
    public void black() {
        System.out.println("开黑色的中车");
    }
}
interface Factory{
    public Green getGreen();
    public Black getBlack();
}
// 定义具体工厂
class BigFactory implements Factory{

    @Override
    public Green getGreen() {
        new BigCarGreen().green();
        return new BigCarGreen();
    }

    @Override
    public Black getBlack() {
        return new BigCarBlack();
    }
}
class MiddelFactory implements Factory{

    @Override
    public Green getGreen() {
        return new MiddleCarGreen();
    }

    @Override
    public Black getBlack() {
        return new MiddleCarBlack();
    }
}
// 定义一个管理类
class Manager{
    public Car anpai(Factory f,String color){
        Car car = null;
        if ("black".equals(color))
            car = f.getBlack();
        if ("green".equals(color))
            car = f.getGreen();
        return car;
    }
}


