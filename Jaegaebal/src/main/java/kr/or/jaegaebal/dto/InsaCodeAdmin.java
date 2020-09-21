package kr.or.jaegaebal.dto;

public class InsaCodeAdmin {
	private String insaCode;
	private String insaName;
	private String insaStaffName;
	private String insaRegDate;
	
	public String getInsaCode() {
		return insaCode;
	}
	public void setInsaCode(String insaCode) {
		this.insaCode = insaCode;
	}
	public String getInsaName() {
		return insaName;
	}
	public void setInsaName(String insaName) {
		this.insaName = insaName;
	}
	public String getInsaStaffName() {
		return insaStaffName;
	}
	public void setInsaStaffName(String insaStaffName) {
		this.insaStaffName = insaStaffName;
	}
	public String getInsaRegDate() {
		return insaRegDate;
	}
	public void setInsaRegDate(String insaRegDate) {
		this.insaRegDate = insaRegDate;
	}
	
	@Override
	public String toString() {
		return "InsaCodeAdmin [insaCode=" + insaCode + ", insaName=" + insaName + ", insaStaffName=" + insaStaffName
				+ ", insaRegDate=" + insaRegDate + "]";
	}
	
}
	
	
