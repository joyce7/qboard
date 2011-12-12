package me.qboard.system;

public class SystemInfo
{
	
    
    public static boolean IS_DEV_SITE = false;
    public static String N_IP = null;
	public static String C_IP = null;
	public static String S_IP = null;
	public static String DB_NAME = null;			
	public static String ZONE = null; //主機所在區域位置：n c s(小寫)
	public static String ROOT_PATH = null;
    
    
    public static void dump () {

        System.out.println("::: BEGIN dumping SYSTEM INFO :::");        
        System.out.println("IS_DEV_SITE:"+IS_DEV_SITE);
    	System.out.println("N_IP:"+N_IP);
    	System.out.println("C_IP:"+C_IP);
    	System.out.println("S_IP+"+S_IP);
    	System.out.println("DB_NAME:"+DB_NAME);
    	System.out.println("ROOT_PATH:"+ROOT_PATH);    	
        System.out.println("::: END dumping SYSTEM INFO :::");        
        
    }
    
    
}
