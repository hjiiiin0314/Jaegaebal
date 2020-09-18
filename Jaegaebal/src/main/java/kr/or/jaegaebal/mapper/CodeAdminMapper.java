package kr.or.jaegaebal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import kr.or.jaegaebal.dto.CodeAdmin;



@Mapper
public interface CodeAdminMapper {
	
	//근무형태코드 검색
	public List<CodeAdmin> getSearchWorkCodeList(String sk, String sv);
	
	
	//근무형태코드 등록
	public int addWorkCode(CodeAdmin codeAdmin);
	
	//근무형태코드 리스트 
	public List<CodeAdmin> getWorkCodeList();
	
	//근무형태코드 수정
	public int updateWorkCode(CodeAdmin codeAdmin);	
	
	//근무코드로 조회
	public CodeAdmin getWorkCode(String workCode);
	
	//근무형태코드 삭제
	public int deleteWorkCode(String workCode);
	
	//근무형태코드 중복확인
		public String codeCheck(String workCode);
}
