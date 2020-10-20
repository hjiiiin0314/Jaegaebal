package kr.or.jaegaebal.dto;

public class NoticeBoard {

	private String ntCode;
	private String ntTitle;
	private String ntContents;
	private String ntFile;
	private String regStaffNum;
	private String regStaffName;
	private String regDate;
	
	
	public String getNtCode() {
		return ntCode;
	}
	public void setNtCode(String ntCode) {
		this.ntCode = ntCode;
	}
	public String getNtTitle() {
		return ntTitle;
	}
	public void setNtTitle(String ntTitle) {
		this.ntTitle = ntTitle;
	}
	public String getNtContents() {
		return ntContents;
	}
	public void setNtContents(String ntContents) {
		this.ntContents = ntContents;
	}
	public String getNtFile() {
		return ntFile;
	}
	public void setNtFile(String ntFile) {
		this.ntFile = ntFile;
	}
	public String getRegStaffNum() {
		return regStaffNum;
	}
	public void setRegStaffNum(String regStaffNum) {
		this.regStaffNum = regStaffNum;
	}
	public String getRegStaffName() {
		return regStaffName;
	}
	public void setRegStaffName(String regStaffName) {
		this.regStaffName = regStaffName;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NoticeBoard [ntCode=");
		builder.append(ntCode);
		builder.append(", ntTitle=");
		builder.append(ntTitle);
		builder.append(", ntContents=");
		builder.append(ntContents);
		builder.append(", ntFile=");
		builder.append(ntFile);
		builder.append(", regStaffNum=");
		builder.append(regStaffNum);
		builder.append(", regStaffName=");
		builder.append(regStaffName);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append("]");
		return builder.toString();
	}
}
