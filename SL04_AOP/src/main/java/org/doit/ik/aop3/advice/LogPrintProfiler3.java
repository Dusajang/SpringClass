package org.doit.ik.aop3.advice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
public class LogPrintProfiler3 {
	
	//3. after~ advice p.221
	public void after(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().getName();
	      Log log = LogFactory.getLog(this.getClass());
	      log.info(">>> " + methodName + "() : LogPrintProfiler3.after 가 호출됨... ");
	}
	
	
	
	//2. before advice p.217
	public void before(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().getName();
	      Log log = LogFactory.getLog(this.getClass());
	      log.info(">>> " + methodName + "() : LogPrintProfiler3.before 가 호출됨... ");
	}
	
	
	//1. around advice  p.222
	public Object trace(ProceedingJoinPoint joinpoint) throws Throwable{
		
		String methodName = joinpoint.getSignature().toShortString();

	      Log log =  LogFactory.getLog(this.getClass());
	      log.info("> " + methodName +"() start.");

	      StopWatch sw = new StopWatch();
	      sw.start();       

	      // 핵심 관심 사항.
	      Object  result = joinpoint.proceed() ;  // calc.add()     

	      sw.stop();

	      log.info("> " + methodName +"() end.");
	      log.info("> " + methodName +"() 처리 시간 :  " + sw.getTotalTimeMillis() +"ms");

	      return result;
	}
	
	
	
}//class
