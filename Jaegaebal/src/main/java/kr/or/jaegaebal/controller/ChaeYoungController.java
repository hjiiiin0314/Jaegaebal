package kr.or.jaegaebal.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.jaegaebal.dto.ChaeYoungApplicant;
import kr.or.jaegaebal.dto.ChaeYoungBoard;
import kr.or.jaegaebal.dto.Jojic;
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
		
		//지원부서코드를 가져온다.
		List<Jojic> jojicCode = chaeYoungService.getJojicCode();
		if(jobNumber != null && !"".equals(jobNumber)) {
			ChaeYoungBoard chaeYoungboard = chaeYoungService.cyBoardList(jobNumber);
			model.addAttribute("cyboard", chaeYoungboard);
		}
		
		model.addAttribute("jojicCode", jojicCode);
		
		return "chaeyoung/add_cy_post_form";
	}
	@PostMapping("addCYPost")
	public String addCYPost(ChaeYoungBoard ChaeYoungBoard) {
		//구인공고 등록
		chaeYoungService.addCYBoardPost(ChaeYoungBoard);
		return "redirect:/cyboardList";
	}
	
	@GetMapping("applicantForm")
	public String applicantLogin() {
		
		return "chaeyoung/applicantLogin";
	}
	//지원할 시 이메일 체크
	@PostMapping(value = "/emailCheck", produces = "application/json")
	@ResponseBody
	public int emailCheck(@RequestParam(value="appEmail") String appEmail) {
		ChaeYoungApplicant app = chaeYoungService.emailCheck(appEmail);
		int result = 0;
		if(app != null) {
			result = 1;		
		}
		
		return result;
	}
}
