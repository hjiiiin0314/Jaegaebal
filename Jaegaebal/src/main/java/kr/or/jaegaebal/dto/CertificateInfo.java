package kr.or.jaegaebal.dto;

public class CertificateInfo {

	//자격증정보 is_certificate_info
	//certificate_info_code, staff_num, certificate_name, issuing_agency, certificate_num, get_date, 
	//finished_date, certificate_info_notes, reg_staff_name, reg_date

	private String certificateInfoCode;		//사원 자격증정보 코드
	private String certificateName;			//자격증명
	private String issuingAgency;			//발급기관
	private String certificateNum;			//자격번호
	private String getDate;					//취득일
	private String finishedDate;			//만료일
	private String certificateInfoNotes;	//비고	
	private String staffNum;				//사원번호
	private String regDate;					//등록일
	private String staffNotes;				//비고	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CertificateInfo [certificateInfoCode=");
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
		builder.append(", staffNum=");
		builder.append(staffNum);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", staffNotes=");
		builder.append(staffNotes);
		builder.append("]");
		return builder.toString();
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
	
	
}
