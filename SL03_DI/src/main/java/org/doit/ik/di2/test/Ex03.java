package org.doit.ik.di2.test;

import org.doit.ik.di2.Config;
import org.doit.ik.di3.RecordViewImpl3;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex03 {

	public static void main(String[] args) {
		// ApplicationContext ctx p.60
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		
		
		//RecordViewImpl rvi =  ctx.getBean("rvi" , RecordViewImpl.class); // 어노테이션 name 사용해서
		//RecordViewImpl rvi =  ctx.getBean(RecordViewImpl.class); //내가 찾은 방법
		//RecordViewImpl rvi =  ctx.getBean("recordViewImpl" , RecordViewImpl.class); // 안되는거
		RecordViewImpl3 rvi =  ctx.getBean("getRecordViewImpl" , RecordViewImpl3.class);
		
		rvi.input();
		rvi.output();
		
		System.out.println("END.");
		
	}//main
	
}//class
