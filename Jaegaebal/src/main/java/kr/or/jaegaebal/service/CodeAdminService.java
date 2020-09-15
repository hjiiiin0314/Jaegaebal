package kr.or.jaegaebal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.jaegaebal.dto.CodeAdmin;
import kr.or.jaegaebal.mapper.CodeAdminMapper;

@Service
@Transactional
public class CodeAdminService {
	
	//코드추가
	@Autowired private CodeAdminMapper codeAdminMapper;
	
	public int addWorkCode(CodeAdmin codeAdmin) {
		int result = codeAdminMapper.addWorkCode(codeAdmin);
		
		return result;
	}
	
	//코드리스트
	public List<CodeAdmin> getWorkCodeList(){
		
		return codeAdminMapper.getWorkCodeList();
	}
}
