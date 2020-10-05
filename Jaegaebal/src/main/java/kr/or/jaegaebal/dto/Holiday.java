package kr.or.jaegaebal.dto;

public class Holiday {
	
	public String hdCode;
	public String companyCode;
	public String hdStartDay;
	public String hdName;
	public String hdEndDay;
	public String regStaffName;
	public String hdRegDate;
	
	public String getHdName() {
		return hdName;
	}
	public void setHdName(String hdName) {
		this.hdName = hdName;
	}
	public String getHdCode() {
		return hdCode;
	}
	public void setHdCode(String hdCode) {
		this.hdCode = hdCode;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getHdStartDay() {
		return hdStartDay;
	}
	public void setHdStartDay(String hdStartDay) {
		this.hdStartDay = hdStartDay;
	}
	public String getHdEndDay() {
		return hdEndDay;
	}
	public void setHdEndDay(String hdEndDay) {
		this.hdEndDay = hdEndDay;
	}
	public String getRegStaffName() {
		return regStaffName;
	}
	public void setRegStaffName(String regStaffName) {
		this.regStaffName = regStaffName;
	}
	public String getHdRegDate() {
		return hdRegDate;
	}
	public void setHdRegDate(String hdRegDate) {
		this.hdRegDate = hdRegDate;
	}
	
	@Override
	public String toString() {
		return "Holiday [hdCode=" + hdCode + ", companyCode=" + companyCode + ", hdStartDay=" + hdStartDay + ", hdName="
				+ hdName + ", hdEndDay=" + hdEndDay + ", regStaffName=" + regStaffName + ", hdRegDate=" + hdRegDate
				+ "]";
	}
	
	
	
	
}
