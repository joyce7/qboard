package me.qboard.web;

import me.qboard.dso.dao.UserDAO;
import me.qboard.dso.data.UserData;

public class UserSessionUtil implements UserLoginStatus {

	
	
	public static int authenticate(String userid, String password) {
		
		int stat = NO_USER;
			
		UserDAO dao = new UserDAO();
		
		UserData user = dao.get(userid);
		
		if ( user == null ) {
		} else if ( user.getUid()!= userid ) {	
		} else if ( user.getPassword()!= password ) {
			stat = PASSWORD_NOT_MATCH;
		} else {
			stat = LOGIN;
		}
		
		return stat;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
