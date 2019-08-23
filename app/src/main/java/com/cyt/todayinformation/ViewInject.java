package com.cyt.todayinformation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

@Retention(RetentionPolicy.RUNTIME) // 运行时 注解
@Target(TYPE) // 类 接口 注解
public @interface ViewInject {
    int mainlayoutid() default -1;
}
