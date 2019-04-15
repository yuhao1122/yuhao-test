package com.yuhao.aspect.anno;

import java.lang.annotation.*;

/**
 * @description：实体业务编码前缀注解，作用于类上
 * @author：Mr.Yu
 * @date：2019/4/8 15:21
 * @version：V1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CodeEntityAnno {

    String codePrefix() default "";

}
