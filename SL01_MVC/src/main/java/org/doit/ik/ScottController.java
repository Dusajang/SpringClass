package org.doit.ik;

import java.util.ArrayList;
import java.util.Locale;

import org.doit.ik.domain.DeptDTO;
import org.doit.ik.domain.EmpDTO;
import org.doit.ik.mapper.scott.DeptMapper;
import org.doit.ik.mapper.scott.EmpMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Setter;

@Controller
public class ScottController {

	private static final Logger logger = LoggerFactory.getLogger(ScottController.class);
	
	// DI
	// 스프링 제공 어노테이션
	//@Autowired
	
	//롬복 제공 어노테이션
	@Setter(onMethod=@__({@Autowired}))
	private DeptMapper deptmapper;
	
	@Setter(onMethod=@__({@Autowired}))
	private EmpMapper empmapper;
	
	//@RequestMapping(value = "/scott/dept", method = RequestMethod.GET)
	@GetMapping(value = "/scott/dept")
	public String dept(Locale locale, Model model) {
		logger.info("> ScottController.dept()...");
		
		ArrayList<DeptDTO> list = this.deptmapper.selectDept();
		model.addAttribute("list", list);
		
		return "scott/dept";
	}
	
	
	
	//@RequestMapping(value = "/scott/dept", method = RequestMethod.POST)
		@PostMapping(value = "/scott/emp")
		public String emp(Locale locale, Model model
				, @RequestParam(value = "deptno") int [] deptnos) {
			logger.info("> ScottController.dept()...");
			
			ArrayList<EmpDTO> list = this.empmapper.selectEmp(deptnos);
			model.addAttribute("list", list);
			
			return "scott/emp";
		}
	
		
	/* [1] 예전 풀이
	//@RequestMapping(value = "/scott/dept", method = RequestMethod.POST)
	@PostMapping(value = "/scott/emp")
	public String emp(Locale locale, Model model
			, HttpServletRequest request) {
		logger.info("> ScottController.dept()...");
		
		int [] deptnos = null;
		String [] pdeptnos = request.getParameterValues("deptno");
		deptnos = new int[ pdeptnos.length ];
		for (int i = 0; i < pdeptnos.length; i++) {
			deptnos[i] = Integer.parseInt(pdeptnos[i]);
		}
		
		
		return "scott/emp";
	}
	 */
		
		
}



