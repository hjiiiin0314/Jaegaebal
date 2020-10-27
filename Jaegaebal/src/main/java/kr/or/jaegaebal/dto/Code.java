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
	private String balryoungCode;	//발령코드
	
	public String getBalryoungCode() {
		return balryoungCode;
	}
	public void setBalryoungCode(String balryoungCode) {
		this.balryoungCode = balryoungCode;
	}
	private String balryoungName;	//발령명
	
	public String getBalryoungName() {
		return balryoungName;
	}
	public void setBalryoungName(String balryoungName) {
		this.balryoungName = balryoungName;
	}
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
		StringBuilder builder = new StringBuilder();
		builder.append("Code [accessNum=");
		builder.append(accessNum);
		builder.append(", accessName=");
		builder.append(accessName);
		builder.append(", jojicCode=");
		builder.append(jojicCode);
		builder.append(", jojicName=");
		builder.append(jojicName);
		builder.append(", levelCode=");
		builder.append(levelCode);
		builder.append(", levelName=");
		builder.append(levelName);
		builder.append(", positionCode=");
		builder.append(positionCode);
		builder.append(", positionName=");
		builder.append(positionName);
		builder.append(", balryoungCode=");
		builder.append(balryoungCode);
		builder.append(", balryoungName=");
		builder.append(balryoungName);
		builder.append("]");
		return builder.toString();
	}
	
	
}
