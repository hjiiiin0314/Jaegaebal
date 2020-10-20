package kr.or.jaegaebal.service;

import java.text.DecimalFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.jaegaebal.dto.SalaryInfo;
import kr.or.jaegaebal.dto.SalaryRecord;
import kr.or.jaegaebal.dto.StaffInfo;
import kr.or.jaegaebal.dto.YoulPyo;
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
	
	public List<Map<String, Object>> getAddPay() {
		List<Map<String, Object>> listPayMap = salaryMapper.getAddPay();
		return listPayMap;
	}
	
	public List<Map<String, Object>> getAddDeduct() {
		List<Map<String, Object>> listDeductMap = salaryMapper.getAddDeduct();
		return listDeductMap;
	}
	
	public int updateSalMonth(SalaryRecord salaryRecord) {
		int result = salaryMapper.updateSalMonth(salaryRecord);
		return result;
	}
	
	public int addSalMonth(SalaryRecord salaryRecord) {
		int result = salaryMapper.addSalMonth(salaryRecord);
		return result;
	}
	
	public YoulPyo getYoulList() {
		YoulPyo youlPyo = salaryMapper.getYoulList();
		return youlPyo;
	}
	
	public int getStaffNormal(String dataNum) {
		int staffBasicSalary = salaryMapper.getStaffNormal(dataNum);
		return staffBasicSalary;
	}
	
	public int getPrizeList(String dataNum, String searchDate) {
		int prizeSum = salaryMapper.getPrizeList(dataNum, searchDate);
		return prizeSum;
	}
	
	public int getPunishmentList(String dataNum, String searchDate) {
		int punishmentSum = salaryMapper.getPunishmentList(dataNum, searchDate);
		return punishmentSum;
	}
	
	public SalaryRecord getSelMonthData(String dataNum, String searchDate) {
		SalaryRecord salaryRecord = salaryMapper.getSelMonthData(dataNum, searchDate);
		return salaryRecord;
	}
	
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
	
	public List<Map<String, Object>> getFilterYear(){
		List<Map<String, Object>> yearList = salaryMapper.getFilterYear();
		return yearList;
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
		//받은 숫자값들에 3자리마다 쉼표를 붙이기 위한 처리
		DecimalFormat dc = new DecimalFormat("###,###");
		String ch = null;
		Object numValue = null;
		for(int i=0;i<22;i++) {
			for(int j=1;j<13;j++) {
				numValue = monthSalList.get(i).get("M"+j); 
				ch = dc.format(numValue);
				monthSalList.get(i).put("M"+j, ch);
			}
			numValue = monthSalList.get(i).get("plus"); 
			ch = dc.format(numValue);
			monthSalList.get(i).put("plus", ch);
		}
		return monthSalList;
	}
}
