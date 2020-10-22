package kr.or.jaegaebal.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.jaegaebal.dto.StaffInfo;
import kr.or.jaegaebal.service.LoginService;



/**
 * 메인화면
 * @author ECS
 *
 */
@Controller
public class MainController {
	
	
	private static final Logger log = LoggerFactory.getLogger(MainController.class);

	@Autowired LoginService loginService;
	
	/*
	 * //index.html
	 * 
	 * @GetMapping("/") public String main(Model model) {
	 * model.addAttribute("title", "로그인화면"); 
	 * return "main/login"; 
	 * }
	 */
	
	//index2.html --> 원본 부트스트랩 화면
	@GetMapping("/index")
	public String main(HttpSession httpsession
			,Model model) {
		String setUrl = "main/index";
		if(httpsession.getAttribute("SSTAFFNUM") == null) {
			setUrl = "main/login";
			model.addAttribute("title", "로그인화면");
		} else {
			model.addAttribute("title", "메인화면");
		}
		return setUrl;
	}
	
	//로그인 화면
	@GetMapping("/")
	public String login(HttpSession httpsession
					,Model model) {
		model.addAttribute("title", "로그인화면");
		String setUrl = "main/login";
		if(httpsession.getAttribute("SSTAFFNUM") != null) {
			setUrl = "main/index";
			model.addAttribute("title", "메인화면");
		} else {
			model.addAttribute("title", "로그인화면");
		}
		return setUrl;
	}
	
	@PostMapping(value = "/staffLogin", produces = "application/json")
	@ResponseBody
	public int login(@RequestParam(value="staffNum") String staffNum,
							@RequestParam(value="staffPw") String staffPw,
							HttpSession httpsession
							) {
		
		StaffInfo staffInfo = loginService.staffLogin(staffNum, staffPw);		
		
		int result = 0;
		if(staffInfo != null) {
			if(httpsession.getAttribute("SSTAFFNUM") == null) {		
				httpsession.setAttribute("SSTAFFNUM", staffInfo.getStaffNum());
				httpsession.setAttribute("SSTAFFNAME", staffInfo.getStaffName());
				httpsession.setAttribute("SJOJICNAME", staffInfo.getJojicName());
				httpsession.setAttribute("SJOJICCODE", staffInfo.getJojicCode());

			}
			
			result = 1;
		}
		
		return result;
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session,Model model) {
		session.invalidate();
		model.addAttribute("title", "로그인화면");
		return "redirect:/";
	}
	
	//익스플로러로 접근 시 화면
	@GetMapping("/error/ie_block")
	public String ieBlock(Model model) {
		model.addAttribute("title", "Chrome 최적화 페이지입니다.");
		return "/error/ie_block";
	}
}
