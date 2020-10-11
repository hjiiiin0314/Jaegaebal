package kr.or.jaegaebal.dto;

public class CareerInfoFromOut {

	//사외경력정보 is_career_info_from_out
	//career_info_from_out_code, staff_num, company_name, company_access, company_position_from_out, company_work_form_out, company_in_date_from_out,
	//company_out_date_from_out, company_out_reason, career_info_from_out_notes, reg_staff_name, reg_date
	
	private String careerInfoFromOutCode;	//사외경력정보 코드
	private String staffNum;				//사원번호
	private String companyName;				//직장명	
	private String companyAccess;			//직위
	private String companyPositionFromOut;	//직책
	private String companyWorkFormOut;		//직무
	private String companyInDateFromOut;	//입사일자
	private String companyOutDateFromOut;	//퇴사일자
	private String companyOutReason;		//퇴직사유
	private String careerInfoFromOutNotes;	//비고	
	private String regDate;					//등록일
	private String staffNotes;				//비고
	public String getCareerInfoFromOutCode() {
		return careerInfoFromOutCode;
	}
	public void setCareerInfoFromOutCode(String careerInfoFromOutCode) {
		this.careerInfoFromOutCode = careerInfoFromOutCode;
	}
	public String getStaffNum() {
		return staffNum;
	}
	public void setStaffNum(String staffNum) {
		this.staffNum = staffNum;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAccess() {
		return companyAccess;
	}
	public void setCompanyAccess(String companyAccess) {
		this.companyAccess = companyAccess;
	}
	public String getCompanyPositionFromOut() {
		return companyPositionFromOut;
	}
	public void setCompanyPositionFromOut(String companyPositionFromOut) {
		this.companyPositionFromOut = companyPositionFromOut;
	}
	public String getCompanyWorkFormOut() {
		return companyWorkFormOut;
	}
	public void setCompanyWorkFormOut(String companyWorkFormOut) {
		this.companyWorkFormOut = companyWorkFormOut;
	}
	public String getCompanyInDateFromOut() {
		return companyInDateFromOut;
	}
	public void setCompanyInDateFromOut(String companyInDateFromOut) {
		this.companyInDateFromOut = companyInDateFromOut;
	}
	public String getCompanyOutDateFromOut() {
		return companyOutDateFromOut;
	}
	public void setCompanyOutDateFromOut(String companyOutDateFromOut) {
		this.companyOutDateFromOut = companyOutDateFromOut;
	}
	public String getCompanyOutReason() {
		return companyOutReason;
	}
	public void setCompanyOutReason(String companyOutReason) {
		this.companyOutReason = companyOutReason;
	}
	public String getCareerInfoFromOutNotes() {
		return careerInfoFromOutNotes;
	}
	public void setCareerInfoFromOutNotes(String careerInfoFromOutNotes) {
		this.careerInfoFromOutNotes = careerInfoFromOutNotes;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getStaffNotes() {
		return staffNotes;
	}
	public void setStaffNotes(String staffNotes) {
		this.staffNotes = staffNotes;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CareerInfoFromOut [careerInfoFromOutCode=");
		builder.append(careerInfoFromOutCode);
		builder.append(", staffNum=");
		builder.append(staffNum);
		builder.append(", companyName=");
		builder.append(companyName);
		builder.append(", companyAccess=");
		builder.append(companyAccess);
		builder.append(", companyPositionFromOut=");
		builder.append(companyPositionFromOut);
		builder.append(", companyWorkFormOut=");
		builder.append(companyWorkFormOut);
		builder.append(", companyInDateFromOut=");
		builder.append(companyInDateFromOut);
		builder.append(", companyOutDateFromOut=");
		builder.append(companyOutDateFromOut);
		builder.append(", companyOutReason=");
		builder.append(companyOutReason);
		builder.append(", careerInfoFromOutNotes=");
		builder.append(careerInfoFromOutNotes);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", staffNotes=");
		builder.append(staffNotes);
		builder.append("]");
		return builder.toString();
	}
	
	
}
