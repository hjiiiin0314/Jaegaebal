package kr.or.jaegaebal.dto;

public class StaffInfo {

	/* 컬럼명 */
	//사원 is_staff
	//staff_num, jojic_code, access_num, staff_level_code, staff_position_code, hobong, staff_basic_salary, staff_pw,
	//staff_name, staff_status_code, employment_status, company_in_date, company_out_date, reg_staff_name, reg_date
	
	//인적정보 is_staff_basic_info
	//basic_info_code, staff_eng_name, human_num, staff_gender, staff_nationality, staff_country,
	//staff_phone, staff_email, staff_marriged, staff_addr
	
	//가족정보 is_staff_family_info
	//family_info_code, relation, family_name, family_birthday, family_job, family_addr, family_phone
	
	//발령정보 is_balryoung_info
	//balryoung_info_code, balryoung_staff_num, balryoung_code, balryoung_date, balryoung_stage, notes
	
	//사내경력정보 is_career_info_from_in
	//career_info_from_in_code, project_name, project_start_date, project_end_date, project_access,
	//project_level_name, project_work, project_position
	
	//사외경력정보 is_career_info_from_out
	//career_info_from_out_code, company_name, company_access,company_position_from_out, company_work_form_out
	//company_in_date_from_out, company_out_date_from_out, company_out_reason
	
	//자격증정보 is_certificate_info
	//certificate_info_code, certificate_name, issuing_agency, certificate_num, get_date, finished_date
	
	//학력정보 is_education_info
	//education_info_code, school_name, hakryuck_status, major_name, minor_name, entrance_date, graduat_date, degree
	
	//병력정보 is_military_info
	//military_info_code, military_service_type, military_state
	//military_in_day,  military_out_day, military_level
	
	/*다른 테이블에서 외래키로 가져온 컬럼명*/
	//level_name, position_name, jojic_name, jaejic_status_name, access_name, position_code
	
	private String staffNum;				//사원번호
	private String jojicCode;				//소속
	private String accessNum;				//권한레벨	
	private String staffLevelCode;			//직급코드
	private String staffPositionCode;		//직책코드
	private String hobong;					//호봉
	private String staffBasicSalary;		//기본급
	private String staffPw;					//비밀번호
	private String staffName;				//이름
	private String staffStatusCode;			//재직상태코드
	private String employmentStatus;		//고용상태
	private String companyInDate;			//입사일
	private String companyOutDate;			//퇴사일
	private String regStaffName;			//등록자
	private String regDate;					//등록일
	
	private String basicInfoCode;			//인적사항코드
	private String staffEngName;			//영문명
	private String humanNum;				//주민등록번호
	private String staffGender;				//성별(여or남) sql타입 char에요
	private String staffNationality;		//내외국인
	private String staffCountry;			//국적
	private String staffPhone;			
	private String staffEmail;
	private String staffMarriged;			//결혼여부
	private String staffAddr;
	
	private String familyInfoCode;			//사원 가족정보 코드
	private String relation;				//가족관계
	private String familyName;
	private String familyBirthday;			//가족 생년월일
	private String familyJob;
	private String familyAddr;
	private String familyPhone;
	
	private String balryoungInfoCode;		//발령정보 코드
	private String balryoungStaffNum;		//발령 담당자or발령한 사람 사번
	private String balryoungCode;			//발령내용코드
	private String balryoungDate;			//발령일
	private String balryoungStage;			//발령지
	private String notes;					//비고
	
	private String careerInfoFromInCode;	//사내경력정보 코드
	private String projectName;				//맡았던 프로젝트명
	private String projectStartDate;		//프로젝트 시작일
	private String projectEndDate;			//프로젝트 종료일
	private String projectAccess;			//프로젝트 도중 권한
	private String projectLevelName;		//프로젝트 도중 직책
	private String projectWork;				//프로젝트 도중 직무
	private String projectPosition;			//프로젝트 도중 직책
	
