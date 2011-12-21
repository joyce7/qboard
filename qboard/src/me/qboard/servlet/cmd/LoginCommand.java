package me.qboard.servlet.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import me.qboard.dso.data.UserData;
import me.qboard.web.UserSessionUtil;

public class LoginCommand extends HttpCommand {

    private String next = null;

    public LoginCommand(String next) {
    	this.next = next;
    }

    public boolean requireLogin() {
        return false;
    }

    public boolean isPermitted(HttpServletRequest request) {
        return true;
    }

    public boolean redirect() {
        return true;
    }

    public String execute(HttpServletRequest request)
            throws me.qboard.servlet.cmd.HttpCommandException {

        String userid = (String) request.getParameter("userid");
        String password = (String) request.getParameter("password");
        
        HttpSession session = null;
        
        if  (UserSessionUtil.isAuthenticated(userid, password)) {
        	UserData user = new UserData(userid, "派大興", "","","" );
        	session = request.getSession(true);
        	session.setAttribute("user",  user);
        	        	
        	next = (String) session.getAttribute("url");
        } else {
        	 throw new HttpCommandException (HttpCommandException.AUTH_ERROR,
                     "Authentication Fail!");   
        }
                
        return next;
    }

}