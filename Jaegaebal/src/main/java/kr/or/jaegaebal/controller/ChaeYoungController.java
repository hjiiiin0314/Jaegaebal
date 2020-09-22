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
		//채용공고 게시판 리스트를 가져온다.
		List<ChaeYoungBoard> cyBoardList = chaeYoungService.cyBoardList();
		model.addAttribute("title", "채용공고게시판");
		model.addAttribute("cyBoardList", cyBoardList);
		
		return "chaeyoung/cyboard";
	}
	
	@GetMapping("/addCYPostForm")
	public String addCYPostForm(Model model,@RequestParam(value="jobNumber",required = false) String jobNumber) {
		//구인공고 글쓰기 화면
		
		//지원부서코드를 가져온다.
		List<Jojic> jojicCode = chaeYoungService.getJojicCode();
		if(jobNumber != null && !"".equals(jobNumber)) {
			//리스트에서 클릭하여 form 화면으로 올 경우.
			ChaeYoungBoard chaeYoungboard = chaeYoungService.cyBoardList(jobNumber);
			model.addAttribute("cyboard", chaeYoungboard);
		}
		
		model.addAttribute("jojicCode", jojicCode);
		
		return "chaeyoung/add_cy_post_form";
	}
	@PostMapping("/addCYPost")
	public String addCYPost(ChaeYoungBoard ChaeYoungBoard) {
		//채용공고 등록
		chaeYoungService.addCYBoardPost(ChaeYoungBoard);
		return "redirect:/cyboardList";
	}
	@PostMapping("/updateCYPost")
	public String updateCYPost(ChaeYoungBoard ChaeYoungBoard) {
		//채용공고 수정

		chaeYoungService.updateCYPost(ChaeYoungBoard);
		return "redirect:/cyboardList";
	}
	//지원할 시 이메일 체크
	@PostMapping(value = "/emailCheck", produces = "application/json")
	@ResponseBody
	public int emailCheck(@RequestParam(value="appEmail") String appEmail) {
		String app = chaeYoungService.emailCheck(appEmail);
		int result = 0;
		if(app != null) {
			result = 1;		
		}
		return result;
	}
	
	//지원자 목록
	@GetMapping("/appManagement")
	public String appManagement(Model model) {
		
		List<ChaeYoungBoard> cyBoardList = chaeYoungService.cyBoardList();
		List<ChaeYoungApplicant> appList = chaeYoungService.appManagement();
		model.addAttribute("cyBoardList", cyBoardList);
		model.addAttribute("appList", appList);
		
		return "chaeyoung/app_management";
	}
	//지원자 이력서 작성form
	@GetMapping("/appResumeForm")
	public String appResumeForm(ChaeYoungApplicant chaeYoungApplicant,Model model) {
		if(chaeYoungApplicant != null) {
			ChaeYoungApplicant applicant = chaeYoungService.appManagement(chaeYoungApplicant);
			model.addAttribute("chaeYoungApplicant", applicant);
		}
		
		model.addAttribute("title", "이력서 작성 form");
		return "chaeyoung/app_resumeForm";
	}
	//지원하기 버튼 누른 후 지원
	@PostMapping("/addApplicant")
	public String addApplicant(ChaeYoungApplicant chaeYoungApplicant,Model model) {
		
		int result = chaeYoungService.addApplicant(chaeYoungApplicant);
		
		if(result == 0) {
			return "redirect:/cyboardList";
		}
		model.addAttribute("chaeYoungApplicant", chaeYoungApplicant);
		return "chaeyoung/app_resumeForm";
	}
}
