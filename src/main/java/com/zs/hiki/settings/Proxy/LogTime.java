package com.zs.hiki.settings.Proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Date;

@Aspect
public class LogTime {
    @Around(value="execution(* com.zs.hiki.settings.dao.*.*(..))")
    public void logTime(JoinPoint jp,ProceedingJoinPoint pjp) throws Throwable {
        Date f = new Date();
        pjp.proceed();
        Date l = new Date();
        System.out.println(jp.getSignature()+"执行完毕,耗时"+(l.getTime()-f.getTime())+"毫秒");
    }
}
