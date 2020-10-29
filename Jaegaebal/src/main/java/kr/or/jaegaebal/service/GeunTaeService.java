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

	@Autowired
	private GeunTaeMapper geunTaeMapper;

	// 휴일관리

	/*
	 * public List<Holiday> getHolidayList() {
	 * 
	 * return geunTaeMapper.holidayList(); }
	 */
	public List<Map<String, Object>> getHolidayList() {
		List<Map<String, Object>> fullCalendarResult = geunTaeMapper.holidayList();
		return fullCalendarResult;
	}


	// 휴일등록
	public int addHdCode(Holiday holiday) {
		return geunTaeMapper.addHdCode(holiday);
	}

	
}
