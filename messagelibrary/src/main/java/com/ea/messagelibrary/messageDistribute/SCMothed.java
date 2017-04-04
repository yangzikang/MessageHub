package com.ea.messagelibrary.messageDistribute;
import com.example.dell.socialcampus.bussness.SCUserManager;

/**
 * Created by yangzikang on 2017/1/23.
 * 做映射
 */

public enum SCMothed {
    REPLY,LOGIN,UPDATE,ERROR,SIGNUP;

    public static SCIResponder returnResponder(SCMothed mothed){
        switch (mothed) {
            case LOGIN:
                return new SCUserManager();
            case UPDATE:
                System.out.println("还未实现");
                break;
            case SIGNUP:
                return new SCUserManager();

            case REPLY:
                break;
            case ERROR:
                break;
            default:
                return null;
        }
        return null;
    }

}
