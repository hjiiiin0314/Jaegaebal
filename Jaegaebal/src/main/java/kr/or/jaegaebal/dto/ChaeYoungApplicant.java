package kr.or.jaegaebal.dto;

/**
 * 지원자 지원정보
 * 작성자 : 김형진
 * @author ECS
 *
 */
public class ChaeYoungApplicant {

	 private String appEmail; //지원자 이메일
	 private String jobNumber; //구인공고번호
	 private String appPassward; //지원자 비밀번호
	 private String appName; //지원자이름
	 private String appPhone; //지원자 핸드폰번호
	 private String appRegDate; //지원날짜
	 
	 private String appNumCode; //지원자접수번호
	 private String appFinalState; //지원자상태
	
	 
	public String getAppFinalState() {
		return appFinalState;
	}
	public void setAppFinalState(String appFinalState) {
		this.appFinalState = appFinalState;
	}
	public String getAppNumCode() {
		return appNumCode;
	}
	public void setAppNumCode(String appNumCode) {
		this.appNumCode = appNumCode;
	}
	public String getAppEmail() {
		return appEmail;
	}
	public void setAppEmail(String appEmail) {
		this.appEmail = appEmail;
	}
	public String getJobNumber() {
		return jobNumber;
	}
	public void setJobNumber(String appNumber) {
		this.jobNumber = appNumber;
	}
	public String getAppPassward() {
		return appPassward;
	}
	public void setAppPassward(String appPassward) {
		this.appPassward = appPassward;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppPhone() {
		return appPhone;
	}
	public void setAppPhone(String appPhone) {
		this.appPhone = appPhone;
	}
	public String getAppRegDate() {
		return appRegDate;
	}
	public void setAppRegDate(String appRegDate) {
		this.appRegDate = appRegDate;
	}
	@Override
	public String toString() {
		return "ChaeYoungApplicant [appEmail=" + appEmail + ", jobNumber=" + jobNumber + ", appPassward=" + appPassward
				+ ", appName=" + appName + ", appPhone=" + appPhone + ", appRegDate=" + appRegDate + ", appNumCode="
				+ appNumCode + ", appFinalState=" + appFinalState + "]";
	}
	 
	 
}
