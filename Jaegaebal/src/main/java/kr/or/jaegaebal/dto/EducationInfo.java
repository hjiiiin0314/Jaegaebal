package kr.or.jaegaebal.dto;

public class EducationInfo {

	
	//학력정보 is_education_info
	// education_info_code, staff_num, school_name, hakryuck_status, major_name, minor_name, entrance_date,
	//graduat_date, degree, education_info_notes, reg_staff_name, reg_date

	private String educationInfoCode;		//사원 학력정보 코드
	private String schoolName;				//학교명
	private String hakryuckStatus;			//상태 (졸업or재학중or휴학)
	private String majorName;				//전공
	private String minorName;				//부전공
	private String entranceDate;			//입학일
	private String graduatDate;				//졸업일
	private String degree;					//학위
	private String educationInfoNotes;		//비고	
	private String staffNum;				//사원번호	
	private String regDate;					//등록일
	private String staffNotes;				//비고
	public String getEducationInfoCode() {
		return educationInfoCode;
	}
	public void setEducationInfoCode(String educationInfoCode) {
		this.educationInfoCode = educationInfoCode;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getHakryuckStatus() {
		return hakryuckStatus;
	}
	public void setHakryuckStatus(String hakryuckStatus) {
		this.hakryuckStatus = hakryuckStatus;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public String getMinorName() {
		return minorName;
	}
	public void setMinorName(String minorName) {
		this.minorName = minorName;
	}
	public String getEntranceDate() {
		return entranceDate;
	}
	public void setEntranceDate(String entranceDate) {
		this.entranceDate = entranceDate;
	}
	public String getGraduatDate() {
		return graduatDate;
	}
	public void setGraduatDate(String graduatDate) {
		this.graduatDate = graduatDate;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getEducationInfoNotes() {
		return educationInfoNotes;
	}
	public void setEducationInfoNotes(String educationInfoNotes) {
		this.educationInfoNotes = educationInfoNotes;
	}
	public String getStaffNum() {
		return staffNum;
	}
	public void setStaffNum(String staffNum) {
		this.staffNum = staffNum;
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
		builder.append("EducationInfo [educationInfoCode=");
		builder.append(educationInfoCode);
		builder.append(", schoolName=");
		builder.append(schoolName);
		builder.append(", hakryuckStatus=");
		builder.append(hakryuckStatus);
		builder.append(", majorName=");
		builder.append(majorName);
		builder.append(", minorName=");
		builder.append(minorName);
		builder.append(", entranceDate=");
		builder.append(entranceDate);
		builder.append(", graduatDate=");
		builder.append(graduatDate);
		builder.append(", degree=");
		builder.append(degree);
		builder.append(", educationInfoNotes=");
		builder.append(educationInfoNotes);
		builder.append(", staffNum=");
		builder.append(staffNum);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", staffNotes=");
		builder.append(staffNotes);
		builder.append("]");
		return builder.toString();
	}
	
}
