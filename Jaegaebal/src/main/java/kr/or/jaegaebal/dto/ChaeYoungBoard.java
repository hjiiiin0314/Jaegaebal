package kr.or.jaegaebal.dto;

public class ChaeYoungBoard {

	private String jobNumber; //구인공고번호
	private String jobFieldCode; //지원분야코드
	private String jobFieldName; //지원분야명
	private String jobTitle; //구인공고제목
	private String jobContent; //구인공고내용
	private String jobCareer; //경력사항 
	private String jobDeadLine; //채용마감일
	private String jobRegDate; //공고등록일
	private String jobRegStaff; //공고등록자
	
	public String getJobCareer() {
		return jobCareer;
	}
	public void setJobCareer(String jobCareer) {
		this.jobCareer = jobCareer;
	}
	public String getJobNumber() {
		return jobNumber;
	}
	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}
	public String getJobFieldCode() {
		return jobFieldCode;
	}
	public void setJobFieldCode(String jobFieldCode) {
		this.jobFieldCode = jobFieldCode;
	}
	public String getJobFieldName() {
		return jobFieldName;
	}
	public void setJobFieldName(String jobFieldName) {
		this.jobFieldName = jobFieldName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobContent() {
		return jobContent;
	}
	public void setJobContent(String jobContent) {
		this.jobContent = jobContent;
	}
	public String getJobRegDate() {
		return jobRegDate;
	}
	public void setJobRegDate(String jobRegDate) {
		this.jobRegDate = jobRegDate;
	}
	public String getJobDeadLine() {
		return jobDeadLine;
	}
	public void setJobDeadLine(String jobDeadLine) {
		this.jobDeadLine = jobDeadLine;
	}
	public String getJobRegStaff() {
		return jobRegStaff;
	}
	public void setJobRegStaff(String jobRegStaff) {
		this.jobRegStaff = jobRegStaff;
	}
	@Override
	public String toString() {
		return "ChaeYoungBoard [jobNumber=" + jobNumber + ", jobFieldCode=" + jobFieldCode + ", jobFieldName="
				+ jobFieldName + ", jobTitle=" + jobTitle + ", jobContent=" + jobContent + ", jobRegDate=" + jobRegDate
				+ ", jobDeadLine=" + jobDeadLine + ", jobRegStaff=" + jobRegStaff + "]";
	}
	
	
}
