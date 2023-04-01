import MyThread.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();

        MyRunnable myRunnable = new MyRunnable();
        Thread myThread2 = new Thread(myRunnable);
        myThread2.start();

        MyCallable myCallable = new MyCallable();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Boolean> booleanFuture = executorService.submit(myCallable);
        Boolean result = booleanFuture.get();

        System.out.println(result);
        
        executorService.shutdown();
    }
}