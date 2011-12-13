package me.qboard.servlet;

import java.util.HashMap;

import me.qboard.servlet.cmd.HttpCommand;

public class CommandContainer
{
    private static final int MAX_CMD = 30;
    private static final int WAIT_TIME = 1000;
    private static final int MAX_WAIT_TIME = 3000;

    private HashMap<String, HttpCommand> _base = null;
    private HashMap<String, CommandData[]> _cmds = null;

    public CommandContainer()
    {
        _base = new HashMap<String, HttpCommand>();
        _cmds = new HashMap<String, CommandData[]>();
    }

    public void putCommand(String cmdName, HttpCommand cmd) throws Exception
    {
        _base.put(cmdName, cmd);
        CommandData[] cmds = new CommandData[MAX_CMD];
        _cmds.put(cmdName, cmds);
    }

    private synchronized HttpCommand get(String cmdName)
    {
        int firstWaitCmd = -1;
        CommandData[] cmdDatas = (CommandData[]) _cmds.get(cmdName);
        if (cmdDatas == null)
            return null;

        for (int i=0; i<cmdDatas.length; i++)
        {
            CommandData cmdData = cmdDatas[i];
            if (cmdData != null && !cmdData.isUsed())
            {
                cmdData.setUsed(true);
                HttpCommand cmd = cmdData.getCommand();
                return cmd; // ���i�Τ�Command
            }
            else if (cmdData == null && firstWaitCmd == -1)
                firstWaitCmd = i; // �O��Ĥ@��null��CommandData
        }

        if (firstWaitCmd != -1)
        {
            HttpCommand cmd = (HttpCommand) _base.get(cmdName);
            cmdDatas[firstWaitCmd] = new CommandData(cmd.duplicateInstance());
            cmdDatas[firstWaitCmd].setUsed(true);
            return cmdDatas[firstWaitCmd].getCommand();
        }

        return null;
    }

    public synchronized HttpCommand getCommand(String cmdName)
    {
        HttpCommand result = null;
        long startTime = System.currentTimeMillis();

        while ((result = get(cmdName)) == null)
        {
            try
            {
                wait(WAIT_TIME);
            }
            catch (InterruptedException e) {}
            if (System.currentTimeMillis() - startTime > MAX_WAIT_TIME)
                return null;
        }
        return result;
    }

    public synchronized void freeCommand(String cmdName, HttpCommand cmd)
    {
        if (cmd == null)
            return;

        CommandData[] cmdDatas = (CommandData[]) _cmds.get(cmdName);
        for (int i=0; i<cmdDatas.length; i++)
        {
            if (cmdDatas[i].isMine(cmd))
            {
                cmdDatas[i].returnCommand(cmd);
                notifyAll();
                break;
            }
        }
    }
}

class CommandData
{
    HttpCommand _cmd = null;
    boolean _isUsed = false;

    public CommandData(HttpCommand cmd)
    {
        _cmd = cmd;
    }

    public HttpCommand getCommand()
    {
        return _cmd;
    }

    public boolean isUsed()
    {
        return _isUsed;
    }

    public void setUsed(boolean used)
    {
        _isUsed = used;
    }

    public boolean isMine(HttpCommand cmd)
    {
        if (cmd == null)
            return false;
        return cmd == _cmd;
    }

    public void returnCommand(HttpCommand cmd)
    {
        _isUsed = false;
    }
}
