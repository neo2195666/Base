package MyThread;

public class JoinTest implements Runnable{
    @Override
    public void run() {
        System.out.println("执行join");
    }

    public static void main(String[] args) throws InterruptedException {
        JoinTest joinTest = new JoinTest();
        Thread myThread = new Thread(joinTest);

        myThread.start();

        for (int i = 0; i < 10000; i++) {
            if(i == 50)
                myThread.join();
        }
    }
}
