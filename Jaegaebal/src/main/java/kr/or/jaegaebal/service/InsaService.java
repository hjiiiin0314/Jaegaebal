package kr.or.jaegaebal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.jaegaebal.dto.Company;
import kr.or.jaegaebal.dto.Jojic;
import kr.or.jaegaebal.dto.StaffInfo;
import kr.or.jaegaebal.mapper.InsaMapper;


/**
 * 담당자 : 이은혜
 * @author ECS
 *
 */
@Service
@Transactional
public class InsaService {
	
	@Autowired
	private InsaMapper insaMapper;
	
	
	private static final Logger log = LoggerFactory.getLogger(InsaService.class);

	
	//회사 정보 목록
	public Company getCompanyInfo(){
		Company companyList = insaMapper.getCompanyInfo();
		System.out.printf("companyInfo.service.java----->", companyList.toString());
		return companyList;
	}
	
	//일반 직원일때 직원 목록
	public Map<String, Object> getStaffInfoList(int currentPage){
		
		final int ROW_PER_PAGE = 15;		//보여줄 행의 갯수
		int startRow = 0;					//보여줄 행의 시작점 초기화	
		int startPageNum = 1;				//시작페이지번호
		int lastPageNum = ROW_PER_PAGE;		//끝페이지번호
		
		//6번째 가운데 위치
		if(currentPage > (ROW_PER_PAGE/2)) {
			startPageNum = currentPage - ((lastPageNum/2)-1);
			lastPageNum += (startPageNum-1); 
		}
		// 페이징 알고리즘
		startRow = (currentPage - 1) * ROW_PER_PAGE; 
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("startRow", startRow);
		parameterMap.put("rowPerPage", ROW_PER_PAGE);
		
		double totalRowCount = insaMapper.getStaffInfoListCount();
		
		int lastPage = (int) Math.ceil((totalRowCount / ROW_PER_PAGE));
		
		List<Map<String, Object>> getStaffInfoList = insaMapper.getStaffInfo(parameterMap);
		
		log.info("service getStaffInfoList ::::::::::::: {}", getStaffInfoList);
		
		if(currentPage >= (lastPage-4)) {
			lastPageNum = lastPage;
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("getStaffInfoList", getStaffInfoList);
		resultMap.put("lastPage", lastPage);
		resultMap.put("startPageNum", startPageNum);
		resultMap.put("lastPageNum", lastPageNum);
		
		return resultMap;
	}	
	
	//부서명 가지고 오기
	public List<Map<Jojic, Object>> getJojicInfo() {
		List<Map<Jojic, Object>> getJojicInfo = insaMapper.getJojicInfo();

		log.info("getJojicInfo---> {}",getJojicInfo);
		return getJojicInfo;
	};
	
	//팀명 가지고 오기
	 public List<Jojic> getTeamName(String buseoName) { 
		 
		 List<Jojic> getTeamName = insaMapper.getTeamName(buseoName);
		 
		 return getTeamName;
	 		
	};
	
	//부서별 직원 목록 리스트 가져오기
	public List<StaffInfo> getStaffInfoByParentJojicName(String parentJojicName){
	
		List<StaffInfo> getStaffInfoByParentJojicName = insaMapper.getStaffInfoByParentJojicName(parentJojicName);
		
		return getStaffInfoByParentJojicName;
	};
	
	/*
	 * //페이징 하기 public Map<String, Object> getStaffInfoList(int currentPage){ final
	 * int ROW_PER_PAGE = 15; //보여줄 행의 갯수 int startRow = 0; //보여줄 행의 시작점 초기화 int
	 * startPageNum = 1; //시작페이지번호 int lastPageNum = ROW_PER_PAGE; //끝페이지번호
	 * 
	 * //6번째 가운데 위치 if(currentPage > (ROW_PER_PAGE/2)) { startPageNum = currentPage
	 * - ((lastPageNum/2)-1); lastPageNum += (startPageNum-1); } // 페이징 알고리즘
	 * startRow = (currentPage - 1) * ROW_PER_PAGE;
	 * 
	 * Map<String, Object> parameterMap = new HashMap<String, Object>();
	 * parameterMap.put("startRow", startRow); parameterMap.put("rowPerPage",
	 * ROW_PER_PAGE);
	 * 
	 * double totalRowCount = insaMapper.getStaffInfoListCount();
	 * 
	 * int lastPage = (int) Math.ceil((totalRowCount / ROW_PER_PAGE)); }
	 */
}
