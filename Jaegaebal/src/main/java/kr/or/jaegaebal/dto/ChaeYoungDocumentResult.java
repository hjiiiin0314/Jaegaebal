package kr.or.jaegaebal.dto;

public class ChaeYoungDocumentResult {

	private String docResultNum; //서류합격자코드
	private String appNumCode; //지원자접수번호 
	private String jobNumber; //구인공고번호
	private String appEmail; //지원자이메일
	private String docResultScore; //평가점수
	private String docResult; //평가구분
	private String regStaffName; //평가자
	private String docRegDate; //평가일
	
	public String getDocResultNum() {
		return docResultNum;
	}
	public void setDocResultNum(String docResultNum) {
		this.docResultNum = docResultNum;
	}
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
	public String getDocResultScore() {
		return docResultScore;
	}
	public void setDocResultScore(String docResultScore) {
		this.docResultScore = docResultScore;
	}
	public String getDocResult() {
		return docResult;
	}
	public void setDocResult(String docResult) {
		this.docResult = docResult;
	}
	public String getRegStaffName() {
		return regStaffName;
	}
	public void setRegStaffName(String regStaffName) {
		this.regStaffName = regStaffName;
	}
	public String getDocRegDate() {
		return docRegDate;
	}
	public void setDocRegDate(String docRegDate) {
		this.docRegDate = docRegDate;
	}
	@Override
	public String toString() {
		return "ChaeYoungDocumentResult [docResultNum=" + docResultNum + ", appNumCode=" + appNumCode + ", jobNumber="
				+ jobNumber + ", appEmail=" + appEmail + ", docResultScore=" + docResultScore + ", docResult="
				+ docResult + ", regStaffName=" + regStaffName + ", docRegDate=" + docRegDate + "]";
	}
	
	
	
}
