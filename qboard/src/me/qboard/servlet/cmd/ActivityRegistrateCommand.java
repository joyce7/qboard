package me.qboard.servlet.cmd;

import javax.servlet.http.HttpServletRequest;

import me.qboard.dso.dao.ActivityDAO;
import me.qboard.dso.data.ActivityData;

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

		String actid = request.getParameter("actid");
		
		ActivityDAO dao = new ActivityDAO();
		ActivityData data = dao.get(actid);
		
		//MemberDAO mdao = new MemberDAO();
		// mdao.get(  ((MemberData) request.getSession().getAttribute("user")).getMemberid()   );
		
		request.setAttribute("activity", data);

		return this.next;
	}


}
