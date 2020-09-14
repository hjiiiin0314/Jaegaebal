package kr.or.jaegaebal.dto;

public class Company {
	
	//컬럼명
	//company_code, company_name, company_eng_name, mutual_name, company_addr, company_phone, 
	//company_ceo_name, company_start_date, company_num, company_fax, reg_staff_name, reg_date
	
	private String companyCode;
	private String companyName;
	private String companyEngName;
	private String mutualName;
	private String companyAddr;
	private String companyPhone;
	private String companyCeoName;
	private String companyStartDate;
	private String companyNum;
	private String companyFax;
	private String regStaffName;
	private String regDate;
	
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyEngName() {
		return companyEngName;
	}
	public void setCompanyEngName(String companyEngName) {
		this.companyEngName = companyEngName;
	}
	public String getMutualName() {
		return mutualName;
	}
	public void setMutualName(String mutualName) {
		this.mutualName = mutualName;
	}
	public String getCompanyAddr() {
		return companyAddr;
	}
	public void setCompanyAddr(String companyAddr) {
		this.companyAddr = companyAddr;
	}
	public String getCompanyPhone() {
		return companyPhone;
	}
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	public String getCompanyCeoName() {
		return companyCeoName;
	}
	public void setCompanyCeoName(String companyCeoName) {
		this.companyCeoName = companyCeoName;
	}
	public String getCompanyStartDate() {
		return companyStartDate;
	}
	public void setCompanyStartDate(String companyStartDate) {
		this.companyStartDate = companyStartDate;
	}
	public String getCompanyNum() {
		return companyNum;
	}
	public void setCompanyNum(String companyNum) {
		this.companyNum = companyNum;
	}
	public String getCompanyFax() {
		return companyFax;
	}
	public void setCompanyFax(String companyFax) {
		this.companyFax = companyFax;
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
		builder.append("Company [companyCode=");
		builder.append(companyCode);
		builder.append(", companyName=");
		builder.append(companyName);
		builder.append(", companyEngName=");
		builder.append(companyEngName);
		builder.append(", mutualName=");
		builder.append(mutualName);
		builder.append(", companyAddr=");
		builder.append(companyAddr);
		builder.append(", companyPhone=");
		builder.append(companyPhone);
		builder.append(", companyCeoName=");
		builder.append(companyCeoName);
		builder.append(", companyStartDate=");
		builder.append(companyStartDate);
		builder.append(", companyNum=");
		builder.append(companyNum);
		builder.append(", companyFax=");
		builder.append(companyFax);
		builder.append(", regStaffName=");
		builder.append(regStaffName);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append("]");
		return builder.toString();
	}

	
}
