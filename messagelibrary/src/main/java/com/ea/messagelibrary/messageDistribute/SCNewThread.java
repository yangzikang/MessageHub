package com.ea.messagelibrary.messageDistribute;

/**
 * Created by yangzikang on 2017/4/11.
 * 在新线程分发时使用
 */

public class SCNewThread implements Runnable {
    private SCResponser responser;
    private SCMessage message;
    public SCNewThread(SCResponser responser,SCMessage message){
        this.responser = responser;
        this.message = message;
    }
    @Override
    public void run() {
        responser.onReceive(message);
    }
}
