package kr.or.jaegaebal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.jaegaebal.dto.CareerInfoFromIn;
import kr.or.jaegaebal.dto.CareerInfoFromOut;
import kr.or.jaegaebal.dto.CertificateInfo;
import kr.or.jaegaebal.dto.Code;
import kr.or.jaegaebal.dto.Company;
import kr.or.jaegaebal.dto.EducationInfo;
import kr.or.jaegaebal.dto.Jojic;
import kr.or.jaegaebal.dto.MilitaryInfo;
import kr.or.jaegaebal.dto.Prize;
import kr.or.jaegaebal.dto.Punishment;
import kr.or.jaegaebal.dto.StaffBasicInfo;
import kr.or.jaegaebal.dto.StaffFamilyInfo;
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

	// 일반 직원일때 직원 목록 - 조직도
	public Map<String, Object> getStaffInfoList(int currentPage, Map<String, Object> map) {
		final int ROW_PER_PAGE 			= 20; 				// 보여줄 행의 갯수
		int startRow 					= 0;				// 보여줄 행의 시작점 초기화
		int startPageNum 				= 1; 				// 시작페이지번호
		int lastPageNum 				= ROW_PER_PAGE; 	// 끝페이지번호
		// 6번째 가운데 위치
		if (currentPage > (ROW_PER_PAGE / 2)) {
			startPageNum 				= currentPage - ((lastPageNum / 2) - 1);
			lastPageNum 			   += (startPageNum - 1);
		}
		startRow = (currentPage - 1) * ROW_PER_PAGE;		// 페이징 알고리즘
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("startRow", startRow);
		parameterMap.put("rowPerPage", ROW_PER_PAGE);
		parameterMap.put("map", map);
		double totalRowCount = insaMapper.getStaffInfoListCount(map);
		int lastPage = (int) Math.ceil((totalRowCount / ROW_PER_PAGE));
		
		List<StaffInfo> getStaffInfoList = insaMapper.getStaffInfo(parameterMap);

		if (currentPage >= (lastPage-4)) {
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
		final int ROW_PER_PAGE 			= 20; 				// 보여줄 행의 갯수
		int startRow 					= 0;				// 보여줄 행의 시작점 초기화
		int startPageNum 				= 1; 				// 시작페이지번호
		int lastPageNum 				= ROW_PER_PAGE; 	// 끝페이지번호
		// 6번째 가운데 위치
		if (currentPage > (ROW_PER_PAGE / 2)) {
			startPageNum 				= currentPage - ((lastPageNum / 2) - 1);
			lastPageNum 			   += (startPageNum - 1);
		}
		startRow = (currentPage - 1) * ROW_PER_PAGE;		// 페이징 알고리즘
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("startRow", startRow);
		parameterMap.put("rowPerPage", ROW_PER_PAGE);
		parameterMap.put("map", map);
		double totalRowCount = insaMapper.getStaffInfoAllCount(map);
		int lastPage = (int) Math.ceil((totalRowCount / ROW_PER_PAGE));
		
		List<Map<String, Object>> getStaffInfoAllList = insaMapper.getStaffInfoAll(parameterMap);
		
		if (currentPage >= (lastPage-4)) {
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

		final int ROW_PER_PAGE			= 20; 					// 보여줄 행의 갯수
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
	public int insertStaffDetaillInfo(StaffBasicInfo staffBasicInfo) {
		int result = insaMapper.insertStaffBasicInfo(staffBasicInfo);
		return result;
	};
	//직원 등록 - 가족정보 insert
	public int insertStaffFamilyInfo(List<StaffFamilyInfo> staffFamilyInfo) {
		int resultVal = 0;
		for(int i=0; i<staffFamilyInfo.size(); i++) {
			log.info("staffFamilyInfo.get(i):::{}", staffFamilyInfo.get(i));
			StaffFamilyInfo info = staffFamilyInfo.get(i);
			int result = insaMapper.insertStaffFamilyInfo(info);
			if(result != 0) {
				resultVal = 1;
			}
		}
		return resultVal;
	};
	//직원 등록 - 사내 경력 정보 insert
	public int insertStaffCareerInfoFromIn(List<CareerInfoFromIn> careerInfoFromIn) {
		int resultVal = 0;
		for(int i=0; i<careerInfoFromIn.size(); i++) {
			CareerInfoFromIn info = careerInfoFromIn.get(i);
			int result = insaMapper.insertStaffCareerInfoFromIn(info);
			if(result != 0) {
				resultVal = 1;
			}
		}
		return resultVal;
	};
	//직원 등록 - 사외 경력 정보 insert
	public int insertStaffCareerInfoFromOut(List<CareerInfoFromOut> careerInfoFromOut) {
		int resultVal = 0;
		for(int i=0; i<careerInfoFromOut.size(); i++) {
			CareerInfoFromOut info = careerInfoFromOut.get(i);
			int result = insaMapper.insertStaffCareerInfoFromOut(info);
			if(result != 0) {
				resultVal = 1;
			}
		}
		return resultVal;
	};
	//직원 등록 - 자격증 경력 정보 insert
	public int insertStaffCertificateInfo(List<CertificateInfo> certificateInfo) {
		int resultVal = 0;
		for(int i=0; i<certificateInfo.size(); i++) {
			CertificateInfo info = certificateInfo.get(i);
			int result = insaMapper.insertStaffCertificateInfo(info);
			if(result != 0) {
				resultVal = 1;
			}
		}
		return resultVal;
	};
	//직원 등록 - 학력 정보 insert
	public int insertStaffEducationInfo(List<EducationInfo> educationInfo) {
		int resultVal = 0;
		for(int i=0; i<educationInfo.size(); i++) {
			EducationInfo info = educationInfo.get(i);
			int result = insaMapper.insertStaffEducationInfo(info);
			if(result != 0) {
				resultVal = 1;
			}
		}
		return resultVal;
	};
	//직원 등록 - 병역 정보 insert
	public int insertStaffMilitaryInfo(List<MilitaryInfo> militaryInfo) {
		int resultVal = 0;
		for(int i=0; i<militaryInfo.size(); i++) {
			MilitaryInfo info = militaryInfo.get(i);
			int result = insaMapper.insertStaffMilitaryInfo(info);
			if(result != 0) {
				resultVal = 1;
			}
		}
		return resultVal;
	};
	
	//징계 리스트 & 검색조건 & 페이징
	public Map<String, Object> getPunishmentList(int currentPage, Map<String, Object> map) {
		final int ROW_PER_PAGE 			= 10; 				// 보여줄 행의 갯수
		int startRow 					= 0;				// 보여줄 행의 시작점 초기화
		int startPageNum 				= 1; 				// 시작페이지번호
		int lastPageNum 				= ROW_PER_PAGE; 	// 끝페이지번호
		// 6번째 가운데 위치
		if (currentPage > (ROW_PER_PAGE / 2)) {
			startPageNum 				= currentPage - ((lastPageNum / 2) - 1);
			lastPageNum 			   += (startPageNum - 1);
		}
		startRow = (currentPage - 1) * ROW_PER_PAGE;		// 페이징 알고리즘
		double totalRowCount = insaMapper.getPnshListCount(map);
		int lastPage = (int) Math.ceil((totalRowCount / ROW_PER_PAGE));
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("startRow", startRow);
		parameterMap.put("rowPerPage", ROW_PER_PAGE);
		parameterMap.put("map", map);
		
		List<Map<String, Object>> pnshList = insaMapper.getPnshList(parameterMap);
		
		if (currentPage >= (lastPage - 4)) {
			lastPageNum = lastPage;
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("pnshList", pnshList);
		resultMap.put("lastPage", lastPage);
		resultMap.put("startPageNum", startPageNum);
		resultMap.put("lastPageNum", lastPageNum);
		
		return resultMap;
	}	
	
	//징계리스트 - 징계리스트 추가 - 징계명 클릭시  / 징계 정보 가져오기 
	public List<Punishment> getPunhInfo(){
		List<Punishment> pnshInfo = insaMapper.getPnshInfo();
		return pnshInfo;
	};
	//징계리스트 - 추가 버튼 클릭 - 징계명 클릭시 - 점수 삽입하기
	public List<Punishment> getPnshInfo(String pnshNameSelect){
		List<Punishment> pnshInfo = insaMapper.getPnshInfo(pnshNameSelect);
		return pnshInfo;
	};
	//징계리스트 추가하기
	public int insertPnshList(Punishment insertPnshListInfo) {
		int result = insaMapper.insertPnshList(insertPnshListInfo);
		return result;
	};
	//징계리스트 수정하기
	public int modifyPnshListInfo(Punishment modifyPnshListInfo) {
		int result = insaMapper.modifyPnshListInfo(modifyPnshListInfo);
		return result;
	};	
	//징계리스트 삭제하기
	public int deletePnshListInfo(String punishmentNum) {
		int result = insaMapper.deletePnshListInfo(punishmentNum);
		return result;
	};
	
	
	//포상 리스트 & 검색조건 & 페이징
	public Map<String, Object> getPrizeList(int currentPage, Map<String, Object> map) {
		final int ROW_PER_PAGE 			= 10; 				// 보여줄 행의 갯수
		int startRow 					= 0;				// 보여줄 행의 시작점 초기화
		int startPageNum 				= 1; 				// 시작페이지번호
		int lastPageNum 				= ROW_PER_PAGE; 	// 끝페이지번호
		// 6번째 가운데 위치
		if (currentPage > (ROW_PER_PAGE / 2)) {
			startPageNum 				= currentPage - ((lastPageNum / 2) - 1);
			lastPageNum 			   += (startPageNum - 1);
		}
		startRow = (currentPage - 1) * ROW_PER_PAGE;		// 페이징 알고리즘
		double totalRowCount = insaMapper.getPrizeListCount(map);
		int lastPage = (int) Math.ceil((totalRowCount / ROW_PER_PAGE));
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("startRow", startRow);
		parameterMap.put("rowPerPage", ROW_PER_PAGE);
		parameterMap.put("map", map);
		
		List<Map<String, Object>> prizeList = insaMapper.getPrizeList(parameterMap);
		
		if (currentPage >= (lastPage - 4)) {
			lastPageNum = lastPage;
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("prizeList", prizeList);
		resultMap.put("lastPage", lastPage);
		resultMap.put("startPageNum", startPageNum);
		resultMap.put("lastPageNum", lastPageNum);
		
		return resultMap;
	}	
	
	//포상리스트 - 포상리스트 추가 - 포상명 클릭시  / 징계 정보 가져오기 
	public List<Prize> getPrizeInfo(){
		List<Prize> prizeInfo = insaMapper.getPrizeInfo();
		return prizeInfo;
	};
	//포상리스트 - 추가 버튼 클릭 - 포상명 클릭시 - 점수 삽입하기
	public List<Prize> getPrizeInfo(String prizeNameSelect){
		List<Prize> prizeInfo = insaMapper.getPrizeInfo(prizeNameSelect);
		return prizeInfo;
	};
	//포상리스트 추가하기
	public int insertPrizeList(Prize insertPrizeListInfo) {
		int result = insaMapper.insertPrizeList(insertPrizeListInfo);
		return result;
	};
	//포상리스트 수정하기
	public int modifyPrizeListInfo(Prize modifyPrizeListInfo) {
		int result = insaMapper.modifyPrizeListInfo(modifyPrizeListInfo);
		return result;
	};	
	//포상리스트 삭제하기
	public int deletePrizeListInfo(String prizeNum) {
		int result = insaMapper.deletePrizeInfo(prizeNum);
		return result;
	};
}
