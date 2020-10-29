package kr.or.jaegaebal.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.jaegaebal.dto.Holiday;



@Mapper
public interface GeunTaeMapper {
	
	//휴일 코드 리스트
	/* public List<Holiday> holidayList(); */
	public List<Map<String, Object>> holidayList();
		
	//휴일등록
		public int addHdCode(Holiday holiday);
		
	//휴일 수정
		public int updateHdCode(Holiday holiday);
		
	//휴일 코드로 조회	
		public Holiday getHdCode(String hdCode);
}
