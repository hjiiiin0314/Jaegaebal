package kr.or.jaegaebal.dto;

public class MilitaryInfo {
	
	//병역정보 is_military_info
	//military_info_code, staff_num, military_service_type, military_state, military_in_day, military_out_day, 
	//military_level, military_info_notes, reg_staff_name, reg_date

	private String militaryInfoCode;		//사원 병역정보 코드
	private String militaryServiceType;		//군종
	private String militaryState;			//상태 (전역or예비군)
	private String militaryInDay;			//입대일자
	private String militaryOutDay;			//전역일자
	private String militaryLevel;			//계급
	private String militaryInfoNotes;		//비고
	private String staffNum;				//사원번호
	private String regStaffName;			//등록자
	private String regDate;					//등록일
	public String getMilitaryInfoCode() {
		return militaryInfoCode;
	}
	public void setMilitaryInfoCode(String militaryInfoCode) {
		this.militaryInfoCode = militaryInfoCode;
	}
	public String getMilitaryServiceType() {
		return militaryServiceType;
	}
	public void setMilitaryServiceType(String militaryServiceType) {
		this.militaryServiceType = militaryServiceType;
	}
	public String getMilitaryState() {
		return militaryState;
	}
	public void setMilitaryState(String militaryState) {
		this.militaryState = militaryState;
	}
	public String getMilitaryInDay() {
		return militaryInDay;
	}
	public void setMilitaryInDay(String militaryInDay) {
		this.militaryInDay = militaryInDay;
	}
	public String getMilitaryOutDay() {
		return militaryOutDay;
	}
	public void setMilitaryOutDay(String militaryOutDay) {
		this.militaryOutDay = militaryOutDay;
	}
	public String getMilitaryLevel() {
		return militaryLevel;
	}
	public void setMilitaryLevel(String militaryLevel) {
		this.militaryLevel = militaryLevel;
	}
	public String getMilitaryInfoNotes() {
		return militaryInfoNotes;
	}
	public void setMilitaryInfoNotes(String militaryInfoNotes) {
		this.militaryInfoNotes = militaryInfoNotes;
	}
	public String getStaffNum() {
		return staffNum;
	}
	public void setStaffNum(String staffNum) {
		this.staffNum = staffNum;
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
		builder.append("MilitaryInfo [militaryInfoCode=");
		builder.append(militaryInfoCode);
		builder.append(", militaryServiceType=");
		builder.append(militaryServiceType);
		builder.append(", militaryState=");
		builder.append(militaryState);
		builder.append(", militaryInDay=");
		builder.append(militaryInDay);
		builder.append(", militaryOutDay=");
		builder.append(militaryOutDay);
		builder.append(", militaryLevel=");
		builder.append(militaryLevel);
		builder.append(", militaryInfoNotes=");
		builder.append(militaryInfoNotes);
		builder.append(", staffNum=");
		builder.append(staffNum);
		builder.append(", regStaffName=");
		builder.append(regStaffName);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append("]");
		return builder.toString();
	}
	
}
