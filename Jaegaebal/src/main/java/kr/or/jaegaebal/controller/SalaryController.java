package kr.or.jaegaebal.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.jaegaebal.dto.SalaryInfo;
import kr.or.jaegaebal.dto.SalaryRecord;
import kr.or.jaegaebal.dto.StaffInfo;
import kr.or.jaegaebal.service.SalaryService;


/**
 * 담당자 : 이요셉
 * @author ECS
 *
 */
@Controller
public class SalaryController {
	@Autowired
	private SalaryService salaryService;
	
	//월별급여현황화면
	@GetMapping("/salary/salary_month")
	public String salaryMonth(Model model) {
		List<Map<StaffInfo,Object>> staffInfoList = salaryService.getSalaryStaffList();
		List<Map<String, Object>> levelList = salaryService.getLevelList();
		List<Map<String, Object>> jojicList = salaryService.getJojicList();
		List<Map<String, Object>> yearList = salaryService.getFilterYear();
		String searchYear = (String) yearList.get(0).get("getYear");
		String dataNum = (String) staffInfoList.get(0).get("dataNum");
		List<Map<String,Object>> monthSalList = salaryService.getMonthSalList(searchYear, dataNum);
		model.addAttribute("dataNum", dataNum);
		model.addAttribute("yearList", yearList);
		model.addAttribute("levelList", levelList);
		model.addAttribute("jojicList", jojicList);
		model.addAttribute("staffInfoList", staffInfoList);
		model.addAttribute("monthSalList", monthSalList);
		return "salary/salary_month";
	}
	
	//급상여입력 insert, update 처리
	@PostMapping("/salary/salary_record")
	public String salaryRecord(SalaryRecord salaryRecord, String[] payName, String[] payPrice, String[] deductName, String[] deductPrice) {
		String sqlKey = salaryRecord.getSqlKey();
		//항목과 금액을 &로 묶어 저장
		//지급항목
		if(payName != null) {
			String addPay = "";
			for(int i=0;i<payName.length;i++) {
				addPay = payName[i];
				if(i>0) {
					addPay += "&" + payName[i];
				}
			}
			salaryRecord.setDataAddpay(addPay);
		}
		if(payPrice != null) {
			int sumPay = 0;
			String pricePay = "";
			for(int i=0;i<payPrice.length;i++) {
				pricePay = payPrice[i];
				sumPay += Integer.parseInt(payPrice[i]);
				if(i>0) {
					pricePay += "&" + payPrice[i];
				}
			}
			salaryRecord.setDataPricepay(pricePay);
			salaryRecord.setDataSumpay(sumPay);
		}
		
		//공제항목
		if(deductName != null) {
			String addDeduct = "";
			for(int i=0;i<deductName.length;i++) {
				addDeduct = deductName[i];
				if(i>0) {
					addDeduct += "&" + deductName[i];
				}
			}
			salaryRecord.setDataAdddeduct(addDeduct);
		}
		if(deductPrice != null) {
			int sumDeduct = 0;
			String priceDeduct = "";
			for(int i=0;i<deductPrice.length;i++) {
				priceDeduct = deductPrice[i];
				sumDeduct += Integer.parseInt(deductPrice[i]);
				if(i>0) {
					priceDeduct += "&" + deductPrice[i];
				}
			}
			salaryRecord.setDataPricededuct(priceDeduct);
			salaryRecord.setDataSumdeduct(sumDeduct);
		}
		if(sqlKey == "ins") {
			
		} else if (sqlKey == "upd") {
			
		}
		return "redirect:/salary/salary_record";
	}
	
