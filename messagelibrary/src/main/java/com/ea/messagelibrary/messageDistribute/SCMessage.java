package com.ea.messagelibrary.messageDistribute;


/**
 * Created by atong on 2016/11/7.
 */

public class SCMessage {
    //枚举变量容易造成内存泄漏
    public enum Error{
        MESSAGE_ERROR_NORESPONDER,MESSAGE_ERROR_RUNTIME
    }

    private SCMothed        mothed;              //消息类型
    private SCLinkedMap     parameters;          //携带的数据
    private SCIResponder    responder;           //响应者(接受者，消息的消费)
    private Error           error;               //错误域
    private String errorCause;          //错误原因

    /**
     * 类似JavaBean
     */
    public void setError(Error error) {
        this.error = error;
    }
    public Error getError(){
        return error;
    }
    public SCLinkedMap getParameters(){
        return parameters;
    }
    public void setResponder(SCIResponder responder){
        this.responder = responder;
    }
    public SCIResponder getResponder() {
        return responder;
    }
    public SCMothed getMothed(){
        return mothed;
    }
    public void setErrorCause(String errorCause){
        this.errorCause = errorCause;
    }
    public String getErrorCause(){
        return errorCause;
    }
    /**
     * 构造函数
     */
    public SCMessage(SCMothed mothed, SCLinkedMap parameters){
        init(mothed, parameters);
    }
    /**
     * 初始化函数
     */
    public void init(SCMothed mothed, SCLinkedMap parameters){
        this.mothed     = mothed;
        this.responder  = SCMothed.returnResponder(mothed);
        this.parameters = parameters;
        this.error      = null;
        this.errorCause = null;
    }

}
