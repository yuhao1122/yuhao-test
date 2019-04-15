package com.yuhao.aspect.anno;

import java.lang.annotation.*;

/**
 * @description：定义系统日志注解
 * @author：Mr.Yu
 * @date：2019/4/2 15:42
 * @version：V1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    String value() default "";

}
