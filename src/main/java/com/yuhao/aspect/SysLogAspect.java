package com.yuhao.aspect;

import com.google.gson.Gson;
import com.yuhao.aspect.anno.SysLog;
import com.yuhao.model.SysLogBO;
import com.yuhao.service.SysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description：系统日志切面
 * @author：Mr.Yu
 * @date：2019/4/2 15:43
 * @version：V1.0
 */
@Aspect  // 使用@Aspect注解声明一个切面
@Component
public class SysLogAspect<tes> {

    @Autowired
    private SysLogService sysLogService;

    /**
     * 这里我们使用注解的形式
     * 当然，我们也可以通过切点表达式直接指定需要拦截的package,需要拦截的class 以及 method
     * 切点表达式:   execution(...)
     */
    @Pointcut("@annotation(com.yuhao.aspect.anno.SysLog)")
    public void logPointCut() {
    }

    /**
     * 环绕通知 @Around  ， 当然也可以使用 @Before (前置通知)  @After (后置通知)
     *
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();

        long time = System.currentTimeMillis() - beginTime;
        try {
            //返回的参数
            Object result1 = point.proceed();
            //请求的参数
            Object[] args = point.getArgs();

            saveLog(point, time);
        } catch (Exception e) {
        }
        return result;
    }

    /**
     * 保存日志
     *
     * @param joinPoint
     * @param time
     */
    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLogBO sysLogBO = new SysLogBO();
        sysLogBO.setExeuTime(time);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        sysLogBO.setCreateDate(dateFormat.format(new Date()));
        SysLog sysLog = method.getAnnotation(SysLog.class);
        if (sysLog != null) {
            //注解上的描述
            sysLogBO.setRemark(sysLog.value());
        }
        //请求的 类名、方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLogBO.setClassName(className);
        sysLogBO.setMethodName(methodName);
        //请求的参数
        Object[] args = joinPoint.getArgs();
        try {
            List<String> list = new ArrayList<String>();
            for (Object o : args) {
                list.add(new Gson().toJson(o));
            }
            sysLogBO.setParams(list.toString());
        } catch (Exception e) {

        }
        sysLogService.save(sysLogBO);
    }

    class user {
        private String name;
        private String age;
        private String like;

        public String getLike() {
            return like;
        }

        public void setLike(String like) {
            this.like = like;
        }
    }

    public static void main(String[] args) {

        String name = "yuhao";
        System.out.println(name);

    }

}
