package kr.or.jaegaebal.dto;

public class Holiday {
	
	public String hdCode;
	public String regStaffName;
	public String hdName;
	public String hdStartDay;
	public String hdEndDay;
	public String hdContents;
	public String hdRegDate;
	
	public String getHdCode() {
		return hdCode;
	}
	public void setHdCode(String hdCode) {
		this.hdCode = hdCode;
	}
	public String getRegStaffName() {
		return regStaffName;
	}
	public void setRegStaffName(String regStaffName) {
		this.regStaffName = regStaffName;
	}
	public String getHdName() {
		return hdName;
	}
	public void setHdName(String hdName) {
		this.hdName = hdName;
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
	public String getHdContents() {
		return hdContents;
	}
	public void setHdContents(String hdContents) {
		this.hdContents = hdContents;
	}
	public String getHdRegDate() {
		return hdRegDate;
	}
	public void setHdRegDate(String hdRegDate) {
		this.hdRegDate = hdRegDate;
	}
	
	@Override
	public String toString() {
		return "Holiday [hdCode=" + hdCode + ", regStaffName=" + regStaffName + ", hdName=" + hdName + ", hdStartDay="
				+ hdStartDay + ", hdEndDay=" + hdEndDay + ", hdContents=" + hdContents + ", hdRegDate=" + hdRegDate
				+ "]";
	}
	
	
	
}
