package me.qboard.system;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.*;

import javax.sql.*;
import javax.naming.*;

public class ConnectionPoolHelper {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger
            .getLogger(ConnectionPoolHelper.class);

    private static HashMap<String, DataSource> MAP = new HashMap<String, DataSource>();

    protected static void addDBPoolJNDI(String poolName, String jndiName) {
        try {
            Context ctx = new InitialContext();
            MAP.put(poolName, (DataSource) ctx.lookup("java:comp/env/"
                    + jndiName));
            logger.debug("adding dbpool "+poolName);
        } catch (Exception ex) {
            logger.fatal("ConnectionPoolHelper addDBPoolJNDI " + poolName
                    + "ERROR : " + ex);
        }
    }

    public static Connection getConnection(String poolName) {
        Connection result = null;
        try {
            if (poolName != null)
                result = ((DataSource) MAP.get(poolName)).getConnection();
        } catch (Exception ex) {
            logger.error("( " + poolName + " )"
                    + "ConnectionPoolHelper getConnection ERROR : " + ex);
        }
        return result;
    }

    public static void freeConnection(String poolName, Connection conn) {
        try {
            if (conn != null)
                conn.close();
        } catch (Exception ex) {
            logger.error("( " + poolName
                    + ") ConnectionPoolHelper freeConnection ERROR : " + ex);
        }
    }
    

}