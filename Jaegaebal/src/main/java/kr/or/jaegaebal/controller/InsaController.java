package kr.or.jaegaebal.controller;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String getStaffList(Model model,
			@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage,
			@RequestParam Map<String, Object> map) {
		log.info("map>>>>>>>>>>>> - {}", map);

		List<Map<Jojic, Object>> jojicInfo = insaService.getJojicInfo(); // 가지고 오기
		Map<String, Object> resultMap = insaService.getStaffInfoList(currentPage, map);

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

	/*
	 * //검색 조건시 전체 화면
	 * 
	 * @PostMapping("/insa/staffInfoList") public String getStaffListBySearching(
	 * Model model, ,@RequestParam(value = "currentPage", required = false,
	 * defaultValue = "1") int currentPage ,) {
	 * 
	 * return null; }
	 */

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

	// 직원 등록하기 화면
	@GetMapping("/insa/insertStaff")
	public String insertStaff(	 Model model) {
		Map<String, Object> codeAndName = insaService.getCodeAndName();
		String staffNum = insaService.makeStaffNum();

		model.addAttribute("title", "직원 등록");
		model.addAttribute("codeAndName", codeAndName);
		model.addAttribute("staffNum", staffNum);

		return "insa/insert_staff";
	}
	

	// 부서별 직원 목록 리스트 가져오기, 팀명가지고 오기
	@PostMapping(value = "/getStaffInfoByParentJojicName", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getStaffInfoByParentJojicName(Model model,
			@RequestParam(value = "buseoName") String buseoName,
			@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) {

		Map<String, Object> data = new HashMap<String, Object>();

		List<Jojic> jojicTeamName = insaService.getTeamName(buseoName);
		Map<String, Object> staffInfoByParentJojicName = insaService.getStaffInfoByParentJojicName(buseoName,
				currentPage);

		data.put("jojicTeamName", jojicTeamName);
		data.put("staffInfoByParentJojicName", staffInfoByParentJojicName);

		log.info("data---> {}", data);

		return data;

	}

	// 팀별 직원 목록 리스트 가져오기
	@PostMapping(value = "/getStaffInfoByTeamName", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getStaffInfoListByTeamName(	Model model,
															@RequestParam(value = "teamName") String teamName,
															@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) {

		Map<String, Object> data = new HashMap<String, Object>();

		Map<String, Object> staffInfoByteamName = insaService.getStaffInfoByTeamName(teamName, currentPage);

		data.put("staffInfoByteamName", staffInfoByteamName);

		log.info("data---> {}", data);

		return data;

	}
	
	 //조직도 화면
	 @GetMapping("/insa/jojicdo") 
	 public String jojicdo(Model model) {
		 List<Jojic> jojicInfo = insaService.getJojicInfoAll();
		 List<Jojic> jojicInfo2 = insaService.getJojicInfoAll();
		 
		 model.addAttribute("title", "조직도");
		 model.addAttribute("jojicInfo", jojicInfo);
		 model.addAttribute("jojicInfo2", jojicInfo2);
		 log.info("jojicInfo>>>>>>>> {}",jojicInfo);
		 log.info("jojicInfo2>>>>>>>> {}",jojicInfo2);
	 
	 	return "insa/jojicdo"; 
	 }
	 
	 //조직 비활성 상태 바꾸기
	 @PostMapping(value = "/changeJojicStatusTo0", produces = "application/json")
	 @ResponseBody
	 public int changeJojicStatus0(	 Model model
			 								,@RequestParam(value = "jojicName[]") 	List<String> jojicName) {
		 int result = insaService.changeJojicStatus0(jojicName);
		 log.info("jojicName:::: {}", jojicName.toString());
		 log.info("result::::::>> {}", result);
		 return result;
		 
	 }
	 
	 //조직 활성 상태 바꾸기
	 @PostMapping(value = "/changeJojicStatusTo1", produces = "application/json")
	 @ResponseBody
	 public int changeJojicStatus1(	 Model model
			 								,@RequestParam(value = "jojicName[]") 	List<String> jojicName) {
		 int result = insaService.changeJojicStatus1(jojicName);
		 log.info("jojicName:::: {}", jojicName.toString());
		 log.info("result::::::>> {}", result);
		 return result;
		 
	 }

}
