package kr.or.jaegaebal.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.jaegaebal.dto.NoticeBoard;
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
	
	//업무관리 - 선택한 사원의 업무
	@PostMapping(value="/staffUpmu",produces = "application/json")
	@ResponseBody
	public List<Upmu> staffUpmu(@RequestParam(value = "staffNum",required = false)String staffNum) {		
		List<Upmu> staffUpmu = upmuService.staffUpmu(staffNum);		
		return staffUpmu;
	}
	
	//업무관리 - 사원검색
	@PostMapping("/staffTaskList")
	public String staffTaskList(Model model
								,@RequestParam(value = "sk",required = false)String sk
								,@RequestParam(value = "sv",required = false)String sv) {
		
		if(sk != null && !"".equals(sk) 
				&& sv != null && !"".equals(sv)){
			List<StaffInfo> staffTask = upmuService.staffTaskList(sk,sv);
			model.addAttribute("staffTask", staffTask);
			//업무정보란에는 기본적으로 내 업무정보가 나오도록
			List<Upmu> myTask = upmuService.myTask();
			model.addAttribute("myTask", myTask);
			
		}else {
			List<StaffInfo> staffTask = upmuService.staffTask();
			model.addAttribute("staffTask", staffTask);
			//업무정보란에는 기본적으로 내 업무정보가 나오도록
			List<Upmu> myTask = upmuService.myTask();
			model.addAttribute("myTask", myTask);
		}	
		
		return "upmu/upmuList";
	}	
	//업무관리 화면이동
	@GetMapping("/upmuList")
	public String upmuList(Model model) {
		
		//업무관리할 사원 목록
		List<StaffInfo> staffTask = upmuService.staffTask();
		model.addAttribute("staffTask", staffTask);
		
		//나의 업무목록
		List<Upmu> myTask = upmuService.myTask();
		model.addAttribute("myTask", myTask);
		
		return "upmu/upmuList";
	}

	
	//업무공유게시판화면이동
	@GetMapping("/upmuShare")
	public String upmuShare() {
		
		return "upmu/upmuShare";
	}
	
	//공지게시판 -조건검색
	@PostMapping("/searchNotice")
	public String searchNotice(Model model,
							@RequestParam(value = "sk", required = false)String sk
							,@RequestParam(value = "sv",required = false)String sv) {
		
		if(sk != null && !"".equals(sk) && sv != null && !"".equals(sv)){
			List<NoticeBoard>noticeBoard = upmuService.searchNotice(sk, sv);
			model.addAttribute("noticeBoard", noticeBoard);
		}else {
			List<NoticeBoard> noticeBoard = upmuService.noticeBoard();
			model.addAttribute("noticeBoard", noticeBoard);
		}
		return "upmu/noticeBoard";
	}
	
	
	//공지게시판화면이동
	@GetMapping("/noticeBoard")
	public String noticeBoard(Model model) {
		List<NoticeBoard> noticeBoard = upmuService.noticeBoard();
		model.addAttribute("noticeBoard", noticeBoard);
		return "upmu/noticeBoard";
	}

}
