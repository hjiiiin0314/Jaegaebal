package kr.or.jaegaebal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.jaegaebal.dto.CodeAdmin;



@Mapper
public interface CodeAdminMapper {
	
	//근무형태코드 등록
	public int addWorkCode(CodeAdmin codeAdmin);
	
	//근무형태코드 리스트 
	public List<CodeAdmin> getWorkCodeList();
}
