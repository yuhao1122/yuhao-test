package com.yuhao.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @description：发送事件切面
 * @author：Mr.Yu
 * @date：2019/4/8 15:33
 * @version：V1.0
 */
@Aspect
@Component
public class EventAspect {

    @Pointcut("@annotation(com.yuhao.aspect.anno.EventAnno)")
    public void event() {

    }

    @Around("event()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        Object result = point.proceed();
        try {

        } catch (Throwable e) {
        }
        return result;
    }
}
