package com.ea.messagelibrary.messageDistribute;


/**
 * Created by atong on 2016/12/13.
 *
 * 通用入口 组装消息，通过MessageFactory生产消息,交由控制台分发
 */

public class SCSender{

    public static void sendMessage(){
        SCMessage message = SCMessageFactory.createMessage("",null);
        enqueueMessage(message);
    }
    public static void sendMessage(SCLinkedMap parameters){
        SCMessage message = SCMessageFactory.createMessage("",parameters);
        enqueueMessage(message);
    }
    public static void sendMessage(String tag){
        SCMessage message = SCMessageFactory.createMessage(tag,null);
        enqueueMessage(message);
    }
    public static void sendMessage(String tag,SCLinkedMap parameters){

        SCMessage message = SCMessageFactory.createMessage(tag,parameters);
        enqueueMessage(message);

    }

    synchronized private static SCMessage createMessage(String tag, SCLinkedMap parameters){

        return SCMessageFactory.createMessage(tag,parameters);

    }
    public static void enqueueMessage(SCMessage message){
        SCMessageQueue.add(message);
    }

}

