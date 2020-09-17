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
	public Map<String, Object> salaryInfoMap(String dataNum);
	
	public List<Map<SalaryInfo, Object>> salaryInfo(String dataNum);
	
	public List<Map<StaffInfo,Object>> getSalaryStaffList();
}
