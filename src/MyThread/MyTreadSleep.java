package MyThread;

class ThreadSleepDemo extends Thread{
    int num = 15;
    @Override
    public void run() {
        while (num > 0){

            try {
                System.out.println(num);
                Thread.sleep(1000);
                num--;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class MyTreadSleep {

    public static void main(String[] args) {

        ThreadSleepDemo myTreadSleep = new ThreadSleepDemo();
        myTreadSleep.start();
    }

}
