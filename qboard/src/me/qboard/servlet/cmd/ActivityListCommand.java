/*
 *
 */
package me.qboard.servlet.cmd;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import me.qboard.dso.dao.ActivityDAO;
import me.qboard.dso.data.ActivityData;


public class ActivityListCommand extends HttpCommand {
    
	private boolean requireLogin = false;
	private String next = null;   

	public ActivityListCommand(String next) {
		this.next = next;	    
	}

    public boolean isPermitted(HttpServletRequest request) {
        
        return true;
    }

    public boolean requireLogin() {
        
        return this.requireLogin;
    }

    public String execute(HttpServletRequest request)throws HttpCommandException {

        ActivityDAO dao = new ActivityDAO();
        ArrayList<ActivityData> activities = dao.getActivities();
        
    	request.setAttribute("activities", activities);
    	
    	return this.next;
    }

}
