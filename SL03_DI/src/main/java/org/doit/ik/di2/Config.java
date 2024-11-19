package org.doit.ik.di2;

import org.doit.ik.di3.RecordImpl3;
import org.doit.ik.di3.RecordViewImpl3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//application-context.xml == 자바 클래스 설정 파일 p.66
//p.85 자바 코드로 스프링 설정...
@Configuration // 클래스를 스프링 설정으로 사용함을 의미
public class Config {
	
	//<bean id="record" class="org.doit.ik.di.RecordImpl"></bean>
	@Bean
	public RecordImpl3 record() {
		return new RecordImpl3();
	}
	
	/*
 	<bean id="rvi" class="org.doit.ik.di.RecordViewImpl">
  	 <property name="record">
  	   <ref bean="record" />
  	 </property>
	*/
	@Bean //(name = "rvi") // name을 따로 줄 수 있음
	public RecordViewImpl3 getRecordViewImpl() {
		RecordViewImpl3 rvi = new RecordViewImpl3();
		rvi.setRecord(record());
		return rvi;
	}

}// class
