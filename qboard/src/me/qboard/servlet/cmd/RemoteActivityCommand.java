/*
 *
 */
package me.qboard.servlet.cmd;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import me.qboard.dso.dao.ActivityDAO;
import me.qboard.dso.dao.MemberDAO;
import me.qboard.dso.data.ActivityData;
import me.qboard.dso.data.MemberData;


public class RemoteActivityCommand extends HttpCommand {
    
	private boolean requireLogin = false;
	private String next = null;   

	public RemoteActivityCommand(String next) {
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
    		request.setAttribute("msg", "找不到使用者:"+ userid);
    		next = "/errorPages/error.jsp";
    	}else{
    		session = request.getSession(true);
    		session.setAttribute("user", user);
    		next = "/activity_list.jsp";
    	}
    	
    	
        ActivityDAO dao = new ActivityDAO();
        ArrayList<ActivityData> activities = dao.getActivities();
        
    	request.setAttribute("activities", activities);
    	
    	return this.next;
    }

}
