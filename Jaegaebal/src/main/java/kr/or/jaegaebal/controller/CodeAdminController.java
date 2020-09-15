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

import kr.or.jaegaebal.dto.CodeAdmin;
import kr.or.jaegaebal.service.CodeAdminService;

@Controller
public class CodeAdminController {
	
	
	@Autowired private CodeAdminService codeAdminService;
	
	@GetMapping("/insaCode")
	public String insaCode() {
		
		return "codeAdmin/insaCode";
	}
	
	@GetMapping("/docCode")
	public String docCode() {
		
		return "codeAdmin/docCode";
	}
	
	@GetMapping("/empCode")
	public String empCode() {
		
		return "codeAdmin/empCode";
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
		return "codeAdmin/workCodeList";
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
		return "redirect:codeAdmin/workCodeList";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
