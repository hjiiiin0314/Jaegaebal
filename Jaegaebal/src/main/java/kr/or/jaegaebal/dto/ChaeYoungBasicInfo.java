package kr.or.jaegaebal.dto;

/**
 * 채용 기본 인적사항
 * 작성자 : 김형진
 * @author ECS
 *
 */
public class ChaeYoungBasicInfo {

	private String jobNumber; //구인공고번호
	private String appEmail; //지원자이메일
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
	@Override
	public String toString() {
		return "ChaeYoungBasicInfo [jobNumber=" + jobNumber + ", appEmail=" + appEmail + ", staffEngName="
				+ staffEngName + ", humanNum=" + humanNum + ", staffGender=" + staffGender + ", staffNationality="
				+ staffNationality + ", staffCountry=" + staffCountry + ", staffPhone=" + staffPhone + ", staffEmail="
				+ staffEmail + ", staffMarriged=" + staffMarriged + ", staffAddr=" + staffAddr + ", regDate=" + regDate
				+ "]";
	}

	
}
