package testXian;

public class TestOverRide {
    public static void main(String[] args) {
        Base b = new Sub();
        System.out.println(b.x);
        System.out.println(b.method());
    }
}
class Base{
    int x = 2;
    int method () {
        return x;
    }
}
class Sub extends  Base{
    int x = 3;
    int method (){
        return x;
    }
}

