package Test0817;

public class TestStringBuffer {
    public static void main(String[] args) {
        String name = "hello";
        StringBuffer stringBuffer = new StringBuffer("hello");
        stringBuffer.append("world");
        System.out.println(stringBuffer);
        name = name.concat("world");
        System.out.println("string concat:" + name);

    }
}
