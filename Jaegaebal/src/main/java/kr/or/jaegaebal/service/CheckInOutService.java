package kr.or.jaegaebal.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.jaegaebal.dto.CheckInOut;
import kr.or.jaegaebal.mapper.CheckInOutMapper;



@Service
@Transactional
public class CheckInOutService {
	
	@Autowired private CheckInOutMapper checkInOutMapper;
	//출퇴근 리스트
	
		 public List<Map<CheckInOut, Object>> getCheckInOutList(){
			 return checkInOutMapper.getCheckInOutList();
			 
		 }
		 
		//출퇴근코드로 조회
			public CheckInOut getCheckInOut(String wcCode) {
				return checkInOutMapper.getCheckInOut(wcCode);
			}
			
		//출근등록
			public int checkIn(CheckInOut checkInOut) {
				return checkInOutMapper.checkIn(checkInOut);
			}
		//퇴근등록
			public int checkOut(CheckInOut checkInOut) {
				return checkInOutMapper.checkOut(checkInOut);
			}
			
}
