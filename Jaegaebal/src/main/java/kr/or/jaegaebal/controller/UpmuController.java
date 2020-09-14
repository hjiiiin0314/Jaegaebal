package kr.or.jaegaebal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 담당자 : 노종석 , 장현지
 * @author ECS
 *
 */
@Controller
public class UpmuController {
	
	//결재함화면연결
	@GetMapping("/appBox")
	public String appBox() {
		return "approval/appBox";
	}
	
	//임시저장화면연결
	@GetMapping("/storageBox")
	public String storageBox() {
		return "approval/storageBox";
	}
	

	//기안하기화면연결
	@GetMapping("/appWrite")
	public String appWrite() {
		return "approval/appWrite";
	}

	//출퇴근화면이동
	@GetMapping("/checkInOut")
	public String checkInOut() {
		return "upmu/checkInOut";
	}

}
