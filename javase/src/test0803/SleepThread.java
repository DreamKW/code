package test0803;

public class SleepThread extends  Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行： " + i );
        }
    }

    public static void main(String[] args) {
        SleepThread st = new SleepThread();
        st.start();
    }
}
