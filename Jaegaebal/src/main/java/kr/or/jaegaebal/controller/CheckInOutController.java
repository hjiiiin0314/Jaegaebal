package kr.or.jaegaebal.controller;

import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
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
					,@RequestParam(value="staffNum",required = false) String staffNum
					,@RequestParam(value="wcInIp",required = false) String wcInIp
					,HttpServletRequest request
				) {
			String ipIn = request.getRemoteAddr();
			
			System.out.println("ipIn::::"+ipIn);
			checkInOut.setStaffNum(staffNum);
			checkInOut.setWcInIp(ipIn);
			checkInOutService.checkIn(checkInOut);
			
			return "redirect:/getCheckInOutList";
			
		         
		    }
		
	//퇴근기록
		@GetMapping("/checkOut")
		public String checkOut(CheckInOut checkInOut
				,@RequestParam(value="staffNum",required = false) String wcCode
				,@RequestParam(value="staffNum",required = false) String wcOutIp
				,HttpServletRequest request
				) {
			String ipOut = request.getRemoteAddr();
			
			System.out.println("ipOut::::"+ipOut);
			System.out.println(checkInOut);
			checkInOut.setWcOutIp(ipOut);
			checkInOutService.checkOut(checkInOut);
			return "redirect:/getCheckInOutList";
			
		}
		
		
	
		
	
}
