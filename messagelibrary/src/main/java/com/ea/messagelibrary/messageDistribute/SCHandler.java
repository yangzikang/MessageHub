package com.ea.messagelibrary.messageDistribute;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/**
 * Created by yangzikang on 2017/4/6.
 */

public class SCHandler extends Handler{
    private static SCHandler mHandler = new SCHandler(Looper.getMainLooper());

    public static SCHandler getInstance(){
        return mHandler;
    }

    public SCHandler(Looper looper) {
        super(looper);

    }
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        Log.d("lll","ggggg");
        //update UI
        SCMessage message =(SCMessage)msg.getData().getSerializable("message");
        SCResponser responser  =(SCResponser)msg.getData().getSerializable("responser");
        responser.onReceive(message);
    }
}
