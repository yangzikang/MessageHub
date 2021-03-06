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
 *
 * SCLooper用来在新线程遍历MessageQueue，如果不为空则分发，如果为空阻塞等待唤醒（待实现）
 */

public class SCLooper implements Runnable{
    private static SCLooper looper = new SCLooper();
    private SCLooper(){}
    public static SCLooper getInstance(){
        return looper;
    }
    private Thread loopThread = new Thread(this);

    public void loop(){
        if(!loopThread.isAlive()){
            loopThread.start();
        }
    }


    @Override
    public void run() {
        while(true){
            if(!SCMessageQueue.isEmpty()){
                SCMessage message = SCMessageQueue.remove();
                distributeMessage(message);
            }
        }

    }

    synchronized private void distributeMessage(SCMessage message){
        Handler mHandler;
        SCResponser responser = SCResponser.relationShip.get(message.getTag());
        if (responser==null){
            if(message.getSticky()){
                SCMessageQueue.add(message);
            }
        }
        else{
            switch(responser.getThreadModeType()){
                case MAINTHREAD:
                    mHandler = SCHandlerFactory.createHandler(Looper.getMainLooper(),message,responser);
                    mHandler.sendEmptyMessage(0);
                    break;
                case NEWTHREAD:
                    new Thread(new SCNewThread(responser,message)).start();
                    break;
                case POSTTHREAD:
                    mHandler = SCHandlerFactory.createHandler(message.getLooper(),message,responser);
                    mHandler.sendEmptyMessage(0);
                    break;

                default: break;
            }
        }
    }
}
