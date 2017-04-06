package com.ea.messagelibrary.messageDistribute;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by yangzikang on 2017/4/6.
 */

public class SCMessageQueue {
    public static List<SCMessage> queue = new LinkedList<>();
    public static void add(SCMessage message){
        queue.add(message);
        if(!SCLooper.isWorking){
            SCLooper looper = SCLooper.getInstance();
            looper.notifyLooper();
        }
    }
    public static SCMessage remove(){
        return  queue.remove(0);
    }

    public static boolean isEmpty(){
        return  queue.isEmpty();
    }
}
