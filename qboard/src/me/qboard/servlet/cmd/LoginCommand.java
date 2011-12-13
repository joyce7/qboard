package me.qboard.servlet.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import me.qboard.dso.data.UserData;
import me.qboard.web.UserSessionUtil;

public class LoginCommand extends HttpCommand {

    private String next = null;

    public LoginCommand(String next) {
        next = this.next;
    }

    public boolean requireLogin() {
        return false;
    }

    public boolean isPermitted(HttpServletRequest request) {
        return true;
    }

    public boolean redirect() {
        return true;
    }

    public String execute(HttpServletRequest request)
            throws me.qboard.servlet.cmd.HttpCommandException {

        String userid = (String) request.getParameter("userid");
        String password = (String) request.getParameter("password");
        String errMsg = null;
        
        
        if  (UserSessionUtil.isAuthenticated(userid, password)) {
        	HttpSession session = request.getSession();
        	session.setAttribute("user", new UserData(userid, "", "","","" ) );
        } else {
        	errMsg = "帳號或密碼錯誤";
        }
                
        request.setAttribute("err_msg",errMsg);
        return next;
    }

}