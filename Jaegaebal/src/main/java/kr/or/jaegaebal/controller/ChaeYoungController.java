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
import kr.or.jaegaebal.dto.ChaeYoungCareerInfo;
import kr.or.jaegaebal.dto.ChaeYoungInfo;
import kr.or.jaegaebal.dto.Jojic;
import kr.or.jaegaebal.mapper.ChaeYoungMapper;
import kr.or.jaegaebal.service.ChaeYoungService;

/**
 * 담당자 : 김형진
 * @author ECS
 *
 */
@Controller
public class ChaeYoungController {

	@Autowired ChaeYoungService chaeYoungService;
	@Autowired ChaeYoungMapper chaeYoungMapper;
	//채용공고 리스트
	@GetMapping("/cyboardList")
	public String cyBoardList(Model model) {
		//채용공고 게시판 리스트를 가져온다.
		List<ChaeYoungBoard> cyBoardList = chaeYoungService.cyBoardList();
		model.addAttribute("title", "채용공고게시판");
		model.addAttribute("cyBoardList", cyBoardList);
		
		return "chaeyoung/cyboard";
	}
	//채용공고 글쓰기 화면
	@GetMapping("/addCYPostForm")
	public String addCYPostForm(Model model,@RequestParam(value="jobNumber",required = false) String jobNumber) {
	
		
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
	//채용공고 등록
	@PostMapping("/addCYPost")
	public String addCYPost(ChaeYoungBoard ChaeYoungBoard) {
	
		chaeYoungService.addCYBoardPost(ChaeYoungBoard);
		return "redirect:/cyboardList";
	}
	//채용공고 수정
	@PostMapping("/updateCYPost")
	public String updateCYPost(ChaeYoungBoard ChaeYoungBoard) {
		

		chaeYoungService.updateCYPost(ChaeYoungBoard);
		return "redirect:/cyboardList";
	}
	//채용공고 삭제
	@GetMapping("/deleteCYPost")
	public String deleteCYPost(@RequestParam(value="jobNumber") String jobNumber) {
		
		chaeYoungService.deleteCYPost(jobNumber);
		return "redirect:/cyboardList";
	}
	//지원할 시 이메일 체크
	@PostMapping(value = "/emailCheck", produces = "application/json")
	@ResponseBody
	public ChaeYoungApplicant emailCheck(@RequestParam(value="appEmail") String appEmail) {
		ChaeYoungApplicant app = chaeYoungService.emailCheck(appEmail);
		if(app == null) {
			//값이 없을 경우 임의적으로 값을 셋팅한다 (파서에러 방지)
			ChaeYoungApplicant app2 = new ChaeYoungApplicant(); 
			app2.setAppEmail(null);
			return app2;
			
		}
		return app;
	}
	//공고 삭제할 시 지원자 유무 
	@PostMapping(value = "/appSearch", produces = "application/json")
	@ResponseBody
	public ChaeYoungApplicant appSearch(ChaeYoungApplicant chaeYoungApplicant) {
		ChaeYoungApplicant applicant = chaeYoungService.appManagement(chaeYoungApplicant);
		
		if(applicant == null) {
			//값이 없을 경우 임의적으로 값을 셋팅한다 (파서에러 방지)
			ChaeYoungApplicant app = new ChaeYoungApplicant(); 
			app.setAppEmail(null);
			return app;
			
		}

		return applicant;
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
			//지원자 한명의 정보 가져오기
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
	
	//지원자 삭제
	@GetMapping("/deleteApplicant")
	public String deleteApplicant(@RequestParam(value="appEmail") String appEmail) {
		
		chaeYoungService.deleteApplicant(appEmail);
		
		return "redirect:/cyboardList";
	}
	//채용평가기준화면
	@GetMapping("/cyStandard")
	public String cyStandard(Model model) {
		
		//지원부서코드를 가져온다.
		List<Jojic> jojicCode = chaeYoungService.getJojicCode();
		
		model.addAttribute("jojicCode", jojicCode);
		return "chaeyoung/cyStandard";
	}
	
	//지원서작성
	@PostMapping(value = "/addInfo", produces = "application/json")
	@ResponseBody
	public int addInfo(ChaeYoungInfo chaeYoungInfo) {
		
		System.out.println(chaeYoungInfo + "<--- dfdfadf");

		
		//int result = chaeYoungService.addAppInfo(chaeYoungInfo);

		return 0;
	}
}
