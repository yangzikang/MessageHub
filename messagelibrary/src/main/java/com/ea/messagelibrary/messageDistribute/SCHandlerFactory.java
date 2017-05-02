package com.ea.messagelibrary.messageDistribute;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/**
 * Created by yangzikang on 2017/4/6.
 * 继承Handler实现消息对主线程的分发
 */

public class SCHandlerFactory{

    public static Handler createHandler(Looper looper, final SCMessage message, final SCResponser responser){
        Handler mHandler = new Handler(looper){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                responser.onReceive(message);
            }
        };
        return mHandler;
    }
}
