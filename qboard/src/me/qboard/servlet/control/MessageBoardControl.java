package me.qboard.servlet.control;

import me.qboard.servlet.CommandContainer;
import me.qboard.servlet.Controller;
import me.qboard.servlet.cmd.HttpCommand;
import me.qboard.servlet.cmd.MessageBoardCommand;

public class MessageBoardControl extends Controller {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CommandContainer container = null;

    private final static String CMD_MESSAGE_BOARD = "main";
   
    private final static String PAGE_MESSAGE_BOARD    = "/messageboard_main.jsp";
    
    

    protected HttpCommand lookupCommand(String cmdString) {
        return container.getCommand(cmdString);
    }

    protected void initCommand() {
        try {
            container = new CommandContainer();

            MessageBoardCommand messageBoardCommand = new MessageBoardCommand(PAGE_MESSAGE_BOARD);
            container.putCommand(CMD_MESSAGE_BOARD, messageBoardCommand);
            
        } catch (Exception ex) {
            System.out.println(" MessageBoardCommand ex " + ex);
        }
    }

    protected void freeCommand(String cmdString, HttpCommand cmd) {
        container.freeCommand(cmdString, cmd);
    }

}