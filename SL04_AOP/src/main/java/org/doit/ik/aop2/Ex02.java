package org.doit.ik.aop2;

import org.doit.ik.aop.Calculator;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex02 {

	public static void main(String[] args) {
		// p.204 스프링 AOP
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:org/doit/ik/aop2/application-context2.xml");
		
		Calculator calc = ctx.getBean("calcProxy", Calculator.class);
		
		System.out.println(calc.add(3, 5)); // 처리 시간(공통기능)
	
		
		
		System.out.println("END.");
	}// main

}//class
