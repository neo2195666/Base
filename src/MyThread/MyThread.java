package MyThread;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("使用继承Thread类实现多线程");
    }
}