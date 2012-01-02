package me.qboard.dso.data;

import java.util.Date;

public class MemberData {

	private String memberid;  	
	private String membername;
	private boolean gender;
	private String password;
	private Date memberbirth;
	private int memberage;
	private int cityid;
	private int townid;
	private String memberaddr;
	private String cellphone;
	private String memberemail;
	private Date applicationdate;
	private String bankname;
	private String branchname;
	private String accountnum;
	private int mmberstateid;
	private boolean issubscriber;	
	
	public MemberData(String memberid, String membername, boolean gender, String password,
			Date memberbirth, int memberage, int cityid, int townid,
			String memberaddr, String cellphone, String memberemail,
			Date applicationdate, String bankname, String branchname,
			String accountnum, int mmberstateid, boolean issubscriber) {
		super();
		this.membername = membername;
		this.gender = gender;
		this.password = password;
		this.memberbirth = memberbirth;
		this.memberage = memberage;
		this.cityid = cityid;
		this.townid = townid;
		this.memberaddr = memberaddr;
		this.cellphone = cellphone;
		this.memberemail = memberemail;
		this.applicationdate = applicationdate;
		this.bankname = bankname;
		this.branchname = branchname;
		this.accountnum = accountnum;
		this.mmberstateid = mmberstateid;
		this.issubscriber = issubscriber;
		this.memberid = memberid;
	}

	public String getMemberid() {
		return memberid;
	}
	public String getMembername() {
		return membername;
	}
	public boolean isGender() {
		return gender;
	}
	public String getPassword() {
		return password;
	}
	public Date getMemberbirth() {
		return memberbirth;
	}
	public int getMemberage() {
		return memberage;
	}
	public int getCityid() {
		return cityid;
	}
	public int getTownid() {
		return townid;
	}
	public String getMemberaddr() {
		return memberaddr;
	}
	public String getCellphone() {
		return cellphone;
	}
	public String getMemberemail() {
		return memberemail;
	}
	public Date getApplicationdate() {
		return applicationdate;
	}
	public String getBankname() {
		return bankname;
	}
	public String getBranchname() {
		return branchname;
	}
	public String getAccountnum() {
		return accountnum;
	}
	public int getMmberstateid() {
		return mmberstateid;
	}
	public boolean isIssubscriber() {
		return issubscriber;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setMemberbirth(Date memberbirth) {
		this.memberbirth = memberbirth;
	}
	public void setMemberage(int memberage) {
		this.memberage = memberage;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	public void setTownid(int townid) {
		this.townid = townid;
	}
	public void setMemberaddr(String memberaddr) {
		this.memberaddr = memberaddr;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public void setMemberemail(String memberemail) {
		this.memberemail = memberemail;
	}
	public void setApplicationdate(Date applicationdate) {
		this.applicationdate = applicationdate;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public void setAccountnum(String accountnum) {
		this.accountnum = accountnum;
	}
	public void setMmberstateid(int mmberstateid) {
		this.mmberstateid = mmberstateid;
	}
	public void setIssubscriber(boolean issubscriber) {
		this.issubscriber = issubscriber;
	}
	
}