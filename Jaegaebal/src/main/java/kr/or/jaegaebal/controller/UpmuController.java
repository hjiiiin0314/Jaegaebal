package kr.or.jaegaebal.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger  log = LoggerFactory.getLogger(UpmuController.class);
	

	//결재처리함 화면이동
	@GetMapping("/decideBox")
	public String decideBox() {
		return "approval/decideBox";
	}
	
	//문서상세보기
	@GetMapping("/docDetail")
	public String docDetail(Model model
							, @RequestParam(value = "docCode",required = false)String docCode) {		
		List<UpmuDocument> getAppLine = upmuService.getAppLine(docCode);		
		model.addAttribute("getAppLine", getAppLine);
				
		List<UpmuDocument> docDetail = upmuService.docDetail(docCode);
		model.addAttribute("docDetail", docDetail);
				
		return "approval/docDetail";
	}
	
	
	
	//반려/회수함화면연결
	@GetMapping("/retrievalBox")
	public @ResponseBody String retrievalBox() {
		return "approval/retrievalBox";
	}
	
	//상신함 검색리스트
	@PostMapping(value="/myAppList", produces = "application/json")
	public @ResponseBody List<UpmuDocument>searchAppList(@RequestParam(value = "sk")String sk
														,@RequestParam(value = "sv")String sv
														){			
		List<UpmuDocument> searchAppList = upmuService.searchAppList(sk,sv);
			
		return searchAppList;		
	
	}
		
	//상신함-화면연결- 전체리스트조회
	@GetMapping("/myAppList")
	public String myAppList(Model model) {
		List<UpmuDocument> myAppList = upmuService.myAppList();
		model.addAttribute("myAppList", myAppList);
		
		return "approval/myAppList";
	}
	
	//임시저장 - 삭제
	@GetMapping("/delStorage")
	public String delStorage( @RequestParam(value = "docCode",required = false)String docCode) {		
		upmuService.delStorage(docCode);
		return "redirect:/storageBox";
	}
	
	//임시저장 - 검색조건 리스트
	@PostMapping("/storageBox")
	public String storageBox(Model model
			,@RequestParam(value = "sk",required = false)String sk
			,@RequestParam(value = "sv", required = false)String sv) {

		
		if(sk != null && !"".equals(sk) 
				&& sv != null && !"".equals(sv)){
			List<UpmuDocument> storageBox = upmuService.storageBox(sk,sv);
			model.addAttribute("storageBox",storageBox);

		}else {
				List<UpmuDocument> storageBox = upmuService.storageBox();
				model.addAttribute("storageBox",storageBox);
		
		}
		return "approval/storageBox";
		
	}
	
	//임시저장화면연결 - 전체리스트 조회
	@GetMapping("/storageBox")
	public String storageBox(Model model) {		
		List<UpmuDocument> storageBox = upmuService.storageBox();
		model.addAttribute("storageBox", storageBox);
		
		return "approval/storageBox";
	}
	
	//기안하기 - db에 값 저장
	@PostMapping("/appWrite")
	public String appWrite(UpmuDocument upmuDocument
							,@RequestParam(value = "jojicCode",required = false)String[] jojicCode
							,@RequestParam(value = "staffLevelCode",required = false)String[] staffLevelCode
							,@RequestParam(value = "staffNum",required = false)String[] staffNum) {
		
		upmuService.appWrite(upmuDocument,jojicCode,staffLevelCode,staffNum);
		
		return "redirect:/myAppList";
	}
	//기안하기 - 결재라인선택 후  db에 넣기
	@PostMapping("/choiceStaff")
	public String choiceStaff() {
					
		return "redirect:/appWrite";
	}
	

	//기안하기-화면연결
	@GetMapping("/appWrite")
	public String appWrite(Model model) {
		
		List<Map<String, Object>> docType = upmuService.getDocType();	
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
