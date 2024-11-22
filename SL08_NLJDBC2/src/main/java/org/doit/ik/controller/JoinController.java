package org.doit.ik.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.doit.ik.domain.MemberVO;
import org.doit.ik.domain.NoticeVO;
import org.doit.ik.persistence.MemberDao;
import org.doit.ik.persistence.NoticeDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

// 공지사항 
@Controller
@RequestMapping("/joinus/*")
public class JoinController {

	@Autowired
	private MemberDao memberDao;
	
	// 로그인    /joinus/login.htm   -> /joinus/login.jsp
	@GetMapping("/login.htm")
	public String login() throws Exception {
		
		return "login.jsp";
	}
	
	
	// 회원 가입 시     /joinus/join.htm    ->    /joinus/join.jsp  응답.
	@GetMapping("/join.htm")
	public String join() throws Exception {
		
		return "join.jsp";
	}
	
	// 회원 가입 시     /joinus/join.htm    ->    /joinus/join.jsp  응답.
	@PostMapping("/join.htm")
	public String join(MemberVO member) throws Exception {
		this.memberDao.insert(member);
		
		return "redirect:../index.htm";  
	}
  
} // class






