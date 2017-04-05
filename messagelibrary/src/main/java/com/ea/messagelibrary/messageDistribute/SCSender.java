package com.ea.messagelibrary.messageDistribute;

/**
 * Created by atong on 2016/12/13.
 *
 * 通用入口 组装消息，通过MessageFactory生产消息,交由控制台分发
 */

public class SCSender{

    public static void sendEmptyMessage()

    public static void sendMessage(SCMothed mothed,SCIResponder responder,SCLinkedMap parameters){
        if(SCLooper.isWorking){
            SCLooper looper = SCLooper.getInstance();
            looper.initLooper();
        }
        SCMessage message = createMessage(mothed,parameters);
        message.setResponder(responder);
        enqueueMessage(message);
    }

    synchronized private static SCMessage createMessage(SCMothed mothed, SCLinkedMap parameters){
        return SCMessageFactory.createMessage(mothed,parameters);
    }

    private static void enqueueMessage(SCMessage message){
        SCMessageQueue.insertIntoMessageQueue(message);
    }

    public static void distributeMessage(SCMessage message){
        switch (message.getThreadMode()){
            case MAIN:
                break;
            case LOCAL:
                break;
            case NEW:
                break;
            default:
                break;
        }
    }

}

