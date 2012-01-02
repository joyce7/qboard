/*
 *
 */
package me.qboard.servlet.cmd;


import javax.servlet.http.HttpServletRequest;

import me.qboard.dso.dao.ActivityDAO;
import me.qboard.dso.dao.ActivityDetailDAO;
import me.qboard.dso.data.MemberData;



public class ActivityDetailAddCommand extends HttpCommand {
    
	private boolean requireLogin = true;
	private String next = null;   

	public ActivityDetailAddCommand(String next) {
		this.next = next;	    
	}

    public boolean isPermitted(HttpServletRequest request) {
        
        return true;
    }

    public boolean requireLogin() {
        
        return this.requireLogin;
    }

    public String execute(HttpServletRequest request)throws HttpCommandException {
    	
    	ActivityDetailDAO dao = new ActivityDetailDAO();

    	
    	if (dao.add(  
    			Integer.parseInt(request.getParameter("actid")),
    			((MemberData) request.getSession().getAttribute("user")).getMemberid(), 
        		Integer.parseInt(request.getParameter("adultnum")) , 
        		Integer.parseInt(request.getParameter("kidnum")))
        	) {
    		
    		ActivityDAO dao2 = new ActivityDAO();
    		request.setAttribute("activities", dao2.getActivities());
    		request.setAttribute("msg", "報名成功!!");
   
    	}else {
    		request.setAttribute("activity", request.getParameter("actid"));
    		request.setAttribute("msg", "報名失敗!");
    		this.next = "/activity_regi.jsp";
    	}
    	return this.next;
    }

}
