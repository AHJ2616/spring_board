package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/board/*") //http:localhost:80/board/*
@AllArgsConstructor
public class Board_controller {

	private BoardService service;
	
	// http:localhost:80/board/list (@GetMapping) 에서 실행된다
	@GetMapping("/list")
	public void list(Model model) {
		
		model.addAttribute("list",service.getlist());
		//list라는 변수에 List<BoardVO> 가 넘어 온다.
	}//method end
	
	// form을 작성 안했을때 접속 할 수 있게한다.
	@GetMapping("/register")
	public void register() {}
	
	// http:localhost:80/board/register (@PostMapping) 에서 실행 후 http:localhost:80/board/list로 이동
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		//rttr : 1회성으로 저장되는 값
		log.info("BoardContorller.register() 실행");
		
		//글 등록 method 실행
		service.register(board);
		
		//글 등록할때 글번호를 rttr에 저장한다
		rttr.addFlashAttribute("result",board.getBno()); 
		
		
		return "redirect:/board/list"; //등록 후 이동시킬 url
	}
	// http:localhost:80/board/get (@GetMapping) 에서 실행된다.
	@GetMapping(value= {"/get","/modify"}) 
	public void get(@RequestParam("bno") long bno, Model model) {
		log.info("Board_controller.get() 실행");
		model.addAttribute("board", service.get(bno));
		// board/get에서 받은 bno로 service.get 실행 하여 board에 저장(model영역)
		
	}
	// http:localhost:80/board/modify (@PostMapping) 에서 실행 후 http:localhost:80/board/list로 이동
	@PostMapping("/modify")
	public String modify(BoardVO board,RedirectAttributes rttr) {
		log.info("Board_controller.modify() 실행");
		if(service.modify(board)==true) {//service.modify retrun값이 boolean 이다.
			rttr.addFlashAttribute("result","글이 수정되었습니다");
		} else {rttr.addFlashAttribute("result","글 수정이 실패하였습니다");}
		
		return "redirect:/board/list";
	}
	
	
	// http:localhost:80/board/remove (@PostMapping) 에서 실행 후 http:localhost:80/board/list로 이동
	@GetMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("Board_controller.remove() 실행");
		if(service.remove(bno)==true) {//service.modify retrun값이 boolean 이다.
			rttr.addFlashAttribute("result","글이 삭제되었습니다");
		} else {rttr.addFlashAttribute("result","글 삭제에 실패하였습니다");}
		
		
		return "redirect:/board/list";
	}
	
}//class end

