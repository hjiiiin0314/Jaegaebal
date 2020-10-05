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
import kr.or.jaegaebal.service.ApprovalService;

/**
 * 담당자 : 장현지
 * @author ECS
 *
 */
@Controller
public class ApprovalController {
	@Autowired private ApprovalService approvalService;
	private static final Logger  log = LoggerFactory.getLogger(ApprovalController.class);
	
	//결재처리함 - 결재하기 
	@PostMapping("/appDecide")
	public String appDecide(UpmuDocument appDecide) {
		approvalService.appDecide(appDecide);
	
		return "redirect:/decideBox";
	}
	

	//결재처리함 화면이동 - 결재처리문서리스트 
	@GetMapping("/decideBox")
	public String decideBox(Model model
							) {
		List<UpmuDocument> decideList = approvalService.decideList();
		model.addAttribute("decideList", decideList);

		return "approval/decideBox";
	}
	
	//문서상세보기
	@GetMapping("/docDetail")
	public String docDetail(Model model
							, @RequestParam(value = "docCode",required = false)String docCode) {		
		List<UpmuDocument> getAppLine = approvalService.getAppLine(docCode);		
		model.addAttribute("getAppLine", getAppLine);
				
		List<UpmuDocument> docDetail = approvalService.docDetail(docCode);
		model.addAttribute("docDetail", docDetail);
				
		return "approval/docDetail";
	}
	
	
	
	//반려/회수함화면연결
	@GetMapping("/retrievalBox")
	public @ResponseBody String retrievalBox() {
		return "approval/retrievalBox";
	}
	
	//상신함 검색리스트
	@PostMapping("/myAppList")
	public String searchAppList(Model model
								,@RequestParam(value = "sk", required = false)String sk
								,@RequestParam(value = "sv", required = false)String sv){	
	
		if(sk != null && !"".equals(sk) 
				&& sv != null && !"".equals(sv)){
			List<UpmuDocument> myAppList = approvalService.searchAppList(sk,sv);
			model.addAttribute("myAppList", myAppList);
		}else {
			List<UpmuDocument> myAppList = approvalService.myAppList();
			model.addAttribute("myAppList", myAppList);
		}	
		return "approval/myAppList";		
	
	}
		
	//상신함-화면연결- 전체리스트조회
	@GetMapping("/myAppList")
	public String myAppList(Model model) {
		List<UpmuDocument> myAppList = approvalService.myAppList();
		model.addAttribute("myAppList", myAppList);
		
		return "approval/myAppList";
	}
	
	//임시저장 - 삭제
	@GetMapping("/delStorage")
	public String delStorage( @RequestParam(value = "docCode",required = false)String docCode) {		
		approvalService.delStorage(docCode);
		return "redirect:/storageBox";
	}
	
	//임시저장 - 검색조건 리스트
	@PostMapping("/storageBox")
	public String storageBox(Model model
			,@RequestParam(value = "sk",required = false)String sk
			,@RequestParam(value = "sv", required = false)String sv) {

		
		if(sk != null && !"".equals(sk) 
				&& sv != null && !"".equals(sv)){
			List<UpmuDocument> storageBox = approvalService.storageBox(sk,sv);
			model.addAttribute("storageBox",storageBox);

		}else {
				List<UpmuDocument> storageBox = approvalService.storageBox();
				model.addAttribute("storageBox",storageBox);
		
		}
		return "approval/storageBox";
		
	}
	
	//임시저장화면연결 - 전체리스트 조회
	@GetMapping("/storageBox")
	public String storageBox(Model model) {		
		List<UpmuDocument> storageBox = approvalService.storageBox();
		model.addAttribute("storageBox", storageBox);
		
		return "approval/storageBox";
	}
	
	//기안하기 - 임시저장
	@PostMapping(value = "/addSotorage", produces = "application/json")
	@ResponseBody
	public int addStorage(UpmuDocument storageDoc
						,@RequestParam(value = "jojicCode",required = false)String[] jojicCode
						,@RequestParam(value = "staffLevelCode",required = false)String[] staffLevelCode
						,@RequestParam(value = "staffNum",required = false)String[] staffNum) {
			
		int	result = approvalService.addStorage(storageDoc, jojicCode, staffLevelCode, staffNum);
		
		return result;
	}
	
	//기안하기 - 결재올리기
	@PostMapping("/appWrite")
	public String appWrite(UpmuDocument upmuDocument
							,@RequestParam(value = "jojicCode",required = false)String[] jojicCode
							,@RequestParam(value = "staffLevelCode",required = false)String[] staffLevelCode
							,@RequestParam(value = "staffNum",required = false)String[] staffNum) {
		
		approvalService.appWrite(upmuDocument,jojicCode,staffLevelCode,staffNum);
		
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
		
		List<Map<String, Object>> docType = approvalService.getDocType();	
		model.addAttribute("docType", docType);
		
		List<Jojic> jojic = approvalService.getJojic();
		model.addAttribute("jojic", jojic);
		
		List<Jojic> team = approvalService.getTeam();
		model.addAttribute("team", team);
				
		List<StaffInfo> staff = approvalService.getStaff();
		model.addAttribute("staff", staff);
		
		return "approval/appWrite";
	}



}