package other;

import java.util.concurrent.*;

/**
 * Callable demo
 */
public class CallDemo {
    public static void main(String[] args) {
        System.out.println("----");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable myCallable = new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("call 方法执行了");
                Thread.sleep(3000);
                return "call 方法返回值";
            }
        };
        Future<String> future = executorService.submit(myCallable);
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
