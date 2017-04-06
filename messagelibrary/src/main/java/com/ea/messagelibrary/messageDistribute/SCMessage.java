package com.ea.messagelibrary.messageDistribute;

import java.io.Serializable;

/**
 * Created by atong on 2016/11/7.
 */

public class SCMessage implements Serializable {

    private SCLinkedMap     parameters;          //携带的数据
    private String          tag;

    public SCLinkedMap getParameters(){
        return parameters;
    }
    public String getTag(){return tag;}
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
    }

}
