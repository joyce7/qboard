package me.qboard.servlet.util;

import javax.servlet.http.HttpServletRequest;

public class LoginUtil
{
    //private static final String USER_STRING = "userid";
    private static final String REQ_STRING = "url";
    private static final String REQ_ATTRS = "reqAttrs";

    // 
    public static final boolean isLogin(HttpServletRequest request)
    {
        return (request.getSession().getAttribute("user") != null);
    }

    public static final void removeLoginUserData(HttpServletRequest request)
    {
        // request.getSession().removeAttribute(USER_STRING);
        if  (request.getSession()!= null)
             request.getSession().invalidate();
    }

	public static String getReqString() {
		return REQ_STRING;
	}

	public static String getReqAttrs() {
		return REQ_ATTRS;
	}
}
