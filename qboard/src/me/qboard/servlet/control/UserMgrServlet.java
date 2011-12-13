package me.qboard.servlet.control;

import me.qboard.servlet.CommandContainer;
import me.qboard.servlet.Controller;
import me.qboard.servlet.cmd.HttpCommand;
import me.qboard.servlet.cmd.UserMgtCommand;

public class UserMgrServlet extends Controller {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CommandContainer container = null;

    private final static String CMD_USER_MGT = "user_mgt";
   
    private final static String PAGE_USER_MGT    = "/user_mgt.jsp";
    
    

    protected HttpCommand lookupCommand(String cmdString) {
        return container.getCommand(cmdString);
    }

    protected void initCommand() {
        try {
            container = new CommandContainer();

            UserMgtCommand userMgtCmd = new UserMgtCommand(PAGE_USER_MGT);
            container.putCommand(CMD_USER_MGT, userMgtCmd);
            

        } catch (Exception ex) {
            System.out.println(" UserMgrServlet ex " + ex);
        }
    }

    protected void freeCommand(String cmdString, HttpCommand cmd) {
        container.freeCommand(cmdString, cmd);
    }

}