package kr.or.jaegaebal.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import kr.or.jaegaebal.dto.StaffInfo;
import kr.or.jaegaebal.dto.Upmu;
import kr.or.jaegaebal.dto.NoticeBoard;

/**
 * 담당자 : 장현지
 * @author ECS
 *
 */
@Mapper
public interface UpmuMapper {
	
	//공지게시판 - 조건검색
	public List<NoticeBoard> searchNotice(String sk, String sv);
	
	//공지게시판 - 전체검색
	public List<NoticeBoard> noticeBoard();
	
	//업무삭제
	public int delTask(int taskNum);
	
	//업무완료
	public int endTask(int taskNum);
	
	//업무등록
	public int addTask(Upmu newTask);
	
	//업무관리 - 선택한 사원의 업무
	public List<Upmu> staffUpmu(String staffNum);
	
	//업무관리 - 나의업무목록
	public List<Upmu> myTask();
	
	//업무관리 - 사원검색
	public List<StaffInfo> staffTaskList(String sk, String sv);

	//업무관리 - 사원목록
	public List<StaffInfo> staffTask();
}
