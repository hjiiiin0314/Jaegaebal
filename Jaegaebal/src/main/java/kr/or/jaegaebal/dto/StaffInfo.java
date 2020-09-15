package kr.or.jaegaebal.dto;

public class StaffInfo {

	/* 컬럼명 */
	//사원
	//staff_num, jojic_code, access_num, staff_level_code, staff_position, hobong, staff_basic_salary, staff_pw,
	//staff_name, staff_status, employment_status, company_in_date, company_out_date, reg_staff_name, reg_date
	
	//인적정보
	//basic_info_code, staff_eng_name, human_num, staff_gender, staff_nationality, staff_country,
	//staff_phone, staff_email, staff_marriged, staff_addr
	
	//가족정보
	//family_info_code, relation, family_name, family_birthday, family_job, family_addr, family_phone
	
	//발령정보
	//balryoung_info_code, balryoung_staff_num, balryoung_code, balryoung_date, balryoung_stage, notes
	
	//사내경력정보
	//career_info_from_in_code, project_name, project_start_date, project_end_date, project_access,
	//project_level_name, project_work, project_position
	
	//사외경력정보
	//career_info_from_out_code, company_name, company_access,
	//company_in_date_from_out, company_out_date_from_out, company_out_reason
	
	//자격증정보
	//certificate_info_code, certificate_name, issuing_agency, certificate_num, get_date, finished_date
	
	//학력정보
	//education_info_code, school_name, gakryuck_status, major_name, minor_name, entrance_date, graduat_date, degree
	
	//병력정보
	//military_info_code, military_service_type, military_state
	

	private String staffNum;
	private String jojicCode;
	private String accessNum;
	private String staffLevelCode;
	private String staffPosition;
	private String hobong;
	private String staffBasicSalary;
	private String staffPw;
	private String staffName;
	private String staffStatus;
	private String employmentStatus;
	private String companyInDate;
	private String companyOutDate;
	private String regStaffName;
	private String regDate;
	
	private String basicInfoCode;
	private String staffEngName;
	private String humanNum;
	private String staffGender;
	private String staffNationality;
	private String staffCountry;
	private String staffPhone;
	private String staffEmail;
	private String staffMarriged;
	private String staffAddr;
	
	private String familyInfoCode;
	private String relation;
	private String familyName;
	private String familyBirthday;
	private String familyJob;
	private String familyAddr;
	private String familyPhone;
	
	private String balryoungInfoCode;
	private String balryoungStaffNum;
	private String balryoungCode;
	private String balryoungDate;
	private String balryoungStage;
	private String notes;
	
	private String careerInfoFromInCode;
	private String projectName;
	private String projectStartDate;
	private String projectEndDate;
	private String projectAccess;
	private String projectLevelName;
	private String projectWork;
	private String projectPosition;
	
	private String careerInfoFromOutCode;
	private String companyName;
	private String companyAccess;
	private String companyInDateFromOut;
	private String companyOutDateFromOut;
	private String companyOutReason;

	private String certificateInfoCode;
	private String certificateName;
	private String issuingAgency;
	private String certificateNum;
	private String getDate;
	private String finishedDate;
	
	private String educationInfoCode;
	private String schoolName;
	private String gakryuckStatus;
	private String majorName;
	private String minorName;
	private String entranceDate;
	private String graduatDate;
	private String degree;
	
