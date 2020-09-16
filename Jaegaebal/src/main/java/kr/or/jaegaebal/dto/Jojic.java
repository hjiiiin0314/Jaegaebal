package kr.or.jaegaebal.dto;

public class Jojic {

	//컬럼명
	//jojic_code, jojic_name, jojic_sosoc_name, parent_jojic_name, jojic_manager_name,
	//reg_staff_name, reg_date, jojic_status
	
	private String jojicCode;			//조직코드
	private String jojicName;			//조직명
	private String jojicSosocName;		//조직소속명
	private String parentJojicName;		//조직소속부서명
	private String jojicManagerName;	//조직담당자명
	private String regStaffName;		//등록자명
	private String regDate;				//등록일
	private String jojicStatus;			//조직활성상태
	
	
	public String getJojicCode() {
		return jojicCode;
	}
	public void setJojicCode(String jojicCode) {
		this.jojicCode = jojicCode;
	}
	public String getJojicName() {
		return jojicName;
	}
	public void setJojicName(String jojicName) {
		this.jojicName = jojicName;
	}
	public String getJojicSosocName() {
		return jojicSosocName;
	}
	public void setJojicSosocName(String jojicSosocName) {
		this.jojicSosocName = jojicSosocName;
	}
	public String getParentJojicName() {
		return parentJojicName;
	}
	public void setParentJojicName(String parentJojicName) {
		this.parentJojicName = parentJojicName;
	}
	public String getJojicManagerName() {
		return jojicManagerName;
	}
	public void setJojicManagerName(String jojicManagerName) {
		this.jojicManagerName = jojicManagerName;
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
	public String getJojicStatus() {
		return jojicStatus;
	}
	public void setJojicStatus(String jojicStatus) {
		this.jojicStatus = jojicStatus;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Jojic [jojicCode=");
		builder.append(jojicCode);
		builder.append(", jojicName=");
		builder.append(jojicName);
		builder.append(", jojicSosocName=");
		builder.append(jojicSosocName);
		builder.append(", parentJojicName=");
		builder.append(parentJojicName);
		builder.append(", jojicManagerName=");
		builder.append(jojicManagerName);
		builder.append(", regStaffName=");
		builder.append(regStaffName);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", jojicStatus=");
		builder.append(jojicStatus);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
