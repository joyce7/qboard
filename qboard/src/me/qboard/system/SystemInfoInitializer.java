package me.qboard.system;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import me.qboard.system.schedule.Scheduler;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class SystemInfoInitializer {
    
    public static void initDB(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();

        // initial database connections
        String dbNames = ctx.getInitParameter("db_names");
        java.util.StringTokenizer st = new java.util.StringTokenizer(dbNames,
                ",");
        while (st.hasMoreTokens()) {
            String name = st.nextToken();
			//
			//if (name.startsWith(SystemInfo.DB_NAME.substring(0,1)))
         	   ConnectionPoolHelper.addDBPoolJNDI(name, "jdbc/" + name);
        }
    }

    public static void initVarialbes(ServletContextEvent sce) {
        // initial static varaibles       
        ServletContext ctx = sce.getServletContext();
        SystemInfo.DB_NAME = ctx.getInitParameter("db_name");

        SystemInfo.IS_DEV_SITE = "true".equals(ctx.getInitParameter("is_dev"));
        SystemInfo.N_IP = ctx.getInitParameter("n_ip");
        SystemInfo.C_IP = ctx.getInitParameter("c_ip");
        SystemInfo.S_IP = ctx.getInitParameter("s_ip");	
        
        SystemInfo.ROOT_PATH = ctx.getRealPath("/");
        
    }
    
    public static void initConfig (ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        
        // Default Logger Config
        String props = ctx.getInitParameter("log_props");
        props = SystemInfo.ROOT_PATH + "WEB-INF" + File.separator + props;
            
		if(props == null || props.length() == 0 ||
			!(new File(props)).isFile()){
			System.err.println(
			"ERROR: Cannot read the configuration file. " +
			"Please check the path of the config init param in web.xml");
		} else {

			PropertyConfigurator.configure(props);
			Logger log = Logger.getLogger(SystemInfoInitializer.class); 
			log.info("Root logger initiated.");
		}
		
    }
    
	public static void initTask(ServletContextEvent sce)
	{       
		ServletContext ctx = sce.getServletContext(); 
		Scheduler.getInstance().addTask(ctx.getInitParameter("daemon")); 
	}	

    public void contextDestroyed(javax.servlet.ServletContextEvent evt) {
        Scheduler.getInstance().stopTasks();
    }

}