	//급상여입력화면
	@GetMapping("/salary/salary_record")
	public String salaryRecord(Model model) {
		List<Map<StaffInfo,Object>> staffInfoList = salaryService.getSalaryStaffList();
		String dataNum = (String) staffInfoList.get(0).get("dataNum");
		String sqlKey = null;
		//현재 년월 가져오기
		SimpleDateFormat format1 = new SimpleDateFormat ("yyyy-MM");	
		Date time = new Date();
		String searchDate = format1.format(time);
		SalaryRecord salaryRecord = salaryService.getSelMonthData(dataNum, searchDate);
		//조회된 값이 없었다면 화면에서 저장할 때 insert 조회된 값이 있었다면 update 처리
		if(salaryRecord == null) {
			salaryRecord = new SalaryRecord();
			sqlKey = "ins";
		} else {
			sqlKey = "upd";
		}
		salaryRecord.setSqlKey(sqlKey);
		//이미 있는 데이터일 시(update) 기존 데이터 출력, 아닐 시(insert) 설정에 저장된 부가 지급 공제 데이터로 입력할 수 있도록 세팅
		if(sqlKey.equals("ins")){
			List<Map<String, Object>> listPayMap = salaryService.getAddPay();
			List<Map<String, Object>> listDeductMap = salaryService.getAddDeduct();
			model.addAttribute("listDeductMap", listDeductMap);
			model.addAttribute("listPayMap", listPayMap);
		}
		if(sqlKey.equals("upd")){
			//지급현황 배열로 만들어 테이블로 출력
			String[] addpayArray = null;
			String[] pricepayArray = null;
			String Addpay = salaryRecord.getDataAddpay();
			if(Addpay != null) {
				addpayArray = Addpay.split("&");
			}
			String Pricepay = salaryRecord.getDataPricepay();
			if(Pricepay != null) {
				pricepayArray = Pricepay.split("&");
			}
			Map<String, Object> payMap = null;
			List<Map<String, Object>> listPayMap = new ArrayList<Map<String, Object>>();
			if(Addpay != null) {
				for(int i=0;i<addpayArray.length;i++) {
					payMap = new HashMap<String, Object>();
					payMap.put("addpay", addpayArray[i]);
					payMap.put("pricepay", pricepayArray[i]);
					listPayMap.add(payMap);
				}
			}
			//공제현황 배열로 만들어 테이블로 출력
			String[] adddeductArray = null;
			String[] pricedeductArray = null;
			String Adddeduct = salaryRecord.getDataAdddeduct();
			if(Adddeduct != null) {
				adddeductArray = Adddeduct.split("&");
			}
			String Pricededuct = salaryRecord.getDataPricededuct();
			if(Pricededuct != null) {
				pricedeductArray = Pricededuct.split("&");
			}
			Map<String, Object> deductMap = null;
			List<Map<String, Object>> listDeductMap = new ArrayList<Map<String, Object>>();
			if(Adddeduct != null) {
				for(int i=0;i<adddeductArray.length;i++) {
					deductMap = new HashMap<String, Object>();
					deductMap.put("adddeduct", adddeductArray[i]);
					deductMap.put("pricededuct", pricedeductArray[i]);
					listDeductMap.add(deductMap);
				}
			}
			model.addAttribute("listDeductMap", listDeductMap);
			model.addAttribute("listPayMap", listPayMap);
		}
		SalaryInfo salaryInfo = salaryService.salaryInfo();
		List<Map<String, Object>> levelList = salaryService.getLevelList();
		List<Map<String, Object>> jojicList = salaryService.getJojicList();
		model.addAttribute("dataNum", dataNum);
		model.addAttribute("salaryRecord", salaryRecord);
		model.addAttribute("levelList", levelList);
		model.addAttribute("jojicList", jojicList);
		model.addAttribute("staffInfoList", staffInfoList);
		model.addAttribute("salaryInfo", salaryInfo);
		return "salary/salary_record";
	}
	
