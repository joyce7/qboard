package me.qboard.servlet.control;

import me.qboard.servlet.CommandContainer;
import me.qboard.servlet.Controller;
import me.qboard.servlet.cmd.ActivityListCommand;
import me.qboard.servlet.cmd.ActivityRegistrateCommand;
import me.qboard.servlet.cmd.HttpCommand;

public class ActivityControl extends Controller {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CommandContainer container = null;

    private final static String CMD_LIST = "list";
    private final static String CMD_REGISTR = "registrate";
   
    private final static String PAGE_LIST    = "/activity_list.jsp";
    private final static String PAGE_REGISTR    = "/activity_regi.jsp";
    

    protected HttpCommand lookupCommand(String cmdString) {
        return container.getCommand(cmdString);
    }

    protected void initCommand() {
        try {
            container = new CommandContainer();

            ActivityListCommand activityListCommand = new ActivityListCommand(PAGE_LIST);
            container.putCommand(CMD_LIST, activityListCommand);

            ActivityRegistrateCommand activityRegistrateCommand = new ActivityRegistrateCommand(PAGE_REGISTR);
            container.putCommand(CMD_REGISTR, activityRegistrateCommand);
            
        } catch (Exception ex) {
            System.out.println(" MessageBoardCommand ex " + ex);
        }
    }

    protected void freeCommand(String cmdString, HttpCommand cmd) {
        container.freeCommand(cmdString, cmd);
    }

}