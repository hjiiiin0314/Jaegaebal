package kr.or.jaegaebal.dto;

public class Prize {
	
	//포상 is_prize
	//prize_code, prize_name, reg_staff_name
	
	//포상리스트 is_prize_list
	//prize_num, staff_num, given_date, prize_reason, prize_price, salary_applied_date, prize_notes
	
	//추가된 것
	//jojic_name
	
	private String prizeCode;
	private String prizeName;
	private String regStaffName;
	private String prizeNum;
	private String staffNum;
	private String givenDate;
	private String prizeReason;
	private String prizePrice;
	private String salaryAppliedDate;
	private String prizeNotes;
	private String jojicName;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Prize [prizeCode=");
		builder.append(prizeCode);
		builder.append(", prizeName=");
		builder.append(prizeName);
		builder.append(", regStaffName=");
		builder.append(regStaffName);
		builder.append(", prizeNum=");
		builder.append(prizeNum);
		builder.append(", staffNum=");
		builder.append(staffNum);
		builder.append(", givenDate=");
		builder.append(givenDate);
		builder.append(", prizeReason=");
		builder.append(prizeReason);
		builder.append(", prizePrice=");
		builder.append(prizePrice);
		builder.append(", salaryAppliedDate=");
		builder.append(salaryAppliedDate);
		builder.append(", prizeNotes=");
		builder.append(prizeNotes);
		builder.append(", jojicName=");
		builder.append(jojicName);
		builder.append("]");
		return builder.toString();
	}
	
	public String getPrizeCode() {
		return prizeCode;
	}
	public void setPrizeCode(String prizeCode) {
		this.prizeCode = prizeCode;
	}
	public String getPrizeName() {
		return prizeName;
	}
	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}
	public String getRegStaffName() {
		return regStaffName;
	}
	public void setRegStaffName(String regStaffName) {
		this.regStaffName = regStaffName;
	}
	public String getPrizeNum() {
		return prizeNum;
	}
	public void setPrizeNum(String prizeNum) {
		this.prizeNum = prizeNum;
	}
	public String getStaffNum() {
		return staffNum;
	}
	public void setStaffNum(String staffNum) {
		this.staffNum = staffNum;
	}
	public String getGivenDate() {
		return givenDate;
	}
	public void setGivenDate(String givenDate) {
		this.givenDate = givenDate;
	}
	public String getPrizeReason() {
		return prizeReason;
	}
	public void setPrizeReason(String prizeReason) {
		this.prizeReason = prizeReason;
	}
	public String getPrizePrice() {
		return prizePrice;
	}
	public void setPrizePrice(String prizePrice) {
		this.prizePrice = prizePrice;
	}
	public String getSalaryAppliedDate() {
		return salaryAppliedDate;
	}
	public void setSalaryAppliedDate(String salaryAppliedDate) {
		this.salaryAppliedDate = salaryAppliedDate;
	}
	public String getPrizeNotes() {
		return prizeNotes;
	}
	public void setPrizeNotes(String prizeNotes) {
		this.prizeNotes = prizeNotes;
	}
	public String getJojicName() {
		return jojicName;
	}
	public void setJojicName(String jojicName) {
		this.jojicName = jojicName;
	}
	
}
