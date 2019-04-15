package com.yuhao.aspect.anno;

import java.lang.annotation.*;

/**
 * @description：实体描述注解，作用于类上
 * @author：Mr.Yu
 * @date：2019/4/8 15:18
 * @version：V1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EntityAnno {

    String name() default "base";

}
