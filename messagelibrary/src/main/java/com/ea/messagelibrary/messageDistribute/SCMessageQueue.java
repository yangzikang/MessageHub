package com.ea.messagelibrary.messageDistribute;

import android.util.Log;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by yangzikang on 2017/4/6.
 * 消息队列，有唤醒Looper的能力
 */

public class SCMessageQueue {
    public static List<SCMessage> queue = new LinkedList<>();
    public static void add(SCMessage message){
        queue.add(message);
        SCLooper looper = SCLooper.getInstance();
        looper.loop();
    }
    public static SCMessage remove(){
        return  queue.remove(0);
    }

    public static boolean isEmpty(){
        return  queue.isEmpty();
    }
}
