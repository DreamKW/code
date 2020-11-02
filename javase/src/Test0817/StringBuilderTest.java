package Test0817;

public class StringBuilderTest {
    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder("hello");
        stringBuilder.append("world");
        stringBuilder.deleteCharAt(1);
        System.out.println(stringBuilder);
        stringBuilder.replace(2,4,"aa");
        System.out.println(stringBuilder);
    }
}
