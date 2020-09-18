package kr.or.jaegaebal.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.jaegaebal.dto.SalaryInfo;
import kr.or.jaegaebal.dto.StaffInfo;
import kr.or.jaegaebal.mapper.SalaryMapper;

/**
 * 담당자 : 이요셉
 * @author ECS
 *
 */
@Service
public class SalaryService {
	@Autowired
	private SalaryMapper salaryMapper;
	
	public int updateSalaryInfo(SalaryInfo salaryInfo) {
		int result = salaryMapper.updateSalaryInfo(salaryInfo);
		return result;
	}
	
	public Map<String, Object> salaryInfoMap(String dataNum) {
		Map<String, Object> salaryInfo = salaryMapper.salaryInfoMap(dataNum);
		return salaryInfo;
	}
	
	public SalaryInfo salaryInfo() {
		SalaryInfo salaryInfo = salaryMapper.salaryInfo();
		return salaryInfo;
	}
	
	public List<Map<StaffInfo,Object>> getSalaryStaffList(){
		List<Map<StaffInfo,Object>> staffInfoList = salaryMapper.getSalaryStaffList();
		return staffInfoList;
	}
}
