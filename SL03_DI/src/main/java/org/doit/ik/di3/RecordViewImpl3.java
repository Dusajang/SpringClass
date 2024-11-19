package org.doit.ik.di3;


import java.util.Scanner;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Setter;

@Setter
public class RecordViewImpl3 implements RecordView3{
	
	//@Setter 롬복 어노테이션
	//@Autowired(required = false)
	//@Autowired
	//@Resource(name="record1")
	@Inject
	@Named(value = "record1")
	private RecordImpl3 record = null;
	//private RecordImpl record = new RecordImpl();
	
	public RecordViewImpl3() {
	}
	
	public RecordViewImpl3(RecordImpl3 record) {
		this.record = record;
	}

	@Override
	public void input() {
		try (Scanner scanner = new Scanner(System.in)){
			
			System.out.print("> kot, eng, mat input??");
			int kor = scanner.nextInt();
			int eng = scanner.nextInt();
			int mat = scanner.nextInt();
			
			this.record.setKor(kor);
			this.record.setEng(eng);
			this.record.setMat(mat);
			
			} catch (Exception e) {
			e.printStackTrace();
		}// try catch
		
	}//input

	@Override
	public void output() {
		System.out.printf("> kor=%d, eng=%d, mat=%d, tot=%d, avg=%.2f\n",
								this.record.getKor(), 
								this.record.getEng(),
								this.record.getMat(),
								this.record.total(),
								this.record.avg()
								);
		
	}

}//class
