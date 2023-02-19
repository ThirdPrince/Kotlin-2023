package block;

import jdk.nashorn.internal.ir.BlockLexicalContext;

public class BlockDemo {

    private Function function;

    public void setFunction(Function function) {
        this.function = function;
    }


    private Function1 function1;

    public void setFunction1(Function1 function1) {
        this.function1 = function1;
    }

    private  Function2 function2;

    public void setFunction2(Function2 function2) {
        this.function2 = function2;
    }

    private Function3 function3;

    public void setFunction3(Function3 function3) {
        this.function3 = function3;
    }

    public static void main(String[] args) {
        BlockDemo blockDemo = new BlockDemo();
        blockDemo.test0(blockDemo);
        System.out.println("---------");
        blockDemo.test1(blockDemo);
        System.out.println("---------");
        blockDemo.test2(blockDemo);
        System.out.println("---------");
        blockDemo.test3(blockDemo);


    }


    /**
     * 无参无返回值
     *
     * @param blockDemo
     */
    private void test0(BlockDemo blockDemo) {
        blockDemo.setFunction(new Function() {
            @Override
            public void call() {
                System.out.println("无参无返回值");
            }
        });
        blockDemo.function.call();
    }

    /**
     * 无参有返回值
     */
    private void test1(BlockDemo blockDemo) {
        blockDemo.setFunction1(new Function1() {
            @Override
            public String call() {
                return "无参有返回值";
            }
        });
        System.out.println(blockDemo.function1.call());

    }


    /**
     * 有参有返回值
     * @param blockDemo
     */
    private void test2(BlockDemo blockDemo) {
        blockDemo.setFunction2(new Function2(){

            @Override
            public int call(int x, int y) {
                return x+y;
            }
        });
        System.out.println(blockDemo.function2.call(2, 4));

    }

    private void test3(BlockDemo blockDemo) {
        blockDemo.setFunction3(new Function3() {
            @Override
            public void call(int x, int y) {
                System.out.println("x:"+x +"----y:"+y);
            }
        });
        blockDemo.function3.call(2,5);

    }


    /**
     * 无参无返回值
     */
    interface Function {
        void call();
    }

    /**
     * 无入参
     * 有返回值
     */
    interface Function1 {
        String call();
    }

    /**
     * 有入参 有返回值
     */
    interface Function2{
     int call(int x,int y);
    }

    /**
     * 入参 无返回值
     */
    interface Function3{
        void call(int x,int y);
    }
}


