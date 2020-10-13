package kr.or.jaegaebal.service;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.jaegaebal.dto.Jojic;
import kr.or.jaegaebal.dto.StaffInfo;
import kr.or.jaegaebal.dto.UpmuDocument;
import kr.or.jaegaebal.mapper.ApprovalMapper;

/**
 * 담당자 : 장현지
 * @author ECS
 *
 */
@Service
public class ApprovalService {

	
	private static final Logger  log = LoggerFactory.getLogger(ApprovalService.class);	
	@Autowired private ApprovalMapper approvalmapper;
	
	//보안문서 열람 시 비밀번호 입력
	public String securityPW(String SSTAFFNUM) {
		String securityPW = approvalmapper.securityPW(SSTAFFNUM);
		
		return securityPW;
	}
	
	//결재처리함 - 결재하기
	public int appDecide(UpmuDocument appDecide) {
		int result = approvalmapper.appDecide(appDecide);
		return result;
	}
	
	//결재처리함 - 전체리스트
	public List<UpmuDocument> decideList(){
		List<UpmuDocument> decideList = approvalmapper.decideList();
		return decideList;
	}
	
	//상세보기 - 결재라인 관련
	public List<UpmuDocument> getAppLine(String docCode){
		List<UpmuDocument> getAppLine = approvalmapper.getAppLine(docCode);
		
		return getAppLine;
	}
	
	//상세보기 - 문서내용만
	public List<UpmuDocument> docDetail(String docCode){
		List<UpmuDocument> docDetail = approvalmapper.docDetail(docCode);
		
		return docDetail;
	}
	
	
	//임시저장함 - 삭제
	public int delStorage(String docCode) {
		int result = 0;
		if(docCode != null && !"".equals(docCode)) {
			result = approvalmapper.delStorage(docCode);
		}
		return result;
	}
	
	//임시저장함 - 조건검색
	public List<UpmuDocument> storageBox (String sk, String sv){
		List<UpmuDocument> storageBox = approvalmapper.searchStorage(sk,sv);
		return storageBox;
	}
	
	//임시저장함 -전체
	public List<UpmuDocument> storageBox(){
		List<UpmuDocument> storageBox = approvalmapper.storageBox();
		return storageBox;
	}
	
	//상신함 - 검색
	public List<UpmuDocument> searchAppList(String sk, String sv){
		List<UpmuDocument> searchAppList = approvalmapper.searchAppList(sk,sv);		
		return searchAppList;
	}
	
	//상신함 - 내가 올린 결재문서 리스트
	public List<UpmuDocument> myAppList(){
		List<UpmuDocument> myAppList = approvalmapper.myAppList();
		return myAppList;
	}
		
	//기안하기 - 임시저장하기
	public int addStorage(UpmuDocument addAppDoc, String[] jojicCode, String[] staffLevelCode, String[] staffNum) {
		approvalmapper.appWrite(addAppDoc);
		
		String getDocCode = addAppDoc.getDocCode();
		
		List<Map<String, Object>> storageAppLine = new ArrayList<>();
		for(int i=0; i<jojicCode.length; i++) {
			Map<String, Object> beforInfo = new HashMap<String, Object>();
			beforInfo.put("jojicCode", jojicCode[i]);
			beforInfo.put("levelCode", staffLevelCode[i]);
			beforInfo.put("staffNum", staffNum[i]);
			beforInfo.put("getDocCode", getDocCode);
			
			storageAppLine.add(beforInfo);
		}
		
		log.info("UpmuService addStorage upmuDocument ::::: {}",storageAppLine);
		int result = approvalmapper.choiceStaff(storageAppLine);
		
		return result;
	}
		
	//기안하기 - 결재올리기 
		public int appWrite(UpmuDocument upmuDocument, String[] jojicCode, String[] staffLevelCode, String[] staffNum) {
			approvalmapper.appWrite(upmuDocument);
			
			String getDocCode = upmuDocument.getDocCode();
			
			List<Map<String, Object>> choiceStaff = new ArrayList<>();
			for(int i=0; i<jojicCode.length; i++) {
				Map<String, Object> beforInfo = new HashMap<String, Object>();
				beforInfo.put("jojicCode", jojicCode[i]);
				beforInfo.put("levelCode", staffLevelCode[i]);
				beforInfo.put("staffNum", staffNum[i]);
				beforInfo.put("getDocCode", getDocCode);
				
				choiceStaff.add(beforInfo);
			}
			
			log.info("UpmuService appWrite upmuDocument ::::: {}",choiceStaff);
			int result = approvalmapper.choiceStaff(choiceStaff);
			
			return result;
		}
		
	
	
	//기안하기 - 결재라인 - 조직도 - 사원
		public List<StaffInfo> getStaff(){
			List<StaffInfo> staff = approvalmapper.getStaff();
			return staff;
		}
		
	//기안하기 - 결재라인 - 조직도
		public List<Jojic> getTeam(){
			List<Jojic> team = approvalmapper.getTeam();
			return team;
		}
		
	//기안하기 - 결재라인 - 조직도
		public List<Jojic> getJojic(){
			List<Jojic> jojic = approvalmapper.getJojic();
			return jojic;
		}
	
	//기안하기-문서유형 option값	
	public List<Map<String, Object>> getDocType(){
		List<Map<String, Object>> docType  = approvalmapper.getDocType();
		return docType;
		
	}
	
}
