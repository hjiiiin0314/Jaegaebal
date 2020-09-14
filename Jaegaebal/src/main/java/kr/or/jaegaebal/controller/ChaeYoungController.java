package kr.or.jaegaebal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 담당자 : 김형진
 * @author ECS
 *
 */
@Controller
public class ChaeYoungController {

	@GetMapping("cyboard")
	public String cyBoard(Model model) {
		
		model.addAttribute("title", "구인공고게시판");
		
		return "chaeyoung/cyboard";
	}
}
