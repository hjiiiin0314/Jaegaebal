package kr.or.jaegaebal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.jaegaebal.dto.CodeAdmin;
import kr.or.jaegaebal.dto.DocCodeAdmin;
import kr.or.jaegaebal.dto.EmpCodeAdmin;
import kr.or.jaegaebal.dto.InsaCodeAdmin;
import kr.or.jaegaebal.service.CodeAdminService;



@Controller
public class CodeAdminController {
	
	
	@Autowired private CodeAdminService codeAdminService;
	
	
/* ==========고용형태코드관리========== */
	
	//고용형태코드리스트
	/* @GetMapping("/getInsaCodeList") */
	@RequestMapping(value="/getEmpCodeList", method=RequestMethod.GET)
	public String getEmpCodeList(Model model) {
		
		 List<EmpCodeAdmin> empCodeList = codeAdminService.getEmpCodeList();
		 System.out.println("empCodeList -> " + empCodeList);
		 model.addAttribute("empCodeList",empCodeList);
		
		model.addAttribute("title","코드리스트");
		
		return "codeAdmin/empCodeList";
	}
	
	//고용코드 등록
		@GetMapping("/addEmpCode")
		public String addEmpCode(Model model) {
			model.addAttribute("title","근무형태코드 추가");
			return "codeAdmin/addEmpCode";
		}
		
		@PostMapping("/addEmpCode")
		public String addEmpCode(EmpCodeAdmin empCodeAdmin
				,@RequestParam(value="empCode",required = false) String empCode
				,@RequestParam(value="empType",required = false) String empType
				,@RequestParam(value="empSalaryType",required = false) String empSalaryType
				,@RequestParam(value="empAttri",required = false) String empAttri
				,@RequestParam(value="empStartDate",required = false) String empStartDate
				) {
			System.out.println("고용코드 -> "+empCode);
			System.out.println("고용형태 -> "+empType);
			System.out.println("사원구분 -> "+empSalaryType);
			System.out.println("귀속구분 -> "+empAttri);
			System.out.println("시작일 -> "+empStartDate);
			
			codeAdminService.addEmpCode(empCodeAdmin);
			return "redirect:/getEmpCodeList";
		}
		
		//고용코드 중복확인
		@PostMapping(value = "/empCodeCheck", produces = "application/json")
		@ResponseBody
		public int empCodeCheck(@RequestParam(value="empCode") String empCode) {
			
			int result = codeAdminService.empCodeCheck(empCode);
			
			return result;
		}
		
		//고용코드 수정
		@GetMapping("/updateEmpCode")
		public String updateEmpCode(Model model
				,@RequestParam(value="empCode",required=false) String empCode) {
			EmpCodeAdmin empca = codeAdminService.getEmpCode(empCode);
			model.addAttribute("EmpCodeAdmin",empca);
			model.addAttribute("title","수정화면");
			
				return "codeAdmin/updateEmpCode";
		}
		
		@PostMapping("/updateEmpCode")
		public String updateEmpCode(EmpCodeAdmin empCodeAdmin) {
			codeAdminService.updateEmpCode(empCodeAdmin);
			return "redirect:/getEmpCodeList";
		}
		
		//코드삭제
		@GetMapping("/deleteEmpCode")
		public String deleteMember(EmpCodeAdmin empCodeAdmin) {
			if(empCodeAdmin.getEmpCode() != null && !"".equals(empCodeAdmin.getEmpCode())) {
				codeAdminService.deleteEmpCode(empCodeAdmin.getEmpCode());	
			}
			return "redirect:/getEmpCodeList";
		}
	
/* ==========문서코드관리========== */
	
	//문서코드리스트
	/* @GetMapping("/getDocCodeList") */
	@RequestMapping(value="/getDocCodeList", method=RequestMethod.GET)
	public String getDocCodeList(Model model) {
		List<DocCodeAdmin> docCodeList = codeAdminService.getDocCodeList();
		System.out.println("docCodeList -> " + docCodeList);
		model.addAttribute("docCodeList",docCodeList);
		model.addAttribute("title","코드리스트");
		
		return "codeAdmin/docCodeList";
	}
	
	
	
