package me.qboard.servlet.cmd;

import javax.servlet.http.HttpServletRequest;

import me.qboard.dso.dao.ActivityDAO;
import me.qboard.dso.dao.ActivityDetailDAO;
import me.qboard.dso.data.ActivityData;
import me.qboard.dso.data.ActivityDetailData;
import me.qboard.dso.data.MemberData;

public class ActivityRegistrateCommand extends HttpCommand {

	private boolean requireLogin = true;
	private String next = null;   
	
	public ActivityRegistrateCommand(String next) {
		this.next = next;
	}

	@Override
	public boolean isPermitted(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return true;
	}

	
	@Override
	public boolean requireLogin() {
		return this.requireLogin;
	}

	public boolean isRequireLogin() {
		return requireLogin;
	}

	public void setRequireLogin(boolean requireLogin) {
		this.requireLogin = requireLogin;
	}
	
	@Override
	public String execute(HttpServletRequest request)
			throws HttpCommandException {

		int actid = Integer.parseInt(request.getParameter("actid"));
		
		ActivityDAO dao = new ActivityDAO();
		ActivityData data = dao.get(actid);
		

				
		ActivityDetailDAO dtdao = new ActivityDetailDAO();
		ActivityDetailData sumdata = dtdao.getActivityTOT(actid);
		
		ActivityDetailData dtdata = dtdao.get(actid,((MemberData) request.getSession().getAttribute("user")).getMemberid()); 
		// redirect to update page if already registrated
		if ( dtdata != null ) {
			request.setAttribute("activitydetail", dtdata);
			this.next = "/activity_regi_update.jsp";
		} else {
			this.next = "/activity_regi.jsp";
		}
		
		request.setAttribute("activity", data);
		request.setAttribute("pcount", sumdata);
		return this.next;
	}


}
