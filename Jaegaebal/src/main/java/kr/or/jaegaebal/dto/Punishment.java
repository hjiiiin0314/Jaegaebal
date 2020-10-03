package kr.or.jaegaebal.dto;

public class Punishment {

	//징계
	//punishment_num, staff_num, punishment_code, punishment_name, given_date, punishment_reason
	//punishment_price, staff_name, salary_applied_date, punishment_notes, reg_staff_name, 
	//punishment_point, punishment_val
	
	private String punishmentNum;			//징계번호
	private String staffNum;				//사원번호
	private String punishmentCode;			//징계코드
	private String punishmentName;			//징계명
	private String givenDate;				//징계일자
	private String punishmentReason;		//징계사유
	private String punishmentPrice;			//징계금액
	private String staffName;				//이름
	private String salaryAppliedDate;		//급여반영일
	private String punishmentNotes;			//비고
	private String regStaffName;			//징계자
	private String punishmentPoint;			//징계점수
	private String punishmentVal;			//징계내용	
	private String totalPnsmtPoint;			//누적점수
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Punishment [punishmentNum=");
		builder.append(punishmentNum);
		builder.append(", staffNum=");
		builder.append(staffNum);
		builder.append(", punishmentCode=");
		builder.append(punishmentCode);
		builder.append(", punishmentName=");
		builder.append(punishmentName);
		builder.append(", givenDate=");
		builder.append(givenDate);
		builder.append(", punishmentReason=");
		builder.append(punishmentReason);
		builder.append(", punishmentPrice=");
		builder.append(punishmentPrice);
		builder.append(", staffName=");
		builder.append(staffName);
		builder.append(", salaryAppliedDate=");
		builder.append(salaryAppliedDate);
		builder.append(", punishmentNotes=");
		builder.append(punishmentNotes);
		builder.append(", regStaffName=");
		builder.append(regStaffName);
		builder.append(", punishmentPoint=");
		builder.append(punishmentPoint);
		builder.append(", punishmentVal=");
		builder.append(punishmentVal);
		builder.append(", totalPnsmtPoint=");
		builder.append(totalPnsmtPoint);
		builder.append("]");
		return builder.toString();
	}
	
	public String getTotalPnsmtPoint() {
		return totalPnsmtPoint;
	}

	public void setTotalPnsmtPoint(String totalPnsmtPoint) {
		this.totalPnsmtPoint = totalPnsmtPoint;
	}

	public String getPunishmentNum() {
		return punishmentNum;
	}
	public void setPunishmentNum(String punishmentNum) {
		this.punishmentNum = punishmentNum;
	}
	public String getStaffNum() {
		return staffNum;
	}
	public void setStaffNum(String staffNum) {
		this.staffNum = staffNum;
	}
	public String getPunishmentCode() {
		return punishmentCode;
	}
	public void setPunishmentCode(String punishmentCode) {
		this.punishmentCode = punishmentCode;
	}
	public String getPunishmentName() {
		return punishmentName;
	}
	public void setPunishmentName(String punishmentName) {
		this.punishmentName = punishmentName;
	}
	public String getGivenDate() {
		return givenDate;
	}
	public void setGivenDate(String givenDate) {
		this.givenDate = givenDate;
	}
	public String getPunishmentReason() {
		return punishmentReason;
	}
	public void setPunishmentReason(String punishmentReason) {
		this.punishmentReason = punishmentReason;
	}
	public String getPunishmentPrice() {
		return punishmentPrice;
	}
	public void setPunishmentPrice(String punishmentPrice) {
		this.punishmentPrice = punishmentPrice;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getSalaryAppliedDate() {
		return salaryAppliedDate;
	}
	public void setSalaryAppliedDate(String salaryAppliedDate) {
		this.salaryAppliedDate = salaryAppliedDate;
	}
	public String getPunishmentNotes() {
		return punishmentNotes;
	}
	public void setPunishmentNotes(String punishmentNotes) {
		this.punishmentNotes = punishmentNotes;
	}
	public String getRegStaffName() {
		return regStaffName;
	}
	public void setRegStaffName(String regStaffName) {
		this.regStaffName = regStaffName;
	}
	public String getPunishmentPoint() {
		return punishmentPoint;
	}
	public void setPunishmentPoint(String punishmentPoint) {
		this.punishmentPoint = punishmentPoint;
	}
	public String getPunishmentVal() {
		return punishmentVal;
	}
	public void setPunishmentVal(String punishmentVal) {
		this.punishmentVal = punishmentVal;
	}

}
