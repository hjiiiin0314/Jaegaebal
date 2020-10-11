package kr.or.jaegaebal.dto;

public class StaffFamilyInfo {

	//인적정보 is_staff_basic_info
	//family_info_code, staff_num, relation, family_name, family_birthday, family_job, family_addr,
	//family_phone, staff_family_info_notes, reg_staff_name, reg_date
	
	private String familyInfoCode;			//사원 가족정보 코드
	private String staffNum;				//사원번호
	private String relation;				//가족관계
	private String familyName;
	private String familyBirthday;			//가족 생년월일
	private String familyJob;
	private String familyAddr;
	private String familyPhone;
	private String staffFamilyInfoNotes;	//비고
	private String regStaffName;			//등록자
	private String regDate;					//등록일
	public String getFamilyInfoCode() {
		return familyInfoCode;
	}
	public void setFamilyInfoCode(String familyInfoCode) {
		this.familyInfoCode = familyInfoCode;
	}
	public String getStaffNum() {
		return staffNum;
	}
	public void setStaffNum(String staffNum) {
		this.staffNum = staffNum;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getFamilyBirthday() {
		return familyBirthday;
	}
	public void setFamilyBirthday(String familyBirthday) {
		this.familyBirthday = familyBirthday;
	}
	public String getFamilyJob() {
		return familyJob;
	}
	public void setFamilyJob(String familyJob) {
		this.familyJob = familyJob;
	}
	public String getFamilyAddr() {
		return familyAddr;
	}
	public void setFamilyAddr(String familyAddr) {
		this.familyAddr = familyAddr;
	}
	public String getFamilyPhone() {
		return familyPhone;
	}
	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	}
	public String getStaffFamilyInfoNotes() {
		return staffFamilyInfoNotes;
	}
	public void setStaffFamilyInfoNotes(String staffFamilyInfoNotes) {
		this.staffFamilyInfoNotes = staffFamilyInfoNotes;
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
		builder.append("StaffFamilyInfo [familyInfoCode=");
		builder.append(familyInfoCode);
		builder.append(", staffNum=");
		builder.append(staffNum);
		builder.append(", relation=");
		builder.append(relation);
		builder.append(", familyName=");
		builder.append(familyName);
		builder.append(", familyBirthday=");
		builder.append(familyBirthday);
		builder.append(", familyJob=");
		builder.append(familyJob);
		builder.append(", familyAddr=");
		builder.append(familyAddr);
		builder.append(", familyPhone=");
		builder.append(familyPhone);
		builder.append(", staffFamilyInfoNotes=");
		builder.append(staffFamilyInfoNotes);
		builder.append(", regStaffName=");
		builder.append(regStaffName);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append("]");
		return builder.toString();
	}
	
	
}
