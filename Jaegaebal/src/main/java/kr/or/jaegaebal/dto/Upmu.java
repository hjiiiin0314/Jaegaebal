package kr.or.jaegaebal.dto;

public class Upmu {
	/*
	 * task_num  , staff_num , task_info , task_result , task_reg_date
	 */
	
	private int taskNum;		//업무번호
	private String staffNum;	//업무등록자
	private String taskInfo;	//업무정보
	private String taskResult;	//업무결과
	private String taskRegDate;	//업무등록일
	
	
	public int getTaskNum() {
		return taskNum;
	}
	public void setTaskNum(int taskNum) {
		this.taskNum = taskNum;
	}
	public String getStaffNum() {
		return staffNum;
	}
	public void setStaffNum(String staffNum) {
		this.staffNum = staffNum;
	}
	public String getTaskInfo() {
		return taskInfo;
	}
	public void setTaskInfo(String taskInfo) {
		this.taskInfo = taskInfo;
	}
	public String getTaskResult() {
		return taskResult;
	}
	public void setTaskResult(String taskResult) {
		this.taskResult = taskResult;
	}
	public String getTaskRegDate() {
		return taskRegDate;
	}
	public void setTaskRegDate(String taskRegDate) {
		this.taskRegDate = taskRegDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Upmu [taskNum=");
		builder.append(taskNum);
		builder.append(", staffNum=");
		builder.append(staffNum);
		builder.append(", taskInfo=");
		builder.append(taskInfo);
		builder.append(", taskResult=");
		builder.append(taskResult);
		builder.append(", taskRegDate=");
		builder.append(taskRegDate);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
