package org.doit.ik.aop2.advice;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 실행 후 호출되는 공통기능 + 예외X
@Component
public class LogPrintAfterReturningAdvice implements AfterReturningAdvice{

	@Override
	public void afterReturning(
			Object returnValue, // 결과값(리턴값)
			Method method, 	// add()
			Object[] args, 	//  3, 5
			Object target	// 핵심 기능 실제 객체
			) throws Throwable {
		String methodName = method.getName();
		Log log = LogFactory.getLog(this.getClass());
		// 인증 체크 부분 코딩
		log.info("<<" + methodName + "() : LogPrintAfterReturningAdvice 호출됨...");
		
	}

	
}
