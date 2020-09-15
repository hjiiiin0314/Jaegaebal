package kr.or.jaegaebal.dto;



public class CodeAdmin {
	private String workCode;
	private String workName;
	private String workUseOrNot;
	private String workStaffName;
	private String workRegDate;
	public String getWorkCode() {
		return workCode;
	}
	public void setWorkCode(String workCode) {
		this.workCode = workCode;
	}
	public String getWorkName() {
		return workName;
	}
	public void setWorkName(String workName) {
		this.workName = workName;
	}
	public String getWorkUseOrNot() {
		return workUseOrNot;
	}
	public void setWorkUseOrNot(String workUseOrNot) {
		this.workUseOrNot = workUseOrNot;
	}
	public String getWorkStaffName() {
		return workStaffName;
	}
	public void setWorkStaffName(String workStaffName) {
		this.workStaffName = workStaffName;
	}
	public String getWorkRegDate() {
		return workRegDate;
	}
	public void setWorkRegDate(String workRegDate) {
		this.workRegDate = workRegDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CodeAdmin [workCode=");
		builder.append(workCode);
		builder.append(", workName=");
		builder.append(workName);
		builder.append(", workUseOrNot=");
		builder.append(workUseOrNot);
		builder.append(", workStaffName=");
		builder.append(workStaffName);
		builder.append(", workRegDate=");
		builder.append(workRegDate);
		builder.append("]");
		return builder.toString();
	}
	
	
}
