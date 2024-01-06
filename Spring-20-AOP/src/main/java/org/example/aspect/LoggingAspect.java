package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Aspect
@Configuration
public class LoggingAspect {
    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

//    @Pointcut("execution(* org.example.controller.CourseController.*(..))")
//    private void pointcut() {}

//    @Before("pointcut()")
//    public void log() {
//        logger.info("Logger info ------");
//    }

//    @Before("execution(* org.example.controller.CourseController.*(..))")
//    public void beforeAdvice() {
//        logger.info("Logger info ------");
//    }

//    @Pointcut("execution(* org.example.repository.CourseRepository.findById(*))")
//    private void anyProductRepositoryFindById() {
//
//    }
//
//    @Before("anyProductRepositoryFindById()")
//    public void beforeCourseRepoOperation(JoinPoint joinPoint) {
//        logger.info("Before : -> Method: {} - Arguments: {} - Target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
//    }

    // within
//    @Pointcut("within(org.example.controller..*)")
//    private void anyControllerOperation() {
//
//    }
//
//    @Pointcut("@within(org.springframework.stereotype.Service)")
//    private void anyServiceOperation() {
//    }
//
//    @Before("anyControllerOperation() || anyServiceOperation()")
//    public void beforeControllerAdvice(JoinPoint joinPoint) {
//        logger.info("Before () -> Method: {} - Arguments: {} - Target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
//    }

//    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
//    private void anyDeleteCourseOperation() {
//
//    }
//
//    @Before("anyDeleteCourseOperation()")
//    public void beforeControllerAdvice(JoinPoint joinPoint) {
//        logger.info("Before () -> Method: {} - Arguments: {} - Target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
//    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetCourseOperation() {

    }

//    @AfterReturning(pointcut = "anyGetCourseOperation()", returning = "result")
//    public void afterReturningController(JoinPoint joinPoint, Object result) {
//        logger.info("After Returning () -> Method: {} - Result: {}", joinPoint.getSignature().toShortString(), result.toString());
//    }
//
//    @AfterReturning(pointcut = "anyGetCourseOperation()", returning = "result")
//    public void afterReturningController(JoinPoint joinPoint, List<Object> result) {
//        logger.info("After Returning (List) -> Method: {} - Result: {}", joinPoint.getSignature().toShortString(), result.toString());
//    }

//    @AfterThrowing(pointcut = "anyGetCourseOperation()", throwing = "exception")
//    public void afterThrowingControllerAdvice(JoinPoint joinPoint, RuntimeException exception) {
//        logger.info("After Throwing -> Method: {} - Exception: {}", joinPoint.getSignature().toShortString(), exception.getMessage());
//    }

//    @After("anyGetCourseOperation()")
//    public void afterControllerAdvice(JoinPoint joinPoint) {
//        logger.info("After finally -> Method: {}", joinPoint.getSignature().toShortString());
//    }

    @Pointcut("@annotation(org.example.annotation.Loggable)")
    public void anyLoggableMethodOperation() {

    }

    @Around("anyLoggableMethodOperation()")
    public Object anyLoggableMethodOperationAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        logger.info("Before () -> Method: {} - Parameters: {}", proceedingJoinPoint.getSignature().toShortString(), proceedingJoinPoint.getArgs());
        Object results = null;
        try {
            results = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        logger.info("After () -> Method: {} - Parameters: {}", proceedingJoinPoint.getSignature().toShortString(), results.toString());

        return results;
    }

}
