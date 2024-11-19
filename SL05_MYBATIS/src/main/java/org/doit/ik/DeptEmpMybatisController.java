package org.doit.ik;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.doit.ik.mapper.DeptEmpSalgradeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Controller
@Log4j
@AllArgsConstructor
public class DeptEmpMybatisController {
	
	//private static final Logger logger = LoggerFactory.getLogger(DeptEmpMybatisController.class);
	
	//@Autowired
	private DeptEmpSalgradeMapper deptEmpSalgradeMapper;
	
	// 컨트롤러 메서드 구현
	@GetMapping(value = "/dept/emp")
	public void getDeptEmpSalgradeMapper(Model model) {
		log.info("> DeptEmpSalgradeMapper.getDeptEmpSalgrade()...");
		model.addAttribute("list", this.deptEmpSalgradeMapper.getDeptEmpInfo());
	}
	
}// class