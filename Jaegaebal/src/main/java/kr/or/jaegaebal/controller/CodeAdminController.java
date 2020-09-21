package kr.or.jaegaebal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.jaegaebal.dto.CodeAdmin;
import kr.or.jaegaebal.dto.DocCodeAdmin;
import kr.or.jaegaebal.dto.InsaCodeAdmin;
import kr.or.jaegaebal.service.CodeAdminService;


@Controller
public class CodeAdminController {
	
	
	@Autowired private CodeAdminService codeAdminService;
	
/* ==========문서코드관리========== */
	
	//문서코드리스트
	/* @GetMapping("/getDocCodeList") */
	@RequestMapping(value="/getDocCodeList", method=RequestMethod.GET)
	public String getDocCodeList(Model model) {
		List<DocCodeAdmin> docCodeList = codeAdminService.getDocCodeList();
		System.out.println("docCodeList -> " + docCodeList);
		model.addAttribute("docCodeList",docCodeList);
		model.addAttribute("title","코드리스트");
		
		return "codeAdmin/docCodeList";
	}
	
	
	@GetMapping("/empCode")
	public String empCode() {
		
		return "codeAdmin/empCode";
	}
	
	/* ==========인사코드관리========== */
	
	//인사코드리스트
	/* @GetMapping("/getInsaCodeList") */
	@RequestMapping(value="/getInsaCodeList", method=RequestMethod.GET)
	public String getInsaCodeList(Model model) {
		List<InsaCodeAdmin> insaCodeList = codeAdminService.getInsaCodeList();
		System.out.println("insaCodeList -> " + insaCodeList);
		model.addAttribute("insaCodeList",insaCodeList);
		model.addAttribute("title","코드리스트");
		
		return "codeAdmin/insaCodeList";
	}
	
	//인사코드 등록
	@GetMapping("/addInsaCode")
	public String addInsaCode(Model model) {
		model.addAttribute("title","근무형태코드 추가");
		return "CodeAdmin/addInsaCode";
	}
	
	@PostMapping("/addInsaCode")
	public String addInsaCode(InsaCodeAdmin insaCodeAdmin
			,@RequestParam(value="insaCode",required = false) String insaCode
			,@RequestParam(value="insaName",required = false) String insaName
			) {
		System.out.println("근무형태코드 -> "+insaCode);
		System.out.println("근무명 -> "+insaName);
		
		codeAdminService.addInsaCode(insaCodeAdmin);
		return "redirect:/getInsaCodeList";
	}
	
	//코드 중복확인
			@PostMapping(value = "/insaCodeCheck", produces = "application/json")
			@ResponseBody
			public int insaCodeCheck(@RequestParam(value="insaCode") String insaCode) {
				
				int result = codeAdminService.insaCodeCheck(insaCode);
				
				return result;
			}
			
	//인사코드 수정
			@GetMapping("/updateInsaCode")
			public String updateInsaCode(Model model
					,@RequestParam(value="insaCode",required=false) String insaCode) {
				InsaCodeAdmin isca = codeAdminService.getInsaCode(insaCode);
				model.addAttribute("InsaCodeAdmin",isca);
				model.addAttribute("title","수정화면");
				
					return "codeAdmin/updateInsaCode";
			}
			
			@PostMapping("/updateInsaCode")
			public String updateInsaCode(InsaCodeAdmin insaCodeAdmin) {
				codeAdminService.updateInsaCode(insaCodeAdmin);
				return "redirect:/getInsaCodeList";
			}
	
	//인사코드 삭제
			@GetMapping("/deleteInsaCode")
			public String deleteMember(InsaCodeAdmin insaCodeAdmin) {
				if(insaCodeAdmin.getInsaCode() != null && !"".equals(insaCodeAdmin.getInsaCode())) {
					codeAdminService.deleteInsaCode(insaCodeAdmin.getInsaCode());	
				}
				return "redirect:/getInsaCodeList";
			}
			
	/* ==========근무형태코드관리========== */
	
	//코드검색
	@PostMapping("/searchWorkCode")
	public String searchWorkCode(@RequestParam(value="sk",required = false) String sk,
							   @RequestParam(value="sv",required = false) String sv,Model model) {
		System.out.println(sk);
		System.out.println(sv);
		List<CodeAdmin> workCodeList = codeAdminService.getSearchWorkCodeList(sk, sv);
				
		model.addAttribute("workCodeList", workCodeList);
		return "codeAdmin/getWorkCodeList";
	}
	
	//코드 삭제
	@GetMapping("/deleteWorkCode")
	public String deleteMember(CodeAdmin codeAdmin) {
		if(codeAdmin.getWorkCode() != null && !"".equals(codeAdmin.getWorkCode())) {
			codeAdminService.deleteWorkCode(codeAdmin.getWorkCode());	
		}
		return "redirect:/getWorkCodeList";
	}
	
	/* @GetMapping("/getWorkCodeList") */
	@RequestMapping(value="/getWorkCodeList", method=RequestMethod.GET)
	public String getWorkCodeList(Model model) {
		List<CodeAdmin> workCodeList = codeAdminService.getWorkCodeList();
		System.out.println("workCodeList -> " + workCodeList);
		model.addAttribute("workCodeList",workCodeList);
		model.addAttribute("title","코드리스트");
		return "codeAdmin/workCodeList";
	}
	
	
	@GetMapping("/addWorkCode")
	public String addWorkCode(Model model) {
		model.addAttribute("title","근무형태코드 추가");
		return "codeAdmin/addWorkCode";
	}
	
	@PostMapping("/addWorkCode")
	public String addWorkCode(CodeAdmin codeAdmin
			,@RequestParam(value="workCode",required = false) String workCode
			,@RequestParam(value="workName",required = false) String workName
			,@RequestParam(value="workUseOrNot",required = false) String workUseOrNot
			) {
		System.out.println("근무형태코드 -> "+workCode);
		System.out.println("근무명 -> "+workName);
		System.out.println("사용유무 -> "+workUseOrNot);
		codeAdminService.addWorkCode(codeAdmin);
		return "redirect:/getWorkCodeList";
	}
	
	@GetMapping("/updateWorkCode")
	public String updateWorkCode(Model model
			,@RequestParam(value="workCode",required=false) String workCode) {
		CodeAdmin ca = codeAdminService.getWorkCode(workCode);
		model.addAttribute("codeAdmin",ca);
		model.addAttribute("title","수정화면");
		
			return "codeAdmin/updateWorkCode";
	}
	
	@PostMapping("/updateWorkCode")
	public String updateWorkCode(CodeAdmin codeAdmin) {
		codeAdminService.updateWorkCode(codeAdmin);
		return "redirect:/getWorkCodeList";
	}
	
	//코드 중복확인
		@PostMapping(value = "/codeCheck", produces = "application/json")
		@ResponseBody
		public int codeCheck(@RequestParam(value="workCode") String workCode) {
			
			int result = codeAdminService.codeCheck(workCode);
			
			return result;
		}
	

}
