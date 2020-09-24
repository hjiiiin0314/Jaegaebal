package kr.or.jaegaebal.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.jaegaebal.dto.Jojic;
import kr.or.jaegaebal.dto.StaffInfo;
import kr.or.jaegaebal.dto.UpmuDocument;
import kr.or.jaegaebal.mapper.UpmuMapper;

/**
 * 담당자 : 노종석,장현지
 * @author ECS
 *
 */
@Service
public class UpmuService {

	@Autowired private UpmuMapper upmumapper;
	
	//임시저장함 - 삭제
	public int delStorage(String docCode) {
		int result = 0;
		if(docCode != null && !"".equals(docCode)) {
			result = upmumapper.delStorage(docCode);
		}
		return result;
	}
	
	//임시저장함 - 조건검색
	public List<UpmuDocument> storageBox (String sk, String sv){
		List<UpmuDocument> storageBox = upmumapper.searchStorage(sk,sv);
		return storageBox;
	}
	
	//임시저장함 -전체
	public List<UpmuDocument> storageBox(){
		List<UpmuDocument> storageBox = upmumapper.storageBox();
		return storageBox;
	}
	
	//상신함 - 검색
	public List<UpmuDocument> searchAppList(String sk, String sv){
		List<UpmuDocument> searchAppList = upmumapper.searchAppList(sk,sv);		
		return searchAppList;
	}
	
	//상신함 - 내가 올린 전체 결재리스트
		public List<UpmuDocument> myAppList(){
			List<UpmuDocument> myAppList = upmumapper.myAppList();
			return myAppList;
		}
		
	//기안하기 - 결재라인으로 선택한 사람 db에 넣기	
		public int choiceStaff(String[] jojicCode,String[] staffLevelCode,String[] staffNum) {
			
			List<Map<String, Object>> choiceStaff = new ArrayList<>();
			for(int i=0; i<jojicCode.length; i++) {
				Map<String, Object> beforInfo = new HashMap<String, Object>();
				beforInfo.put("jojicCode", jojicCode[i]);
				beforInfo.put("levelCode", staffLevelCode[i]);
				beforInfo.put("staffNum", staffNum[i]);
				
				choiceStaff.add(beforInfo);
			}
			
			int result	= upmumapper.choiceStaff(choiceStaff);
			
			return result;
		}
		
	
	//기안하기 - 결재라인 - 조직도 - 사원
		public List<StaffInfo> getStaff(){
			List<StaffInfo> staff = upmumapper.getStaff();
			return staff;
		}
		
	//기안하기 - 결재라인 - 조직도
		public List<Jojic> getTeam(){
			List<Jojic> team = upmumapper.getTeam();
			return team;
		}
		
	//기안하기 - 결재라인 - 조직도
		public List<Jojic> getJojic(){
			List<Jojic> jojic = upmumapper.getJojic();
			return jojic;
		}
	
	//기안하기-문서유형 option값	
	public List<UpmuDocument> getDocType(){
		  List<UpmuDocument> docType = upmumapper.getDocType();
		return docType;
		
	}
	
}
