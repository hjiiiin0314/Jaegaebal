package kr.or.jaegaebal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.jaegaebal.dto.SalaryInfo;
import kr.or.jaegaebal.service.SalaryService;


/**
 * 담당자 : 이요셉
 * @author ECS
 *
 */
@Controller
public class SalaryController {
	@Autowired
	private SalaryService salaryService;
	
	//급여기본정보화면
	@GetMapping("/salary/salary_info")
	public String salaryInfo(Model model, String dataNum) {
		dataNum = "sal_1";
		SalaryInfo salaryInfo = salaryService.salaryInfo(dataNum);
		model.addAttribute("salaryInfo", salaryInfo);
		return "salary/salary_info";
	}
}
