package org.doit.ik.aop4;

import org.doit.ik.aop.Calculator;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex04 {

	public static void main(String[] args) {
		// p.226 @어노테이션을 활용한 AOP 처리
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:org/doit/ik/aop4/application-context4.xml");
		
		//Calculator calc = ctx.getBean("calcProxy", Calculator.class);
		Calculator calc = ctx.getBean("calc4", Calculator.class);
		
		System.out.println(calc.add(3, 5)); // 처리 시간(공통기능)
	
		
		
		System.out.println("END.");
	}// main

}//class
