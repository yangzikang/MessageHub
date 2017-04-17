package com.ea.messagelibrary.messageDistribute;

import android.util.Log;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by yangzikang on 2017/4/5.
 */

public abstract class SCResponser implements Serializable{
    private String tagName;
    private SCThreadModeType threadModeType;

    public static Map<String , SCResponser> relationShip = new HashMap<>();

    public SCThreadModeType getThreadModeType(){
        return threadModeType;
    }

    public void register(Object receiver){
        Class<?> clazz = receiver.getClass();
        for(Field m :clazz.getFields()){
            Tag tag =  m.getAnnotation(Tag.class);
            if(tag !=null){
                tagName = tag.tag();
                threadModeType = tag.threadMode();
                relationShip.put(tagName,this);
            }

        }
    }

    public void unregister(){
        relationShip.remove(tagName);
    }

    public abstract void onReceive(SCMessage message);
}
