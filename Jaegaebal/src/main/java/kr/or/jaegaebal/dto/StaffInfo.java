package kr.or.jaegaebal.dto;

public class StaffInfo {

	/* 컬럼명 */
	//사원 is_staff
	//staff_num, jojic_code, access_num, staff_level_code, staff_position_code, hobong, staff_basic_salary, staff_pw,
	//staff_name, staff_status_code, employment_status, company_in_date, company_out_date, reg_staff_name, reg_date, staff_notes
	
	//인적정보 is_staff_basic_info
	//basic_info_code, staff_eng_name, human_num, staff_gender, staff_nationality, staff_country,
	//staff_phone, staff_email, staff_marriged, staff_addr, staff_basic_info_notes
	
	//가족정보 is_staff_family_info
	//family_info_code, relation, family_name, family_birthday, family_job, family_addr, family_phone, staff_family_info_notes
	
	//발령정보 is_balryoung_info
	//balryoung_info_code, balryoung_staff_num, balryoung_code, balryoung_date, balryoung_stage, balryoung_info_notes
	
	//사내경력정보 is_career_info_from_in
	//career_info_from_in_code, project_name, project_start_date, project_end_date, project_access,
	//project_level_name, project_work, project_position, career_info_from_in_notes
	
	//사외경력정보 is_career_info_from_out
	//career_info_from_out_code, company_name, company_access,company_position_from_out, company_work_form_out
	//company_in_date_from_out, company_out_date_from_out, company_out_reason, career_info_from_out_notes
	
	//자격증정보 is_certificate_info
	//certificate_info_code, certificate_name, issuing_agency, certificate_num, get_date, finished_date, certificate_info_notes
	
	//학력정보 is_education_info
	//education_info_code, school_name, hakryuck_status, major_name, minor_name, entrance_date, graduat_date, degree, education_info_notes
	
	//병역정보 is_military_info
	//military_info_code, military_service_type, military_state
	//military_in_day,  military_out_day, military_level, military_info_notes
	
	//징계 is_punishment
	//punishment_code, punishment_name, parent_code, punishment_val, punishment_point
	
	//징계리스트  is_punishment_list
	//punishment_num, staff_num, punishment_code, given_date, punishment_reason, punishment_price, salary_applied_date, punishment_notes
	
	//포상 is_prize
	//prize_code, prize_name, parent_code
	
	//포상리스트 is_prize_list
	//prize_num, staff_num, prize_code, given_date, prize_reason, prize_price, salary_applied_date, prize_notes
	
	/*다른 테이블에서 외래키로 가져온 컬럼명*/
	//level_name, position_name, jojic_name, jaejic_status_name, access_name, position_code, data_num, balryoung_name
	
	private int rowNum; 					//
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
	private String staffNotes;				//비고
	
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
	private String staffBasicInfoNotes;		//비고
	
	private String familyInfoCode;			//사원 가족정보 코드
	private String relation;				//가족관계
	private String familyName;
	private String familyBirthday;			//가족 생년월일
	private String familyJob;
	private String familyAddr;
	private String familyPhone;
	private String staffFamilyInfoNotes;	//비고
	
	private String balryoungInfoCode;		//발령정보 코드
	private String balryoungStaffNum;		//발령 담당자or발령한 사람 사번
	private String balryoungCode;			//발령내용코드
	private String balryoungDate;			//발령일
	private String balryoungStage;			//발령지
	private String balryoungInfoNotes;		//비고
	
	private String careerInfoFromInCode;	//사내경력정보 코드
	private String projectName;				//맡았던 프로젝트명
	private String projectStartDate;		//프로젝트 시작일
	private String projectEndDate;			//프로젝트 종료일
	private String projectAccess;			//프로젝트 도중 권한
	private String projectLevelName;		//프로젝트 도중 직책
	private String projectWork;				//프로젝트 도중 직무
	private String projectPosition;			//프로젝트 도중 직책
	private String careerInfoFromInNotes;	//비고
	
	private String careerInfoFromOutCode;	//사외경력정보 코드
	private String companyName;				//직장명	
	private String companyAccess;			//직위
	private String companyPositionFromOut;	//직책
	private String companyWorkFormOut;		//직무
	private String companyInDateFromOut;	//입사일자
	private String companyOutDateFromOut;	//퇴사일자
	private String companyOutReason;		//퇴직사유
	private String careerInfoFromOutNotes;	//비고

	private String certificateInfoCode;		//사원 자격증정보 코드
	private String certificateName;			//자격증명
	private String issuingAgency;			//발급기관
	private String certificateNum;			//자격번호
	private String getDate;					//취득일
	private String finishedDate;			//만료일
	private String certificateInfoNotes;	//비고
	
	private String educationInfoCode;		//사원 학력정보 코드
	private String schoolName;				//학교명
	private String hakryuckStatus;			//상태 (졸업or재학중or휴학)
	private String majorName;				//전공
	private String minorName;				//부전공
	private String entranceDate;			//입학일
	private String graduatDate;				//졸업일
	private String degree;					//학위
	private String educationInfoNotes;		//비고
	
