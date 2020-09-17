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
	
	//구인공고 게시글 등록
	public int addCYBoardPost(ChaeYoungBoard ChaeYoungBoard) {
		
		return chaeYoungMapper.addCYBoardPost(ChaeYoungBoard);
	};
	
	//구인공고 리스트
	public List<ChaeYoungBoard> cyBoardList() {
		
		return chaeYoungMapper.cyBoardList();
	};
	//등록된 구인공고 불러오기(메서드 오버로딩)
	public ChaeYoungBoard cyBoardList(String jobNumber) {
		
		return chaeYoungMapper.cyBoardList(jobNumber);
	};
	
	//이메일 중복 체크
	public ChaeYoungApplicant emailCheck(String appEmail) {
		
		return chaeYoungMapper.emailCheck(appEmail);
	};
}
