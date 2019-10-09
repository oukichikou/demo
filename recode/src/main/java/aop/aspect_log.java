package aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import annotation.logTextAnotation;
import entity.Type;
import service.TypeService;
import utils.SearchInfo;

@Component
@Aspect
public class aspect_log {
	@Autowired
	TypeService service;
	@Pointcut("execution(public * *Byid(..))")
    public void anyMethod() {    }
	
	@Around(value = "anyMethod()")
    public Object exe34(ProceedingJoinPoint p) throws Throwable{
		MethodSignature m= (MethodSignature) p.getSignature();
		System.out.println(p.getTarget().getClass().getName());
		Object o=p.proceed();
		
		return o;
	}	
	

}