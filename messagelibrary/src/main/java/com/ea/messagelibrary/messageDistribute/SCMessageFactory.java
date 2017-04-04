package com.ea.messagelibrary.messageDistribute;

/**
 * Created by yangzikang on 2016/12/13.
 */


public class SCMessageFactory {
    /**
     *
     * @param mothed        消息的类型
     * @param parameters    消息所携带的参数
     * @return              消息本身对象
     *
     * createMessage方法内可以放一些逻辑判断，判断生产什么样的消息，然后可以调用消息的set方法做一些初始化
     */
    public static SCMessage createMessage(SCMothed mothed,
                                          SCLinkedMap parameters){
        return new SCMessage(mothed,parameters);
    }
}
