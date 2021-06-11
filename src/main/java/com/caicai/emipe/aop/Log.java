package com.caicai.emipe.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解@Log
 *
 * @author caicai
 * @create 2021/6/9
 */
@Target({ElementType.TYPE, ElementType.METHOD}) // 作用于类、接口、注释及枚举, 方法
@Retention(RetentionPolicy.RUNTIME) // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
public @interface Log {
    String value() default "";
}
