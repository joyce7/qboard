package me.qboard.servlet.control;

import me.qboard.servlet.CommandContainer;
import me.qboard.servlet.Controller;
import me.qboard.servlet.cmd.HttpCommand;
import me.qboard.servlet.cmd.LoginCommand;
import me.qboard.servlet.cmd.LogoutCommand;


public class UserSessionControl extends Controller {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5115920374004099863L;

	private CommandContainer _container = null;

    private final static String CMD_LOGIN = "login";
    private final static String CMD_LOGOUT = "logout";
    
    private final static String PAGE_LOGIN = "/login.jsp";
    private final static String PAGE_LOGOUT = "/main.html";

    public UserSessionControl() {
    }

    protected HttpCommand lookupCommand(String cmdString) {
        return _container.getCommand(cmdString);
    }

    protected void initCommand() {
        _container = new CommandContainer();

        try {
            LoginCommand loginCmd = new LoginCommand(PAGE_LOGIN);
            LogoutCommand logoutCmd = new LogoutCommand(PAGE_LOGOUT);

            _container.putCommand(CMD_LOGIN, loginCmd);
            _container.putCommand(CMD_LOGOUT, logoutCmd);
            
        } catch (Exception ex) {
            System.out.println(" initCommand Login ex " + ex);
        }

    }

    protected void freeCommand(String cmdString, HttpCommand cmd) {
        _container.freeCommand(cmdString, cmd);
    }

}