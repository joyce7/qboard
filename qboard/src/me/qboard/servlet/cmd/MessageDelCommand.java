/*
 *
 */
package me.qboard.servlet.cmd;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import me.qboard.dso.dao.MessageDAO;
import me.qboard.dso.data.MessageData;


public class MessageDelCommand extends HttpCommand {
    
	private boolean requireLogin = true;
	private String next = null;   

	public MessageDelCommand(String next) {
		this.next = next;	    
	}

    public boolean isPermitted(HttpServletRequest request) {
        
        return true;
    }

    public boolean requireLogin() {
        
        return this.requireLogin;
    }

    public String execute(HttpServletRequest request)throws HttpCommandException {
    	
    	int msgid = request.getParameter("msgid")==null?-1:Integer.parseInt(request.getParameter("msgid"));
    	MessageDAO dao = new MessageDAO();
        dao.remove(msgid);
        
        ArrayList<MessageData> messages = dao.getMessages();    
    	request.setAttribute("messages", messages);
    	
    	return this.next;
    }

}
