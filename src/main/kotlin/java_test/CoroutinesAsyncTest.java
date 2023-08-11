package java_test;

import os.Handler;
import os.HandlerThread;
import os.Looper;
import os.Message;

public class CoroutinesAsyncTest {
    public static void main(String[] args) throws InterruptedException {
        Looper.prepareMainLooper();
        //TaskOne.start();
        TaskTwo.start();
        Thread.sleep(2000);

        Looper.loop();

    }
}
