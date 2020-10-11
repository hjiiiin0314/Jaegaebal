package kr.or.jaegaebal.dto;

public class CareerInfoFromIn {

	//사내경력정보 is_career_info_from_in
	//career_info_from_in_code, staff_num, project_name, project_start_date, project_end_date, project_access,
	//project_level_name, project_work, project_position, career_info_from_in_notes, reg_staff_name, reg_date
	
	private String careerInfoFromInCode;	//사내경력정보 코드
	private String staffNum;				//사원번호
	private String projectName;				//맡았던 프로젝트명
	private String projectStartDate;		//프로젝트 시작일
	private String projectEndDate;			//프로젝트 종료일
	private String projectAccess;			//프로젝트 도중 권한
	private String projectLevelName;		//프로젝트 도중 직책
	private String projectWork;				//프로젝트 도중 직무
	private String projectPosition;			//프로젝트 도중 직책
	private String careerInfoFromInNotes;	//비고
	private String regStaffName;			//등록자
	private String regDate;					//등록일
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CareerInfoFromIn [careerInfoFromInCode=");
		builder.append(careerInfoFromInCode);
		builder.append(", staffNum=");
		builder.append(staffNum);
		builder.append(", projectName=");
		builder.append(projectName);
		builder.append(", projectStartDate=");
		builder.append(projectStartDate);
		builder.append(", projectEndDate=");
		builder.append(projectEndDate);
		builder.append(", projectAccess=");
		builder.append(projectAccess);
		builder.append(", projectLevelName=");
		builder.append(projectLevelName);
		builder.append(", projectWork=");
		builder.append(projectWork);
		builder.append(", projectPosition=");
		builder.append(projectPosition);
		builder.append(", careerInfoFromInNotes=");
		builder.append(careerInfoFromInNotes);
		builder.append(", regStaffName=");
		builder.append(regStaffName);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append("]");
		return builder.toString();
	}
	public String getCareerInfoFromInCode() {
		return careerInfoFromInCode;
	}
	public void setCareerInfoFromInCode(String careerInfoFromInCode) {
		this.careerInfoFromInCode = careerInfoFromInCode;
	}
	public String getStaffNum() {
		return staffNum;
	}
	public void setStaffNum(String staffNum) {
		this.staffNum = staffNum;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectStartDate() {
		return projectStartDate;
	}
	public void setProjectStartDate(String projectStartDate) {
		this.projectStartDate = projectStartDate;
	}
	public String getProjectEndDate() {
		return projectEndDate;
	}
	public void setProjectEndDate(String projectEndDate) {
		this.projectEndDate = projectEndDate;
	}
	public String getProjectAccess() {
		return projectAccess;
	}
	public void setProjectAccess(String projectAccess) {
		this.projectAccess = projectAccess;
	}
	public String getProjectLevelName() {
		return projectLevelName;
	}
	public void setProjectLevelName(String projectLevelName) {
		this.projectLevelName = projectLevelName;
	}
	public String getProjectWork() {
		return projectWork;
	}
	public void setProjectWork(String projectWork) {
		this.projectWork = projectWork;
	}
	public String getProjectPosition() {
		return projectPosition;
	}
	public void setProjectPosition(String projectPosition) {
		this.projectPosition = projectPosition;
	}
	public String getCareerInfoFromInNotes() {
		return careerInfoFromInNotes;
	}
	public void setCareerInfoFromInNotes(String careerInfoFromInNotes) {
		this.careerInfoFromInNotes = careerInfoFromInNotes;
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
	
	
}
