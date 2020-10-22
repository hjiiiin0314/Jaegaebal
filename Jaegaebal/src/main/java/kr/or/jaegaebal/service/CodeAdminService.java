package kr.or.jaegaebal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import kr.or.jaegaebal.dto.CodeAdmin;
import kr.or.jaegaebal.dto.DocCodeAdmin;
import kr.or.jaegaebal.dto.EmpCodeAdmin;
import kr.or.jaegaebal.dto.InsaCodeAdmin;
import kr.or.jaegaebal.mapper.CodeAdminMapper;

@Service
@Transactional
public class CodeAdminService {
	
	@Autowired private CodeAdminMapper codeAdminMapper;
	
	/* ==========고용코드관리========== */
	
	//고용형태코드 검색
	public List<CodeAdmin> getSearchEmpCodeList(String sk, String sv){
		List<CodeAdmin> empCodeList = codeAdminMapper.getSearchEmpCodeList(sk, sv);
		return empCodeList;
		
	}
	//고용코드 리스트
	
	 public List<EmpCodeAdmin> getEmpCodeList(){
	 return codeAdminMapper.getEmpCodeList();	 
	 }
	 
	 //고용형태코드 등록
	 public int addEmpCode(EmpCodeAdmin empCodeAdmin) {
		 return codeAdminMapper.addEmpCode(empCodeAdmin);
	 }
	 //고용코드 중복확인
	 public int empCodeCheck(String empCode) {
		 int result=0;
		 String eCode = codeAdminMapper.empCodeCheck(empCode);
		 if(eCode != null && !"".equals(eCode.trim())) {
		 result = 1;
		 }
		 return result;
	 }
	 
	 //고용코드 수정
	 public int updateEmpCode(EmpCodeAdmin empCodeAdmin) {
		 return codeAdminMapper.updateEmpCode(empCodeAdmin);
	 }
	 
	//고용코드로 조회
		public EmpCodeAdmin getEmpCode(String empCode) {
			return codeAdminMapper.getEmpCode(empCode);
		}
		
	//문서코드 삭제
	public int deleteEmpCode(String empCode) {
		return codeAdminMapper.deleteEmpCode(empCode);
	}
	
	
	/* ==========문서코드관리========== */
	
	//고용형태코드 검색
		public List<CodeAdmin> getSearchDocCodeList(String sk, String sv){
			List<CodeAdmin> docCodeList = codeAdminMapper.getSearchDocCodeList(sk, sv);
			return docCodeList;
			
		}
	
	//문서리스트
	public List<DocCodeAdmin> getDocCodeList(){
		return codeAdminMapper.getDocCodeList();
	}
	
	//문서코드 추가
	public int addDocCode(DocCodeAdmin docCodeAdmin) {
		return codeAdminMapper.addDocCode(docCodeAdmin);
	}
	
	//문서코드 중복확인
	public int docCodeCheck(String docCode) {
		int result=0;
		String dCode = codeAdminMapper.docCodeCheck(docCode);
		if(dCode != null && !"".equals(dCode.trim())) {
			result = 1;
		}
		return result;
	}
	
	//문서코드 수정
	public int updateDocCode(DocCodeAdmin docCodeAdmin) {
		return codeAdminMapper.updateDocCode(docCodeAdmin);
	}
	
	//문서코드로 조회
	public DocCodeAdmin getDocCode(String docCode) {
		return codeAdminMapper.getDocCode(docCode);
	}
	
	//문서코드 삭제
	public int deleteDocCode(String docCode) {
		return codeAdminMapper.deleteDocCode(docCode);
	}
	
	
	/* ==========인사코드관리========== */
	//인사코드 검색
		public List<CodeAdmin> getSearchInsaCodeList(String sk, String sv){
			List<CodeAdmin> insaCodeList = codeAdminMapper.getSearchInsaCodeList(sk, sv);
			return insaCodeList;
			
		}
		
	//인사코드 리스트
		public List<InsaCodeAdmin> getInsaCodeList(){
			
			return codeAdminMapper.getInsaCodeList();
		}
	
	//인사코드 추가
		public int addInsaCode(InsaCodeAdmin insaCodeAdmin) {
			int result = codeAdminMapper.addInsaCode(insaCodeAdmin);
			
			return result;
		}
	
		//인사코드 중복확인
	
	 public int insaCodeCheck(String insaCode) {
	 
		 int result = 0;
		 String isCode = codeAdminMapper.insaCodeCheck(insaCode);
			 if(isCode != null && !"".equals(isCode.trim())) {
				 result = 1;
				 } 
			 return result;
		 }
	 
	 	//인사코드수정
	 public int updateInsaCode(InsaCodeAdmin insaCodeAdmin) {
			return codeAdminMapper.updateInsaCode(insaCodeAdmin);
			
		}
	//인사코드로 조회
		public InsaCodeAdmin getInsaCode(String insaCode) {
			
			return codeAdminMapper.getInsaCode(insaCode);
					
		}
	// 인사코드 삭제
		public int deleteInsaCode(String insaCode) {
			return codeAdminMapper.deleteInsaCode(insaCode);
		}
	
	
	/* ==========근무형태코드관리========== */
	
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
		public int codeCheck(String workCode) {
			
			int result = 0;
			String code = codeAdminMapper.codeCheck(workCode);
			if(code != null && !"".equals(code.trim())) {
				result = 1;
			}
			return result;
		}
		
}
