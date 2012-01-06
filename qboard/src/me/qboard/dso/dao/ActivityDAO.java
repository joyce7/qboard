package me.qboard.dso.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import me.qboard.dso.data.ActivityData;
import me.qboard.system.ConnectionPoolHelper;

public class ActivityDAO {
	
	
	public ArrayList<ActivityData> getActivities () {
		
		ArrayList<ActivityData> al = new ArrayList<ActivityData>();
		final Connection conn = ConnectionPoolHelper.getConnection("qbdb");
		
        Statement stmt = null;
        ResultSet rs = null;
        ActivityData data = null;
        
        try {
            StringBuffer qString = new StringBuffer("SELECT activityid, activityname, activitydate,")
                                              .append("activitytime,cityid,townid,activityaddr,activitybudget,adultnum,")
                                              .append("childrennum,applicationnum,employeeid,attendancefee,")
                                              .append("applicationbegindate,applicationenddate ")
                                              .append("FROM activity");

//            String qString = "SELECT activityid,activityname,activitydate,"+
//            				 "activitytime,cityid,townid,activityaddr,activitybudget,adultnum,"+
//            		         "childrennum,applicationnum,employeeid,attendancefee,"+
//            				 "applicationbegindate,applicationenddate "+
//            		         "FROM ACTIVITY";
        	
        	stmt =conn.createStatement();           
            rs=stmt.executeQuery(qString.toString());
                        
            while (rs.next()) {
            	
            	data = new ActivityData (rs.getInt("activityid"),
            			                 rs.getString("activityname"),
            			                 rs.getDate("activitydate"),
            			                 rs.getDate("activitytime"),
            			                 rs.getInt("cityid"),
            			                 rs.getInt("townid"),
            			                 rs.getString("activityaddr"),
            			                 rs.getInt("activitybudget"),
            			                 rs.getInt("adultnum"),
            			                 rs.getInt("childrennum"),
            			                 rs.getInt("applicationnum"),
            			                 rs.getString("employeeid"),
            			                 rs.getInt("attendancefee"),
            			                 rs.getDate("applicationbegindate"),
            			                 rs.getDate("applicationenddate")
            							);
                al.add(data);
                

            }
                
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                ConnectionPoolHelper.freeConnection("qbdb",conn);
            } catch (Exception ex) {
                System.out.println(this.getClass().getName()+ " ex " + ex);
            }
        }
                
		return al;		
	}

	public ActivityData get(int actid) {

		final Connection conn = ConnectionPoolHelper.getConnection("qbdb");
		
        Statement stmt = null;
        ResultSet rs = null;
        ActivityData data = null;
        
        try {
            StringBuffer qString = new StringBuffer("SELECT activityid, activityname, activitydate,")
                                              .append("activitytime,cityid,townid,activityaddr,activitybudget,adultnum,")
                                              .append("childrennum,applicationnum,employeeid,attendancefee,")
                                              .append("applicationbegindate,applicationenddate ")
                                              .append("FROM activity ")
                                              .append("WHERE activityid=").append(actid);

        	
        	stmt =conn.createStatement();           
            rs=stmt.executeQuery(qString.toString());
                        
            while (rs.next()) {
            	
            	data = new ActivityData (rs.getInt("activityid"),
            			                 rs.getString("activityname"),
            			                 rs.getDate("activitydate"),
            			                 rs.getDate("activitytime"),
            			                 rs.getInt("cityid"),
            			                 rs.getInt("townid"),
            			                 rs.getString("activityaddr"),
            			                 rs.getInt("activitybudget"),
            			                 rs.getInt("adultnum"),
            			                 rs.getInt("childrennum"),
            			                 rs.getInt("applicationnum"),
            			                 rs.getString("employeeid"),
            			                 rs.getInt("attendancefee"),
            			                 rs.getDate("applicationbegindate"),
            			                 rs.getDate("applicationenddate")
            							);
            }
                
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                ConnectionPoolHelper.freeConnection("qbdb",conn);
            } catch (Exception ex) {
                System.out.println(this.getClass().getName()+ " ex " + ex);
            }
        }
                
		return data;		
		
	}
	

}
