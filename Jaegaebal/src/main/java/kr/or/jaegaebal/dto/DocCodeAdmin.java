package kr.or.jaegaebal.dto;

public class DocCodeAdmin {

	private String docCode;
	private String docType;
	private String docStaffName;
	private String docRegDate;
	public String getDocCode() {
		return docCode;
	}
	public void setDocCode(String docCode) {
		this.docCode = docCode;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public String getDocStaffName() {
		return docStaffName;
	}
	public void setDocStaffName(String docStaffName) {
		this.docStaffName = docStaffName;
	}
	public String getDocRegDate() {
		return docRegDate;
	}
	public void setDocRegDate(String docRegDate) {
		this.docRegDate = docRegDate;
	}
	
	@Override
	public String toString() {
		return "docCodeAdmin [docCode=" + docCode + ", docType=" + docType + ", docStaffName=" + docStaffName
				+ ", docRegDate=" + docRegDate + "]";
	}

}
