package kr.or.jaegaebal.dto;

public class Code {
	
	/*컬럼명*/
	//access_num, access_name, jojic_code, jojic_name, level_code, level_name, position_code, position_name
	
	private String accessNum;		//권한레벨
	private String accessName;		//권한명
	private String jojicCode;		//소속코드
	private String jojicName;		//소속명
	private String levelCode;		//직급코드
	private String levelName;		//직급명
	private String positionCode;	//직책코드
	private String positionName;	//직책명
	
	public String getAccessNum() {
		return accessNum;
	}
	public void setAccessNum(String accessNum) {
		this.accessNum = accessNum;
	}
	public String getAccessName() {
		return accessName;
	}
	public void setAccessName(String accessName) {
		this.accessName = accessName;
	}
	public String getJojicCode() {
		return jojicCode;
	}
	public void setJojicCode(String jojicCode) {
		this.jojicCode = jojicCode;
	}
	public String getJojicName() {
		return jojicName;
	}
	public void setJojicName(String jojicName) {
		this.jojicName = jojicName;
	}
	public String getLevelCode() {
		return levelCode;
	}
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public String getPositionCode() {
		return positionCode;
	}
	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	@Override
	public String toString() {
		return "Code [accessNum=" + accessNum + ", accessName=" + accessName + ", jojicCode=" + jojicCode
				+ ", jojicName=" + jojicName + ", levelCode=" + levelCode + ", levelName=" + levelName
				+ ", positionCode=" + positionCode + ", positionName=" + positionName + "]";
	}
	
	
}
