/*
 *
 */
package me.qboard.servlet.cmd;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import me.qboard.dso.dao.MemberDAO;
import me.qboard.dso.dao.MessageDAO;
import me.qboard.dso.data.MemberData;
import me.qboard.dso.data.MessageData;


public class RemoteMessageBoardCommand extends HttpCommand {
    
	private boolean requireLogin = false;
	private String next = null;   

	public RemoteMessageBoardCommand(String next) {
		this.next = next;	    
	}

    public boolean isPermitted(HttpServletRequest request) {
        
        return true;
    }

    public boolean requireLogin() {
        
        return this.requireLogin;
    }

    public String execute(HttpServletRequest request)throws HttpCommandException {

        String userid = (String) request.getParameter("userid");
        
        HttpSession session = null;
        
		MemberDAO udao = new MemberDAO();	
		MemberData user = udao.get(userid);

    	if (user == null) {
    		//throw new HttpCommandException(HttpCommandException.CUST_ERROR, "找不到使用者:"+ userid);
    		request.setAttribute("msg", "找不到使用者:"+ userid);
    		next = "/errorPages/error.jsp";
    	}else{
    		session = request.getSession(true);
    		session.setAttribute("user", user);
    		next = "/messageboard_main.jsp";
    	}
    	
    	
    	MessageDAO dao = new MessageDAO();
        ArrayList<MessageData> messages = dao.getMessages();
        
    	request.setAttribute("messages", messages);
    	
    	return this.next;
    }

}
