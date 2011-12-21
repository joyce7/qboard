package me.qboard.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.qboard.servlet.cmd.HttpCommand;
import me.qboard.servlet.cmd.HttpCommandException;
import me.qboard.servlet.util.LoginUtil;

abstract public class Controller extends HttpServlet {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -3776505831662057496L;
 
    private static final String AUTH_ERROR_PAGE = "/login.jsp";
    private static final String NOT_LOGIN_PAGE  = "/login.jsp";
    private static final String ERROR_PAGE      = "/errorPages/error.jsp";
   
    private String CUST_ERROR_PAGE ;
    
    abstract protected HttpCommand lookupCommand(String cmdString);
    abstract protected void freeCommand(String cmdString, HttpCommand cmd);
    abstract protected void initCommand();

    public void init() throws ServletException {
        super.init();
        initCommand();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String next = null;
        //request.setCharacterEncoding("big5");
        String cmdString = request.getParameter("cmd");

        HttpCommand cmd = lookupCommand(cmdString);
        try {
        	
            if (cmd==null) 
                throw new HttpCommandException(HttpCommandException.EXEC_ERROR,
                                               "找不到指令:"+cmdString);        	
            
            
            if (cmd.requireLogin() && !LoginUtil.isLogin(request)) {
                String uri = request.getRequestURI();
                if (uri.startsWith(request.getContextPath()))
                    uri = uri.substring(request.getContextPath().length());

                request.getSession().setAttribute("url",
                        uri + "?" + request.getQueryString());
                
                throw new HttpCommandException(
                        HttpCommandException.NOT_LOGIN_ERROR);
            }

            // NOT ALLOWED TO PERFORM ACCTION
            if (!cmd.isPermitted(request))
                throw new HttpCommandException(HttpCommandException.AUTH_ERROR);
            
            // RUN COMMAND
            next = cmd.execute(request);
            if (cmd.redirect())
                response.sendRedirect(request.getContextPath() + next);
            else {
                RequestDispatcher rd = getServletContext()
                        .getRequestDispatcher(next);
                rd.forward(request, response);
            }
            
        } catch (HttpCommandException e) {
            switch (e.getErrorType()) {
            case HttpCommandException.EXEC_ERROR:
                request.setAttribute("msg", e.getReason());
                next = ERROR_PAGE;
                break;
            case HttpCommandException.AUTH_ERROR:
            	request.setAttribute("msg", "帳號或密碼錯誤"); 
                next = AUTH_ERROR_PAGE;
                break;
            case HttpCommandException.NOT_LOGIN_ERROR:
                request.setAttribute("msg", "NOT_LOGIN");                
                next = NOT_LOGIN_PAGE;
                break;
            case HttpCommandException.CUST_ERROR:
                request.setAttribute("msg", e.getReason());
                next = CUST_ERROR_PAGE;
                break;                
            }
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    next);
            rd.forward(request, response);
            
        } catch (Exception ex) {
            next = ERROR_PAGE;
            request.setAttribute("msg", ex.toString());
            System.out.println("controller ex:" + ex);
            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    next);
            rd.forward(request, response);
        } finally {
            try {
                freeCommand(cmdString, cmd);
            } catch (Exception ex) {
                System.out.println(" free Command ex " + cmdString);
            }
        }

    }
    
    public void setCustPage(String errorPage) {
           this.CUST_ERROR_PAGE = errorPage;    
    }  
    
}