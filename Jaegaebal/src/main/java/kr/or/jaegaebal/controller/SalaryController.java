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
	
	//월별급여현황화면
	@GetMapping("/salary/salary_month")
	public String salaryMonth(Model model) {
		List<Map<StaffInfo,Object>> staffInfoList = salaryService.getSalaryStaffList();
		List<Map<String, Object>> levelList = salaryService.getLevelList();
		List<Map<String, Object>> jojicList = salaryService.getJojicList();
		List<Map<String, Object>> yearList = salaryService.getFilterYear();
		String searchYear = (String) yearList.get(0).get("getYear");
		String dataNum = (String) staffInfoList.get(0).get("dataNum");
		List<Map<String,Object>> monthSalList = salaryService.getMonthSalList(searchYear, dataNum);
		model.addAttribute("dataNum", dataNum);
		model.addAttribute("yearList", yearList);
		model.addAttribute("levelList", levelList);
		model.addAttribute("jojicList", jojicList);
		model.addAttribute("staffInfoList", staffInfoList);
		model.addAttribute("monthSalList", monthSalList);
		return "salary/salary_month";
	}
	
	//급여기본정보화면
	@GetMapping("/salary/salary_info")
	public String salaryInfo(Model model) {
		List<Map<StaffInfo,Object>> staffInfoList = salaryService.getSalaryStaffList();
		SalaryInfo salaryInfo = salaryService.salaryInfo();
		List<Map<String, Object>> levelList = salaryService.getLevelList();
		List<Map<String, Object>> jojicList = salaryService.getJojicList();
		model.addAttribute("levelList", levelList);
		model.addAttribute("jojicList", jojicList);
		model.addAttribute("staffInfoList", staffInfoList);
		model.addAttribute("salaryInfo", salaryInfo);
		return "salary/salary_info";
	}
	
	//급여기본정보화면 수정처리
	@PostMapping("/salary/salary_info")
	public String salaryInfo(SalaryInfo salaryInfo) {
		System.out.println(salaryInfo);
		int result = salaryService.updateSalaryInfo(salaryInfo);
		
		System.out.println(result + " <- 급여정보수정 처리 결과");
		return "redirect:/salary/salary_info";
	}
	
	//사원정보 클릭시 급여 ajax조회
	@PostMapping(value = "/salary/salary_info", produces = "application/json")
	@ResponseBody
	public Map<String, Object> salaryInfo(@RequestParam(value = "dataEmp", required = false) String dataEmp) {
		Map<String, Object> salaryInfo = salaryService.salaryInfoMap(dataEmp);
		return salaryInfo;
	}
	
	//사원정보 클릭시 월별급여 ajax조회
	@PostMapping(value = "/salary/salary_month", produces = "application/json")
	@ResponseBody
	public List<Map<String,Object>> salaryMonth(@RequestParam(value = "dataNum", required = false) String dataNum
			,@RequestParam(value = "searchYear", required = false) String searchYear) {
		List<Map<String,Object>> monthSalList = salaryService.getMonthSalList(searchYear, dataNum);
		return monthSalList;
	}
	
	//사원정보 검색 ajax조회
	@PostMapping(value = "/salary/salary_search", produces = "application/json")
	@ResponseBody
	public List<Map<String, Object>> salaryInfo(@RequestParam(value = "ajaxArray[]", required = false) String[] ajaxArray) {
		String searchCate = ajaxArray[0];
		String searchText = ajaxArray[1];
		String searchLevel = ajaxArray[2];
		String searchJojic = ajaxArray[3];
		List<Map<String, Object>> staffList = salaryService.getStaffListMap(searchCate, searchText, searchLevel, searchJojic);
		return staffList;
	}
}
