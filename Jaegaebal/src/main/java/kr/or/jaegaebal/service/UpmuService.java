package kr.or.jaegaebal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.jaegaebal.dto.StaffInfo;
import kr.or.jaegaebal.dto.Upmu;
import kr.or.jaegaebal.mapper.UpmuMapper;

/**
 * 담당자 : 장현지
 * @author ECS
 *
 */
@Service
public class UpmuService {
	@Autowired UpmuMapper upmumapper;
	
	//업무등록
	public int addTask(Upmu newTask) {
		int result = upmumapper.addTask(newTask);
		return result;
	}
	
	//업무관리 - 나의 업무목록 조회
	public List<Upmu> myTesk(){
		List<Upmu> myTesk = upmumapper.myTesk();
		return myTesk;
	}
	
	//업무관리 - 사원목록
		public List<StaffInfo> staffTask(){
			List<StaffInfo> staffTask = upmumapper.staffTask();
			return staffTask;
		}

}
