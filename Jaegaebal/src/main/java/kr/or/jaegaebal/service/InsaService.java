package kr.or.jaegaebal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.jaegaebal.dto.Code;
import kr.or.jaegaebal.dto.Company;
import kr.or.jaegaebal.dto.Jojic;
import kr.or.jaegaebal.dto.StaffInfo;
import kr.or.jaegaebal.mapper.InsaMapper;

/**
 * 담당자 : 이은혜
 * 
 * @author ECS
 *
 */
@Service
@Transactional
public class InsaService {

	@Autowired
	private InsaMapper insaMapper;

	private static final Logger log = LoggerFactory.getLogger(InsaService.class);

	// 회사 정보 목록
	public Company getCompanyInfo() {
		Company companyList = insaMapper.getCompanyInfo();
		System.out.printf("companyInfo.service.java----->", companyList.toString());
		return companyList;
	}

	// 일반 직원일때 직원 목록
	public Map<String, Object> getStaffInfoList(int currentPage, Map<String, Object> map) {
		final int ROW_PER_PAGE 			= 15; 				// 보여줄 행의 갯수
		int startRow 					= 0;				// 보여줄 행의 시작점 초기화
		int startPageNum 				= 1; 				// 시작페이지번호
		int lastPageNum 				= ROW_PER_PAGE; 	// 끝페이지번호
		// 6번째 가운데 위치
		if (currentPage > (ROW_PER_PAGE / 2)) {
			startPageNum 				= currentPage - ((lastPageNum / 2) - 1);
			lastPageNum 			   += (startPageNum - 1);
		}
		startRow = (currentPage - 1) * ROW_PER_PAGE;		// 페이징 알고리즘
		double totalRowCount = insaMapper.getStaffInfoListCount(map);
		int lastPage = (int) Math.ceil((totalRowCount / ROW_PER_PAGE));
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("startRow", startRow);
		parameterMap.put("rowPerPage", ROW_PER_PAGE);
		parameterMap.put("map", map);
		
		List<Map<String, Object>> getStaffInfoList = insaMapper.getStaffInfo(parameterMap);

		if (currentPage >= (lastPage - 4)) {
			lastPageNum = lastPage;
		}

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("getStaffInfoList", getStaffInfoList);
		resultMap.put("lastPage", lastPage);
		resultMap.put("startPageNum", startPageNum);
		resultMap.put("lastPageNum", lastPageNum);

		return resultMap;
	}
	//직원 리스트 & 검색조건 & 페이징
	public Map<String, Object> getStaffInfoAll(int currentPage, Map<String, Object> map) {
		final int ROW_PER_PAGE 			= 15; 				// 보여줄 행의 갯수
		int startRow 					= 0;				// 보여줄 행의 시작점 초기화
		int startPageNum 				= 1; 				// 시작페이지번호
		int lastPageNum 				= ROW_PER_PAGE; 	// 끝페이지번호
		// 6번째 가운데 위치
		if (currentPage > (ROW_PER_PAGE / 2)) {
			startPageNum 				= currentPage - ((lastPageNum / 2) - 1);
			lastPageNum 			   += (startPageNum - 1);
		}
		startRow = (currentPage - 1) * ROW_PER_PAGE;		// 페이징 알고리즘
		double totalRowCount = insaMapper.getStaffInfoAllCount(map);
		int lastPage = (int) Math.ceil((totalRowCount / ROW_PER_PAGE));
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("startRow", startRow);
		parameterMap.put("rowPerPage", ROW_PER_PAGE);
		parameterMap.put("map", map);
		
		List<Map<String, Object>> getStaffInfoAllList = insaMapper.getStaffInfoAll(parameterMap);
		
		if (currentPage >= (lastPage - 4)) {
			lastPageNum = lastPage;
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("getStaffInfoAllList", getStaffInfoAllList);
		resultMap.put("lastPage", lastPage);
		resultMap.put("startPageNum", startPageNum);
		resultMap.put("lastPageNum", lastPageNum);
		
		return resultMap;
	}

	// 부서명 가지고 오기
	public List<Map<Jojic, Object>> getJojicInfo() {
		List<Map<Jojic, Object>> getJojicInfo = insaMapper.getJojicInfo();

		return getJojicInfo;
	};

	// 팀명 가지고 오기
	public List<Jojic> getTeamName(String buseoName) {

		List<Jojic> getTeamName = insaMapper.getTeamName(buseoName);

		return getTeamName;

	};

	// 부서별 직원 목록 리스트 가져오기
	public Map<String, Object> getStaffInfoByParentJojicName(String buseoName, int currentPage) {

		final int ROW_PER_PAGE			= 15; 					// 보여줄 행의 갯수
		int startRow					= 0;					// 보여줄 행의 시작점 초기화
		int startPageNum 				= 1; 					// 시작페이지번호
		int lastPageNum 				= ROW_PER_PAGE;			// 끝페이지번호
		// 6번째 가운데 위치
		if (currentPage > (ROW_PER_PAGE / 2)) {
			startPageNum 				= currentPage - ((lastPageNum / 2) - 1);
			lastPageNum 	   		   += (startPageNum - 1);
		}
		startRow 						= (currentPage - 1) * ROW_PER_PAGE;	// 페이징 알고리즘
		double totalRowCount 			= insaMapper.getStaffInfoListCountByBuseoName(buseoName);
		int lastPage 					= (int) Math.ceil((totalRowCount / ROW_PER_PAGE));			
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("startRow", startRow);
		parameterMap.put("rowPerPage", ROW_PER_PAGE); 
		parameterMap.put("buseoName", buseoName);
		
		List<Map<String, Object>> getStaffInfoListByParentJojicName = insaMapper.getStaffInfoByParentJojicName(parameterMap);

		if (currentPage >= (lastPage - 4)) {
			lastPageNum = lastPage;
		}

		Map<String, Object> resultMap 	= new HashMap<String, Object>();
		resultMap.put("getStaffInfoList", getStaffInfoListByParentJojicName);
		resultMap.put("lastPage", lastPage);
		resultMap.put("startPageNum", startPageNum);
		resultMap.put("lastPageNum", lastPageNum);
		log.info("resultMap::::::::::::{}", resultMap);
		return resultMap;
	};
	
	// 팀별 직원 목록 리스트 가져오기
	public Map<String, Object> getStaffInfoByTeamName(String teamName, int currentPage) {
		
		final int ROW_PER_PAGE			= 15; 					// 보여줄 행의 갯수
		int startRow					= 0;					// 보여줄 행의 시작점 초기화
		int startPageNum 				= 1; 					// 시작페이지번호
		int lastPageNum 				= ROW_PER_PAGE;			// 끝페이지번호
		// 6번째 가운데 위치
		if (currentPage > (ROW_PER_PAGE / 2)) {
			startPageNum 				= currentPage - ((lastPageNum / 2) - 1);
			lastPageNum 	   		   += (startPageNum - 1);
		}
		startRow 						= (currentPage - 1) * ROW_PER_PAGE;	// 페이징 알고리즘
		double totalRowCount 			= insaMapper.getStaffInfoListCountByTeamName(teamName);
		int lastPage 					= (int) Math.ceil((totalRowCount / ROW_PER_PAGE));			
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("startRow", startRow);
		parameterMap.put("rowPerPage", ROW_PER_PAGE); 
		parameterMap.put("teamName", teamName);
		
		List<Map<String, Object>> getStaffInfoByTeamName = insaMapper.getStaffInfoByTeamName(parameterMap);
		
		if (currentPage >= (lastPage - 4)) {
			lastPageNum = lastPage;
		}
		
		Map<String, Object> resultMap 	= new HashMap<String, Object>();
		resultMap.put("getStaffInfoList", getStaffInfoByTeamName);
		resultMap.put("lastPage", lastPage);
		resultMap.put("startPageNum", startPageNum);
		resultMap.put("lastPageNum", lastPageNum);
		log.info("resultMap::::::::::::{}", resultMap);
		return resultMap;
	};
	
	//조직테이블 인포 다 가져오기
	public List<Jojic> getJojicInfoAll(){
		List<Jojic> getJojicInfoAll = insaMapper.getJojicInfoAll();
		return getJojicInfoAll;
	};
	
	//조직도 - 부서 추가 생성하기
	public int insertBuseoName(String insertBuseoName) {
		int result = insaMapper.insertBuseoName(insertBuseoName);
		return result;
	};	
	//조직도 - 팀 추가 생성하기
	public int insertTeamName(String modalSosocVal, String insertTeamName) {
		int result = insaMapper.insertTeamName(modalSosocVal, insertTeamName);
		return result;
	};	
	
	//직원 등록시 권한,직책,직급,소속 코드와 명 가져오기
	public Map<String, Object> getCodeAndName(){
		Map<String, Object> codeAndName	= new HashMap<String, Object>();
		
		List<Code> accessInfo 					= insaMapper.getAccessInfo();
		List<Code> jojicInfo 					= insaMapper.getJojicInfo1();
		List<Code> levelInfo 					= insaMapper.getLevelInfo();
		List<Code> positionInfo 				= insaMapper.getPositionInfo();
		
		codeAndName.put("accessInfo", accessInfo);
		codeAndName.put("jojicInfo", jojicInfo);
		codeAndName.put("levelInfo", levelInfo);
		codeAndName.put("positionInfo", positionInfo);
		
		return codeAndName;
	}
	
	//사번 생성 후 가져오기
	/*
	 * public String makeStaffNum() { String staffNum = insaMapper.makeStaffNum();
	 * 
	 * return staffNum; };
	 */
	
	//활성상태로 수정하기
	public int changeJojicStatus1(List<String> jojicName){
		int result = insaMapper.changeJojicStatus1(jojicName);
		return result;
	};
	//비활성 상태로 수정하기
	public int changeJojicStatus0(List<String> jojicName){
		int result = insaMapper.changeJojicStatus0(jojicName);
		return result;
	};
	
	//회원가입(필수 정보 입력)
	public String insertToIsStaffInfo(StaffInfo staffInfo) {
		//새로운 직원코드 생성 후 직원등록
		insaMapper.insertToIsStaffInfo(staffInfo);
		
		// 등록된 사원번호 리턴
		String staffNum = staffInfo.getStaffNum();
		insaMapper.insertStaffSalaryInfo(staffInfo);
		log.info("staffInfo staffNum :::: {}", staffNum);
		
		return staffNum;
	};
	//회원가입 이후 생성된 사번 가지고 오기
	public String getStaffNum(StaffInfo staffInfo) {
		String staffNum = insaMapper.getStaffNum(staffInfo);
		return staffNum;
	};	
	
	//추가 정보 입력시 정보가져오기
	public StaffInfo getInsertStaffInfo(String staffNum){
		StaffInfo list = insaMapper.getInsertStaffInfo(staffNum);
		log.info("list.service:::::::::::::::::::::::::::::::::::::::{}", list);
		return list;
	};
	
	//직원 등록 - 인적사항 insert
	public int insertStaffDetaillInfo(StaffInfo staffInfo) {
		int result = insaMapper.insertStaffBasicInfo(staffInfo);
		return result;
	};
	//직원 등록 - 가족정보 insert
	public int insertStaffFamilyInfo(StaffInfo staffInfo) {
		int result = insaMapper.insertStaffFamilyInfo(staffInfo);
		return result;
	};
	//직원 등록 - 사내 경력 정보 insert
	public int insertStaffCareerInfoFromIn(StaffInfo staffInfo) {
		int result = insaMapper.insertStaffCareerInfoFromIn(staffInfo);
		return result;
	};
	//직원 등록 - 사외 경력 정보 insert
	public int insertStaffCareerInfoFromOut(StaffInfo staffInfo) {
		int result = insaMapper.insertStaffCareerInfoFromOut(staffInfo);
		return result;
	};
	//직원 등록 - 자격증 경력 정보 insert
	public int insertStaffCertificateInfo(StaffInfo staffInfo) {
		int result = insaMapper.insertStaffCertificateInfo(staffInfo);
		return result;
	};
	//직원 등록 - 학력 정보 insert
	public int insertStaffEducationInfo(StaffInfo staffInfo) {
		int result = insaMapper.insertStaffEducationInfo(staffInfo);
		return result;
	};
	//직원 등록 - 병역 정보 insert
	public int insertStaffMilitaryInfo(StaffInfo staffInfo) {
		int result = insaMapper.insertStaffMilitaryInfo(staffInfo);
		return result;
	};
	
}
