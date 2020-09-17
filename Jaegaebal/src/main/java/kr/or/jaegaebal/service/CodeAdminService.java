package kr.or.jaegaebal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.jaegaebal.dto.ChaeYoungApplicant;
import kr.or.jaegaebal.dto.CodeAdmin;
import kr.or.jaegaebal.mapper.CodeAdminMapper;

@Service
@Transactional
public class CodeAdminService {
	
	@Autowired private CodeAdminMapper codeAdminMapper;
	
	//근무형태코드 검색
	public List<CodeAdmin> getSearchWorkCodeList(String sk, String sv){
		List<CodeAdmin> workCodeList = codeAdminMapper.getSearchWorkCodeList(sk, sv);
		return workCodeList;
		
	}
	
	//근무형태코드 삭제
	public int deleteWorkCode(String workCode) {
		return codeAdminMapper.deleteWorkCode(workCode);
	}
	
	//근무코드로 조회
	public CodeAdmin getWorkCode(String workCode) {
		
		return codeAdminMapper.getWorkCode(workCode);
	
		
	}
	
	//근무형태코드 수정
	public int updateWorkCode(CodeAdmin codeAdmin) {
		return codeAdminMapper.updateWorkCode(codeAdmin);
		
	}
	
	//근무형태코드 추가
	public int addWorkCode(CodeAdmin codeAdmin) {
		int result = codeAdminMapper.addWorkCode(codeAdmin);
		
		return result;
	}
	
	//근무형태코드 리스트
	public List<CodeAdmin> getWorkCodeList(){
		
		return codeAdminMapper.getWorkCodeList();
	}
	
	//근무형태코드 중복확인
		public CodeAdmin codeCheck(String workCode) {
		
		return codeAdminMapper.codeCheck(workCode);
		}
}
