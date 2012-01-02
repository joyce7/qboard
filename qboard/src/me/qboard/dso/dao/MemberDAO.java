package me.qboard.dso.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import me.qboard.dso.data.MemberData;
import me.qboard.system.ConnectionPoolHelper;


public class MemberDAO {

	    
    public MemberDAO() {
	}
	
    public MemberData get(String uid) {
    	
		final Connection conn = ConnectionPoolHelper.getConnection("mssqldb");
        Statement stmt = null;
        ResultSet rs = null;   
        MemberData data = null;
        try {
            
        	String qString = "SELECT memberid,membername,gender,password,memberbirth,memberage," +
        			                "cityid,townid,memberaddr,cellphone,memberemail,applicationdate,bankname," +
        			                "branchname,accountnum,memberstateid,issubscriber " +
            				 "FROM member WHERE memberid='"+uid+"'";       
            
            stmt =conn.createStatement();           
            rs=stmt.executeQuery(qString);
            
            while (rs.next()) {
            	data = new MemberData (
            			             rs.getString("memberid").trim(),
            						 rs.getString("membername").trim(),
            						 rs.getBoolean("gender"),
            						 rs.getString("password").trim(),
            						 rs.getDate("memberbirth"),
            						 rs.getInt("memberage"),
            						 rs.getInt("cityid"),
            						 rs.getInt("townid"),
            						 rs.getString("memberaddr"),
            						 rs.getString("cellphone"),
            						 rs.getString("memberemail"),
            						 rs.getDate("applicationdate"),
            						 rs.getString("bankname"),
            						 rs.getString("branchname"),
            						 rs.getString("accountnum"),
            						 rs.getInt("memberstateid"),
            						 rs.getBoolean("issubscriber")
            						 );
            }//while
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                ConnectionPoolHelper.freeConnection("mssqldb",conn);
            } catch (Exception ex) {
                System.out.println(this.getClass()+" ex " + ex);
            }
        } 
        
        return data;
    	
    }
    
	public ArrayList<MemberData> getMembers () {
		
		ArrayList<MemberData> al=new ArrayList<MemberData>();
		final Connection conn = ConnectionPoolHelper.getConnection("mssqldb");
		
        Statement stmt = null;
        ResultSet rs = null;   
        MemberData obj = null;
        
        try {
        	String qString = "SELECT memberid,membername,gender,password,memberbirth,memberage," +
	                			"cityid,townid,memberaddr,cellphone,memberemail,applicationdate,bankname," +
	                			"branchname,accountnum,memberstateid,issubscriber " +
	                		 "FROM member";       
            stmt =conn.createStatement();           
            rs=stmt.executeQuery(qString);
            
            while (rs.next()) {
            	obj = new MemberData (
			             rs.getString("memberid").trim(),
						 rs.getString("membername").trim(),
						 rs.getBoolean("gender"),
						 rs.getString("password").trim(),
						 rs.getDate("memberbirth"),
						 rs.getInt("memberage"),
						 rs.getInt("cityid"),
						 rs.getInt("townid"),
						 rs.getString("memberaddr"),
						 rs.getString("cellphone"),
						 rs.getString("memberemail"),
						 rs.getDate("applicationdate"),
						 rs.getString("bankname"),
						 rs.getString("branchname"),
						 rs.getString("accountnum"),
						 rs.getInt("memberstateid"),
						 rs.getBoolean("issubscriber")
            			);
                al.add(obj);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                ConnectionPoolHelper.freeConnection("mssqldb",conn);
            } catch (Exception ex) {
                System.out.println(this.getClass()+" ex " + ex);
            }
        }
	
		return al;
	
	}
    

} /* END */
