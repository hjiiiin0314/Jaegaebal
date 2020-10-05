package kr.or.jaegaebal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.jaegaebal.dto.Holiday;



@Mapper
public interface GeunTaeMapper {
	
	//문서코드리스트
		public List<Holiday> holidayList();
	
}
