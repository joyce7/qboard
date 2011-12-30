package me.qboard.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.qboard.dso.dao.UserDAO;
import me.qboard.dso.data.UserData;

public class LoginBot extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	//String sessionid = request.getParameter("ssnid");
    	String userid = request.getParameter("userid");
    	
    	//System.out.println("Bot responding: i recieved sessionid: ["+ request.getRequestedSessionId() +"] and memberid:["+memberid+"]");
    	
        HttpSession session = request.getSession(true);
        session.setAttribute("remoteSession", request.getRequestedSessionId());
		UserDAO dao = new UserDAO();		
		UserData user = dao.get(userid);
    	session.setAttribute("user",  user);

        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/messageboard_main.jsp");
        rd.forward(request, response);    	
        //session.setAttribute(user, arg1)
        		//;
    	
    	//session.getSessionContext().
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	this.doGet(request, response);
    }

	
	
}
