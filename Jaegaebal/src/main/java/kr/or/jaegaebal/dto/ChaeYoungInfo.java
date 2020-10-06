package kr.or.jaegaebal.dto;

/**
 * 지원자 인적사항
 * 작성자 : 김형진
 * @author ECS
 *
 */
public class ChaeYoungInfo {

	//지원자 기본정보
	private String appNumCode; //지원자접수번호
	private String jobNumber; //구인공고번호
	private String appEmail; //지원자이메일
	
	//지원자 인적사항
	private String basicInfoCode; //인적사항코드
	private String staffEngName; //영문이름
	private String humanNum; //주민등록번호
	private char staffGender; //성별
	private String staffNationality; //내외국인
	private String staffCountry; //국적
	private String staffPhone; //핸드폰
	private String staffEmail; //이메일
	private String staffMarriged; //결혼여부
	private String staffAddr; //주소
	private String regDate; //등록일
	
	//지원자 경력사항
	private String careerInfoCode; //지원자경력정보코드
	private String companyName; //직장명
	private String companyAccess; //직위
	private String companyPositionFromOut; //직책
	private String companyWorkFormOut; //직무
	private String companyInDateFromOut; //입사일자
	private String companyOutDateFromOut; //퇴사일자
	private String companyOutReason; //퇴직사유
	
	//지원자 자격증정보
	private String certificateInfoCode; //자격증정보코드
	private String certificateName; //자격증명
	private String issuingAgency; //발급기관
	private String certificateNum; //자격번호
	private String getDate; //취득일
	private String finishedDate; //만료일
	
	//지원자 학력정보
	private String educationInfoCode; //학력정보코드
	private String schoolName; //학교명
	private String hakryuckStatus; //상태
	private String majorName; //전공
	private String minorName; //부전공
	private String entranceDate; //입학일
	private String graduatDate; //졸업일
	private String degree; //학위
	
	//지원자 병역정보
	private String militaryInfoCode; //병역코드
	private String militaryClassidx; //병역구분
	private String militaryServiceType; //군별
	private String militaryState; //전역상태
	private String militaryInDay; //입대일자
	private String militaryOutDay; //전역일자
	private String militaryLevel; //계급
	private String militaryInfoNotes; //비고
	
	
	public String getAppNumCode() {
		return appNumCode;
	}
	public void setAppNumCode(String appNumCode) {
		this.appNumCode = appNumCode;
	}
	public String getJobNumber() {
		return jobNumber;
	}
	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}
	public String getAppEmail() {
		return appEmail;
	}
	public void setAppEmail(String appEmail) {
		this.appEmail = appEmail;
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
	public char getStaffGender() {
		return staffGender;
	}
	public void setStaffGender(char staffGender) {
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
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getCareerInfoCode() {
		return careerInfoCode;
	}
	public void setCareerInfoCode(String careerInfoCode) {
		this.careerInfoCode = careerInfoCode;
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
	public String getMilitaryClassidx() {
		return militaryClassidx;
	}
	public void setMilitaryClassidx(String militaryClassidx) {
		this.militaryClassidx = militaryClassidx;
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
	@Override
	public String toString() {
		return "ChaeYoungInfo [appNumCode=" + appNumCode + ", jobNumber=" + jobNumber + ", appEmail=" + appEmail
				+ ", basicInfoCode=" + basicInfoCode + ", staffEngName=" + staffEngName + ", humanNum=" + humanNum
				+ ", staffGender=" + staffGender + ", staffNationality=" + staffNationality + ", staffCountry="
				+ staffCountry + ", staffPhone=" + staffPhone + ", staffEmail=" + staffEmail + ", staffMarriged="
				+ staffMarriged + ", staffAddr=" + staffAddr + ", regDate=" + regDate + ", careerInfoCode="
				+ careerInfoCode + ", companyName=" + companyName + ", companyAccess=" + companyAccess
				+ ", companyPositionFromOut=" + companyPositionFromOut + ", companyWorkFormOut=" + companyWorkFormOut
				+ ", companyInDateFromOut=" + companyInDateFromOut + ", companyOutDateFromOut=" + companyOutDateFromOut
				+ ", companyOutReason=" + companyOutReason + ", certificateInfoCode=" + certificateInfoCode
				+ ", certificateName=" + certificateName + ", issuingAgency=" + issuingAgency + ", certificateNum="
				+ certificateNum + ", getDate=" + getDate + ", finishedDate=" + finishedDate + ", educationInfoCode="
				+ educationInfoCode + ", schoolName=" + schoolName + ", hakryuckStatus=" + hakryuckStatus
				+ ", majorName=" + majorName + ", minorName=" + minorName + ", entranceDate=" + entranceDate
				+ ", graduatDate=" + graduatDate + ", degree=" + degree + ", militaryInfoCode=" + militaryInfoCode
				+ ", militaryClassidx=" + militaryClassidx + ", militaryServiceType=" + militaryServiceType
				+ ", militaryState=" + militaryState + ", militaryInDay=" + militaryInDay + ", militaryOutDay="
				+ militaryOutDay + ", militaryLevel=" + militaryLevel + ", militaryInfoNotes=" + militaryInfoNotes
				+ "]";
	}

	
	
	
}
