package kr.or.jaegaebal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.jaegaebal.dto.CheckInOut;

@Mapper
public interface CheckInOutMapper {
	
	//출퇴근리스트
		public List<CheckInOut> getCheckInOutList();
		
}
