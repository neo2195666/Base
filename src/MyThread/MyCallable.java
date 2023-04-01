package MyThread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {

        System.out.println("使用显示Callable接口来实现多线程");

        return true;
    }
}
