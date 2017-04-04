package com.ea.messagelibrary.messageDistribute;

/**
 * Created by atong on 2016/12/13.
 *
 * 通用入口 组装消息，通过MessageFactory生产消息,交由控制台分发
 */

public class SCSender{

    SCMessage message = null;

    public void sendMessage(SCMothed mothed, SCLinkedMap parameters) {
        message = createMessage(mothed,parameters);
        distribute(message);
    }
    public void sendError(SCMothed mothed,SCIResponder responder,String errorCause){
        message = createMessage(mothed,null);
        message.setResponder(responder);
        message.setError(SCMessage.Error.MESSAGE_ERROR_RUNTIME);
        message.setErrorCause(errorCause);
        distribute(message);
    }
    public void sendMessage(SCMothed mothed,SCIResponder responder,SCLinkedMap parameters){
        message = createMessage(mothed,parameters);
        message.setResponder(responder);
        distribute(message);
    }

    synchronized private SCMessage createMessage(SCMothed mothed, SCLinkedMap parameters){
        return SCMessageFactory.createMessage(mothed,parameters);
    }

    private void distribute(SCMessage message){
        if(message.getResponder()!=null){  //获取响应者
            SCIResponder responder = message.getResponder();
            responder.reciveMessage(message);
        }
        else{                             //设置无响应者错误错误
            message.setError(SCMessage.Error.MESSAGE_ERROR_NORESPONDER);
        }
    }
}

