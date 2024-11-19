package org.doit.ik.di.test;

import org.doit.ik.di3.RecordImpl3;
import org.doit.ik.di3.RecordViewImpl3;

public class Ex01 {
	
	public static void main(String[] args) {
		
		RecordImpl3 record = new RecordImpl3();
		// 1. 생성자 의존성 주입(DI)
		//RecordViewImpl rvi = new RecordViewImpl(record);
		
		// 2. Setter 의존성 주입(DI)
		RecordViewImpl3 rvi = new RecordViewImpl3(record);
		rvi.setRecord(record);
		
		rvi.input();
		rvi.output();
		
		System.out.println("END.");
		
		
	}//main
	
}//class
