package ThreadDemo;

public class JoinDemo implements Runnable{
    @Override
    public void run() {
        System.out.println("执行join");
    }

    public static void main(String[] args) throws InterruptedException {
        JoinDemo joinDemo = new JoinDemo();
        Thread myThread = new Thread(joinDemo);

        myThread.start();

        for (int i = 0; i < 10000; i++) {
            if(i == 50)
                myThread.join();
        }
    }
}
