package kr.or.jaegaebal.dto;

public class ChaeYoungCode {

	private String evLargeCateCode; //평가대분류코드
	private String evLargeName; //평가대분류명

	private String evMiddleCateCode; //평가중분류코드
	private String fkLargeCateCode; //평가대분류코fk
	private String evMiddleName; //평가중분류명
	public String getEvLargeCateCode() {
		return evLargeCateCode;
	}
	public void setEvLargeCateCode(String evLargeCateCode) {
		this.evLargeCateCode = evLargeCateCode;
	}
	public String getEvLargeName() {
		return evLargeName;
	}
	public void setEvLargeName(String evLargeName) {
		this.evLargeName = evLargeName;
	}
	public String getEvMiddleCateCode() {
		return evMiddleCateCode;
	}
	public void setEvMiddleCateCode(String evMiddleCateCode) {
		this.evMiddleCateCode = evMiddleCateCode;
	}
	public String getFkLargeCateCode() {
		return fkLargeCateCode;
	}
	public void setFkLargeCateCode(String fkLargeCateCode) {
		this.fkLargeCateCode = fkLargeCateCode;
	}
	public String getEvMiddleName() {
		return evMiddleName;
	}
	public void setEvMiddleName(String evMiddleName) {
		this.evMiddleName = evMiddleName;
	}
	@Override
	public String toString() {
		return "ChaeYoungCode [evLargeCateCode=" + evLargeCateCode + ", evLargeName=" + evLargeName
				+ ", evMiddleCateCode=" + evMiddleCateCode + ", fkLargeCateCode=" + fkLargeCateCode + ", evMiddleName="
				+ evMiddleName + "]";
	}
	
	
}
