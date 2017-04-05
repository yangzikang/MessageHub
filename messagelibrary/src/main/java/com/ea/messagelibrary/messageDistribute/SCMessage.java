package com.ea.messagelibrary.messageDistribute;


/**
 * Created by atong on 2016/11/7.
 */

public class SCMessage {


    private SCThreadMode    threadMode;           //消息类型
    private SCLinkedMap     parameters;          //携带的数据
    private String          tag;

    public SCLinkedMap getParameters(){
        return parameters;
    }
    public SCThreadMode getThreadMode(){
        return threadMode;
    }
    /**
     * 构造函数
     */
    public SCMessage(SCThreadMode threadMode, SCLinkedMap parameters){
        init(threadMode, parameters);
    }
    /**
     * 初始化函数
     */
    public void init(SCThreadMode threadMode, SCLinkedMap parameters){
        this.threadMode = threadMode;
        this.parameters = parameters;
    }

}
