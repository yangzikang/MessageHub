package com.ea.messagelibrary.messageDistribute;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangzikang on 17-4-5.
 */

public class SCMessageQueue {
    private static List<SCMessage> messages = new ArrayList<SCMessage>();

    public static boolean isEmpty(){
        return messages.isEmpty();
    }

    public static void insertIntoMessageQueue(SCMessage message){
        messages.add(message);

    }
    public static SCMessage removeFromMessageQueue(){
        return messages.remove(0);
    }

}
