package kr.or.jaegaebal.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.jaegaebal.dto.SalaryInfo;
import kr.or.jaegaebal.dto.StaffInfo;
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
	public String salaryInfo(Model model) {
		List<Map<StaffInfo,Object>> staffInfoList = salaryService.getSalaryStaffList();
		String dataEmp = "20010100";
		List<Map<SalaryInfo, Object>> salaryInfo = salaryService.salaryInfo(dataEmp);
		model.addAttribute("staffInfoList", staffInfoList);
		model.addAttribute("salaryInfo", salaryInfo.get(0));
		return "salary/salary_info";
	}
	
	//사원정보 클릭시 급여 ajax조회
	@PostMapping(value = "/salary/salary_info", produces = "application/json")
	@ResponseBody
	public Map<String, Object> salaryInfo(@RequestParam(value = "dataEmp", required = false) String dataEmp) {
		System.out.println(dataEmp);
		Map<String, Object> salaryInfo = salaryService.salaryInfoMap(dataEmp);
		System.out.println(salaryInfo);
		return salaryInfo;
	}
}
