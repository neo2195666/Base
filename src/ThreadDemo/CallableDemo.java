package ThreadDemo;

import java.util.concurrent.*;

public class CallableDemo implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {

        System.out.println("使用显示Callable接口来实现多线程");

        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CallableDemo myCallable = new CallableDemo();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Boolean> booleanFuture = executorService.submit(myCallable);
        Boolean result = booleanFuture.get();

        System.out.println(result);

        executorService.shutdown();
    }

}
