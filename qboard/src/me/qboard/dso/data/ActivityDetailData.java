package me.qboard.dso.data;

public class ActivityDetailData {

	private int activityid;
	private String memberid;
	private int applicationadult; 
	private int applicationchildren;
	
	public ActivityDetailData(int activityid, String memberid,
			int applicationadult, int applicationchildren) {
		super();
		this.activityid = activityid;
		this.memberid = memberid;
		this.applicationadult = applicationadult;
		this.applicationchildren = applicationchildren;
	}
	public int getActivityid() {
		return activityid;
	}
	public String getMemberid() {
		return memberid;
	}
	public int getApplicationadult() {
		return applicationadult;
	}
	public int getApplicationchildren() {
		return applicationchildren;
	}
	public void setActivityid(int activityid) {
		this.activityid = activityid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public void setApplicationadult(int applicationadult) {
		this.applicationadult = applicationadult;
	}
	public void setApplicationchildren(int applicationchildren) {
		this.applicationchildren = applicationchildren;
	}
	

	
}
