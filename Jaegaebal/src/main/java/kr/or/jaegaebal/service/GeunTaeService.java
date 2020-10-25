package kr.or.jaegaebal.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.jaegaebal.dto.Holiday;
import kr.or.jaegaebal.mapper.GeunTaeMapper;

@Service
@Transactional
public class GeunTaeService {
	
@Autowired private GeunTaeMapper geunTaeMapper;
	

	//휴일관리
	
	 public List<Holiday> getHolidayList(){
		 
		 return geunTaeMapper.holidayList(); 
	 }
	 
	 //휴일 등록
	 
	 public List<Map<String, Object>> addHdCode() {
			List<Map<String, Object>> addHdCode = geunTaeMapper.addHdCode();
			return addHdCode;
		}
		 
	// 휴일코드 수정
		 public int updateHdCode(Holiday holiday) {
			 return geunTaeMapper.updateHdCode(holiday);
		 }
		 
	//휴일코드로 조회
		 public Holiday getHdCode(String hdCode) {
			 return geunTaeMapper.getHdCode(hdCode);
		 }
}
