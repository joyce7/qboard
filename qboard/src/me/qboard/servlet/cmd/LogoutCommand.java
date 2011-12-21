package me.qboard.servlet.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand extends HttpCommand {

    String next = null;
    public LogoutCommand(String next) {
        this.next = next;
    }

    @Override
    public String execute(HttpServletRequest request)
            throws HttpCommandException {

        // String next = (String) request.getSession().getAttribute("url");
        // if  (next == null)  next = this.next;
       
        HttpSession session = null;

        try {          
            session = request.getSession(true);                    
            session.removeAttribute("user");
            session.removeAttribute("url");
            session.invalidate();
            
        } catch (Exception ex) {
            ex.printStackTrace();                     
        }

        return next;
    }

    @Override
    public boolean isPermitted(HttpServletRequest request) {
        return true;
    }

    @Override
    public boolean requireLogin() {
        return false;
    }
    
    public boolean redirect() {
        return true;
    }


}
