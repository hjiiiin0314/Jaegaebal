package kr.or.jaegaebal.dto;

public class CheckInOut {
	private String wcCode;
	private String staffNum;
	private String wcIn;
	private String wcOut;
	private String wcHour;
	private String wcInIp;
	private String wcOutIp;
	private String wcRegDate;
	
	
	public String getStaffNum() {
		return staffNum;
	}
	public void setStaffNum(String staffNum) {
		this.staffNum = staffNum;
	}
	public String getWcHour() {
		return wcHour;
	}
	public void setWcHour(String wcHour) {
		this.wcHour = wcHour;
	}
	public String getWcCode() {
		return wcCode;
	}
	public void setWcCode(String wcCode) {
		this.wcCode = wcCode;
	}
	public String getWcIn() {
		return wcIn;
	}
	public void setWcIn(String wcIn) {
		this.wcIn = wcIn;
	}
	public String getWcOut() {
		return wcOut;
	}
	public void setWcOut(String wcOut) {
		this.wcOut = wcOut;
	}
	public String getWcInIp() {
		return wcInIp;
	}
	public void setWcInIp(String wcInIp) {
		this.wcInIp = wcInIp;
	}
	public String getWcOutIp() {
		return wcOutIp;
	}
	public void setWcOutIp(String wcOutIp) {
		this.wcOutIp = wcOutIp;
	}
	public String getWcRegDate() {
		return wcRegDate;
	}
	public void setWcRegDate(String wcRegDate) {
		this.wcRegDate = wcRegDate;
	}
	
	@Override
	public String toString() {
		return "CheckInOut [wcCode=" + wcCode + ", staffNum=" + staffNum + ", wcIn=" + wcIn + ", wcOut=" + wcOut
				+ ", wcHour=" + wcHour + ", wcInIp=" + wcInIp + ", wcOutIp=" + wcOutIp + ", wcRegDate=" + wcRegDate
				+ "]";
	}
	
	
}
