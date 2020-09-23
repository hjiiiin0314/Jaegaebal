package kr.or.jaegaebal.service;

import java.util.List;

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
	
		 public List<CheckInOut> getCheckInOutList(){
			 return checkInOutMapper.getCheckInOutList();	 
		 }
}
