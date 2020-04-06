package com.aspectjsnippet.aspect;

import static java.lang.String.format;

import lombok.val;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class LoggerAspect {
  
  private static final ObjectMapper mapper = new ObjectMapper();
  
  @Pointcut("@annotation(com.aspectjsnippet.model.LogAspect)")
  public void annotatedWithLogAspect() {}
  
  @Pointcut("execution(* com.aspectjsnippet.messaging.*.*(..))")
  public void anyMethod() {}
  
  @Pointcut("anyMethod() && annotatedWithLogAspect()")
  public void anyMethodAnnotatedWithLogAspect() {}
  
  @Before("anyMethodAnnotatedWithLogAspect()")
  public void logAnyMethodAnnotatedWithLogAspect(JoinPoint jp) throws JsonProcessingException {
    val methodSignature = (MethodSignature) jp.getSignature();
    val className = methodSignature.getClass().getCanonicalName();
    val argumentsAsStr = mapper.writeValueAsString(jp.getArgs());
    val logmessage = format("[%s] Annotated: %s", className, argumentsAsStr);
    System.out.println(logmessage);
  }
  
}