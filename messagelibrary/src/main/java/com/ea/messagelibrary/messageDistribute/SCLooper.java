package com.ea.messagelibrary.messageDistribute;

import android.os.MessageQueue;

/**
 * Created by yangzikang on 17-4-5.
 */

public class SCLooper implements Runnable{
    private static SCLooper looper = new SCLooper();
    private static Thread   looperThread;
    public  static boolean  isWorking = false;

    private SCLooper(){}
    public static SCLooper getInstance(){
        return looper;
    }

    public void initLooper(){
        looperThread = new Thread(this);
        looperThread.start();
        isWorking = true;
    }

    @Override
    public void run(){
        while(true){
            if(SCMessageQueue.isEmpty()){
                try {
                    looperThread.wait();
                } catch (InterruptedException e) {
                    isWorking = false;
                }
            }
            else{
                SCMessage message = SCMessageQueue.removeFromMessageQueue();
                SCSender.distributeMessage(message);
            }
        }
    }
}
