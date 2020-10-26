package kr.or.jaegaebal.dto;

public class StaffBalryoungInfo {
	
	//발령정보 is_balryoung_info
	//balryoung_info_code, staff_num, balryoung_staff_num, balryoung_code, balryoung_date,
	//balryoung_stage, balryoung_info_notes, reg_date, balryoung_name
	
	private String balryoungInfoCode;		//발령정보 코드
	private String staffNum;				//사원번호
	private String balryoungStaffNum;		//발령 담당자or발령한 사람 사번
	private String balryoungCode;			//발령내용코드
	private String balryoungDate;			//발령일
	private String balryoungStage;			//발령지
	private String balryoungInfoNotes;		//비고
	private String regDate;					//등록일
	private String balryoungName;			//발령이름
	
	
	public String getBalryoungName() {
		return balryoungName;
	}
	public void setBalryoungName(String balryoungName) {
		this.balryoungName = balryoungName;
	}
	public String getBalryoungInfoCode() {
		return balryoungInfoCode;
	}
	public void setBalryoungInfoCode(String balryoungInfoCode) {
		this.balryoungInfoCode = balryoungInfoCode;
	}
	public String getStaffNum() {
		return staffNum;
	}
	public void setStaffNum(String staffNum) {
		this.staffNum = staffNum;
	}
	public String getBalryoungStaffNum() {
		return balryoungStaffNum;
	}
	public void setBalryoungStaffNum(String balryoungStaffNum) {
		this.balryoungStaffNum = balryoungStaffNum;
	}
	public String getBalryoungCode() {
		return balryoungCode;
	}
	public void setBalryoungCode(String balryoungCode) {
		this.balryoungCode = balryoungCode;
	}
	public String getBalryoungDate() {
		return balryoungDate;
	}
	public void setBalryoungDate(String balryoungDate) {
		this.balryoungDate = balryoungDate;
	}
	public String getBalryoungStage() {
		return balryoungStage;
	}
	public void setBalryoungStage(String balryoungStage) {
		this.balryoungStage = balryoungStage;
	}
	public String getBalryoungInfoNotes() {
		return balryoungInfoNotes;
	}
	public void setBalryoungInfoNotes(String balryoungInfoNotes) {
		this.balryoungInfoNotes = balryoungInfoNotes;
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
		builder.append("StaffBalryoungInfo [balryoungInfoCode=");
		builder.append(balryoungInfoCode);
		builder.append(", staffNum=");
		builder.append(staffNum);
		builder.append(", balryoungStaffNum=");
		builder.append(balryoungStaffNum);
		builder.append(", balryoungCode=");
		builder.append(balryoungCode);
		builder.append(", balryoungDate=");
		builder.append(balryoungDate);
		builder.append(", balryoungStage=");
		builder.append(balryoungStage);
		builder.append(", balryoungInfoNotes=");
		builder.append(balryoungInfoNotes);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", balryoungName=");
		builder.append(balryoungName);
		builder.append("]");
		return builder.toString();
	}
	
	
}
