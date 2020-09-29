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
	
	//index.html
	@GetMapping("/")
	public String main() {
		
		return "main/index";
	}
	
	//index2.html --> 원본 부트스트랩 화면
	@GetMapping("/index2")
	public String main2() {
		
		return "main/index2";
	}
	
	//로그인 화면
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("title", "로그인화면");
		return "main/login";
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
		return "redirect:/login";
	}
	
}
