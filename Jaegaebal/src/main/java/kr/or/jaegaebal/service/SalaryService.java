package kr.or.jaegaebal.service;

import java.util.*;

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
	
	public List<Map<String, Object>> getStaffListMap(String searchCate, String searchText, String searchLevel, String searchJojic){
		List<Map<String, Object>> staffList = salaryMapper.getStaffListMap(searchCate, searchText, searchLevel, searchJojic);
		return staffList;
	}
	
	public List<Map<String, Object>> getLevelList(){
		List<Map<String, Object>> levelList = salaryMapper.getLevelList();
		return levelList;
	}
	
	public List<Map<String, Object>> getJojicList(){
		List<Map<String, Object>> jojicList = salaryMapper.getJojicList();
		return jojicList;
	}
	
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
	
	public List<Map<String,Object>> getMonthSalList(String searchYear, String dataNum){
		List<Map<String,Object>> monthSalList = salaryMapper.getMonthSalList(searchYear, dataNum);
		return monthSalList;
	}
}
