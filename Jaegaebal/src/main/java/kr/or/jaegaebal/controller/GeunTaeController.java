package kr.or.jaegaebal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.jaegaebal.dto.Holiday;
import kr.or.jaegaebal.service.GeunTaeService;

@Controller
public class GeunTaeController {
	
	@Autowired private GeunTaeService geunTaeService;
	
	
	
	
	//휴일 리스트
	
	@GetMapping("/holidayList")
	public String fullCalendar(Model model) {
		model.addAttribute("title","휴일 관리");
		return "geuntae/holidayList";
	}
	
	//calendar ajax
		@PostMapping(value="/fullCalendar",produces = "application/json")
		@ResponseBody
		public List<Map<String, Object>> fullCalendar(){
			List<Map<String, Object>> javaMap1 = geunTaeService.getHolidayList();
			return javaMap1;
		}
	
	
	//휴일등록
	@PostMapping("/addHdCode")
	public String addInsaCode(Holiday holiday
			,@RequestParam(value="hdCode",required = false) String hdCode
			,@RequestParam(value="hdName",required = false) String hdName
			,@RequestParam(value="hdStartDay",required = false) String hdStartDay
			,@RequestParam(value="hdEndDay",required = false) String hdEndDay
			,@RequestParam(value="hdContents",required = false) String hdContents
			) {
		
		geunTaeService.addHdCode(holiday);
		return "redirect:/holidayList";
	}
	
			
	
}
