package org.doit.ik.domain;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import lombok.Data;

@Data
public class MultiMessage {   // NoticeVO

	private String output;
	
	//private CommonsMultipartFile [] attach;
	private List<CommonsMultipartFile> attach;
}
