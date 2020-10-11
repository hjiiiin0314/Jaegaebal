package kr.or.jaegaebal.dto;

public class StaffBasicInfo {
	
	//인적정보 is_staff_basic_info
	//basic_info_code, staff_num, staff_eng_name, human_num, staff_gender, staff_nationality, staff_country,
	//staff_phone, staff_email, staff_marriged, staff_addr, staff_basic_info_notes, reg_staff_name, reg_date
	
	private String basicInfoCode;			//인적사항코드
	private String staffNum;				//사원번호
	private String staffEngName;			//영문명
	private String humanNum;				//주민등록번호
	private String staffGender;				//성별(여or남) sql타입 char에요
	private String staffNationality;		//내외국인
	private String staffCountry;			//국적
	private String staffPhone;			
	private String staffEmail;
	private String staffMarriged;			//결혼여부
	private String staffAddr;
	private String staffBasicInfoNotes;		//비고
	private String regStaffName;			//등록자
	private String regDate;					//등록일
	public String getBasicInfoCode() {
		return basicInfoCode;
	}
	public void setBasicInfoCode(String basicInfoCode) {
		this.basicInfoCode = basicInfoCode;
	}
	public String getStaffNum() {
		return staffNum;
	}
	public void setStaffNum(String staffNum) {
		this.staffNum = staffNum;
	}
	public String getStaffEngName() {
		return staffEngName;
	}
	public void setStaffEngName(String staffEngName) {
		this.staffEngName = staffEngName;
	}
	public String getHumanNum() {
		return humanNum;
	}
	public void setHumanNum(String humanNum) {
		this.humanNum = humanNum;
	}
	public String getStaffGender() {
		return staffGender;
	}
	public void setStaffGender(String staffGender) {
		this.staffGender = staffGender;
	}
	public String getStaffNationality() {
		return staffNationality;
	}
	public void setStaffNationality(String staffNationality) {
		this.staffNationality = staffNationality;
	}
	public String getStaffCountry() {
		return staffCountry;
	}
	public void setStaffCountry(String staffCountry) {
		this.staffCountry = staffCountry;
	}
	public String getStaffPhone() {
		return staffPhone;
	}
	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}
	public String getStaffEmail() {
		return staffEmail;
	}
	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}
	public String getStaffMarriged() {
		return staffMarriged;
	}
	public void setStaffMarriged(String staffMarriged) {
		this.staffMarriged = staffMarriged;
	}
	public String getStaffAddr() {
		return staffAddr;
	}
	public void setStaffAddr(String staffAddr) {
		this.staffAddr = staffAddr;
	}
	public String getStaffBasicInfoNotes() {
		return staffBasicInfoNotes;
	}
	public void setStaffBasicInfoNotes(String staffBasicInfoNotes) {
		this.staffBasicInfoNotes = staffBasicInfoNotes;
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
		builder.append("StaffBasicInfo [basicInfoCode=");
		builder.append(basicInfoCode);
		builder.append(", staffNum=");
		builder.append(staffNum);
		builder.append(", staffEngName=");
		builder.append(staffEngName);
		builder.append(", humanNum=");
		builder.append(humanNum);
		builder.append(", staffGender=");
		builder.append(staffGender);
		builder.append(", staffNationality=");
		builder.append(staffNationality);
		builder.append(", staffCountry=");
		builder.append(staffCountry);
		builder.append(", staffPhone=");
		builder.append(staffPhone);
		builder.append(", staffEmail=");
		builder.append(staffEmail);
		builder.append(", staffMarriged=");
		builder.append(staffMarriged);
		builder.append(", staffAddr=");
		builder.append(staffAddr);
		builder.append(", staffBasicInfoNotes=");
		builder.append(staffBasicInfoNotes);
		builder.append(", regStaffName=");
		builder.append(regStaffName);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append("]");
		return builder.toString();
	}
	
	
}
