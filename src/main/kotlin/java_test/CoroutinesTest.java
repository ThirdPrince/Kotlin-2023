package java_test;

import os.Handler;
import os.HandlerThread;
import os.Looper;
import os.Message;

public class CoroutinesTest {
    public static void main(String[] args) throws InterruptedException {
        Looper.prepareMainLooper();
        //TaskOne.start();
        TaskTwo.start();
        Thread.sleep(2000);
        HandlerThread handlerThread = new HandlerThread("updateMessage");
        handlerThread.start();
        Handler updateHandler = new UpdateHandler(handlerThread.getLooper());
        for(int i = 0;i <1000;i++){
            Message message = Message.obtain();
            message.obj = i;
            updateHandler.sendMessageDelayed(message,1000);
        }
        Looper.loop();

    }
}
