package ThreadDemo;

public class RunnableDemo implements Runnable{
    @Override
    public void run() {
        System.out.println("使用显示Runnable接口来实现多线程");
    }


    public static void main(String[] args) {

        RunnableDemo runnableDemo = new RunnableDemo();
        Thread myThread2 = new Thread(runnableDemo);

        myThread2.start();
    }
}
