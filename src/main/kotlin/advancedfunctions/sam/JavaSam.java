package advancedfunctions.sam;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * java sam
 * @author  dhl
 * 一个参数类型为只有一个方法的接口的方法，调用时可用Lambda表达式转换作为参数
 */
public class JavaSam {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("run in executor");
            }
        });
        executorService.submit(()-> System.out.println("run in executor"));



    }

    public static void submit(Function function){
        function.apply();
    }

//    public static void submit(Invokable invokable){
//
//    }
}
abstract class Function{
    abstract void apply();
}
