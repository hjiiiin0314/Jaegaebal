package kr.or.jaegaebal.controller;

import java.util.List;
import java.util.Map;

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
		model.addAttribute("staffInfoList", staffInfoList);
		return "salary/salary_info";
	}
	
	//사원정보 클릭시 급여 ajax조회
	@PostMapping(value = "/salary/salary_info", produces = "application/json")
	@ResponseBody
	public String salaryInfo(@RequestParam(value = "dataEmp", required = false) String dataEmp) {
		SalaryInfo salaryInfo = salaryService.salaryInfo(dataEmp);
		String salaryInfoMap = salaryInfo.toString();
		return salaryInfoMap;
	}
}
