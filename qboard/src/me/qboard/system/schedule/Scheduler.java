package me.qboard.system.schedule;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Timer;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

public class Scheduler
{
    private static final char TASK_DELIM = ',';
    private static final char CONTENT_DELIM = '|';

    private static Scheduler INSTANCE = null;
    private ArrayList<ScheduledTask> _tasks = null;

    private Scheduler()
    {
        _tasks = new ArrayList<ScheduledTask>();
    }

    public static Scheduler getInstance()
    {
        if (INSTANCE == null)
            INSTANCE = new Scheduler();
        return INSTANCE;
    }

    private long getDelayTime(int startHour, int startMinute)
    {
        if (startHour < 0)
            return 0;

        Calendar calendar = Calendar.getInstance();
        if (startHour < calendar.get(Calendar.HOUR_OF_DAY))
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        else if (startHour == calendar.get(Calendar.HOUR_OF_DAY))
            if (startMinute <= calendar.get(Calendar.MINUTE))
                calendar.add(Calendar.DAY_OF_YEAR, 1);

        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.MINUTE, startMinute);
        calendar.set(Calendar.HOUR_OF_DAY, startHour);

        return calendar.getTime().getTime() - System.currentTimeMillis();
    }

    // �榡 "�{���W��|����D���W��(*�N�����)|�X�I�}�l(�D�Ʀr�����ά��ߧY�}�l)|���j�X����|�{�����O"
    // �h�Ӫ��ܥH�r�I�Ϲj
    public void addTask(String str)
    {
        if (str == null)
            return;

        StringTokenizer st = new StringTokenizer(str, String.valueOf(TASK_DELIM));
        while (st.hasMoreTokens())
        {
            String tmp = st.nextToken().trim();
            try
            {
                int idx1 = tmp.indexOf(CONTENT_DELIM);
                int idx2 = tmp.indexOf(CONTENT_DELIM, idx1+1);
                int idx3 = tmp.indexOf(CONTENT_DELIM, idx2+1);
                int idx4 = tmp.indexOf(CONTENT_DELIM, idx3+1);
                String taskName = tmp.substring(0, idx1);
                String exeHost = tmp.substring(idx1+1, idx2);

                int startHour = 0, startMinute = 0;
                String startTime = tmp.substring(idx2+1, idx3);
                if ("*".equals(startTime))
                {
                    startHour = -1;
                    startMinute = -1;
                }else if (startTime!=null&&startTime.startsWith("+")){
                	int addMin=NumberUtils.stringToInt(StringUtils.substringAfter(startTime,"+"));
                	Calendar c=Calendar.getInstance();
                	c.add(Calendar.MINUTE,addMin);
                	startHour = c.get(Calendar.HOUR_OF_DAY);
                    startMinute = c.get(Calendar.MINUTE);
                }else
                {
                    startHour = Integer.parseInt(startTime.substring(0, startTime.indexOf(':')));
                    startMinute = Integer.parseInt(startTime.substring(startTime.indexOf(':') + 1));
                }
                long period = ((long) Integer.parseInt(tmp.substring(idx3+1, idx4))) * 60000;
                String className = tmp.substring(idx4+1);

                // �P�_�O�_������D��
                if ("*".equals(exeHost) || java.net.InetAddress.getLocalHost().getHostName().equals(exeHost))
                    addTask(taskName, className, startHour, startMinute, period);
            }
            catch (Exception ex)
            {
                System.out.println("Scheduler�{���]�w��~ : " + tmp);
            }
        }
    }


    public void addTask(String taskName, String className, int startHour, int startMinute, long period)
    {
        try
        {
            Class<?> clazz = Class.forName(className);
            Timer timer = new Timer(true);
            ScheduledTask task = (ScheduledTask) clazz.newInstance();
            task.setTaskName(taskName);
            System.out.println("Start scheduled task : " + taskName + "...");
            timer.scheduleAtFixedRate(task, getDelayTime(startHour, startMinute), period);
            _tasks.add(task);
        }
        catch (Exception ex)
        {
            System.out.println("Scheduler addTask ERROR : ");
            ex.printStackTrace();
        }
    }

    public Collection<ScheduledTask> getAllTasks()
    {
        return _tasks;
    }

    public void stopTask(String taskName)
    {
        for (Iterator<ScheduledTask> iter = _tasks.iterator(); iter.hasNext(); )
        {
            ScheduledTask task = (ScheduledTask) iter.next();
            if (task.getTaskName().equals(taskName))
            {
                System.out.println("Stop scheduled Task : " + task.getTaskName() + "....");
                task.cancel();
                break;
            }
        }
    }

    public void stopTasks()
    {
        for (Iterator<ScheduledTask> iter = _tasks.iterator(); iter.hasNext(); )
        {
            ScheduledTask task = (ScheduledTask) iter.next();
            System.out.println("Stop scheduled task : " + task.getTaskName() + "....");
            task.cancel();
        }
    }

}


