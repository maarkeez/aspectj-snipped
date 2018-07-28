package com.aspectjsnipped.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
public class LoggerAspect {

	private static final ObjectMapper mapper = new ObjectMapper();

	@Pointcut("execution(public * com.aspectjsnipped.messaging.*.*(..))")
	public void publicLogger() {
	}

	@Before("publicLogger()")
	public void logPublic(JoinPoint jp) throws JsonProcessingException {
		System.out.println(jp.getClass().getCanonicalName() + " - Logging PUBLIC with: " + mapper.writeValueAsString(jp.getArgs()));
	}

	@Pointcut("execution(protected * com.aspectjsnipped.messaging.*.*(..))")
	public void protectedLogger() {
	}

	@Before("protectedLogger()")
	public void logProtected(JoinPoint jp) throws JsonProcessingException {
		System.out.println(jp.getClass().getCanonicalName() + " - Logging PROTECTED with: " + mapper.writeValueAsString(jp.getArgs()));
	}

	@Pointcut("execution(private * com.aspectjsnipped.messaging.*.*(..))")
	public void privateLogger() {
	}

	@Before("privateLogger()")
	public void logPrivate(JoinPoint jp) throws JsonProcessingException {
		System.out.println(jp.getClass().getCanonicalName() + " - Logging PRIVATE with: " + mapper.writeValueAsString(jp.getArgs()));
	}

	@Pointcut("execution(!private !public !protected * com.aspectjsnipped.messaging.*.*(..))")
	public void defaultLogger() {
	}

	@Before("defaultLogger()")
	public void logDefault(JoinPoint jp) throws JsonProcessingException {
		System.out.println(jp.getClass().getCanonicalName() + " - Logging DEFAULT with: " + mapper.writeValueAsString(jp.getArgs()));
	}
}