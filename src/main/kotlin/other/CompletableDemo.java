package other;

import java.sql.SQLOutput;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableDemo {
    public static void main(String[] args) {

//        Runnable runnable = ()-> System.out.println("无返回结果异步任务");
//
//        CompletableFuture.runAsync(runnable);
//
//        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
//            System.out.println("有返回值的异步任务");
//            try {
//                Thread.sleep(4000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "Hello World";
//        });
//        try {
//            String result = future.get();
//            System.out.println("result = "+result);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        test1();
    }

    public static void test1(){
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
            int result = 1000;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("第一次运算："+result+"--Thread:"+Thread.currentThread().getName());
            return result;
        }).thenApply(number ->{
            int result = number *3 ;
            System.out.println("第二次运算："+result+"--Thread:"+Thread.currentThread().getName());
            return result;
        }).thenApply(number ->{
            int result = number *3 ;
            System.out.println("第3次运算："+result+"--Thread:"+Thread.currentThread().getName());
            return result;

        });
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("main end");
    }
}
