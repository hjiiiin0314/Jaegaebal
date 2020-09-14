package kr.or.jaegaebal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.jaegaebal.service.ChaeYoungService;

/**
 * 담당자 : 김형진
 * @author ECS
 *
 */
@Controller
public class ChaeYoungController {

	@Autowired ChaeYoungService chaeYoungService;
	
	@GetMapping("/cyboardList")
	public String cyBoardList(Model model) {
		//구인공고 게시판 리스트를 가져온다.
		model.addAttribute("title", "구인공고게시판");
		
		return "chaeyoung/cyboard";
	}
	
	@GetMapping("/addCYBoardPost")
	public String addCYBoardPost() {
		
		
		return "";
	}
}
