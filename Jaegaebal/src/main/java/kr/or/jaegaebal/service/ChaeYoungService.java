package kr.or.jaegaebal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.jaegaebal.dto.ChaeYoungApplicant;
import kr.or.jaegaebal.dto.ChaeYoungBoard;
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
	
	//채용공고 리스트
	public List<ChaeYoungBoard> cyBoardList() {
		
		return chaeYoungMapper.cyBoardList();
	};
	//등록된 채용공고 불러오기(메서드 오버로딩)
	public ChaeYoungBoard cyBoardList(String jobNumber) {
		
		return chaeYoungMapper.cyBoardList(jobNumber);
	};
	
	//이메일 중복 체크
	public String emailCheck(String appEmail) {
		
		return chaeYoungMapper.emailCheck(appEmail);
	};
	
	//지원자 목록 가져오기
	public List<ChaeYoungApplicant> appManagement() {
			
		return chaeYoungMapper.appManagement();
	};
	
	//지원자 이메일 등록
	public int addApplicant(ChaeYoungApplicant chaeYoungApplicant) {
		int result = 0;
		if(chaeYoungApplicant != null) {
			
			result += chaeYoungMapper.addApplicant(chaeYoungApplicant);
			result += chaeYoungMapper.addAppNumCode(chaeYoungApplicant);
		}
		
		
		return result;
	};
}
