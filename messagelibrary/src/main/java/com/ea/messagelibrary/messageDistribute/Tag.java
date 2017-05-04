package com.ea.messagelibrary.messageDistribute;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface Tag {
    public String tag() default "";

	public SCThreadModeType threadMode() default SCThreadModeType.MAINTHREAD;
}
