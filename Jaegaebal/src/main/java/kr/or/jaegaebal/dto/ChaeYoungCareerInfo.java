package kr.or.jaegaebal.dto;

public class ChaeYoungCareerInfo {

	//지원자 기본정보
	private String appNumCode; //지원자접수번호
	private String jobNumber; //구인공고번호
	private String appEmail; //지원자이메일
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
	
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "ChaeYoungCareerInfo [appNumCode=" + appNumCode + ", jobNumber=" + jobNumber + ", appEmail=" + appEmail
				+ ", careerInfoCode=" + careerInfoCode + ", companyName=" + companyName + ", companyAccess="
				+ companyAccess + ", companyPositionFromOut=" + companyPositionFromOut + ", companyWorkFormOut="
				+ companyWorkFormOut + ", companyInDateFromOut=" + companyInDateFromOut + ", companyOutDateFromOut="
				+ companyOutDateFromOut + ", companyOutReason=" + companyOutReason + "]";
	}
	
	
}