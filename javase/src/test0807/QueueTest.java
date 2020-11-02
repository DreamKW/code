package test0807;
//队列
public class QueueTest {
    int [] queue;
    int SIZE;
    int head;
    int end;
    public QueueTest (){
        SIZE = 100;
        queue = new int [SIZE];
        head = 0;
        end = 0;
    }
    public QueueTest (int size){
        queue = new int [size];
        SIZE = size;
        head = 0;
        end = 0;
    }
    //因为使用循环队列，所以下一位置需要经过运算得出下标
    public int next(int index){
        return ((index  + 1)%SIZE );
    }
    //判断对满
    public boolean isFull(){
        return next(end) == head;
    }
    //进队
    public synchronized void offer (int date){
        //是否对满
        if (isFull()){
            throw new IllegalStateException("对满啦");
        }else {
            queue[end] = date;
            end = next(end);
        }
    }
    //判断是否为空
    public boolean isNull(){
        return end ==head;
    }
    //出队
    public  int peek (){
        int data = 0 ;
        if (isNull()){
            throw new IllegalStateException("对空啦。。。。");
        }else {
            data = queue[head];
            head = next(head);
        }
        return data;
    }

    public static void main(String[] args) {
        QueueTest queueTest = new QueueTest();
        queueTest.offer(1);
        queueTest.offer(2);
        System.out.println( queueTest.peek());
        System.out.println( queueTest.peek());
        System.out.println("--------");
    }
}
