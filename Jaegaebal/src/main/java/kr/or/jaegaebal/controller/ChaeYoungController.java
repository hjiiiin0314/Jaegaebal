package kr.or.jaegaebal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.jaegaebal.dto.ChaeYoungBoard;
import kr.or.jaegaebal.dto.ChaeYoungCode;
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
		List<ChaeYoungBoard> cyBoardList = chaeYoungService.cyBoardList();
		model.addAttribute("title", "구인공고게시판");
		model.addAttribute("cyBoardList", cyBoardList);
		
		return "chaeyoung/cyboard";
	}
	
	@GetMapping("/addCYPostForm")
	public String addCYPostForm(Model model,@RequestParam(value="jobNumber",required = false) String jobNumber) {
		//구인공고 글쓰기 화면
		System.out.println(jobNumber + "<--jobNumber");
		//지원분야코드를 가져온다.
		List<ChaeYoungCode> fieldCode = chaeYoungService.getFieldeCode();
		if(jobNumber != null && !"".equals(jobNumber)) {
			ChaeYoungBoard chaeYoungboard = chaeYoungService.cyBoardList(jobNumber);
			model.addAttribute("cyboard", chaeYoungboard);
		}
		
		model.addAttribute("fieldCode", fieldCode);
		
		return "chaeyoung/add_cy_post_form";
	}
	@PostMapping("addCYPost")
	public String addCYPost(ChaeYoungBoard ChaeYoungBoard) {
		//구인공고 등록
		chaeYoungService.addCYBoardPost(ChaeYoungBoard);
		return "redirect:/cyboardList";
	}

}