	private String militaryInfoCode;		//사원 병역정보 코드
	private String militaryServiceType;		//군종
	private String militaryState;			//상태 (전역or예비군)
	private String militaryInDay;			//입대일자
	private String militaryOutDay;			//전역일자
	private String militaryLevel;			//계급
	private String militaryInfoNotes;		//비고
	
	/*추가된것들*/
	private String levelName;				//직급명
	private String positionName;			//직책명
	private String jojicName;				//소속명
	private String jaejicStatusName;		//재직상태
	private String jojicSosocName;			//소속이름
	private String accessName;				//권한명
	private String positionCode;			//직책코드
	private String dataNum;		
	private String balryoungName;			//발령이름
	
	private String punishmentCode;			//징계코드
	private String punishmentName;			//징계명
	private String parentCode;				//상위코드
	private String punishmentVal;			//징계내용	
	private String punishmentPoint;			//징계점수
	
	private String punishmentNum;			//징계번호
	private String givenDate;				//징계일자
	private String punishmentReason;		//징계사유
	private String punishmentPrice;			//징계금액
	private String salaryAppliedDate;		//급여반영일
	private String punishmentNotes;			//비고
	
	private String prizeCode;				//포상코드
	private String prizeName;				//포상명
	
	private String prizeNum;				//포상번호
	private String prizeReason;				//포상사유
	private String prizePrice;				//포상금
	private String prizeNotes;				//비고
	private String totalPnsmtPoint;			//징계누적점수	
	private String totalWorkMonths;			//근속년수

	
	
