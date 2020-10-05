package kr.or.jaegaebal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.jaegaebal.dto.Holiday;
import kr.or.jaegaebal.mapper.GeunTaeMapper;

@Service
@Transactional
public class GeunTaeService {
	
@Autowired private GeunTaeMapper geunTaeMapper;
	
	/* ==========고용코드관리========== */
	//고용코드 리스트
	
	 public List<Holiday> getHolidayList(){
	 return geunTaeMapper.holidayList(); 
	 }

}
