package test0804;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueTest {
    public static void main(String[] args) {
        //常见的非阻塞队列
        ConcurrentLinkedDeque<Integer>  que = new ConcurrentLinkedDeque<>();
        que.add(1);
        que.add(2);
        que.add(3);
        //出队列
        System.out.println(que.peek());
        System.out.println(que.poll());
        System.out.println(que.poll());
        //阻塞队列
        BlockingDeque<String> bd = new LinkedBlockingDeque<>(2);
        bd.add("hello");
        bd.add("world");
        System.out.println(bd.peek());
        System.out.println(bd.poll());
        System.out.println(bd.poll());
    }
}
