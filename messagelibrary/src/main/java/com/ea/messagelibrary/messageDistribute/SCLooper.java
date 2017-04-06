package com.ea.messagelibrary.messageDistribute;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.support.annotation.MainThread;
import android.support.v4.util.Pools;
import android.util.Log;
import android.widget.Switch;

/**
 * Created by yangzikang on 2017/4/6.
 */

public class SCLooper implements Runnable{
    private static SCLooper looper = new SCLooper();
    private SCLooper(){
        loopThread = new Thread(this);
        loopThread.start();
        isWorking = true;
    }
    private Thread loopThread;

    public static boolean isWorking = false;

    public Object lock = "";//只为了锁线程

    public static SCLooper getInstance(){
        return looper;
    }

    synchronized public void notifyLooper(){
        if(isWorking == false) {
            loopThread.notify();
        }
    }


    @Override
    public void run() {
        while(true){
            if(SCMessageQueue.isEmpty()){
                synchronized (lock){
                    try {
                        loopThread.wait();
                        isWorking =false;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        loopThread = new Thread(this);
                        loopThread.start();
                        isWorking = true;
                    }
                }
            }
            else{
                SCMessage message = SCMessageQueue.remove();
                distributeMessage(message);
            }
        }

    }

    private void distributeMessage(SCMessage message){
        SCResponser responser = SCResponser.relationShip.get(message.getTag());
        if (responser==null){
            SCMessageQueue.add(message);
            Log.d("llll","no tag");
        }
        else{
            switch(responser.getThreadModeType()){
                case MAINTHREAD:
                    Log.d("llll","shdus");
                    Message m = new Message();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("message", message);
                    bundle.putSerializable("responser",responser);
                    m.setData(bundle);
                    SCHandler.getInstance().sendMessage(m);

                    break;
                case NEWTHREAD: break;
                case SENDTHREAD: break;
                default: break;
            }
        }
    }
}
