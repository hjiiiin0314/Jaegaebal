package kr.or.jaegaebal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.jaegaebal.dto.ChaeYoungBoard;
import kr.or.jaegaebal.dto.ChaeYoungCode;
import kr.or.jaegaebal.mapper.ChaeYoungMapper;

/**
 * 담당자 : 김형진
 * @author ECS
 *
 */
@Service
public class ChaeYoungService {
	
	@Autowired ChaeYoungMapper chaeYoungMapper;
	//지원분야코드 가져오기
	public List<ChaeYoungCode> getFieldeCode() {
		
		return chaeYoungMapper.getFieldeCode();
	};
	
	//구인공고 게시글 등록
	public int addCYBoardPost(ChaeYoungBoard ChaeYoungBoard) {
		
		return chaeYoungMapper.addCYBoardPost(ChaeYoungBoard);
	};
	
	//구인공고 리스트
	public List<ChaeYoungBoard> cyBoardList() {
		
		return chaeYoungMapper.cyBoardList();
	};
}
