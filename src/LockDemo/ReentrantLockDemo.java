package LockDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) {
        TicketTest ticketTest = new TicketTest();
        new Thread( ()->{for (int i = 0; i < 20; i++)ticketTest.sale();},"E").start();
        new Thread( ()->{for (int i = 0; i < 20; i++)ticketTest.sale();},"F").start();
        new Thread( ()->{for (int i = 0; i < 20; i++)ticketTest.sale();},"G").start();
    }
}

class TicketTest{
    int ticket = 60;
    Lock lock = new ReentrantLock();
    public void sale(){
        lock.lock();
        try {
            if(ticket > 0)
                System.out.println(Thread.currentThread().getName() + "卖了一张票，剩余" + ticket-- + "票");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}