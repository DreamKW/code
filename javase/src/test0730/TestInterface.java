package test0730;

public class TestInterface extends Pet implements  FirstInterface,SecondInterface{
    public static void main(String[] args) {
        //测试接口对象
        FirstInterface fi  =new FirstInterfaceImpl();
        fi.eat();
        fi.show();
        Pet pet = new Pet() {
            @Override
            public void eat() {
                System.out.println("dd");
            }
        };
        pet.name = "ss";
//        FirstInterface.NAME ="sdfs";

        fi.test();
        fi.test2();
    }

    @Override
    public void eat() {

    }

//    @Override
//    public void show() {
//
//    }
}
