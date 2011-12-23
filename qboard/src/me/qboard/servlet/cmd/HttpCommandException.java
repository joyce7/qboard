package me.qboard.servlet.cmd;



public class HttpCommandException extends Exception
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6161777510406224317L;
	/**
	 * 
	 */
	
	public static final int NOT_LOGIN_ERROR = 0;
    public static final int AUTH_ERROR = 1;
    public static final int EXEC_ERROR = 2;
    public static final int CUST_ERROR = 9;  // custimized error

    protected int _errorType = NOT_LOGIN_ERROR;
    String _reason = null;

    public HttpCommandException(int errorType)
    {
        super();
        _errorType = errorType;
    }

    public HttpCommandException(int errorType, String reason)
    {
        super();
        _errorType = errorType;
        _reason = reason;
    }

    public int getErrorType()
    {
        return _errorType;
    }

    public String getReason()
    {
        return _reason;
    }

    public String toString()
    {
        return _reason;
    }
}
