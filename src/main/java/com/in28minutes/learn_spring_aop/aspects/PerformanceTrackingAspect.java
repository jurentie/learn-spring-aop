package com.in28minutes.learn_spring_aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Around("com.in28minutes.learn_spring_aop.aspects.CommonPointcutConfig.businessPackageConfig()")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // start a timer
        long startTime = System.currentTimeMillis();
        // execute method
        Object returnValue = proceedingJoinPoint.proceed();

        //stop the timer
        long stopTime = System.currentTimeMillis();

        long executionDuration = stopTime - startTime;

        logger.info("Around Aspect - {} Method executed in {} ms", proceedingJoinPoint, executionDuration);

        return returnValue;
    }

}
