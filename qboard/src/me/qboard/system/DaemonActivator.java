package me.qboard.system;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

//import notify.sms.core.MobileMgr;

//import socket.NESessionMgr;

public class DaemonActivator extends HttpServlet implements
        ServletContextListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void contextInitialized(ServletContextEvent sce) {
        try {
            // initial
            SystemInfoInitializer.initVarialbes(sce);
            SystemInfoInitializer.initConfig(sce);
            SystemInfoInitializer.initDB(sce);

            if ( !SystemInfo.IS_DEV_SITE ) {
                
    			//start SocketServer thread			    
                //System.out.println("Start NE Session Socket Server");
			    //NESessionMgr.initNE();
			    //System.out.println("Finish NE Session Socket Server");
			    //start Schedule Task						
	            SystemInfoInitializer.initTask(sce);            
			    
            }

        } catch (Exception e) {
            System.out.println("DaemonActivator ERROR : " + e);
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        //system.ResourceCleaner
        //MobileMgr.getInstance().stop("doss");
        //NESessionMgr.destroy();
    }

}