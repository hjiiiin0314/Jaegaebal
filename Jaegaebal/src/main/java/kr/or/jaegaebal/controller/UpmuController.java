package kr.or.jaegaebal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 담당자 : 장현지
 * @author ECS
 *
 */
@Controller
public class UpmuController {
	
	//업무관리 화면이동
	@GetMapping("/upmuList")
	public String upmuList() {
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
