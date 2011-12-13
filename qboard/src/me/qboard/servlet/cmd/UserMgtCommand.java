/*
 * Created on 2004/11/11
 *
 */
package me.qboard.servlet.cmd;


import javax.servlet.http.HttpServletRequest;

/**
 * @author jc
 *
 */

public class UserMgtCommand extends HttpCommand {
    
	private boolean _requireLogin = false;
	private String _next = null;   

	public UserMgtCommand(String next) {
		_next = next;	    
	}

    public boolean isPermitted(HttpServletRequest request) {
        // TODO Auto-generated method stub
        return true;
    }

    public boolean requireLogin() {
        // TODO Auto-generated method stub
        return _requireLogin;
    }

    public String execute(HttpServletRequest request)throws HttpCommandException {

        return _next;
    }

}
