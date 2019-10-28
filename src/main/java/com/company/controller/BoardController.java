package com.company.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.domain.BoardVo;
import com.company.domain.Criteria;
import com.company.domain.PageDto;
import com.company.domain.ReplyVo;
import com.company.service.BoardService;
import com.company.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@AllArgsConstructor
@Log4j
@RequestMapping("/board/*")
public class BoardController {

	private BoardService service;
	private ReplyService replyService;
	
	//목록리스트
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		List<BoardVo> boards = service.getList(cri);
//		Map<Long, Object> replyMap = new HashMap<Long, Object>();
//		
//		for(BoardVo board : boards) {
//			List<ReplyVo> replies = replyService.getList(board.getBno());
//			replyMap.put(board.getBno(), replies);
//		}
		
		System.out.println(boards);
		log.info("list: " + cri);
//		model.addAttribute("replyList", replyMap);
		model.addAttribute("list", boards);
		int total = service.getTotal(cri);
		log.info("total: " + total);
		model.addAttribute("pageMaker", new PageDto(cri, total));
	}
	
	//글 등록페이지 이동
	@GetMapping("/register")
	public void register() {
		
	}
	
	//글  등록 처리
	@PostMapping("register")
	public String register(BoardVo board, RedirectAttributes rttr) { //RedirectAttributes : d
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		rttr.addFlashAttribute("fix", board.getFix());
		return "redirect:/board/list";
	}
	
	//게시글 조회, 게시글 수정 페이지 이동
	//@GetMapping 이나 @PostMapping은 url을 배열로 처리가 가능하다.
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("get or moidfy");
		model.addAttribute("board", service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVo board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify:" + board);
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("remove:" + bno);
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:/board/list";
	}
	
	//답글 등록페이지 이동
	@GetMapping("/boardReply")
	public void boardReply(@RequestParam("bno") Long bno, Model model) {
	
		System.out.println(service.getBoardReplyInfo(bno));
		model.addAttribute("boardReply", service.getBoardReplyInfo(bno));
	}
	
	//답글 등록 처리
	@PostMapping("boardReply")
	public String boardReply(BoardVo board, RedirectAttributes rttr) {
		service.updateGroupOrd(board);
		service.insertBoardReply(board);
		rttr.addFlashAttribute("result", "success");
		
		return "redirect:/board/list";
	}
}
