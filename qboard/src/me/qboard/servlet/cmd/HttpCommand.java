package me.qboard.servlet.cmd;

import javax.servlet.http.*;

public abstract class HttpCommand implements Cloneable
{
    public HttpCommand duplicateInstance()
    {
        HttpCommand result = null;
        try
        {
            result = (HttpCommand) this.clone();
        }
        catch (CloneNotSupportedException ex)
        {
            System.out.println("Error : " + ex);
        }
        return result;
    }

    public boolean redirect()
    {
        return false;
    }

    public abstract boolean isPermitted(HttpServletRequest request);
    public abstract boolean requireLogin();
    public abstract String execute(HttpServletRequest request) throws HttpCommandException;
}
