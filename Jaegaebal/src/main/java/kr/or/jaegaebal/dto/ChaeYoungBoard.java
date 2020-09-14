package kr.or.jaegaebal.dto;

public class ChaeYoungBoard {

	private String jobNumber;
	private String jobFieldCode;
	private String jobFieldName;
	private String jobTitle;
	private String jobContent;
	private String jobRegDate;
	private String jobDeadLine;
	private String jobRegStaff;
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
