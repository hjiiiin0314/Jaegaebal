package kr.or.jaegaebal.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import kr.or.jaegaebal.dto.StaffInfo;
import kr.or.jaegaebal.dto.Upmu;
import kr.or.jaegaebal.service.UpmuService;

/**
 * 담당자 : 장현지
 * @author ECS
 *
 */
@Controller
public class UpmuController {
	@Autowired private UpmuService upmuService;
	
	//업무삭제처리
	@GetMapping("/delTask")
	public String delTask(int taskNum) {
		upmuService.delTask(taskNum);
		return"redirect:/upmuList";	
	}
	
	//업무완료
	@GetMapping("/endTask")
	public String endTask(int taskNum) {
		upmuService.endTask(taskNum);
		return"redirect:/upmuList";
	}
	
	//업무등록처리
	@PostMapping("/addTask")
	public String addTask(Upmu newTask) {
		upmuService.addTask(newTask);
		return "redirect:/upmuList";
	}
	
	//업무관리 화면이동
	@GetMapping("/upmuList")
	public String upmuList(Model model) {
		
		//업무관리할 사원 목록
		List<StaffInfo> staffTask = upmuService.staffTask();
		model.addAttribute("staffTask", staffTask);
		
		//나의 업무목록
		List<Upmu> myTesk = upmuService.myTesk();
		model.addAttribute("myTesk", myTesk);
		
		return "upmu/upmuList";
	}

	//출퇴근화면이동
	@GetMapping("/checkInOut")
	public String checkInOut() {
		return "upmu/checkInOut";
	}
	
	//업무공유게시판화면이동
	@GetMapping("/upmuShare")
	public String upmuShare() {
		
		return "upmu/upmuShare";
	}
	
	//공지게시판화면이동
	@GetMapping("/noticeBoard")
	public String noticeBoard() {
		
		return "upmu/noticeBoard";
	}

}
