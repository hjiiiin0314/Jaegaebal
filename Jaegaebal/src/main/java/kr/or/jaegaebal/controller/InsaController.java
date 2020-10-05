package kr.or.jaegaebal.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import kr.or.jaegaebal.dto.Company;
import kr.or.jaegaebal.dto.Jojic;
import kr.or.jaegaebal.dto.StaffInfo;
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

	// 직원 리스트
	@GetMapping("/insa/staffInfoList")
	public String getStaffList(Model model,
			@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage,
			@RequestParam Map<String, Object> map) {
		
		 log.info("map>>>>>>>>>>>> - {}", map);
		 
		 Map<String, Object> resultMap = insaService.getStaffInfoAll(currentPage, map);
		 
		 model.addAttribute("lastPage", resultMap.get("lastPage")); 
		 model.addAttribute("getStaffInfoAllList", resultMap.get("getStaffInfoAllList")); 
		 model.addAttribute("startPageNum", resultMap.get("startPageNum")); 
		 model.addAttribute("lastPageNum", resultMap.get("lastPageNum")); 
		 model.addAttribute("currentPage", currentPage);
		 model.addAttribute("title", "직원 목록");

		log.info("staffInfoList---> {}", resultMap.get("getStaffInfoAllList"));

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
	public String insertStaff(Model model) {

		// String staffNum = insaService.makeStaffNum();
		Map<String, Object> codeAndName = insaService.getCodeAndName();
		model.addAttribute("codeAndName", codeAndName);
		model.addAttribute("title", "직원 등록");
		// model.addAttribute("staffNum", staffNum);

		return "insa/insert_staff";
	}

	// 직원 등록 - 필수 입력 사항
	@PostMapping("/insertStaffInfoAll")
	public String insertStaffInfoAll(StaffInfo insertStaffInfo, Model model, RedirectAttributes redirectAttr) {
		// String staffNum = insaService.makeStaffNum();
		// model.addAttribute("staffNum", staffNum);
		Map<String, Object> codeAndName = insaService.getCodeAndName();
		model.addAttribute("codeAndName", codeAndName);
		log.info("insertStaffInfo >>>>>>>>>> {}", insertStaffInfo, "<<<<<<<<<<");
		String staffNum = insaService.insertToIsStaffInfo(insertStaffInfo);
		if (staffNum != null && !"".equals(staffNum)) {
			redirectAttr.addAttribute("staffNum", staffNum);
		}
		return "redirect:/insertStaffDetaillInfo";
	}

	// 직원 등록 - 추가 입력 사항
	@GetMapping("/insertStaffDetaillInfo")
	public String insertStaffDetaillInfo(Model model,
			@RequestParam(value = "staffNum", required = false) String staffNum) {
		StaffInfo list = insaService.getInsertStaffInfo(staffNum);
		Map<String, Object> codeAndName = insaService.getCodeAndName();
		model.addAttribute("codeAndName", codeAndName);
		model.addAttribute("title", "추가 입력 사항");
		model.addAttribute("list", list);
		model.addAttribute("staffNum", staffNum);
		log.info("list:::::::::{}", list.toString());
		return "insa/insert_staff_detaill_info";
	}

	// 직원 등록 - 추가 입력 사항
	@PostMapping("/insertStaffDetaillInfo")
	public String insertStaffDetaillInfo(StaffInfo insertStaffInfo, Model model, RedirectAttributes redirectAttr) {
		log.info("insertStaffInfo>>>>>>>>>{}", insertStaffInfo);
		int resultBSIF = insaService.insertStaffDetaillInfo(insertStaffInfo);
		int resultFMLIF = insaService.insertStaffFamilyInfo(insertStaffInfo);
		int resultCINIF = insaService.insertStaffCareerInfoFromIn(insertStaffInfo);
		int resultCOUTIF = insaService.insertStaffCareerInfoFromOut(insertStaffInfo);
		int resultCTIF = insaService.insertStaffCertificateInfo(insertStaffInfo);
		int resultEDIF = insaService.insertStaffEducationInfo(insertStaffInfo);
		int resultMLIF = insaService.insertStaffMilitaryInfo(insertStaffInfo);

		log.info("resultBSIF:::::{}", resultBSIF, "<<<<<<<<<<<<");
		log.info("resultFMLIF:::::{}", resultFMLIF, "<<<<<<<<<<<<");
		log.info("resultCINIF:::::{}", resultCINIF, "<<<<<<<<<<<<");
		log.info("resultCOUTIF:::::{}", resultCOUTIF, "<<<<<<<<<<<<");
		log.info("resultCTIF:::::{}", resultCTIF, "<<<<<<<<<<<<");
		log.info("resultEDIF:::::{}", resultEDIF, "<<<<<<<<<<<<");
		log.info("resultMLIF:::::{}", resultMLIF, "<<<<<<<<<<<<");
		return "redirect:/";

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

	// 조직도 화면
	@GetMapping("/insa/jojicdo")
	public String jojicdo(Model model) {
		List<Jojic> jojicInfo = insaService.getJojicInfoAll();
		List<Jojic> jojicInfo2 = insaService.getJojicInfoAll();

		model.addAttribute("title", "조직도");
		model.addAttribute("jojicInfo", jojicInfo);
		model.addAttribute("jojicInfo2", jojicInfo2);
		log.info("jojicInfo>>>>>>>> {}", jojicInfo);
		log.info("jojicInfo2>>>>>>>> {}", jojicInfo2);

		return "insa/jojicdo";
	}

	// 조직 비활성 상태 바꾸기
	@PostMapping(value = "/changeJojicStatusTo0", produces = "application/json")
	@ResponseBody
	public int changeJojicStatus0(Model model, @RequestParam(value = "jojicName[]") List<String> jojicName) {
		int result = insaService.changeJojicStatus0(jojicName);
		log.info("jojicName:::: {}", jojicName.toString());
		log.info("result::::::>> {}", result);
		return result;

	}

	// 조직 활성 상태 바꾸기
	@PostMapping(value = "/changeJojicStatusTo1", produces = "application/json")
	@ResponseBody
	public int changeJojicStatus1(Model model, @RequestParam(value = "jojicName[]") List<String> jojicName) {
		int result = insaService.changeJojicStatus1(jojicName);
		log.info("jojicName:::: {}", jojicName.toString());
		log.info("result::::::>> {}", result);
		return result;

	}

	// 조직도 - 부서 추가 생성하기
	@PostMapping(value = "/insertBuseo", produces = "application/json")
	@ResponseBody
	public int insertBuseo(@RequestParam(value = "insertBuseoName", required = false) String insertBuseoName) {
		log.info("insertBuseoName>>>>>>>>>> {}", insertBuseoName);
		int result = insaService.insertBuseoName(insertBuseoName);
		return result;
	}

	// 조직도 - 팀 추가 생성하기
	@PostMapping(value = "/insertTeam", produces = "application/json")
	@ResponseBody
	public int insertTeam(	@RequestParam(value = "modalSosocVal", required = false) String modalSosocVal,
							@RequestParam(value = "insertTeamName", required = false) String insertTeamName) {
		int result = insaService.insertTeamName(modalSosocVal, insertTeamName);
		log.info("modalSosocVal>>>>>>>>>> {}", modalSosocVal);
		log.info("insertTeamName>>>>>>>>>> {}", insertTeamName);

		return result;
	}

	// 조직도 리스트 화면
	@GetMapping("/insa/jojicdoList")
	public String getJojicdoList(	Model model,
									@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage,
									@RequestParam Map<String, Object> map) {
		Map<String, Object> resultMap = insaService.getStaffInfoList(currentPage, map);
		List<Jojic> jojicInfo = insaService.getJojicInfoAll();
		List<Jojic> jojicInfo2 = insaService.getJojicInfoAll();
		model.addAttribute("lastPage", resultMap.get("lastPage"));
		model.addAttribute("staffInfoList", resultMap.get("getStaffInfoList"));
		model.addAttribute("startPageNum", resultMap.get("startPageNum"));
		model.addAttribute("lastPageNum", resultMap.get("lastPageNum"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("jojicInfo", jojicInfo);
		model.addAttribute("jojicInfo2", jojicInfo2);
		model.addAttribute("title", "조직도 리스트");
		return "insa/jojicdo_list";
	}

	// 징계 리스트 화면
	@GetMapping("/insa/punishment")
	public String getPunishmentList(	 Model model
										,@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage
										,@RequestParam Map<String, Object> map) {
		Map<String, Object> resultMap = insaService.getPunishmentList(currentPage, map);
		
		log.info(">>>>>>resultMap>>>>>>>{}", resultMap);
		
		model.addAttribute("lastPage", resultMap.get("lastPage"));
		model.addAttribute("pnshList", resultMap.get("pnshList"));
		model.addAttribute("startPageNum", resultMap.get("startPageNum"));
		model.addAttribute("lastPageNum", resultMap.get("lastPageNum"));
		model.addAttribute("currentPage", currentPage);		
		
		model.addAttribute("title", "징계 정보");
		
		return "insa/punishment_list";
	}
	
	//징계리스트 - tr 리스트 한 행 클릭시 상세정보 가져오기
	@PostMapping(value = "/getPnshListInfo", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getPnshListInfo(		 @RequestParam(value = "punishmentNum", required = false) String punishmentNum
													,@RequestParam(value = "staffNum", 		required = false) String staffNum
													,@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) {
		
		Map<String, Object> map 		= new HashMap<String, Object>();
		map.put("punishmentNum", 	punishmentNum);
		map.put("staffNum", 		staffNum);
		log.info("map 1::::::{}", map.get("punishmentNum"));
		log.info("map 2::::::{}", map.get("staffNum"));
		
		Map<String, Object> resultMap 	= insaService.getPunishmentList(currentPage, map);
		log.info("resultMap::::/getPnshListInfo:::::{}", resultMap.toString());
		return resultMap;
	}
	
	//징계리스트 - 검색어 서칭시 리스트 새로 출력하기
	@PostMapping("/insa/punishment")
	public String searchPnshList(	 Model model
									,@RequestParam(value = "sk", required = false) String sk
									,@RequestParam(value = "sv", required = false) String sv
									,@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) {
		if(sk == null || sk.equals("")) {
			System.out.println("공백ㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱ");
			return "/insa/punishment";
		}
		Map<String, Object> map 		= new HashMap<String, Object>();
		map.put("sk", sk);
		map.put("sv", sv);
		Map<String, Object> resultMap 	= insaService.getPunishmentList(currentPage, map);
		model.addAttribute("lastPage", resultMap.get("lastPage"));
		model.addAttribute("pnshList", resultMap.get("pnshList"));
		model.addAttribute("startPageNum", resultMap.get("startPageNum"));
		model.addAttribute("lastPageNum", resultMap.get("lastPageNum"));
		model.addAttribute("currentPage", currentPage);	
		
		model.addAttribute("title", "징계 정보");
		
		return "insa/punishment_list";
	}
}
