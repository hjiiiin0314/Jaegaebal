package kr.or.jaegaebal.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import kr.or.jaegaebal.dto.CheckInOut;

@Mapper
public interface CheckInOutMapper {
	
	//출퇴근리스트
		public List<Map<CheckInOut, Object>> getCheckInOutList();
		
	//출퇴근코드로 조회
		public CheckInOut getCheckInOut(String wcCode);
		
	//출근 등록
		public int checkIn(CheckInOut checkInOut);
		
}
