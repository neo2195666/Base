package MyThread;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("使用显示Runnable接口来实现多线程");
    }


    public static void main(String[] args) {

        MyRunnable myRunnable = new MyRunnable();
        Thread myThread2 = new Thread(myRunnable);

        myThread2.start();
    }
}
