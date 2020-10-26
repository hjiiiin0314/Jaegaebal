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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.jaegaebal.dto.CareerInfoFromIn;
import kr.or.jaegaebal.dto.CareerInfoFromOut;
import kr.or.jaegaebal.dto.CertificateInfo;
import kr.or.jaegaebal.dto.Company;
import kr.or.jaegaebal.dto.EducationInfo;
import kr.or.jaegaebal.dto.Jojic;
import kr.or.jaegaebal.dto.MilitaryInfo;
import kr.or.jaegaebal.dto.Prize;
import kr.or.jaegaebal.dto.Punishment;
import kr.or.jaegaebal.dto.StaffBalryoungInfo;
import kr.or.jaegaebal.dto.StaffBasicInfo;
import kr.or.jaegaebal.dto.StaffFamilyInfo;
import kr.or.jaegaebal.dto.StaffInfo;
import kr.or.jaegaebal.mapper.InsaMapper;
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
	@Autowired
	private InsaMapper insaMapper;
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
		 
		Map<String, Object> resultMap 	= insaService.getStaffInfoAll(currentPage, map);
		List<Jojic> jojicInfo			= insaService.getJojicInfoAll();
		List<Jojic> jojicInfo2 			= insaService.getJojicInfoAll();
		model.addAttribute("lastPage", resultMap.get("lastPage"));
		model.addAttribute("getStaffInfoAllList", resultMap.get("getStaffInfoAllList")); 
		model.addAttribute("startPageNum", resultMap.get("startPageNum"));
		model.addAttribute("lastPageNum", resultMap.get("lastPageNum"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("jojicInfo", jojicInfo);
		model.addAttribute("jojicInfo2", jojicInfo2);
		model.addAttribute("title", "직원 목록");

		log.info("staffInfoList---> {}", resultMap.get("getStaffInfoAllList"));

		return "insa/staff_list";
	}
	
	//직원리스트
	@PostMapping("/insa/staffInfoList")
	public String getStaffList(  Model model
								,@RequestParam(value = "sk", required = false) String sk
								,@RequestParam(value = "sv", required = false) String sv
								,@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) {
		log.info("sksksksksksk::::::{}",sk);
		log.info("svsvsvsvsvsv::::::{}",sv);
		
		Map<String, Object> map 		= new HashMap<String, Object>();
		map.put("sk", sk);
		map.put("sv", sv);
		Map<String, Object> resultMap 	= insaService.getStaffInfoAll(currentPage, map);
		model.addAttribute("lastPage", resultMap.get("lastPage"));
		model.addAttribute("getStaffInfoAllList", resultMap.get("getStaffInfoAllList")); 
		model.addAttribute("startPageNum", resultMap.get("startPageNum"));
		model.addAttribute("lastPageNum", resultMap.get("lastPageNum"));
		model.addAttribute("currentPage", currentPage);			
		model.addAttribute("title", "직원 목록");
		
		return "insa/staff_list";
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
	public String insertStaffDetaillInfo(	Model model,
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
	public String insertStaffDetaillInfo(	  String insertStaffInfo
											, Model model
											, RedirectAttributes redirectAttr
											, StaffBasicInfo staffBasicInfo
											, StaffFamilyInfo staffFamilyInfo
											, CareerInfoFromIn careerInfoFromIn
											, CareerInfoFromOut careerInfoFromOut
											, CertificateInfo certificateInfo
											, EducationInfo educationInfo
											, MilitaryInfo militaryInfo
											, StaffBalryoungInfo staffBalryoungInfo
											, StaffInfo staffInfo	) {
		log.info("staffFamilyInfo>>>>>>>>>{}", staffFamilyInfo);
		
		//int resultBSIF = insaService.insertStaffDetaillInfo(staffBasicInfo);
		

		return "redirect:/insa/staffInfoList";
	}
	
	// 직원 등록 - 추가 입력 사항 -staffBasicInfo
	@PostMapping("/staffBasicInfo")
	public String staffBasicInfo(String[] staffBasicInfo) {
		log.info("staffBasicInfo>>>>>>>>>>>>>>>>>>>>>>>>>>>>>{}", staffBasicInfo.toString());
		return "redirect:/insa/staffInfoList";
	}
	// 직원 등록 - 추가 입력 사항 -staffFamilyInfo
	@PostMapping(value = "/staffFamilyInfo", produces = "application/json")
	@ResponseBody
	public int staffFamilyInfo(@RequestBody List<StaffFamilyInfo> staffFamilyInfo) {
		log.info("familyInfoTableId>>>{}", staffFamilyInfo.toString());
		int resultFMLIF = insaService.insertStaffFamilyInfo(staffFamilyInfo);
		return resultFMLIF;
	}
	// 직원 등록 - 추가 입력 사항 -careerInfoFromIn
	@PostMapping(value = "/careerInfoFromIn", produces = "application/json")
	@ResponseBody
	public int careerInfoFromIn(@RequestBody List<CareerInfoFromIn> careerInfoFromIn) {
		log.info("careerInfoFromIn>>>{}", careerInfoFromIn.toString());
		int resultCINIF = insaService.insertStaffCareerInfoFromIn(careerInfoFromIn);
		return resultCINIF;
	}
	// 직원 등록 - 추가 입력 사항 -careerInfoFromOut
	@PostMapping(value = "/careerInfoFromOut", produces = "application/json")
	@ResponseBody	
	public int careerInfoFromOut(@RequestBody List<CareerInfoFromOut> careerInfoFromOut) {
		log.info("careerInfoFromOut>>>{}", careerInfoFromOut.toString());
		int resultCOUTIF = insaService.insertStaffCareerInfoFromOut(careerInfoFromOut);
		return resultCOUTIF;
	}
	// 직원 등록 - 추가 입력 사항 -certificateInfo
	@PostMapping(value = "/certificateInfo", produces = "application/json")
	@ResponseBody	
	public int certificateInfo(@RequestBody List<CertificateInfo> certificateInfo) {
		log.info("certificateInfo>>>{}", certificateInfo.toString());
		int resultCTIF = insaService.insertStaffCertificateInfo(certificateInfo);
		return resultCTIF;
	}
	// 직원 등록 - 추가 입력 사항 -educationInfo
	@PostMapping(value = "/educationInfo", produces = "application/json")
	@ResponseBody
	public int educationInfo(@RequestBody List<EducationInfo> educationInfo) {
		log.info("careerInfoFromOut>>>{}", educationInfo.toString());
		int resultEDIF = insaService.insertStaffEducationInfo(educationInfo);
		return resultEDIF;
	}
	// 직원 등록 - 추가 입력 사항 -militaryInfo
	@PostMapping(value = "/militaryInfo", produces = "application/json")
	@ResponseBody
	public int militaryInfo(@RequestBody List<MilitaryInfo> militaryInfo) {
		log.info("militaryInfo>>>{}", militaryInfo.toString());
		int resultMLIF = insaService.insertStaffMilitaryInfo(militaryInfo);
		return resultMLIF;
	}
	
	//직원 리스트 - tr 클릭시 직원 정보 가져오기
	@PostMapping(value = "/getStaffInfoAll", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getStaffInfoAllByTr(String staffNum){
		Map<String, Object> info = insaService.getStaffInfoByTr(staffNum);
		log.info("info.toString()>>>>>>>>>>>>>>>{}", info.toString());
		return info;
	}
	
	//직원리스트 - 상세보기 - 수정하기
	@GetMapping("/modifyStaffInfo")
	public String modifyStaffInfo(	 Model model
									,@RequestParam(value = "staffNum", required = false) String staffNum) {
		log.info("staffNum::::::::::::::::>>>>>>>>>{}", staffNum);
		
		Map<String, Object> info = insaService.getStaffInfoByTr(staffNum);
		Map<String, Object> codeAndName = insaService.getCodeAndName();
		model.addAttribute("codeAndName", codeAndName);
		model.addAttribute("list", info);
		model.addAttribute("title", "직원 정보 수정");
		log.info("info::::::::::::::::>>>>>>>>>{}", info.toString());
		return "/insa/modify_insert_staff_detaill_info";
	}
	
	//직원 삭제시 - 일괄 처리
	@PostMapping(value = "/deleteStaffInfoByStaffNum", produces = "application/json")
	@ResponseBody
	public int deleteStaffInfoByStaffNum(@RequestParam(value = "staffNum") String staffNum) {
		int result = insaService.deleteStaffInfo(staffNum);
		return result;
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
		//Map<String, Object> resultMap 	= insaService.getStaffInfoList(currentPage, map);
		Map<String, Object> resultMap 	= insaService.getStaffInfoAll(currentPage, map);
		List<Jojic> jojicInfo			= insaService.getJojicInfoAll();
		List<Jojic> jojicInfo2 			= insaService.getJojicInfoAll();
		model.addAttribute("lastPage", resultMap.get("lastPage"));
		model.addAttribute("getStaffInfoAllList", resultMap.get("getStaffInfoAllList")); 
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
	
	//징계 리스트 - 추가시 / 검색어에 해당되는 직원 info 가지고 오기
	@PostMapping(value = "/getStaffInfo", produces = "application/json")
	@ResponseBody	
	public List<StaffInfo> getStaffInfo(	 @RequestParam(value = "sk", required = false) String sk
											,@RequestParam(value = "sv", required = false) String sv){
		log.info("sk>>>{}", sk);
		log.info("sv>>>{}", sv);
		Map<String, Object> map 		= new HashMap<String, Object>();
		Map<String, Object> map2 		= new HashMap<String, Object>();
		map2.put("sk", sk);
		map2.put("sv", sv);
		map.put("map", map2);
		List<StaffInfo> staffInfo = insaMapper.getStaffInfo(map);
		log.info("staffInfo.toString()::::::::::{}",staffInfo.toString());
		return staffInfo;
	}
	//징계리스트 - 추가 버튼 클릭시
	@PostMapping(value = "/getPnshInfo", produces = "application/json")
	@ResponseBody	
	public List<Punishment> getPnshInfo(@RequestParam(value = "pnshNameSelect", required = false) String pnshNameSelect){
		if(pnshNameSelect == null || pnshNameSelect.equals("")) {
			List<Punishment> pnshInfo = insaMapper.getPnshInfo();
			log.info("pnshInfo.toString()::::::::::{}", pnshInfo.toString());
			return pnshInfo;
		}else if(pnshNameSelect != null && !pnshNameSelect.equals("")){
			List<Punishment> pnshInfo = insaMapper.getPnshInfo(pnshNameSelect);
			return pnshInfo;
		}
		return null;
	}
	
	//징계리스트 추가하기
	@PostMapping("/insa/insertPnshList")
	public String insertPnshList(Punishment insertPnshListInfo) {
		log.info("insertPnshListInfo.toString():::>>>>>>{}", insertPnshListInfo.toString());
		insaService.insertPnshList(insertPnshListInfo);
		return "redirect:/insa/punishment";
	}
	
	//징계리스트 수정하기
	@PostMapping(value = "/modifyPnshListInfo", produces = "application/json")
	@ResponseBody	
	public int modifyPnshListInfo(Punishment modifyPnshListInfo) {
		int result = insaService.modifyPnshListInfo(modifyPnshListInfo);
		return result;
	}
	
	//징계리스트 삭제하기
	@PostMapping(value = "/deletePnshListInfo", produces = "application/json")
	@ResponseBody	
	public int deletePnshListInfo(String punishmentNum) {
		System.out.printf("punishmentNum>>>>>>>>>>>>>{}", punishmentNum);
		int result = insaService.deletePnshListInfo(punishmentNum);
		return result;
	}
	
	// 포상 리스트 화면
	@GetMapping("/insa/prize")
	public String getPrizeList(	 		 Model model
										,@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage
										,@RequestParam Map<String, Object> map) {
		Map<String, Object> resultMap = insaService.getPrizeList(currentPage, map);
		
		log.info(">>>>>>resultMap>>>>>>>{}", resultMap);
		
		model.addAttribute("lastPage", resultMap.get("lastPage"));
		model.addAttribute("prizeList", resultMap.get("prizeList"));
		model.addAttribute("startPageNum", resultMap.get("startPageNum"));
		model.addAttribute("lastPageNum", resultMap.get("lastPageNum"));
		model.addAttribute("currentPage", currentPage);		
		
		model.addAttribute("title", "포상 정보");
		
		return "insa/prize_list";
	}
	
	//포상리스트 - tr 리스트 한 행 클릭시 상세정보 가져오기
	@PostMapping(value = "/getPrizeListInfo", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getPrizeListInfo(		 @RequestParam(value = "prizeNum", required = false) String prizeNum
													,@RequestParam(value = "staffNum", 		required = false) String staffNum
													,@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) {
		
		Map<String, Object> map 		= new HashMap<String, Object>();
		map.put("prizeNum", 		prizeNum);
		map.put("staffNum", 		staffNum);
		log.info("map 1::::::{}", map.get("prizeNum"));
		log.info("map 2::::::{}", map.get("staffNum"));
		
		Map<String, Object> resultMap 	= insaService.getPrizeList(currentPage, map);
		log.info("resultMap::::/getPrizeListInfo:::::{}", resultMap.toString());
		return resultMap;
	}
	
	//포상리스트 - 검색어 서칭시 리스트 새로 출력하기
	@PostMapping("/insa/prize")
	public String searchPrizeList(	 Model model
									,@RequestParam(value = "sk", required = false) String sk
									,@RequestParam(value = "sv", required = false) String sv
									,@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) {
		if(sk == null || sk.equals("")) {
			System.out.println("공백ㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱ");
			return "/insa/prize";
		}
		Map<String, Object> map 		= new HashMap<String, Object>();
		map.put("sk", sk);
		map.put("sv", sv);
		Map<String, Object> resultMap 	= insaService.getPrizeList(currentPage, map);
		model.addAttribute("lastPage", resultMap.get("lastPage"));
		model.addAttribute("prizeList", resultMap.get("prizeList"));
		model.addAttribute("startPageNum", resultMap.get("startPageNum"));
		model.addAttribute("lastPageNum", resultMap.get("lastPageNum"));
		model.addAttribute("currentPage", currentPage);	
		
		model.addAttribute("title", "포상 정보");
		
		return "insa/prize_list";
	}
	
	//포상리스트 - 추가 버튼 클릭시
	@PostMapping(value = "/getPrizeInfo", produces = "application/json")
	@ResponseBody	
	public List<Prize> getPrizeInfo(@RequestParam(value = "prizeNameSelect", required = false) String prizeNameSelect){
		if(prizeNameSelect == null || prizeNameSelect.equals("")) {
			List<Prize> prizeInfo = insaMapper.getPrizeInfo();
			log.info("prizeInfo.toString()::::::::::{}", prizeInfo.toString());
			return prizeInfo;
		}else if(prizeNameSelect != null && !prizeNameSelect.equals("")){
			List<Prize> prizeInfo = insaMapper.getPrizeInfo(prizeNameSelect);
			return prizeInfo;
		}
		return null;
	}
	
	//포상리스트 추가하기
	@PostMapping("/insa/insertPrizeList")
	public String insertPrizeList(Prize insertPrizeListInfo) {
		log.info("insertPrizeListInfo.toString():::>>>>>>{}", insertPrizeListInfo.toString());
		insaService.insertPrizeList(insertPrizeListInfo);
		return "redirect:/insa/prize";
	}
	
	//포상리스트 수정하기
	@PostMapping(value = "/modifyPrizeListInfo", produces = "application/json")
	@ResponseBody	
	public int modifyPrizeListInfo(Prize modifyPrizeListInfo) {
		log.info("modifyPrizeListInfo.toString>>>>>>{}", modifyPrizeListInfo.toString());
		int result = insaService.modifyPrizeListInfo(modifyPrizeListInfo);
		return result;
	}
	
	//포상리스트 삭제하기
	@PostMapping(value = "/deletePrizeListInfo", produces = "application/json")
	@ResponseBody	
	public int deletePrizeListInfo(String prizeNum) {
		System.out.printf("prizeNum>>>>>>>>>>>>>{}", prizeNum);
		int result = insaService.deletePrizeListInfo(prizeNum);
		return result;
	}
	


	
}
