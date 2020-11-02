package test0820;

public class MethodFactory {
    interface Car{
        void driver();
    }
    static class BigCar implements Car{

        @Override
        public void driver() {
            System.out.println("BigCar");
        }
    }
    static class SmallCar implements Car{

        @Override
        public void driver() {
            System.out.println("SmallCar");
        }
    }

    interface Factory {
        public Car anpai(String carname);
    }
    static class BigFactory implements Factory{

        @Override
        public Car anpai(String carname) {
            return new BigCar();
        }
    }

    static class  SmallFactory implements  Factory{

        @Override
        public Car anpai(String carname) {
            return new SmallCar() ;
        }
    }

    public static void main(String[] args) {
        Factory factory = new BigFactory();
//        factory = new SmallFactory();
        Car car = factory.anpai("big");
        car.driver();
    }
}
