package com.example.chuwaproject.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.example.chuwaproject.exception.CustomExceptionHandler.*(..))")
    public void exceptionLoggingMethods() {
    }

    @Around("exceptionLoggingMethods()")
    public Object logException(ProceedingJoinPoint joinPoint) throws Throwable {
            // Proceed with the original method execution
            Object result = joinPoint.proceed();
            Object[] args = joinPoint.getArgs();
            LOGGER.error("Exception occurred in method: {}. Error message: {}", joinPoint.getSignature().toShortString(), args);
            return result;
    }
}
