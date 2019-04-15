package com.yuhao.aspect.anno;

import java.lang.annotation.*;

/**
 * @description：发送事件注解，作用于方法上
 * @author：Mr.Yu
 * @date：2019/4/8 15:29
 * @version：V1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EventAnno {

    String source() default "base";

    String name() default "";

    String notifier() default "";

}
