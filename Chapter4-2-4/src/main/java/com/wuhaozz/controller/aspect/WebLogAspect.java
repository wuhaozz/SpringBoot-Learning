package com.wuhaozz.controller.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


@Aspect
@Component
public class WebLogAspect {

    private Logger logger = Logger.getLogger(getClass());

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.wuhaozz.controller..*.*(..))")
    @Order(5)
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
    }

    @After("webLog()")
    public void doAfter(JoinPoint joinPoint) throws Throwable {
        logger.info("this is webLog after");
    }

    @Pointcut("execution(public * com.wuhaozz.controller..*.*(..))")
    @Order(10)
    public void webLog2() {
    }

    @Before("webLog2()")
    public void doBefore2(JoinPoint joinPoint) throws Throwable {
        logger.info("this is order10 before");
    }

    @AfterReturning(returning = "ret", pointcut = "webLog2()")
    public void doAfterReturning2(Object ret) throws Throwable {
        logger.info("this is order10 afterReturning");
    }

    @After("webLog2()")
    public void doAfter2(JoinPoint joinPoint) throws Throwable {
        logger.info("this is order10 after");
    }

}
