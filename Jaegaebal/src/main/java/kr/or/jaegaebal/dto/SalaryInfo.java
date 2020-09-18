package kr.or.jaegaebal.dto;

public class SalaryInfo {
	private String dataNum;
	private String dataEmp;
	private String staffName; //Join emp 성명
	private String levelName; //Join emp 직급
	private String humanNum; //Join emp 주민등록번호
	private String companyInDate; //Join emp 입사일
	private String companyOutDate; //Join emp 퇴사일
	private String staffNationality; //Join emp 내외국인
	private String staffCountry; //Join emp 거주국
	private String staffPhone; //Join emp 핸드폰
	private String staffEmail; //Join emp 이메일
	private int dataInsu;
	private int dataResi;
	private boolean dataPro;
	private String dataBank;
	private String dataAccount;
	private String dataHost;
	private int dataScrib;
	private boolean dataBate;
	private float dataBatePer;
	private String dataBateDate1;
	private String dataBateDate2;
	private int dataExpen;
	private String dataExpenDate1;
	private String dataExpenDate2;
	private boolean dataTaxdepart;
	private float dataTax;
	private String dataTaxDate1;
	private String dataTaxDate2;
	
	
	public String getStaffCountry() {
		return staffCountry;
	}
	public void setStaffCountry(String staffCountry) {
		this.staffCountry = staffCountry;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public String getHumanNum() {
		return humanNum;
	}
	public void setHumanNum(String humanNum) {
		this.humanNum = humanNum;
	}
	public String getCompanyInDate() {
		return companyInDate;
	}
	public void setCompanyInDate(String companyInDate) {
		this.companyInDate = companyInDate;
	}
	public String getCompanyOutDate() {
		return companyOutDate;
	}
	public void setCompanyOutDate(String companyOutDate) {
		this.companyOutDate = companyOutDate;
	}
	public String getStaffNationality() {
		return staffNationality;
	}
	public void setStaffNationality(String staffNationality) {
		this.staffNationality = staffNationality;
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
	public String getDataNum() {
		return dataNum;
	}
	public void setDataNum(String dataNum) {
		this.dataNum = dataNum;
	}
	public String getDataEmp() {
		return dataEmp;
	}
	public void setDataEmp(String dataEmp) {
		this.dataEmp = dataEmp;
	}
	public int getDataInsu() {
		return dataInsu;
	}
	public void setDataInsu(int dataInsu) {
		this.dataInsu = dataInsu;
	}
	public int getDataResi() {
		return dataResi;
	}
	public void setDataResi(int dataResi) {
		this.dataResi = dataResi;
	}
	public boolean getDataPro() {
		return dataPro;
	}
	public void setDataPro(boolean dataPro) {
		this.dataPro = dataPro;
	}
	public String getDataBank() {
		return dataBank;
	}
	public void setDataBank(String dataBank) {
		this.dataBank = dataBank;
	}
	public String getDataAccount() {
		return dataAccount;
	}
	public void setDataAccount(String dataAccount) {
		this.dataAccount = dataAccount;
	}
	public String getDataHost() {
		return dataHost;
	}
	public void setDataHost(String dataHost) {
		this.dataHost = dataHost;
	}
	public int getDataScrib() {
		return dataScrib;
	}
	public void setDataScrib(int dataScrib) {
		this.dataScrib = dataScrib;
	}
	public boolean getDataBate() {
		return dataBate;
	}
	public void setDataBate(boolean dataBate) {
		this.dataBate = dataBate;
	}
	public float getDataBatePer() {
		return dataBatePer;
	}
	public void setDataBatePer(float dataBatePer) {
		this.dataBatePer = dataBatePer;
	}
	public String getDataBateDate1() {
		return dataBateDate1;
	}
	public void setDataBateDate1(String dataBateDate1) {
		this.dataBateDate1 = dataBateDate1;
	}
	public String getDataBateDate2() {
		return dataBateDate2;
	}
	public void setDataBateDate2(String dataBateDate2) {
		this.dataBateDate2 = dataBateDate2;
	}
	public int getDataExpen() {
		return dataExpen;
	}
	public void setDataExpen(int dataExpen) {
		this.dataExpen = dataExpen;
	}
	public String getDataExpenDate1() {
		return dataExpenDate1;
	}
	public void setDataExpenDate1(String dataExpenDate1) {
		this.dataExpenDate1 = dataExpenDate1;
	}
	public String getDataExpenDate2() {
		return dataExpenDate2;
	}
	public void setDataExpenDate2(String dataExpenDate2) {
		this.dataExpenDate2 = dataExpenDate2;
	}
	public boolean getDataTaxdepart() {
		return dataTaxdepart;
	}
	public void setDataTaxDepart(boolean dataTaxdepart) {
		this.dataTaxdepart = dataTaxdepart;
	}
	public float getDataTax() {
		return dataTax;
	}
	public void setDataTax(float dataTax) {
		this.dataTax = dataTax;
	}
	public String getDataTaxDate1() {
		return dataTaxDate1;
	}
	public void setDataTaxDate1(String dataTaxDate1) {
		this.dataTaxDate1 = dataTaxDate1;
	}
	public String getDataTaxDate2() {
		return dataTaxDate2;
	}
	public void setDataTaxDate2(String dataTaxDate2) {
		this.dataTaxDate2 = dataTaxDate2;
	}
	@Override
	public String toString() {
		return "SalaryInfo [dataNum=" + dataNum + ", dataEmp=" + dataEmp + ", staffName=" + staffName + ", levelName="
				+ levelName + ", humanNum=" + humanNum + ", companyInDate=" + companyInDate + ", companyOutDate="
				+ companyOutDate + ", staffNationality=" + staffNationality + ", staffCountry=" + staffCountry
				+ ", staffPhone=" + staffPhone + ", staffEmail=" + staffEmail + ", dataInsu=" + dataInsu + ", dataResi="
				+ dataResi + ", dataPro=" + dataPro + ", dataBank=" + dataBank + ", dataAccount=" + dataAccount
				+ ", dataHost=" + dataHost + ", dataScrib=" + dataScrib + ", dataBate=" + dataBate + ", dataBatePer="
				+ dataBatePer + ", dataBateDate1=" + dataBateDate1 + ", dataBateDate2=" + dataBateDate2 + ", dataExpen="
				+ dataExpen + ", dataExpenDate1=" + dataExpenDate1 + ", dataExpenDate2=" + dataExpenDate2
				+ ", dataTaxDepart=" + dataTaxdepart + ", dataTax=" + dataTax + ", dataTaxDate1=" + dataTaxDate1
				+ ", dataTaxDate2=" + dataTaxDate2 + "]";
	}
	
}
