package kr.or.jaegaebal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.jaegaebal.dto.ChaeYoungBoard;
import kr.or.jaegaebal.dto.ChaeYoungCode;

/**
 * 담당자 : 김형진
 * @author ECS
 *
 */
@Mapper
public interface ChaeYoungMapper {

	//지원분야코드 가져오기
	public List<ChaeYoungCode> getFieldeCode();
	
	//게시글 등록
	public int addCYBoardPost(ChaeYoungBoard ChaeYoungBoard);
	
	//게시글 리스트
	public List<ChaeYoungBoard> cyBoardList();
	
	//작성된 게시글 화면에 뿌려주기(메서드오버로딩)
	public ChaeYoungBoard cyBoardList(String jobNumber);
}
