// *** Generated Source File ***
// Portions Copyright (c) 1996-2000, SilverStream Software, Inc., All Rights Reserved

package me.qboard.dso;


public class DBFreeConnectionFailedException extends java.lang.Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DBFreeConnectionFailedException()
	{
		super();
	}


    public void printInfo( String info)
    {
        System.out.println ("DBFreeConnectionFailed Exception " +
                        info + "\n" +
                        super.getMessage());

    }

	public void  printInfo()
	{
		System.out.println ("DBFreeConnectionFailed Exception " +
                            super.getMessage());
	}


}
