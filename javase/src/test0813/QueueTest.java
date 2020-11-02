package test0813;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueTest {
    public static void main(String[] args) {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(4);
        queue.add("as");
        queue.offer("sd");
        queue.remove("a");
        //检索并删除此队列的头
        queue.poll();
        //检索,但不删除此队列的头部,
        queue.peek();

    }
}