	//급여기본정보화면
	@GetMapping("/salary/salary_info")
	public String salaryInfo(Model model) {
		List<Map<StaffInfo,Object>> staffInfoList = salaryService.getSalaryStaffList();
		SalaryInfo salaryInfo = salaryService.salaryInfo();
		List<Map<String, Object>> levelList = salaryService.getLevelList();
		List<Map<String, Object>> jojicList = salaryService.getJojicList();
		model.addAttribute("levelList", levelList);
		model.addAttribute("jojicList", jojicList);
		model.addAttribute("staffInfoList", staffInfoList);
		model.addAttribute("salaryInfo", salaryInfo);
		return "salary/salary_info";
	}
	
	//급여기본정보화면 수정처리
	@PostMapping("/salary/salary_info")
	public String salaryInfo(SalaryInfo salaryInfo) {
		System.out.println(salaryInfo);
		int result = salaryService.updateSalaryInfo(salaryInfo);
		
		System.out.println(result + " <- 급여정보수정 처리 결과");
		return "redirect:/salary/salary_info";
	}
	
	//ajax시 기존데이터가 없는 insert처리상태일 때 부가지급, 부가공제 항목을 불러오기 위한 ajax조회
	@PostMapping(value = "/salary/insert_data", produces = "application/json")
	@ResponseBody
	public List<List<Map<String, Object>>> insertData() {
		List<Map<String, Object>> listPayMap = salaryService.getAddPay();
		List<Map<String, Object>> listDeductMap = salaryService.getAddDeduct();
		List<List<Map<String, Object>>> ajaxList = new ArrayList<List<Map<String, Object>>>();
		ajaxList.add(listPayMap);
		ajaxList.add(listDeductMap);
		return ajaxList;
	}
	
	//기준년월 선택 시 해당 년월에 데이터가 있는지 ajax조회
	@PostMapping(value = "/salary/search_data", produces = "application/json")
	@ResponseBody
	public SalaryRecord searchData(@RequestParam(value = "dataNum", required = false) String dataNum
								,@RequestParam(value = "searchDate", required = false) String searchDate) {
		String sqlKey = null;
		SalaryRecord salaryRecord = salaryService.getSelMonthData(dataNum, searchDate);
		//조회된 값이 없었다면 화면에서 저장할 때 insert 처리 값이 있었다면 update 처리
		if(salaryRecord == null) {
			salaryRecord = new SalaryRecord();
			sqlKey = "ins";
		} else {
			sqlKey = "upd";
		}
		salaryRecord.setSqlKey(sqlKey);
		return salaryRecord;
	}
	
	//사원정보 클릭 시 급여 ajax조회
	@PostMapping(value = "/salary/salary_info", produces = "application/json")
	@ResponseBody
	public Map<String, Object> salaryInfo(@RequestParam(value = "dataEmp", required = false) String dataEmp) {
		Map<String, Object> salaryInfo = salaryService.salaryInfoMap(dataEmp);
		return salaryInfo;
	}
	
	//사원정보 클릭 시, 귀속연도 선택 시 월별급여 ajax조회
	@PostMapping(value = "/salary/salary_month", produces = "application/json")
	@ResponseBody
	public List<Map<String,Object>> salaryMonth(@RequestParam(value = "dataNum", required = false) String dataNum
								,@RequestParam(value = "searchYear", required = false) String searchYear) {
		List<Map<String,Object>> monthSalList = salaryService.getMonthSalList(searchYear, dataNum);
		return monthSalList;
	}
	
	//사원정보 검색 ajax조회
	@PostMapping(value = "/salary/salary_search", produces = "application/json")
	@ResponseBody
	public List<Map<String, Object>> salaryInfo(@RequestParam(value = "ajaxArray[]", required = false) String[] ajaxArray) {
		String searchCate = ajaxArray[0];
		String searchText = ajaxArray[1];
		String searchLevel = ajaxArray[2];
		String searchJojic = ajaxArray[3];
		List<Map<String, Object>> staffList = salaryService.getStaffListMap(searchCate, searchText, searchLevel, searchJojic);
		System.out.println(staffList);
		return staffList;
	}
}
