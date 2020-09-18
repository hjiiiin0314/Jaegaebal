package kr.or.jaegaebal.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import kr.or.jaegaebal.dto.SalaryInfo;
import kr.or.jaegaebal.dto.StaffInfo;

/**
 * 담당자 : 이요셉
 * @author ECS
 *
 */
@Mapper
public interface SalaryMapper {
	//급여정보 수정
	public int updateSalaryInfo(SalaryInfo salaryInfo);
	
	//사원정보 클릭 시 해당 사원 급여정보 조회
	public Map<String, Object> salaryInfoMap(String dataNum);
	
	//화면로딩 시 급여상세정보 1줄 조회
	public SalaryInfo salaryInfo();
	
	//사원기본정보 조회
	public List<Map<StaffInfo,Object>> getSalaryStaffList();
}
