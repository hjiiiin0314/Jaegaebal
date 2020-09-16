package kr.or.jaegaebal.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.jaegaebal.dto.Company;
import kr.or.jaegaebal.dto.Jojic;
import kr.or.jaegaebal.service.InsaService;

/**
 * 담당자 : 이은혜
 * 
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

	// 회사정보 보이는 화면
	@GetMapping("/insa/companyInfo")
	public String companyInfo(Model model) {
		Company companyInfo = insaService.getCompanyInfo();
		System.out.printf("companyInfo----->", companyInfo.toString());
		model.addAttribute("title", "회사 정보");
		model.addAttribute("companyInfo", companyInfo);
		log.info("companyInfo----------------> {}", companyInfo);
		return "insa/company_info";
	}

	// 일반 직원일때 직원 목록
	@GetMapping("/insa/staffInfoList")
	public String getUserList(Model model,
			@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) {
		
		List<Map<Jojic, Object>> jojicInfo = insaService.getJojicInfo();		//가지고 오기
		Map<String, Object> resultMap = insaService.getStaffInfoList(currentPage);

		model.addAttribute("title", "직원 목록");
		model.addAttribute("jojicInfo", jojicInfo);
		model.addAttribute("lastPage", resultMap.get("lastPage"));
		model.addAttribute("staffInfoList", resultMap.get("getStaffInfoList"));
		model.addAttribute("startPageNum", resultMap.get("startPageNum"));
		model.addAttribute("lastPageNum", resultMap.get("lastPageNum"));
		model.addAttribute("currentPage", currentPage);

		log.info("staffInfoList---> {}", resultMap.get("getStaffInfoList"));

		return "insa/staff_list";
	}

	// 관리자 직원일때 직원 목록
	@GetMapping("/insa/adminStaffInfoList")
	public String adminStaffInfoList(Model model,
			@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) {

		/*
		 * Map<String, Object> resultMap = insaService.getStaffInfoList(currentPage);
		 * model.addAttribute("title", "직원 목록"); model.addAttribute("lastPage",
		 * resultMap.get("lastPage")); model.addAttribute("staffInfoList",
		 * resultMap.get("getStaffInfoList")); model.addAttribute("startPageNum",
		 * resultMap.get("startPageNum")); model.addAttribute("lastPageNum",
		 * resultMap.get("lastPageNum")); model.addAttribute("currentPage",
		 * currentPage);
		 * 
		 * log.info("staffInfoList---> {}", resultMap.get("getStaffInfoList"));
		 */
		return "insa/admin_staff_list";
	}

	// 조직도
	@GetMapping("/insa/jojicdo")
	public String jojicdo(Model model) {
		model.addAttribute("title", "조직도");
		return "insa/jojicdo";
	}

	// 팀명 가지고 오기
/*	 @PostMapping("/getTeamName")
	 public List<Map<Jojic, Object>> getBuseoName() { 
		 List<Map<Jojic, Object>> TeamName = insaService.getTeamName();
		 log.info("TeamName---> {}",TeamName);
		 return TeamName; 
	 }
*/	 
}
