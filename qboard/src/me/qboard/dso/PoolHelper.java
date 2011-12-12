package me.qboard.dso;

import java.sql.Connection;
import java.sql.Statement;

import me.qboard.system.ConnectionPoolHelper;

public class PoolHelper
{
    public PoolHelper()
    {
    }

    public String update( String sql , String dbName)
    {
        StringBuffer msg = new StringBuffer();

        Connection conn = null;
        Statement  stmt = null;

        try {
            conn = ConnectionPoolHelper.getConnection( dbName);
            if( conn == null)
                return msg.append(" NO DATABASE " + dbName).toString();
            stmt = conn.createStatement();
            stmt.execute( sql );
        }
        catch(java.sql.SQLException sqlE){
            System.out.println(" PoolHelper SQLEx SQL" + sql);
            System.out.println(" sql :"+  sql);
            msg.append(" SQL EX " + sqlE);}
        catch (Exception ex) {

            System.out.println(" PoolHelper ex " + ex);
            System.out.println(" update ex " + sql);
        }
        finally {
            try{stmt.close();  }catch (Exception ex) {}
            try{ ConnectionPoolHelper.freeConnection( dbName, conn );} catch( Exception ex){}
        }


        return msg.toString();
    }
}
