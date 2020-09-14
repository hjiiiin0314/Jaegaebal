package kr.or.jaegaebal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 담당자 : 이은혜
 * @author ECS
 *
 */
@Controller
public class InSaController {
	
	//회사정보 보이는 화면
	@GetMapping("/insa/companyInfo")
	public String companyInfo(Model model) {
		model.addAttribute("title", "회사 정보");
		return "insa/company_info";
	}
}
