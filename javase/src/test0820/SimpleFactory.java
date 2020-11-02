package test0820;

public class SimpleFactory {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Car car = factory.anpai("b");
        if (car !=null)
            car.driver();
    }
}
//车接口
 interface Car{
    public void driver();
}
 class BigCar implements Car{

    @Override
    public void driver() {
        System.out.println("big");
    }
}

class MidCar implements Car{
    @Override
    public void driver() {
        System.out.println("Mid");
    }
}

//创建一个工厂类用来管理车，
class Factory{
    public Car anpai (String cars){
        if ("big".equals(cars)){
            return new BigCar();
        }else if ("mid".equals(cars)){
            return new MidCar();
        }else {
            new RuntimeException("无").printStackTrace();
        }
        return null;
    }
}
