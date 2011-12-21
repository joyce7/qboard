package me.qboard.web;

public class UserSessionUtil {

	/**
	 * @param args
	 */
	
	
	
	public static boolean isAuthenticated(String userid, String password) {
		
		return ("abc".equals(userid)&& "123".equals(password))?true:false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
