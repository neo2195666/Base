package MyThread;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("使用显示Runnable接口来实现多线程");
    }
}
