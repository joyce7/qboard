package me.qboard.dso.data;

import java.util.Date;

public class ActivityData {
  /*
   *     "ACTIVITYID"   NUMBER(4,0),
    "ACTIVITYNAME" VARCHAR2(60 BYTE),
    "ACTIVITYDATE" DATE,
    "ACTIVITYTIME" TIMESTAMP (6),
    "CITYID"         NUMBER(*,0),
    "TOWNID"         NUMBER(*,0),
    "ACTIVITYADDR"   VARCHAR2(60 BYTE),
    "ACTIVITYBUDGET" NUMBER(*,0),
    "ADULTNUM"       NUMBER(*,0),
    "CHILDRENNUM"    NUMBER(*,0),
    "APPLICATIONNUM" NUMBER(*,0),
    "EMPLOYEEID" NCHAR(10),
    "ATTENDANCEFEE" NUMBER(*,0),
    "APPLICATIONBEGINDATE" DATE,
    "APPLICATIONENDDATE" DATE
   */
	
	private int activityid;
	private String activityname;
	private Date activitydate;
	private java.util.Date activitytime;
	private int cityid;
	private int townid;
	private String activityaddr;
	private int activitybudget;
	private int adultnum;
	private int childrennum;
	private int applicationnum;
	private String employeeid;
	private int attendancefee;
	private Date applicationbegindate;
	private Date applicationenddate;
	
	public ActivityData(int activityid, String activityname, Date activitydate,
			Date activitytime, int cityid, int townid, String activityaddr,
			int activitybudget, int adultnum, int childrennum,
			int applicationnum, String employeeid, int attendancefee,
			Date applicationbegindate, Date applicationenddate) {
		super();
		this.activityid = activityid;
		this.activityname = activityname;
		this.activitydate = activitydate;
		this.activitytime = activitytime;
		this.cityid = cityid;
		this.townid = townid;
		this.activityaddr = activityaddr;
		this.activitybudget = activitybudget;
		this.adultnum = adultnum;
		this.childrennum = childrennum;
		this.applicationnum = applicationnum;
		this.employeeid = employeeid;
		this.attendancefee = attendancefee;
		this.applicationbegindate = applicationbegindate;
		this.applicationenddate = applicationenddate;
	}

	
	public int getActivityid() {
		return activityid;
	}
	public String getActivityname() {
		return activityname;
	}
	public java.util.Date getActivitydate() {
		return activitydate;
	}
	public java.util.Date getActivitytime() {
		return activitytime;
	}
	public int getCityid() {
		return cityid;
	}
	public int getTownid() {
		return townid;
	}
	public String getActivityaddr() {
		return activityaddr;
	}
	public int getActivitybudget() {
		return activitybudget;
	}
	public int getAdultnum() {
		return adultnum;
	}
	public int getChildrennum() {
		return childrennum;
	}
	public int getApplicationnum() {
		return applicationnum;
	}
	public String getEmployeeid() {
		return employeeid;
	}
	public int getAttendancefee() {
		return attendancefee;
	}
	public java.util.Date getApplicationbegindate() {
		return applicationbegindate;
	}
	public java.util.Date getApplicationenddate() {
		return applicationenddate;
	}
	public void setActivityid(int activityid) {
		this.activityid = activityid;
	}
	public void setActivityname(String activityname) {
		this.activityname = activityname;
	}
	public void setActivitydate(java.util.Date activitydate) {
		this.activitydate = activitydate;
	}
	public void setActivitytime(java.util.Date activitytime) {
		this.activitytime = activitytime;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	public void setTownid(int townid) {
		this.townid = townid;
	}
	public void setActivityaddr(String activityaddr) {
		this.activityaddr = activityaddr;
	}
	public void setActivitybudget(int activitybudget) {
		this.activitybudget = activitybudget;
	}
	public void setAdultnum(int adultnum) {
		this.adultnum = adultnum;
	}
	public void setChildrennum(int childrennum) {
		this.childrennum = childrennum;
	}
	public void setApplicationnum(int applicationnum) {
		this.applicationnum = applicationnum;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public void setAttendancefee(int attendancefee) {
		this.attendancefee = attendancefee;
	}
	public void setApplicationbegindate(java.util.Date applicationbegindate) {
		this.applicationbegindate = applicationbegindate;
	}
	public void setApplicationenddate(java.util.Date applicationenddate) {
		this.applicationenddate = applicationenddate;
	}

	
	
}
