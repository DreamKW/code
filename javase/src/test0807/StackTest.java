package test0807;
//栈
public class StackTest {
    //定义一个数组
    int [] stacks;
    //定义数组的长度
    private int SIZE;
    //定义栈顶
    private int top;
    //定义栈底
    private int bottom;
    //创建构造方法，初始化数组
    public StackTest(){
        stacks = new int [100];
        //当前长度的值
        SIZE = 100;
        //设置一个空栈
        top = bottom;
        //创建一个有参的构造方法，可以指定栈的大小

    }
    public StackTest (int size){
        stacks = new int [size];
        SIZE = size;
        top = bottom;
    }
    //判断是否栈满
    public boolean isFull(){
        if (top == SIZE){
            return true;
        }else {
            return false;
        }
    }
    //完成进栈功能
    public synchronized void  push (int value){
        //判断是否栈满
        if (isFull()){
            throw new IllegalStateException("栈满了，不能添加了");

        }else {
            //栈未满 将value的值存入数组中即进栈
            stacks[top++] = value;
        }
    }
    //判断栈空
    public boolean isNull(){
        return bottom == top;
    }
    //完成出栈的功能
    public synchronized int poll () {
//        出一个
        //判断是否栈空
//        if (isNull()) {
//            throw new IllegalStateException("栈空啦，没数据了");
//        } else {
//            return stacks[--top];
//        }

//        出所有
        while (top != 0){
            if (isNull()) {
                throw new IllegalStateException("栈空啦，没数据了");
            } else {
                System.out.println(stacks[--top]);
            }
        }
        return 1 ;


    }

    public static void main(String[] args) {
        StackTest stackTest = new StackTest(1000);
        stackTest.push(1);
        stackTest.push(2);
        stackTest.push(3);
//        System.out.println(stackTest.poll());
        stackTest.poll();

    }
}
