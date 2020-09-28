package kr.or.jaegaebal.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import kr.or.jaegaebal.dto.SalaryInfo;
import kr.or.jaegaebal.dto.SalaryRecord;
import kr.or.jaegaebal.dto.StaffInfo;

/**
 * 담당자 : 이요셉
 * @author ECS
 *
 */
@Mapper
public interface SalaryMapper {
	//급상여입력 사원 연월데이터 존재여부 조회
	public SalaryRecord getSelMonthData(String dataNum, String searchDate);
	
	//검색어가 적용된 사원기본정보 조회
	public List<Map<String, Object>> getStaffListMap(String searchCate, String searchText, String searchLevel, String searchJojic);
	
	//직급코드조회
	public List<Map<String, Object>> getLevelList();
	
	//부서코드조회
	public List<Map<String, Object>> getJojicList();
	
	//월별 데이터에 존재하는 연도 조회
	public List<Map<String, Object>> getFilterYear();
	
	//급여정보 수정
	public int updateSalaryInfo(SalaryInfo salaryInfo);
	
	//사원정보 클릭 시 해당 사원 급여정보 조회
	public Map<String, Object> salaryInfoMap(String dataNum);
	
	//화면로딩 시 급여상세정보 1줄 조회
	public SalaryInfo salaryInfo();
	
	//사원기본정보 조회
	public List<Map<StaffInfo,Object>> getSalaryStaffList();
	
	//월별급여현황 조회
	public List<Map<String,Object>> getMonthSalList(String searchYear, String dataNum);
}
