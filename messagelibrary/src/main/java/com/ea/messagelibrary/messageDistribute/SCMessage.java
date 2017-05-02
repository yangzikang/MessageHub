package com.ea.messagelibrary.messageDistribute;

import android.os.Looper;

import java.io.Serializable;

/**
 * Created by atong on 2016/11/7.
 * 消息实体 带参数和标识，其中参数用自己的MAP
 */

public class SCMessage{

    private SCLinkedMap parameters;          //携带的数据
    private String      tag;
    private Looper      looper;

    public SCLinkedMap getParameters(){
        return parameters;
    }
    public String getTag(){return tag;}
    public Looper getLooper(){return looper;}
    /**
     * 构造函数
     */
    public SCMessage(String tag, SCLinkedMap parameters){
        init(tag, parameters);
    }
    /**
     * 初始化函数
     */
    public void init(String tag,SCLinkedMap parameters){
        this.tag = tag;
        this.parameters = parameters;
        this.looper = Looper.myLooper();
    }

}
