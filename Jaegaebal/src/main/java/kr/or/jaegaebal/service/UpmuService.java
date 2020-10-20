package kr.or.jaegaebal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.jaegaebal.dto.StaffInfo;
import kr.or.jaegaebal.dto.Upmu;
import kr.or.jaegaebal.dto.NoticeBoard;
import kr.or.jaegaebal.mapper.UpmuMapper;

/**
 * 담당자 : 장현지
 * @author ECS
 *
 */
@Service
public class UpmuService {
	@Autowired UpmuMapper upmumapper;
	
	//공지사항 - 상세보기
	public List<NoticeBoard> ntDetail(String ntDoc){
		List<NoticeBoard> ntDetail = upmumapper.ntDetail(ntDoc);
		return ntDetail;
	}
	
	//공지게시판 - 조건검색
	public List<NoticeBoard> searchNotice(String sk, String sv){
		List<NoticeBoard> searchNotice = upmumapper.searchNotice(sk, sv);
		return searchNotice;
	}
	
	//공지게시판 - 전체리스트
	public List<NoticeBoard> noticeBoard(){
		List<NoticeBoard> noticeBoard = upmumapper.noticeBoard();
		return noticeBoard;
	}
	
	//업무삭제
	public int delTask(int taskNum) {
		int result = upmumapper.delTask(taskNum);
		return result;		
	}
	
	//업무완료
	public int endTask(int taskNum) {
		int result = upmumapper.endTask(taskNum);
		return result;		
	}
	
	//업무등록
	public int addTask(Upmu newTask) {
		int result = upmumapper.addTask(newTask);
		return result;
	}
	
	//업무관리 - 나의 업무목록 조회
	public List<Upmu> myTask(){
		List<Upmu> myTask = upmumapper.myTask();
		return myTask;
	}
	
	//업무관리 - 선택한 사원의 업무조회
	public List<Upmu> staffUpmu(String staffNum){
		List<Upmu> staffUpmu = upmumapper.staffUpmu(staffNum);
		return staffUpmu;
	}
	
	//업무관리 - 사원검색
	public List<StaffInfo> staffTaskList(String sk, String sv){
		List<StaffInfo> staffTask = upmumapper.staffTaskList(sk, sv);
		return staffTask;
	}
	
	//업무관리 - 사원목록
	public List<StaffInfo> staffTask(){
		List<StaffInfo> staffTask = upmumapper.staffTask();
		return staffTask;
	}

}
