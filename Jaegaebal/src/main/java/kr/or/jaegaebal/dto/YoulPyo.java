package kr.or.jaegaebal.dto;

public class YoulPyo {
	private String insuranceYoulpyoCode;
	private float gukminStaffPercent;
	private int gukminLowerLimitAmount;
	private int gukminUpperLimitAmount;
	private float gunkangStaffPercent;
	private int gunkangLowerLimitAmount;
	private int gunkangUpperLimitAmount;
	private float jangkiStaffPercent;
	private int jangkiLowerLimitAmount;
	private int jangkiUpperLimitAmount;
	private float goyongStaffPercent;
	private float sanjaeStaffPercent;
	private String applicationMonth;
	private String applicationEndMonth;
	private String regDate;
	
	public String getInsuranceYoulpyoCode() {
		return insuranceYoulpyoCode;
	}
	public void setInsuranceYoulpyoCode(String insuranceYoulpyoCode) {
		this.insuranceYoulpyoCode = insuranceYoulpyoCode;
	}
	public float getGukminStaffPercent() {
		return gukminStaffPercent;
	}
	public void setGukminStaffPercent(float gukminStaffPercent) {
		this.gukminStaffPercent = gukminStaffPercent;
	}
	public int getGukminLowerLimitAmount() {
		return gukminLowerLimitAmount;
	}
	public void setGukminLowerLimitAmount(int gukminLowerLimitAmount) {
		this.gukminLowerLimitAmount = gukminLowerLimitAmount;
	}
	public int getGukminUpperLimitAmount() {
		return gukminUpperLimitAmount;
	}
	public void setGukminUpperLimitAmount(int gukminUpperLimitAmount) {
		this.gukminUpperLimitAmount = gukminUpperLimitAmount;
	}
	public float getGunkangStaffPercent() {
		return gunkangStaffPercent;
	}
	public void setGunkangStaffPercent(float gunkangStaffPercent) {
		this.gunkangStaffPercent = gunkangStaffPercent;
	}
	public int getGunkangLowerLimitAmount() {
		return gunkangLowerLimitAmount;
	}
	public void setGunkangLowerLimitAmount(int gunkangLowerLimitAmount) {
		this.gunkangLowerLimitAmount = gunkangLowerLimitAmount;
	}
	public int getGunkangUpperLimitAmount() {
		return gunkangUpperLimitAmount;
	}
	public void setGunkangUpperLimitAmount(int gunkangUpperLimitAmount) {
		this.gunkangUpperLimitAmount = gunkangUpperLimitAmount;
	}
	public float getJangkiStaffPercent() {
		return jangkiStaffPercent;
	}
	public void setJangkiStaffPercent(float jangkiStaffPercent) {
		this.jangkiStaffPercent = jangkiStaffPercent;
	}
	public int getJangkiLowerLimitAmount() {
		return jangkiLowerLimitAmount;
	}
	public void setJangkiLowerLimitAmount(int jangkiLowerLimitAmount) {
		this.jangkiLowerLimitAmount = jangkiLowerLimitAmount;
	}
	public int getJangkiUpperLimitAmount() {
		return jangkiUpperLimitAmount;
	}
	public void setJangkiUpperLimitAmount(int jangkiUpperLimitAmount) {
		this.jangkiUpperLimitAmount = jangkiUpperLimitAmount;
	}
	public float getGoyongStaffPercent() {
		return goyongStaffPercent;
	}
	public void setGoyongStaffPercent(float goyongStaffPercent) {
		this.goyongStaffPercent = goyongStaffPercent;
	}
	public float getSanjaeStaffPercent() {
		return sanjaeStaffPercent;
	}
	public void setSanjaeStaffPercent(float sanjaeStaffPercent) {
		this.sanjaeStaffPercent = sanjaeStaffPercent;
	}
	public String getApplicationMonth() {
		return applicationMonth;
	}
	public void setApplicationMonth(String applicationMonth) {
		this.applicationMonth = applicationMonth;
	}
	public String getApplicationEndMonth() {
		return applicationEndMonth;
	}
	public void setApplicationEndMonth(String applicationEndMonth) {
		this.applicationEndMonth = applicationEndMonth;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "YoulPyo [insuranceYoulpyoCode=" + insuranceYoulpyoCode + ", gukminStaffPercent=" + gukminStaffPercent
				+ ", gukminLowerLimitAmount=" + gukminLowerLimitAmount + ", gukminUpperLimitAmount="
				+ gukminUpperLimitAmount + ", gunkangStaffPercent=" + gunkangStaffPercent + ", gunkangLowerLimitAmount="
				+ gunkangLowerLimitAmount + ", gunkangUpperLimitAmount=" + gunkangUpperLimitAmount
				+ ", jangkiStaffPercent=" + jangkiStaffPercent + ", jangkiLowerLimitAmount=" + jangkiLowerLimitAmount
				+ ", jangkiUpperLimitAmount=" + jangkiUpperLimitAmount + ", goyongStaffPercent=" + goyongStaffPercent
				+ ", sanjaeStaffPercent=" + sanjaeStaffPercent + ", applicationMonth=" + applicationMonth
				+ ", applicationEndMonth=" + applicationEndMonth + ", regDate=" + regDate + "]";
	}
}
