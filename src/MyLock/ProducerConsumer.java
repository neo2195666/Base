package MyLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {
    public static void main(String[] args) {
        DataTest dataTest = new DataTest();
        new Thread( ()->{
            try {
                dataTest.producer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"生产者").start();
        new Thread( ()->{
            try {
                dataTest.consumer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"消费者").start();
    }
}

class DataTest{
    int number = 15;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void producer() throws InterruptedException {
        lock.lock();
        try{
            while(true){
                if(number != 0)
                    condition.await();

                while(number < 15) {
                    number++;
                    Thread.sleep(300);
                    System.out.println("开始生产 => " + number);
                }

                System.out.println("生产满了，通知消费者");
                Thread.sleep(3000);
                condition.signalAll();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void consumer() throws InterruptedException {
        lock.lock();
        try {
            while(true){
                if (number == 0) {
                    System.out.println("消费完了，通知生产者");
                    Thread.sleep(3000);
                    condition.await();
                }

                Thread.sleep(300);
                System.out.println("开始消费 => " + number);
                number--;

                condition.signalAll();
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}


