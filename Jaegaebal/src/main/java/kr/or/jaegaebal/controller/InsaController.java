package kr.or.jaegaebal.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.jaegaebal.dto.Company;
import kr.or.jaegaebal.service.InsaService;

/**
 * 담당자 : 이은혜
 * @author ECS
 *
 */
@Controller
public class InsaController {
	
	private static final Logger log = LoggerFactory.getLogger(InsaController.class);

	@Autowired
	private InsaService insaService;
	/*
	 * @Autowired private InsaMapper insaMapper;
	 */
	
	//회사정보 보이는 화면
	@GetMapping("/insa/companyInfo")
	public String companyInfo(Model model) {
		List<Company> companyInfo = insaService.getCompanyInfo();
		
		model.addAttribute("title", 		"회사 정보");
		model.addAttribute("companyInfo", 	companyInfo);
		
		return "insa/company_info";
	}
	
	//사원 리스트
	@GetMapping("/insa/staffList")
	public String staffList(Model model) {
		model.addAttribute("title", 		"사원 리스트");
		
		return "insa/staff_list";
	}
	

	
	
}
