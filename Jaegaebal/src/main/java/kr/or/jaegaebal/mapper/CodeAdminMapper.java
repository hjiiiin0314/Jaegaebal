package kr.or.jaegaebal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import kr.or.jaegaebal.dto.CodeAdmin;
import kr.or.jaegaebal.dto.DocCodeAdmin;
import kr.or.jaegaebal.dto.EmpCodeAdmin;
import kr.or.jaegaebal.dto.InsaCodeAdmin;



@Mapper
public interface CodeAdminMapper {
	
	/* ==========고용형태코드관리========== */
	//고용형태코드리스트
	public List<EmpCodeAdmin> getEmpCodeList();
	
	//고용형태코드등록
	public int addEmpCode(EmpCodeAdmin empCodeAdmin);
	
	//고용형태 중복확인
	public String empCodeCheck(String empCode);
	
	//고용형태 중복확인
	public int updateEmpCode(EmpCodeAdmin empCodeAdmin);
	
	//고용코드로 조회
	public EmpCodeAdmin getEmpCode(String empCode);
	
	//고용코드 삭제
	public int deleteEmpCode(String empCode);
		
	
	
	/* ==========문서코드관리========== */
	//문서코드리스트
	public List<DocCodeAdmin> getDocCodeList();
	
	//문서코드등록
	public int addDocCode(DocCodeAdmin docCodeAdmin);
	
	//문서코드 중복확인
	public String docCodeCheck(String docCode);
	
	//문서코드로 조회
	public DocCodeAdmin getDocCode(String docCode);
	
	//문서코드 수정
	public int updateDocCode(DocCodeAdmin docCodeAdmin);
	
	//문서코드 삭제
	public int deleteDocCode(String docCode);
	
	/* ==========인사코드관리========== */
	//인사코드리스트
	public List<InsaCodeAdmin> getInsaCodeList();
	
	//인사코드 등록
	public int addInsaCode(InsaCodeAdmin insaCodeAdmin);
	
	//인사코드 중복확인
	public String insaCodeCheck(String insaCode);
	
	//인사코드 수정
	public int updateInsaCode(InsaCodeAdmin insaCodeAdmin);
	
	//인사코드로 조회
	public InsaCodeAdmin getInsaCode(String insaCode);
	
	//인사코드 삭제
	public int deleteInsaCode(String insaCode);
	
	
	/* ==========근무형태코드관리========== */
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
