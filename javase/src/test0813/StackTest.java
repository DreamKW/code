package test0813;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("a");        stack.push("s");
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.pop());//pop删除  peek 不删
        System.out.println(stack.peek());
    }
}
