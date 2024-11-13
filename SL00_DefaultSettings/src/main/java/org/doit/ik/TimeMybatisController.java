package org.doit.ik;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TimeMybatisController {
	
	private static final Logger logger = LoggerFactory.getLogger(TimeMybatisController.class);
	
	//@RequestMapping(value = "/time", method = RequestMethod.GET)
	@GetMapping(value = "/time")
	public String home(Locale locale, Model model) {
		logger.info(" > TimeMybatisController.time()...");
		
		//???DAO , ???DAOImpl
		
		
		
		return "home";
	}
	
}
