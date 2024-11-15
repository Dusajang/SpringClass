package org.doit.ik;

import org.doit.ik.domain.BoardVO;
import org.doit.ik.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
	
	//private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	//@Autowired
	private BoardService boardService;
	
	/* 1.
	@GetMapping("board/list")
	public String list(Model model) {
		log.info("> BoardController.list().......");
		
		model.addAttribute("list", this.boardService.getList());
		
		return "/board/list";
	}
	*/
	
	// 2.
	@GetMapping("/list")
	public void list(Model model) {
		log.info("> BoardController.list().......");
		
		model.addAttribute("list", this.boardService.getList());
		
		//return "/board/list";   요청 url과 같을 경우 생략 가능
	}
	
	
	/* 3.
	@GetMapping("board/list")
	public ModelAndView list(ModelAndView mav) {
		log.info("> BoardController.list().......");
		
		mav.addObject("list", this.boardService.getList());
		mav.setViewName("/board/list");
		
		//return "/board/list";
		return mav;
	}
	*/
	
	//<a herf="/board/register">글쓰기</a>
	@GetMapping("/register")
	public void register() {
		log.info("> BoardController.list().......");
		
	}
	// <button type="submit">Submit</button>
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("> BoardController.list() POST.......");
		this.boardService.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";  // 스프링에서 리다이렉트 시킬 때...
		//return "redirect:/board/list?bno=2";  
		//return "redirect:/board/list/2";  
		
	}
	
	@PostMapping(value = {"/modify"})
	public String modify(BoardVO boardVO, RedirectAttributes rttr) {
	   log.info("> BoardController.modify() POST.....");
	   if (this.boardService.modify(boardVO)) {
		rttr.addFlashAttribute("result", "SUCCESS");
	}
	   
	   return String.format("redirect:/board/get?bno=%d", boardVO.getBno());
	}
	
	//<a href="/board/get?bno=3">
	@GetMapping(value = {"/get","/modify"})
	public void get(@RequestParam("bno") Long bno, Model model) {
	    log.info("> BoardController.get()...");
	    model.addAttribute("boardVO", this.boardService.get(bno));
	}
	/*
	 * //<a href="/board/get/3">
	 * 
	 * @GetMapping(value = {"/get/{bno}"}) public void get(@PathVariable("bno") Long
	 * bno, Model model) { log.info("> BoardController.get()...");
	 * model.addAttribute("boardVO", this.boardService.get(bno)); }
	 */
	
	@GetMapping(value = {"/delete"})
	public String delete(BoardVO boardVO, RedirectAttributes rttr) {
	    log.info("> BoardController.get()...");
	    if (this.boardService.delete(boardVO)) {
			rttr.addFlashAttribute("result", "SUCCESS");
	    }
	    return "redirect:/board/list"; 
	}
}// class
