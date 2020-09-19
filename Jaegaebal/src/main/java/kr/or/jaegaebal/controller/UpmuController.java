package kr.or.jaegaebal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.jaegaebal.dto.Jojic;
import kr.or.jaegaebal.dto.StaffInfo;
import kr.or.jaegaebal.dto.UpmuDocument;
import kr.or.jaegaebal.service.UpmuService;

/**
 * 담당자 : 노종석 , 장현지
 * @author ECS
 *
 */
@Controller
public class UpmuController {
	@Autowired private UpmuService upmuService;
	
	//반려/회수함화면연결
	@GetMapping("/retrievalBox")
	public String retrievalBox() {
		return "approval/retrievalBox";
	}
	
	//상신함 검색리스트
	@PostMapping(value="/myAppList", produces = "application/json")
	public @ResponseBody List<UpmuDocument>searchAppList(@RequestParam(value = "sk")String sk
														,@RequestParam(value = "sv")String sv
														){
		System.out.println(sk + "<---sk로 들어온 값 controller");
		System.out.println(sv + "<---sv로 들어온 값 controller");
			
		List<UpmuDocument> searchAppList = upmuService.searchAppList(sk,sv);
			
		return searchAppList;		
	
	}
		
	//상신함-화면연결
	@GetMapping("/myAppList")
	public String myAppList(Model model) {
		List<UpmuDocument> myAppList = upmuService.myAppList();
		model.addAttribute("myAppList", myAppList);
		
		return "approval/myAppList";
	}
	
	//임시저장화면연결
	@GetMapping("/storageBox")
	public String storageBox() {
		return "approval/storageBox";
	}
	

	//기안하기-화면연결
	@GetMapping("/appWrite")
	public String appWrite(Model model) {
		List<UpmuDocument> docType = upmuService.getDocType();	
		model.addAttribute("docType", docType);
		
		List<Jojic> jojic = upmuService.getJojic();
		model.addAttribute("jojic", jojic);
		
		List<Jojic> team = upmuService.getTeam();
		model.addAttribute("team", team);
				
		List<StaffInfo> staff = upmuService.getStaff();
		model.addAttribute("staff", staff);
		
		return "approval/appWrite";
	}


	//출퇴근화면이동
	@GetMapping("/checkInOut")
	public String checkInOut() {
		return "upmu/checkInOut";
	}
	
	@GetMapping("/upmuShare")
	public String upmuShare() {
		
		return "upmu/upmuShare";
	}
	
	@GetMapping("/noticeBoard")
	public String noticeBoard() {
		
		return "upmu/noticeBoard";
	}

}
