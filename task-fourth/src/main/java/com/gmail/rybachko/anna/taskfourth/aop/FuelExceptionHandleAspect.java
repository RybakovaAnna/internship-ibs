package com.gmail.rybachko.anna.taskfourth.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FuelExceptionHandleAspect {

    @Around("@annotation(FuelExceptionHandle)")
    public Object handled(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (Exception e) {
            return "Error";
        }
    }

}