	//문서코드 등록
	@GetMapping("/addDocCode")
	public String addDocCode(Model model) {
		model.addAttribute("title","근무형태코드 추가");
		return "codeAdmin/addDocCode";
	}
	
	@PostMapping("/addDocCode")
	public String addDocCode(DocCodeAdmin docCodeAdmin
			,@RequestParam(value="docCode",required = false) String docCode
			,@RequestParam(value="docType",required = false) String docType
			) {
		System.out.println("문서코드 -> "+docCode);
		System.out.println("문서명 -> "+docType);
		
		codeAdminService.addDocCode(docCodeAdmin);
		return "redirect:/getDocCodeList";
	}
	
	//문서코드 중복확인
	@PostMapping(value = "/docCodeCheck", produces = "application/json")
	@ResponseBody
	public int docCodeCheck(@RequestParam(value="docCode") String docCode) {
		
		int result = codeAdminService.docCodeCheck(docCode);
		
		return result;
	}
	
	//문서코드 수정
	@GetMapping("/updateDocCode")
	public String updateDocCode(Model model
			,@RequestParam(value="docCode",required=false) String docCode) {
		DocCodeAdmin docca = codeAdminService.getDocCode(docCode);
		model.addAttribute("DocCodeAdmin",docca);
		model.addAttribute("title","수정화면");
		
			return "codeAdmin/updateDocCode";
	}
	
	@PostMapping("/updateDocCode")
	public String updateDocCode(DocCodeAdmin docCodeAdmin) {
		codeAdminService.updateDocCode(docCodeAdmin);
		return "redirect:/getDocCodeList";
	}
	
	//문서코드 삭제
	@GetMapping("/deleteDocCode")
	public String deleteMember(DocCodeAdmin docCodeAdmin) {
		if(docCodeAdmin.getDocCode() != null && !"".equals(docCodeAdmin.getDocCode())) {
			codeAdminService.deleteDocCode(docCodeAdmin.getDocCode());		
		}
		return "redirect:/getMemberList";
	}
	
	/* ==========인사코드관리========== */
	
	//인사코드리스트
	/* @GetMapping("/getInsaCodeList") */
	@RequestMapping(value="/getInsaCodeList", method=RequestMethod.GET)
	public String getInsaCodeList(Model model) {
		List<InsaCodeAdmin> insaCodeList = codeAdminService.getInsaCodeList();
		System.out.println("insaCodeList -> " + insaCodeList);
		model.addAttribute("insaCodeList",insaCodeList);
		model.addAttribute("title","코드리스트");
		
		return "codeAdmin/insaCodeList";
	}
	
	//인사코드 등록
	@GetMapping("/addInsaCode")
	public String addInsaCode(Model model) {
		model.addAttribute("title","근무형태코드 추가");
		return "codeAdmin/addInsaCode";
	}
	
	@PostMapping("/addInsaCode")
	public String addInsaCode(InsaCodeAdmin insaCodeAdmin
			,@RequestParam(value="insaCode",required = false) String insaCode
			,@RequestParam(value="insaName",required = false) String insaName
			) {
		System.out.println("근무형태코드 -> "+insaCode);
		System.out.println("근무명 -> "+insaName);
		
		codeAdminService.addInsaCode(insaCodeAdmin);
		return "redirect:/getInsaCodeList";
	}
	
	//코드 중복확인
			@PostMapping(value = "/insaCodeCheck", produces = "application/json")
			@ResponseBody
			public int insaCodeCheck(@RequestParam(value="insaCode") String insaCode) {
				
				int result = codeAdminService.insaCodeCheck(insaCode);
				
				return result;
			}
			
	//인사코드 수정
			@GetMapping("/updateInsaCode")
			public String updateInsaCode(Model model
					,@RequestParam(value="insaCode",required=false) String insaCode) {
				InsaCodeAdmin isca = codeAdminService.getInsaCode(insaCode);
				model.addAttribute("InsaCodeAdmin",isca);
				model.addAttribute("title","수정화면");
				
					return "codeAdmin/updateInsaCode";
			}
			
