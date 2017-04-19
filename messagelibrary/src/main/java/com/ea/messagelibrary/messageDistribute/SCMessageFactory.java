package com.ea.messagelibrary.messageDistribute;

/**
 * Created by yangzikang on 2016/12/13.
 * 消息生产的简单工厂
 */


public class SCMessageFactory {

    public static SCMessage createMessage(String tag,SCLinkedMap parameters){
        return new SCMessage(tag,parameters);
    }
}
