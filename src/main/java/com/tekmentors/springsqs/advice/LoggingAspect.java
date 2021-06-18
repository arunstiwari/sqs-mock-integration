package com.tekmentors.springsqs.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
    private static  final String POINTCUT = "within(com.tekmentors.springsqs..*)";

    @Around(POINTCUT )
    public Object logCall(ProceedingJoinPoint pjp) throws Throwable {
        log.info("Entering with args {}", constructLogMsg(pjp));
        Object proceed = pjp.proceed();
        if (proceed !=null){
            log.info("after {} wiht result: {}",constructLogMsg(pjp), proceed.toString());
        }else{
            log.info("Exiting the method ");
        }
        return proceed;
    }
    private String constructLogMsg(JoinPoint jp) {
        String args = Arrays.asList(jp.getArgs()).stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        Method method = ((MethodSignature) jp.getSignature()).getMethod();
        StringBuilder sb = new StringBuilder("@");
        sb.append(method.getName());
        sb.append(":");
        sb.append(args);
        return sb.toString();
    }
}
