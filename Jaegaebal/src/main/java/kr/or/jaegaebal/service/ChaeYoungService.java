package kr.or.jaegaebal.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.jaegaebal.dto.ChaeYoungApplicant;
import kr.or.jaegaebal.dto.ChaeYoungBoard;
import kr.or.jaegaebal.dto.ChaeYoungCareerInfo;
import kr.or.jaegaebal.dto.ChaeYoungInfo;
import kr.or.jaegaebal.dto.Jojic;
import kr.or.jaegaebal.mapper.ChaeYoungMapper;

/**
 * 담당자 : 김형진
 * @author ECS
 *
 */
@Service
public class ChaeYoungService {
	
	@Autowired ChaeYoungMapper chaeYoungMapper;
	//지원부서코드 가져오기
	public List<Jojic> getJojicCode() {
		
		return chaeYoungMapper.getJojicCode();
	};
	
	//채용공고 게시글 등록
	public int addCYBoardPost(ChaeYoungBoard ChaeYoungBoard) {
		
		return chaeYoungMapper.addCYBoardPost(ChaeYoungBoard);
	};
	
	//채용공고 수정
	public int updateCYPost(ChaeYoungBoard ChaeYoungBoard) {
		
		return chaeYoungMapper.updateCYPost(ChaeYoungBoard);
	};
	
	//채용공고 삭제
	public int deleteCYPost(String jobNumber) {
		
		return chaeYoungMapper.deleteCYPost(jobNumber);
	};
	
	//채용공고 리스트
	public List<ChaeYoungBoard> cyBoardList() {
		
		return chaeYoungMapper.cyBoardList();
	};
	//등록된 채용공고 불러오기(메서드 오버로딩)
	public ChaeYoungBoard cyBoardList(String jobNumber) {
		
		return chaeYoungMapper.cyBoardList(jobNumber);
	};
	
	//이메일 중복 체크
	public ChaeYoungApplicant emailCheck(String appEmail) {
		
		return chaeYoungMapper.emailCheck(appEmail);
	};
	
	//지원자 목록 가져오기
	public List<ChaeYoungApplicant> appManagement() {
			
		return chaeYoungMapper.appManagement();
	};
	
	//지원자 특정인원 가져오기
	public ChaeYoungApplicant appManagement(ChaeYoungApplicant appNumCode) {
		
		return chaeYoungMapper.appManagement(appNumCode);
	};
	
	//지원자 이메일 등록
	public int addApplicant(ChaeYoungApplicant chaeYoungApplicant) {
		int result = 0;
		if(chaeYoungApplicant != null) {
			try {
				result += chaeYoungMapper.addApplicant(chaeYoungApplicant);
				result += chaeYoungMapper.addAppNumCode(chaeYoungApplicant);
				
			}catch (Exception e) {
				result = 0;
			}
		}	
		return result;
	};
	
	// *********************** 지원자 이력서 등록 Start ***************************** //
	public int addAppInfo(ChaeYoungInfo chaeYoungInfo) {
		int result = 0;
		
		if(chaeYoungInfo.getAppNumCode() != null) {
			//지원자 기본 인적사항
			result += chaeYoungMapper.addBasicInfo(chaeYoungInfo);
			
			if(chaeYoungInfo.getCompanyName() != null) {
				//List<ChaeYoungCareerInfo> chaeYoungCareerInfoList = new ArrayList<ChaeYoungCareerInfo>();				
				for(int i=0; i<chaeYoungInfo.getCompanyName().length; i++) {
					ChaeYoungCareerInfo chaeYoungCareerInfo = new ChaeYoungCareerInfo();
					//지원자 동일정보
					chaeYoungCareerInfo.setAppNumCode(chaeYoungInfo.getAppNumCode());
					chaeYoungCareerInfo.setJobNumber(chaeYoungInfo.getJobNumber());
					chaeYoungCareerInfo.setAppEmail(chaeYoungInfo.getAppEmail());
					chaeYoungCareerInfo.setRegDate(chaeYoungInfo.getRegDate());
					
					//경력정보
					chaeYoungCareerInfo.setCompanyName(chaeYoungInfo.getCompanyName()[i]); //직장명
					chaeYoungCareerInfo.setCompanyAccess(chaeYoungInfo.getCompanyAccess()[i]); //직위
					chaeYoungCareerInfo.setCompanyPositionFromOut(chaeYoungInfo.getCompanyPositionFromOut()[i]); //직책
					chaeYoungCareerInfo.setCompanyWorkFormOut(chaeYoungInfo.getCompanyWorkFormOut()[i]); //직무
					chaeYoungCareerInfo.setCompanyInDateFromOut(chaeYoungInfo.getCompanyInDateFromOut()[i]); //입사일자
					chaeYoungCareerInfo.setCompanyOutDateFromOut(chaeYoungInfo.getCompanyOutDateFromOut()[i]); //퇴사일자
					chaeYoungCareerInfo.setCompanyOutReason(chaeYoungInfo.getCompanyOutReason()[i]); //퇴직사유
					
					//chaeYoungCareerInfoList.add(chaeYoungCareerInfo);
					result += chaeYoungMapper.addCareerInfo(chaeYoungCareerInfo);
				}
			}
			//학력정보 
			if(chaeYoungInfo.getDegree() != null) {
				result += chaeYoungMapper.addEducationInfo(chaeYoungInfo);
			}
			//병역정보
			if(chaeYoungInfo.getMilitaryClassidx() != null) {
				result += chaeYoungMapper.addMilitaryInfo(chaeYoungInfo);
			}
		}
		//지원이 완료 되면 지원상태 지원완료 로 변경 
		if(result > 0) {
			chaeYoungMapper.appFinalStateUpdate(chaeYoungInfo.getAppEmail());
		}
		return result;
	}
	
	// *********************** 지원자 이력서 등록 End ***************************** //
	//지원자 정보 삭제
	public int deleteApplicant(String appEmail) {
		
		return chaeYoungMapper.deleteApplicant(appEmail);
	};
	
}
