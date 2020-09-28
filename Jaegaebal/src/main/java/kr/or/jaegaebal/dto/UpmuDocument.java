package kr.or.jaegaebal.dto;



public class UpmuDocument {

	private String docCode;
	private String docType;
	private String writerBuseoCode;
	private String writerNum;
	private String docTitle;
	private String docContents;
	private String writeDate;
	private String docFile;
	private String startDate;
	private String endDate;
	private String appState;
	private String security;
	private String deadline;
	private String regStaffName;
	private String docTypeName;
	private String umstCate;
	private String docComent;
	private String finalStateName;
	private String umstType;
	
//	결재라인 관련
	private String appJojicCode;		//결재사원의 부서코드
	private String staffLevelCode;		//결재사원의 직급코드
	private String appStaffNum;			//결재사원의 사원번호
	private String appJojicName;		//결재사원의 부서이름
	private String appLevelName;		//결재사원의 직급이름
	private String appStaffName;		//결재사원의 이름
	private String appStateCode;		//결재사원의 결재결과 코드
	private String appStateName;		//결재사원의 결재결과이름
	
	
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
	public String getWriterBuseoCode() {
		return writerBuseoCode;
	}
	public void setWriterBuseoCode(String writerBuseoCode) {
		this.writerBuseoCode = writerBuseoCode;
	}
	public String getWriterNum() {
		return writerNum;
	}
	public void setWriterNum(String writerNum) {
		this.writerNum = writerNum;
	}
	public String getDocTitle() {
		return docTitle;
	}
	public void setDocTitle(String docTitle) {
		this.docTitle = docTitle;
	}
	public String getDocContents() {
		return docContents;
	}
	public void setDocContents(String docContents) {
		this.docContents = docContents;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getDocFile() {
		return docFile;
	}
	public void setDocFile(String docFile) {
		this.docFile = docFile;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getAppState() {
		return appState;
	}
	public void setAppState(String appState) {
		this.appState = appState;
	}
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getRegStaffName() {
		return regStaffName;
	}
	public void setRegStaffName(String regStaffName) {
		this.regStaffName = regStaffName;
	}
	public String getDocTypeName() {
		return docTypeName;
	}
	public void setDocTypeName(String docTypeName) {
		this.docTypeName = docTypeName;
	}
	public String getUmstCate() {
		return umstCate;
	}
	public void setUmstCate(String umstCate) {
		this.umstCate = umstCate;
	}
	public String getDocComent() {
		return docComent;
	}
	public void setDocComent(String docComent) {
		this.docComent = docComent;
	}
	public String getFinalStateName() {
		return finalStateName;
	}
	public void setFinalStateName(String finalStateName) {
		this.finalStateName = finalStateName;
	}
	public String getUmstType() {
		return umstType;
	}
	public void setUmstType(String umstType) {
		this.umstType = umstType;
	}
	public String getAppJojicCode() {
		return appJojicCode;
	}
	public void setAppJojicCode(String appJojicCode) {
		this.appJojicCode = appJojicCode;
	}
	public String getStaffLevelCode() {
		return staffLevelCode;
	}
	public void setStaffLevelCode(String staffLevelCode) {
		this.staffLevelCode = staffLevelCode;
	}
	public String getAppStaffNum() {
		return appStaffNum;
	}
	public void setAppStaffNum(String appStaffNum) {
		this.appStaffNum = appStaffNum;
	}
	public String getAppJojicName() {
		return appJojicName;
	}
	public void setAppJojicName(String appJojicName) {
		this.appJojicName = appJojicName;
	}
	public String getAppLevelName() {
		return appLevelName;
	}
	public void setAppLevelName(String appLevelName) {
		this.appLevelName = appLevelName;
	}
	public String getAppStaffName() {
		return appStaffName;
	}
	public void setAppStaffName(String appStaffName) {
		this.appStaffName = appStaffName;
	}
	public String getAppStateCode() {
		return appStateCode;
	}
	public void setAppStateCode(String appStateCode) {
		this.appStateCode = appStateCode;
	}
	public String getAppStateName() {
		return appStateName;
	}
	public void setAppStateName(String appStateName) {
		this.appStateName = appStateName;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpmuDocument [docCode=");
		builder.append(docCode);
		builder.append(", docType=");
		builder.append(docType);
		builder.append(", writerBuseoCode=");
		builder.append(writerBuseoCode);
		builder.append(", writerNum=");
		builder.append(writerNum);
		builder.append(", docTitle=");
		builder.append(docTitle);
		builder.append(", docContents=");
		builder.append(docContents);
		builder.append(", writeDate=");
		builder.append(writeDate);
		builder.append(", docFile=");
		builder.append(docFile);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", appState=");
		builder.append(appState);
		builder.append(", security=");
		builder.append(security);
		builder.append(", deadline=");
		builder.append(deadline);
		builder.append(", regStaffName=");
		builder.append(regStaffName);
		builder.append(", docTypeName=");
		builder.append(docTypeName);
		builder.append(", umstCate=");
		builder.append(umstCate);
		builder.append(", docComent=");
		builder.append(docComent);
		builder.append(", finalStateName=");
		builder.append(finalStateName);
		builder.append(", umstType=");
		builder.append(umstType);
		builder.append(", appJojicCode=");
		builder.append(appJojicCode);
		builder.append(", staffLevelCode=");
		builder.append(staffLevelCode);
		builder.append(", appStaffNum=");
		builder.append(appStaffNum);
		builder.append(", appJojicName=");
		builder.append(appJojicName);
		builder.append(", appLevelName=");
		builder.append(appLevelName);
		builder.append(", appStaffName=");
		builder.append(appStaffName);
		builder.append(", appStateCode=");
		builder.append(appStateCode);
		builder.append(", appStateName=");
		builder.append(appStateName);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
}
