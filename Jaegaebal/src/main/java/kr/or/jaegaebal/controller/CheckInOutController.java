package kr.or.jaegaebal.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import kr.or.jaegaebal.dto.CheckInOut;
import kr.or.jaegaebal.service.CheckInOutService;




@Controller
public class CheckInOutController {
	
	@Autowired private CheckInOutService checkInOutService;
	
	//출퇴근리스트
		
		@GetMapping("/getCheckInOutList")
		public String getCheckInOutList(Model model) {
			
			List<Map<CheckInOut, Object>> checkInOutList = checkInOutService.getCheckInOutList();
			 System.out.println("checkInOutList -> " + checkInOutList);
			 model.addAttribute("checkInOutList",checkInOutList);
			
			model.addAttribute("title","출퇴근리스트");
			
			return "upmu/checkInOutList";
		}
		
	//출근기록
		@GetMapping("/checkIn")
		public String checkIn(CheckInOut checkInOut
					,@RequestParam(value="wcCode",required = false) String wcCode
					
					
				) {
			checkInOutService.checkIn(checkInOut);
			return "redirect:/getCheckInOutList";
			
			
		         
		    }
		public static String getRemoteIP(HttpServletRequest request){
			String ip = request.getHeader("X-FORWARDED-FOR"); 
			
			//proxy 환경일 경우
			if (ip == null || ip.length() == 0) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			
			//웹로직 서버일 경우
			if (ip == null || ip.length() == 0) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			
			if (ip == null || ip.length() == 0) {
				ip = request.getRemoteAddr() ;
			}
			
			return ip;
			
		}
		
	
}
