package me.qboard.system.schedule;

import java.util.TimerTask;
import org.apache.log4j.Logger;

public abstract class ScheduledTask extends TimerTask
{
    protected String _taskName = null;
	private static final Logger logger = Logger.getLogger(ScheduledTask.class);

	
    public abstract void execute();

    public void setTaskName(String taskName)
    {
        _taskName = taskName;
    }

    public String getTaskName()
    {
        return _taskName;
    }

    public void run()
    {
        noticeBegin();
        execute();
        noticeEnd();
    }

    public void noticeBegin()
    {
        logger.debug("Time now�G" + new java.util.Date() + " execute daemon " + _taskName);
    }

    public void noticeEnd()
    {
		logger.debug("Time now�G" + new java.util.Date() + " daemon" + _taskName + " complete");
    }
}
