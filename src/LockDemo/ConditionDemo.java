package LockDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
    public static void main(String[] args) {
        ConditionTest conditionTest = new ConditionTest();
        new Thread(()->{for (int i = 0; i < 10; i++) conditionTest.printA();},"Thread1").start();
        new Thread(()->{for (int i = 0; i < 10; i++) conditionTest.printB();},"Thread2").start();
        new Thread(()->{for (int i = 0; i < 10; i++) conditionTest.printC();},"Thread3").start();
    }
}

class ConditionTest{

    Lock lock = new ReentrantLock();

    Condition a1 = lock.newCondition();
    Condition b1 = lock.newCondition();
    Condition c1 = lock.newCondition();

    int number = 1;

    void printA(){
        lock.lock();
        try{
            while (number != 1)
                a1.await();

            number = 2;
            System.out.println(Thread.currentThread().getName() + "=> AAAAA");
            b1.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    void printB(){
        lock.lock();
        try{
            while (number !=2 )
                b1.await();

            number = 3;
            System.out.println(Thread.currentThread().getName() + "=> BBBBB");
            c1.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    void printC(){
        lock.lock();
        try{
            while (number != 3)
                c1.await();
            number = 1;
            System.out.println(Thread.currentThread().getName() + "=> CCCCC");
            a1.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
