/*
 *
 */
package me.qboard.servlet.cmd;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import me.qboard.dso.dao.MessageDAO;
import me.qboard.dso.data.MessageData;


public class MessageAddCommand extends HttpCommand {
    
	private boolean requireLogin = true;
	private String next = null;   

	public MessageAddCommand(String next) {
		this.next = next;	    
	}

    public boolean isPermitted(HttpServletRequest request) {
        
        return true;
    }

    public boolean requireLogin() {
        
        return this.requireLogin;
    }

    public String execute(HttpServletRequest request)throws HttpCommandException {
    	
    	MessageDAO dao = new MessageDAO();
        dao.add((String) request.getParameter("title"), 
        		(String) request.getParameter("body"),
        		new java.sql.Date((new java.util.Date()).getTime()), 
        		(String) request.getParameter("author"));
        
        ArrayList<MessageData> messages = dao.getMessages();    
    	request.setAttribute("messages", messages);
    	
    	return this.next;
    }

}