	public String getBalryoungName() {
		return balryoungName;
	}
	public void setBalryoungName(String balryoungName) {
		this.balryoungName = balryoungName;
	}
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	public String getTotalWorkMonths() {
		return totalWorkMonths;
	}
	public void setTotalWorkMonths(String totalWorkMonths) {
		this.totalWorkMonths = totalWorkMonths;
	}
	public String getTotalPnsmtPoint() {
		return totalPnsmtPoint;
	}
	public void setTotalPnsmtPoint(String totalPnsmtPoint) {
		this.totalPnsmtPoint = totalPnsmtPoint;
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
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public String getPunishmentVal() {
		return punishmentVal;
	}
	public void setPunishmentVal(String punishmentVal) {
		this.punishmentVal = punishmentVal;
	}
	public String getPunishmentPoint() {
		return punishmentPoint;
	}
	public void setPunishmentPoint(String punishmentPoint) {
		this.punishmentPoint = punishmentPoint;
	}
	public String getPunishmentNum() {
		return punishmentNum;
	}
	public void setPunishmentNum(String punishmentNum) {
		this.punishmentNum = punishmentNum;
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
	public String getPrizeNum() {
		return prizeNum;
	}
	public void setPrizeNum(String prizeNum) {
		this.prizeNum = prizeNum;
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
	public String getPrizeNotes() {
		return prizeNotes;
	}
	public void setPrizeNotes(String prizeNotes) {
		this.prizeNotes = prizeNotes;
	}
	public String getDataNum() {
		return dataNum;
	}
	public void setDataNum(String dataNum) {
		this.dataNum = dataNum;
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
	public String getStaffNotes() {
		return staffNotes;
	}
	public void setStaffNotes(String staffNotes) {
		this.staffNotes = staffNotes;
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
	public String getStaffBasicInfoNotes() {
		return staffBasicInfoNotes;
	}
	public void setStaffBasicInfoNotes(String staffBasicInfoNotes) {
		this.staffBasicInfoNotes = staffBasicInfoNotes;
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
	public String getStaffFamilyInfoNotes() {
		return staffFamilyInfoNotes;
	}
	public void setStaffFamilyInfoNotes(String staffFamilyInfoNotes) {
		this.staffFamilyInfoNotes = staffFamilyInfoNotes;
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
	public String getBalryoungInfoNotes() {
		return balryoungInfoNotes;
	}
	public void setBalryoungInfoNotes(String balryoungInfoNotes) {
		this.balryoungInfoNotes = balryoungInfoNotes;
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
	public String getCareerInfoFromInNotes() {
		return careerInfoFromInNotes;
	}
	public void setCareerInfoFromInNotes(String careerInfoFromInNotes) {
		this.careerInfoFromInNotes = careerInfoFromInNotes;
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
	public String getCareerInfoFromOutNotes() {
		return careerInfoFromOutNotes;
	}
	public void setCareerInfoFromOutNotes(String careerInfoFromOutNotes) {
		this.careerInfoFromOutNotes = careerInfoFromOutNotes;
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
	public String getCertificateInfoNotes() {
		return certificateInfoNotes;
	}
	public void setCertificateInfoNotes(String certificateInfoNotes) {
		this.certificateInfoNotes = certificateInfoNotes;
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
	public String getEducationInfoNotes() {
		return educationInfoNotes;
	}
	public void setEducationInfoNotes(String educationInfoNotes) {
		this.educationInfoNotes = educationInfoNotes;
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
	public String getMilitaryInfoNotes() {
		return militaryInfoNotes;
	}
	public void setMilitaryInfoNotes(String militaryInfoNotes) {
		this.militaryInfoNotes = militaryInfoNotes;
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StaffInfo [rowNum=");
		builder.append(rowNum);
		builder.append(", staffNum=");
		builder.append(staffNum);
		builder.append(", jojicCode=");
		builder.append(jojicCode);
		builder.append(", accessNum=");
		builder.append(accessNum);
		builder.append(", staffLevelCode=");
		builder.append(staffLevelCode);
		builder.append(", staffPositionCode=");
		builder.append(staffPositionCode);
		builder.append(", hobong=");
		builder.append(hobong);
		builder.append(", staffBasicSalary=");
		builder.append(staffBasicSalary);
		builder.append(", staffPw=");
		builder.append(staffPw);
		builder.append(", staffName=");
		builder.append(staffName);
		builder.append(", staffStatusCode=");
		builder.append(staffStatusCode);
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
		builder.append(", staffNotes=");
		builder.append(staffNotes);
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
		builder.append(", staffBasicInfoNotes=");
		builder.append(staffBasicInfoNotes);
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
		builder.append(", staffFamilyInfoNotes=");
		builder.append(staffFamilyInfoNotes);
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
		builder.append(", balryoungInfoNotes=");
		builder.append(balryoungInfoNotes);
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
		builder.append(", careerInfoFromInNotes=");
		builder.append(careerInfoFromInNotes);
		builder.append(", careerInfoFromOutCode=");
		builder.append(careerInfoFromOutCode);
		builder.append(", companyName=");
		builder.append(companyName);
		builder.append(", companyAccess=");
		builder.append(companyAccess);
		builder.append(", companyPositionFromOut=");
		builder.append(companyPositionFromOut);
		builder.append(", companyWorkFormOut=");
		builder.append(companyWorkFormOut);
		builder.append(", companyInDateFromOut=");
		builder.append(companyInDateFromOut);
		builder.append(", companyOutDateFromOut=");
		builder.append(companyOutDateFromOut);
		builder.append(", companyOutReason=");
		builder.append(companyOutReason);
		builder.append(", careerInfoFromOutNotes=");
		builder.append(careerInfoFromOutNotes);
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
		builder.append(", certificateInfoNotes=");
		builder.append(certificateInfoNotes);
		builder.append(", educationInfoCode=");
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
		builder.append(", militaryInfoCode=");
		builder.append(militaryInfoCode);
		builder.append(", militaryServiceType=");
		builder.append(militaryServiceType);
		builder.append(", militaryState=");
		builder.append(militaryState);
		builder.append(", militaryInDay=");
		builder.append(militaryInDay);
		builder.append(", militaryOutDay=");
		builder.append(militaryOutDay);
		builder.append(", militaryLevel=");
		builder.append(militaryLevel);
		builder.append(", militaryInfoNotes=");
		builder.append(militaryInfoNotes);
		builder.append(", levelName=");
		builder.append(levelName);
		builder.append(", positionName=");
		builder.append(positionName);
		builder.append(", jojicName=");
		builder.append(jojicName);
		builder.append(", jaejicStatusName=");
		builder.append(jaejicStatusName);
		builder.append(", jojicSosocName=");
		builder.append(jojicSosocName);
		builder.append(", accessName=");
		builder.append(accessName);
		builder.append(", positionCode=");
		builder.append(positionCode);
		builder.append(", dataNum=");
		builder.append(dataNum);
		builder.append(", balryoungName=");
		builder.append(balryoungName);
		builder.append(", punishmentCode=");
		builder.append(punishmentCode);
		builder.append(", punishmentName=");
		builder.append(punishmentName);
		builder.append(", parentCode=");
		builder.append(parentCode);
		builder.append(", punishmentVal=");
		builder.append(punishmentVal);
		builder.append(", punishmentPoint=");
		builder.append(punishmentPoint);
		builder.append(", punishmentNum=");
		builder.append(punishmentNum);
		builder.append(", givenDate=");
		builder.append(givenDate);
		builder.append(", punishmentReason=");
		builder.append(punishmentReason);
		builder.append(", punishmentPrice=");
		builder.append(punishmentPrice);
		builder.append(", salaryAppliedDate=");
		builder.append(salaryAppliedDate);
		builder.append(", punishmentNotes=");
		builder.append(punishmentNotes);
		builder.append(", prizeCode=");
		builder.append(prizeCode);
		builder.append(", prizeName=");
		builder.append(prizeName);
		builder.append(", prizeNum=");
		builder.append(prizeNum);
		builder.append(", prizeReason=");
		builder.append(prizeReason);
		builder.append(", prizePrice=");
		builder.append(prizePrice);
		builder.append(", prizeNotes=");
		builder.append(prizeNotes);
		builder.append(", totalPnsmtPoint=");
		builder.append(totalPnsmtPoint);
		builder.append(", totalWorkMonths=");
		builder.append(totalWorkMonths);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
