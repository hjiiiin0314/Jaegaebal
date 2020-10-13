package kr.or.jaegaebal.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.jaegaebal.dto.Jojic;
import kr.or.jaegaebal.dto.StaffInfo;
import kr.or.jaegaebal.dto.UpmuDocument;

/**
 * 담당자 : 장현지
 * @author ECS
 *
 */
@Mapper
public interface ApprovalMapper {
	
	//보안문서 열람 시 비밀번호 확인
		public String securityPW(String SSTAFFNUM);
	
	//결재처리함 - 결재하기
		public int appDecide(UpmuDocument appDecide);
	
	//결재처리함 - 전체리스트
		public List<UpmuDocument> decideList();
	
	//상세보기 - 결재라인관련
		public List<UpmuDocument> getAppLine(String docCode);
	
	//상세보기 - 문서내용만
		public List<UpmuDocument> docDetail(String docCode);
	
	//임시저장함 - 삭제
		public int delStorage(String doccode);
	
	//임시저장함 - 조건검색
		public List<UpmuDocument> searchStorage(String sk, String sv);
	
	//임시저장함 - 전체목록
		public List<UpmuDocument> storageBox();
	
	//상신함 - 검색목록
		public List<UpmuDocument> searchAppList(String sk, String sv);		
		
	//상신함 - 전체목록
		public List<UpmuDocument> myAppList();			
		
	//기안하기 - 결재올리기 - 문서
		public int appWrite(UpmuDocument upmuDocument);
		
	//기안하기 - 결재올리기 - 결재라인
		public int choiceStaff(List<Map<String, Object>> choiceStaff);
	
	//기안하기 - 결재라인  - 사원
		public List<StaffInfo> getStaff();
	
	//기안하기 - 결재라인 - 팀
		public List<Jojic> getTeam();
		
	//기안하기 - 결재라인 - 최상위(부서)
		public List<Jojic> getJojic();


	//기안하기 - 문서유형
		public List<Map<String, Object>> getDocType();

}
