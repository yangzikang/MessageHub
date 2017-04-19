package com.ea.messagelibrary.messageDistribute;


/**
 * Created by atong on 2016/12/13.
 *
 * 通用入口 组装消息，通过MessageFactory生产消息,交由MessageQueue（消息添加的过程）
 */

public class SCSender{

    public static void sendMessage(){
        SCMessage message = createMessage("",null);
        enqueueMessage(message);
    }
    public static void sendMessage(SCLinkedMap parameters){
        SCMessage message = createMessage("",parameters);
        enqueueMessage(message);
    }
    public static void sendMessage(String tag){
        SCMessage message = createMessage(tag,null);
        enqueueMessage(message);
    }
    public static void sendMessage(String tag,SCLinkedMap parameters){
        SCMessage message = createMessage(tag,parameters);
        enqueueMessage(message);
    }

    private static SCMessage createMessage(String tag, SCLinkedMap parameters){

        return SCMessageFactory.createMessage(tag,parameters);

    }
    public static void enqueueMessage(SCMessage message){
        SCMessageQueue.add(message);
    }

}