	private String careerInfoFromOutCode;	//사외경력정보 코드
	private String companyName;				//직장명	
	private String companyAccess;			//직위
	private String companyPositionFromOut;	//직책
	private String companyWorkFormOut;		//직무
	private String companyInDateFromOut;	//입사일자
	private String companyOutDateFromOut;	//퇴사일자
	private String companyOutReason;		//퇴직사유

	private String certificateInfoCode;		//사원 자격증정보 코드
	private String certificateName;			//자격증명
	private String issuingAgency;			//발급기관
	private String certificateNum;			//자격번호
	private String getDate;					//취득일
	private String finishedDate;			//만료일
	
	private String educationInfoCode;		//사원 학력정보 코드
	private String schoolName;				//학교명
	private String hakryuckStatus;			//상태 (졸업or재학중or휴학)
	private String majorName;				//전공
	private String minorName;				//부전공
	private String entranceDate;			//입학일
	private String graduatDate;				//졸업일
	private String degree;					//학위
	
	private String militaryInfoCode;		//사원 병력정보 코드
	private String militaryServiceType;		//군종
	private String militaryState;			//상태 (전역or예비군)
	private String militaryInDay;			//입대일자
	private String militaryOutDay;			//전역일자
	private String militaryLevel;			//계급
	
	/*추가된것들*/
	private String levelName;				//직급명
	private String positionName;			//직책명
	private String jojicName;				//소속명
	private String jaejicStatusName;		//재직상태
	private String jojicSosocName;			//소속이름
	private String accessName;				//권한명
	private String positionCode;			//직책코드
	
	
	@Override
	public String toString() {
		return "StaffInfo [staffNum=" + staffNum + ", jojicCode=" + jojicCode + ", accessNum=" + accessNum
				+ ", staffLevelCode=" + staffLevelCode + ", staffPositionCode=" + staffPositionCode + ", hobong="
				+ hobong + ", staffBasicSalary=" + staffBasicSalary + ", staffPw=" + staffPw + ", staffName="
				+ staffName + ", staffStatusCode=" + staffStatusCode + ", employmentStatus=" + employmentStatus
				+ ", companyInDate=" + companyInDate + ", companyOutDate=" + companyOutDate + ", regStaffName="
				+ regStaffName + ", regDate=" + regDate + ", basicInfoCode=" + basicInfoCode + ", staffEngName="
				+ staffEngName + ", humanNum=" + humanNum + ", staffGender=" + staffGender + ", staffNationality="
				+ staffNationality + ", staffCountry=" + staffCountry + ", staffPhone=" + staffPhone + ", staffEmail="
				+ staffEmail + ", staffMarriged=" + staffMarriged + ", staffAddr=" + staffAddr + ", familyInfoCode="
				+ familyInfoCode + ", relation=" + relation + ", familyName=" + familyName + ", familyBirthday="
				+ familyBirthday + ", familyJob=" + familyJob + ", familyAddr=" + familyAddr + ", familyPhone="
				+ familyPhone + ", balryoungInfoCode=" + balryoungInfoCode + ", balryoungStaffNum=" + balryoungStaffNum
				+ ", balryoungCode=" + balryoungCode + ", balryoungDate=" + balryoungDate + ", balryoungStage="
				+ balryoungStage + ", notes=" + notes + ", careerInfoFromInCode=" + careerInfoFromInCode
				+ ", projectName=" + projectName + ", projectStartDate=" + projectStartDate + ", projectEndDate="
				+ projectEndDate + ", projectAccess=" + projectAccess + ", projectLevelName=" + projectLevelName
				+ ", projectWork=" + projectWork + ", projectPosition=" + projectPosition + ", careerInfoFromOutCode="
				+ careerInfoFromOutCode + ", companyName=" + companyName + ", companyAccess=" + companyAccess
				+ ", companyPositionFromOut=" + companyPositionFromOut + ", companyWorkFormOut=" + companyWorkFormOut
				+ ", companyInDateFromOut=" + companyInDateFromOut + ", companyOutDateFromOut=" + companyOutDateFromOut
				+ ", companyOutReason=" + companyOutReason + ", certificateInfoCode=" + certificateInfoCode
				+ ", certificateName=" + certificateName + ", issuingAgency=" + issuingAgency + ", certificateNum="
				+ certificateNum + ", getDate=" + getDate + ", finishedDate=" + finishedDate + ", educationInfoCode="
				+ educationInfoCode + ", schoolName=" + schoolName + ", hakryuckStatus=" + hakryuckStatus
				+ ", majorName=" + majorName + ", minorName=" + minorName + ", entranceDate=" + entranceDate
				+ ", graduatDate=" + graduatDate + ", degree=" + degree + ", militaryInfoCode=" + militaryInfoCode
				+ ", militaryServiceType=" + militaryServiceType + ", militaryState=" + militaryState
				+ ", militaryInDay=" + militaryInDay + ", militaryOutDay=" + militaryOutDay + ", militaryLevel="
				+ militaryLevel + ", levelName=" + levelName + ", positionName=" + positionName + ", jojicName="
				+ jojicName + ", jaejicStatusName=" + jaejicStatusName + ", jojicSosocName=" + jojicSosocName
				+ ", accessName=" + accessName + ", positionCode=" + positionCode + "]";
	}
	public String getStaffNum() {
		return staffNum;
	}
	public void setStaffNum(String staffNum) {
		this.staffNum = staffNum;
	}
	public String getJojicCode() {
		return jojicCode;
	}
	public void setJojicCode(String jojicCode) {
		this.jojicCode = jojicCode;
	}
	public String getAccessNum() {
		return accessNum;
	}
	public void setAccessNum(String accessNum) {
		this.accessNum = accessNum;
	}
	public String getStaffLevelCode() {
		return staffLevelCode;
	}
	public void setStaffLevelCode(String staffLevelCode) {
		this.staffLevelCode = staffLevelCode;
	}
	public String getStaffPositionCode() {
		return staffPositionCode;
	}
	public void setStaffPositionCode(String staffPositionCode) {
		this.staffPositionCode = staffPositionCode;
	}
	public String getHobong() {
		return hobong;
	}
	public void setHobong(String hobong) {
		this.hobong = hobong;
	}
	public String getStaffBasicSalary() {
		return staffBasicSalary;
	}
	public void setStaffBasicSalary(String staffBasicSalary) {
		this.staffBasicSalary = staffBasicSalary;
	}
	public String getStaffPw() {
		return staffPw;
	}
	public void setStaffPw(String staffPw) {
		this.staffPw = staffPw;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffStatusCode() {
		return staffStatusCode;
	}
	public void setStaffStatusCode(String staffStatusCode) {
		this.staffStatusCode = staffStatusCode;
	}
	public String getEmploymentStatus() {
		return employmentStatus;
	}
	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}
	public String getCompanyInDate() {
		return companyInDate;
	}
	public void setCompanyInDate(String companyInDate) {
		this.companyInDate = companyInDate;
	}
	public String getCompanyOutDate() {
		return companyOutDate;
	}
	public void setCompanyOutDate(String companyOutDate) {
		this.companyOutDate = companyOutDate;
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
	public String getBasicInfoCode() {
		return basicInfoCode;
	}
	public void setBasicInfoCode(String basicInfoCode) {
		this.basicInfoCode = basicInfoCode;
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
	public String getFamilyInfoCode() {
		return familyInfoCode;
	}
	public void setFamilyInfoCode(String familyInfoCode) {
		this.familyInfoCode = familyInfoCode;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getFamilyBirthday() {
		return familyBirthday;
	}
	public void setFamilyBirthday(String familyBirthday) {
		this.familyBirthday = familyBirthday;
	}
	public String getFamilyJob() {
		return familyJob;
	}
	public void setFamilyJob(String familyJob) {
		this.familyJob = familyJob;
	}
	public String getFamilyAddr() {
		return familyAddr;
	}
	public void setFamilyAddr(String familyAddr) {
		this.familyAddr = familyAddr;
	}
	public String getFamilyPhone() {
		return familyPhone;
	}
	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	}
	public String getBalryoungInfoCode() {
		return balryoungInfoCode;
	}
	public void setBalryoungInfoCode(String balryoungInfoCode) {
		this.balryoungInfoCode = balryoungInfoCode;
	}
	public String getBalryoungStaffNum() {
		return balryoungStaffNum;
	}
	public void setBalryoungStaffNum(String balryoungStaffNum) {
		this.balryoungStaffNum = balryoungStaffNum;
	}
	public String getBalryoungCode() {
		return balryoungCode;
	}
	public void setBalryoungCode(String balryoungCode) {
		this.balryoungCode = balryoungCode;
	}
	public String getBalryoungDate() {
		return balryoungDate;
	}
	public void setBalryoungDate(String balryoungDate) {
		this.balryoungDate = balryoungDate;
	}
	public String getBalryoungStage() {
		return balryoungStage;
	}
	public void setBalryoungStage(String balryoungStage) {
		this.balryoungStage = balryoungStage;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getCareerInfoFromInCode() {
		return careerInfoFromInCode;
	}
	public void setCareerInfoFromInCode(String careerInfoFromInCode) {
		this.careerInfoFromInCode = careerInfoFromInCode;
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
	public String getCareerInfoFromOutCode() {
		return careerInfoFromOutCode;
	}
	public void setCareerInfoFromOutCode(String careerInfoFromOutCode) {
		this.careerInfoFromOutCode = careerInfoFromOutCode;
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
	public String getCertificateInfoCode() {
		return certificateInfoCode;
	}
	public void setCertificateInfoCode(String certificateInfoCode) {
		this.certificateInfoCode = certificateInfoCode;
	}
	public String getCertificateName() {
		return certificateName;
	}
	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}
	public String getIssuingAgency() {
		return issuingAgency;
	}
	public void setIssuingAgency(String issuingAgency) {
		this.issuingAgency = issuingAgency;
	}
	public String getCertificateNum() {
		return certificateNum;
	}
	public void setCertificateNum(String certificateNum) {
		this.certificateNum = certificateNum;
	}
	public String getGetDate() {
		return getDate;
	}
	public void setGetDate(String getDate) {
		this.getDate = getDate;
	}
	public String getFinishedDate() {
		return finishedDate;
	}
	public void setFinishedDate(String finishedDate) {
		this.finishedDate = finishedDate;
	}
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
	public String getMilitaryInfoCode() {
		return militaryInfoCode;
	}
	public void setMilitaryInfoCode(String militaryInfoCode) {
		this.militaryInfoCode = militaryInfoCode;
	}
	public String getMilitaryServiceType() {
		return militaryServiceType;
	}
	public void setMilitaryServiceType(String militaryServiceType) {
		this.militaryServiceType = militaryServiceType;
	}
	public String getMilitaryState() {
		return militaryState;
	}
	public void setMilitaryState(String militaryState) {
		this.militaryState = militaryState;
	}
	public String getMilitaryInDay() {
		return militaryInDay;
	}
	public void setMilitaryInDay(String militaryInDay) {
		this.militaryInDay = militaryInDay;
	}
	public String getMilitaryOutDay() {
		return militaryOutDay;
	}
	public void setMilitaryOutDay(String militaryOutDay) {
		this.militaryOutDay = militaryOutDay;
	}
	public String getMilitaryLevel() {
		return militaryLevel;
	}
	public void setMilitaryLevel(String militaryLevel) {
		this.militaryLevel = militaryLevel;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public String getJojicName() {
		return jojicName;
	}
	public void setJojicName(String jojicName) {
		this.jojicName = jojicName;
	}
	public String getJaejicStatusName() {
		return jaejicStatusName;
	}
	public void setJaejicStatusName(String jaejicStatusName) {
		this.jaejicStatusName = jaejicStatusName;
	}
	public String getJojicSosocName() {
		return jojicSosocName;
	}
	public void setJojicSosocName(String jojicSosocName) {
		this.jojicSosocName = jojicSosocName;
	}
	public String getAccessName() {
		return accessName;
	}
	public void setAccessName(String accessName) {
		this.accessName = accessName;
	}
	public String getPositionCode() {
		return positionCode;
	}
	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	

	
	
}
