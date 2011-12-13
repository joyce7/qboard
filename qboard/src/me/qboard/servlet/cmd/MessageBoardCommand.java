/*
 *
 */
package me.qboard.servlet.cmd;


import javax.servlet.http.HttpServletRequest;


public class MessageBoardCommand extends HttpCommand {
    
	private boolean requireLogin = false;
	private String next = null;   

	public MessageBoardCommand(String next) {
		this.next = next;	    
	}

    public boolean isPermitted(HttpServletRequest request) {
        
        return true;
    }

    public boolean requireLogin() {
        
        return this.requireLogin;
    }

    public String execute(HttpServletRequest request)throws HttpCommandException {

        return this.next;
    }

}