			@PostMapping("/updateInsaCode")
			public String updateInsaCode(InsaCodeAdmin insaCodeAdmin) {
				codeAdminService.updateInsaCode(insaCodeAdmin);
				return "redirect:/getInsaCodeList";
			}
	
	//인사코드 삭제
			@GetMapping("/deleteInsaCode")
			public String deleteMember(InsaCodeAdmin insaCodeAdmin) {
				if(insaCodeAdmin.getInsaCode() != null && !"".equals(insaCodeAdmin.getInsaCode())) {
					codeAdminService.deleteInsaCode(insaCodeAdmin.getInsaCode());	
				}
				return "redirect:/getInsaCodeList";
			}
			
	/* ==========근무형태코드관리========== */
	
	//코드검색
	@PostMapping("/searchWorkCode")
	public String searchWorkCode(@RequestParam(value="sk",required = false) String sk,
							   @RequestParam(value="sv",required = false) String sv,Model model) {
		System.out.println(sk);
		System.out.println(sv);
		List<CodeAdmin> workCodeList = codeAdminService.getSearchWorkCodeList(sk, sv);
				
		model.addAttribute("workCodeList", workCodeList);
		return "codeAdmin/getWorkCodeList";
	}
	
	//근무코드 삭제
	@GetMapping("/deleteWorkCode")
	public String deleteMember(CodeAdmin codeAdmin) {
		if(codeAdmin.getWorkCode() != null && !"".equals(codeAdmin.getWorkCode())) {
			codeAdminService.deleteWorkCode(codeAdmin.getWorkCode());	
		}
		return "redirect:/getWorkCodeList";
	}
	
	/* @GetMapping("/getWorkCodeList") */
	@RequestMapping(value="/getWorkCodeList", method=RequestMethod.GET)
	public String getWorkCodeList(Model model) {
		List<CodeAdmin> workCodeList = codeAdminService.getWorkCodeList();
		System.out.println("workCodeList -> " + workCodeList);
		model.addAttribute("workCodeList",workCodeList);
		model.addAttribute("title","코드리스트");
		return "codeAdmin/workCodeList";
	}
	
	
	@GetMapping("/addWorkCode")
	public String addWorkCode(Model model) {
		model.addAttribute("title","근무형태코드 추가");
		return "codeAdmin/addWorkCode";
	}
	
	@PostMapping("/addWorkCode")
	public String addWorkCode(CodeAdmin codeAdmin
			,@RequestParam(value="workCode",required = false) String workCode
			,@RequestParam(value="workName",required = false) String workName
			,@RequestParam(value="workUseOrNot",required = false) String workUseOrNot
			) {
		System.out.println("근무형태코드 -> "+workCode);
		System.out.println("근무명 -> "+workName);
		System.out.println("사용유무 -> "+workUseOrNot);
		codeAdminService.addWorkCode(codeAdmin);
		return "redirect:/getWorkCodeList";
	}
	
	@GetMapping("/updateWorkCode")
	public String updateWorkCode(Model model
			,@RequestParam(value="workCode",required=false) String workCode) {
		CodeAdmin ca = codeAdminService.getWorkCode(workCode);
		model.addAttribute("codeAdmin",ca);
		model.addAttribute("title","수정화면");
		
			return "codeAdmin/updateWorkCode";
	}
	
	@PostMapping("/updateWorkCode")
	public String updateWorkCode(CodeAdmin codeAdmin) {
		codeAdminService.updateWorkCode(codeAdmin);
		return "redirect:/getWorkCodeList";
	}
	
	//코드 중복확인
		@PostMapping(value = "/codeCheck", produces = "application/json")
		@ResponseBody
		public int codeCheck(@RequestParam(value="workCode") String workCode) {
			
			int result = codeAdminService.codeCheck(workCode);
			
			return result;
		}
	

}
