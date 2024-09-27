package com.in28minutes.learn_spring_aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// Configuration class that contains aop configuration
@Configuration
@Aspect
public class LoggingAspects {

    Logger logger = LoggerFactory.getLogger(getClass());

    // Pointcut - when?
    @Before("com.in28minutes.learn_spring_aop.aspects.CommonPointcutConfig.businessPackageConfig()")
    public void logMethodCallBeforeExec(JoinPoint joinPoint){
        // logic - what?
        logger.info("Before Aspect - {} is called with args: {}", joinPoint, joinPoint.getArgs());
    }

    // Called after success and error after execution
    @After("com.in28minutes.learn_spring_aop.aspects.CommonPointcutConfig.businessPackageConfig()")
    public void logMethodCallAfterExec(JoinPoint joinPoint){
        // logic - what?
        logger.info("After Aspect - {} has executed", joinPoint);
    }

    // Gets called only after throwing an exception
    @AfterThrowing(
            pointcut = "com.in28minutes.learn_spring_aop.aspects.CommonPointcutConfig.businessPackageConfig()",
            throwing = "exception"
    )
    public void logMethodCallAfterThrowingExec(JoinPoint joinPoint, Exception exception){
        // logic - what?
        logger.info("After Throwing Aspect - {} has thrown exception - {}", joinPoint, exception.getMessage());
    }

    // Gets called only after returning
    @AfterReturning(
            pointcut = "com.in28minutes.learn_spring_aop.aspects.CommonPointcutConfig.businessPackageConfig()",
            returning = "resultValue"
    )
    public void logMethodCallAfterReturningExec(JoinPoint joinPoint, Object resultValue){
        // logic - what?
        logger.info("After Returning Aspect - {} has thrown exception - {}", joinPoint, resultValue);
    }

}