	private String militaryInfoCode;
	private String militaryServiceType;
	private String militaryState;
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
	public String getStaffPosition() {
		return staffPosition;
	}
	public void setStaffPosition(String staffPosition) {
		this.staffPosition = staffPosition;
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
	public String getStaffStatus() {
		return staffStatus;
	}
	public void setStaffStatus(String staffStatus) {
		this.staffStatus = staffStatus;
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
	public String getGakryuckStatus() {
		return gakryuckStatus;
	}
	public void setGakryuckStatus(String gakryuckStatus) {
		this.gakryuckStatus = gakryuckStatus;
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StaffInfo [staffNum=");
		builder.append(staffNum);
		builder.append(", jojicCode=");
		builder.append(jojicCode);
		builder.append(", accessNum=");
		builder.append(accessNum);
		builder.append(", staffLevelCode=");
		builder.append(staffLevelCode);
		builder.append(", staffPosition=");
		builder.append(staffPosition);
		builder.append(", hobong=");
		builder.append(hobong);
		builder.append(", staffBasicSalary=");
		builder.append(staffBasicSalary);
		builder.append(", staffPw=");
		builder.append(staffPw);
		builder.append(", staffName=");
		builder.append(staffName);
		builder.append(", staffStatus=");
		builder.append(staffStatus);
		builder.append(", employmentStatus=");
		builder.append(employmentStatus);
		builder.append(", companyInDate=");
		builder.append(companyInDate);
		builder.append(", companyOutDate=");
		builder.append(companyOutDate);
		builder.append(", regStaffName=");
		builder.append(regStaffName);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", basicInfoCode=");
		builder.append(basicInfoCode);
		builder.append(", staffEngName=");
		builder.append(staffEngName);
		builder.append(", humanNum=");
		builder.append(humanNum);
		builder.append(", staffGender=");
		builder.append(staffGender);
		builder.append(", staffNationality=");
		builder.append(staffNationality);
		builder.append(", staffCountry=");
		builder.append(staffCountry);
		builder.append(", staffPhone=");
		builder.append(staffPhone);
		builder.append(", staffEmail=");
		builder.append(staffEmail);
		builder.append(", staffMarriged=");
		builder.append(staffMarriged);
		builder.append(", staffAddr=");
		builder.append(staffAddr);
		builder.append(", familyInfoCode=");
		builder.append(familyInfoCode);
		builder.append(", relation=");
		builder.append(relation);
		builder.append(", familyName=");
		builder.append(familyName);
		builder.append(", familyBirthday=");
		builder.append(familyBirthday);
		builder.append(", familyJob=");
		builder.append(familyJob);
		builder.append(", familyAddr=");
		builder.append(familyAddr);
		builder.append(", familyPhone=");
		builder.append(familyPhone);
		builder.append(", balryoungInfoCode=");
		builder.append(balryoungInfoCode);
		builder.append(", balryoungStaffNum=");
		builder.append(balryoungStaffNum);
		builder.append(", balryoungCode=");
		builder.append(balryoungCode);
		builder.append(", balryoungDate=");
		builder.append(balryoungDate);
		builder.append(", balryoungStage=");
		builder.append(balryoungStage);
		builder.append(", notes=");
		builder.append(notes);
		builder.append(", careerInfoFromInCode=");
		builder.append(careerInfoFromInCode);
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
		builder.append(", careerInfoFromOutCode=");
		builder.append(careerInfoFromOutCode);
		builder.append(", companyName=");
		builder.append(companyName);
		builder.append(", companyAccess=");
		builder.append(companyAccess);
		builder.append(", companyInDateFromOut=");
		builder.append(companyInDateFromOut);
		builder.append(", companyOutDateFromOut=");
		builder.append(companyOutDateFromOut);
		builder.append(", companyOutReason=");
		builder.append(companyOutReason);
		builder.append(", certificateInfoCode=");
		builder.append(certificateInfoCode);
		builder.append(", certificateName=");
		builder.append(certificateName);
		builder.append(", issuingAgency=");
		builder.append(issuingAgency);
		builder.append(", certificateNum=");
		builder.append(certificateNum);
		builder.append(", getDate=");
		builder.append(getDate);
		builder.append(", finishedDate=");
		builder.append(finishedDate);
		builder.append(", educationInfoCode=");
		builder.append(educationInfoCode);
		builder.append(", schoolName=");
		builder.append(schoolName);
		builder.append(", gakryuckStatus=");
		builder.append(gakryuckStatus);
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
		builder.append(", militaryInfoCode=");
		builder.append(militaryInfoCode);
		builder.append(", militaryServiceType=");
		builder.append(militaryServiceType);
		builder.append(", militaryState=");
		builder.append(militaryState);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
