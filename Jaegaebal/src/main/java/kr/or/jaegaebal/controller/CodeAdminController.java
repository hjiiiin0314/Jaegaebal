package kr.or.jaegaebal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CodeAdminController {

	
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
	
	@GetMapping("/workCode")
	public String workCode() {
		
		return "codeAdmin/workCode";
	}
}
