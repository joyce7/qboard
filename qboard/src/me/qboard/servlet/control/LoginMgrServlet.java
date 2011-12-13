package me.qboard.servlet.control;

import me.qboard.servlet.CommandContainer;
import me.qboard.servlet.Controller;
import me.qboard.servlet.cmd.HttpCommand;
import me.qboard.servlet.cmd.LoginCommand;


public class LoginMgrServlet extends Controller {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5115920374004099863L;

	private CommandContainer _container = null;

    private final static String CMD_LOGIN = "login";
    private final static String PAGE_LOGIN = "/qms_header.jsp";

    public LoginMgrServlet() {
    }

    protected HttpCommand lookupCommand(String cmdString) {
        return _container.getCommand(cmdString);
    }

    protected void initCommand() {
        _container = new CommandContainer();

        try {
            LoginCommand loginCmd = new LoginCommand(PAGE_LOGIN);

            _container.putCommand(CMD_LOGIN, loginCmd);
        } catch (Exception ex) {
            System.out.println(" initCommand Login ex " + ex);
        }

    }

    protected void freeCommand(String cmdString, HttpCommand cmd) {
        _container.freeCommand(cmdString, cmd);
    }

}