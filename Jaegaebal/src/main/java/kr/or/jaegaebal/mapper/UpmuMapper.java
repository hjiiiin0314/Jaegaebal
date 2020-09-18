package kr.or.jaegaebal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.jaegaebal.dto.Jojic;
import kr.or.jaegaebal.dto.StaffInfo;
import kr.or.jaegaebal.dto.UpmuDocument;

/**
 * 담당자 : 노종석,이은혜
 * @author ECS
 *
 */
@Mapper
public interface UpmuMapper {
	
	//상신함 - 검색목록
		public List<UpmuDocument> searchAppList(String sk, String sv);
		
		
	//상신함 - 전체목록
		public List<UpmuDocument> myAppList();
	
	//기안하기 - 결재라인 - 조직도 - 사원
		public List<StaffInfo> getStaff();
		
		//기안하기 - 결재라인 - 조직도
		public List<Jojic> getJojic();


	//기안하기 - 문서유형
		public List<UpmuDocument> getDocType();
}
