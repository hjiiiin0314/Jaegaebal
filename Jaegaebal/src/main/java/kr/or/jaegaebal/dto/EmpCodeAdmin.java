package kr.or.jaegaebal.dto;

public class EmpCodeAdmin {
	public String empCode;
	public String empType;
	public String empSalaryType;
	public String empAttri;
	public String empStartDate;
	public String empStaffName;
	public String empRegDate;
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getEmpType() {
		return empType;
	}
	public void setEmpType(String empType) {
		this.empType = empType;
	}
	public String getEmpSalaryType() {
		return empSalaryType;
	}
	public void setEmpSalaryType(String empSalaryType) {
		this.empSalaryType = empSalaryType;
	}
	public String getEmpAttri() {
		return empAttri;
	}
	public void setEmpAttri(String empAttri) {
		this.empAttri = empAttri;
	}
	public String getEmpStartDate() {
		return empStartDate;
	}
	public void setEmpStartDate(String empStartDate) {
		this.empStartDate = empStartDate;
	}
	public String getEmpStaffName() {
		return empStaffName;
	}
	public void setEmpStaffName(String empStaffName) {
		this.empStaffName = empStaffName;
	}
	public String getEmpRegDate() {
		return empRegDate;
	}
	public void setEmpRegDate(String empRegDate) {
		this.empRegDate = empRegDate;
	}
	@Override
	public String toString() {
		return "EmpCodeAdmin [empCode=" + empCode + ", empType=" + empType + ", empSalaryType=" + empSalaryType
				+ ", empAttri=" + empAttri + ", empStartDate=" + empStartDate + ", empStaffName=" + empStaffName
				+ ", empRegDate=" + empRegDate + "]";
	}
	
	
	
}
