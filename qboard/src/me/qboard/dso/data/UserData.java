package me.qboard.dso.data;

public class UserData {

	private String uid;
	private String uname;
	private String mobile;
	private String ophone;
	private String hphone;	
	
	public UserData() {

	}


	public UserData(String id, 
					 String uname, 
					 String mobile, 
					 String ophone, 
					 String hphone) {
		this.setId(id);
		this.setUname(uname);
		this.setMobile(mobile);
		this.setophone(ophone);
		this.sethphone(hphone);		
	}

	
	public void setId(String uid) {
		this.uid = uid;
	}

	public String getUid() {
		return uid;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUname() {
		return uname;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMobile() {
		return mobile;
	}

//	public boolean isSupervisor() {
//
//		if (this.id == null)
//			return false;
//		return (this.supervisor.equals(this.id) || this.isSuperuser()) ? true
//				: false;
//	}

//	public boolean isSuperuser() {
//		if (this.id == null)
//			return false;
//		return (this.supervisor.equals("root")) ? true : false;
//	}

//	public String getRole() {
//		if (this.isSuperuser()) {
//			return "SUPERUSER";
//		} else if (this.isSupervisor()) {
//			return "SUPERVISOR";
//		} else {
//			return "OPERATOR";
//		}
//	}

	public String gethphone() {
		return hphone;
	}
	

	public void sethphone(String hphone) {
		this.hphone = hphone;
	}
	

	public String getophone() {
		return ophone;
	}
	

	public void setophone(String ophone) {
		this.ophone = ophone;
	}
	
}