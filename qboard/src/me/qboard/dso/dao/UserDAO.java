package me.qboard.dso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import me.qboard.dso.data.UserData;
import me.qboard.system.ConnectionPoolHelper;


public class UserDAO {

	String primTab  = "qms_users";
	String primView = "vw_qms_users";	 
	String dossTab  = "dcs_user";
	    
    public UserDAO() {
	}
	
    public UserData get(String uid) {
    	
		final Connection conn = ConnectionPoolHelper.getConnection("qbdb");
		
        Statement stmt = null;
        ResultSet rs = null;   
        UserData data = null;
        try {
            String qString = "SELECT userid, uname, ophone, hphone, mobile, password " +
            				 "FROM member WHERE userid='"+uid+"'";            
            stmt =conn.createStatement();           
            rs=stmt.executeQuery(qString);
            
            System.out.println("====>"+qString);
            
            while (rs.next()) {
            	data = new UserData (rs.getString("userid"),
            						 rs.getString("uname"),
            						 rs.getString("ophone"),
            						 rs.getString("hphone"),
            						 rs.getString("mobile"),
            						 rs.getString("password")
            						 );
            }//while
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                ConnectionPoolHelper.freeConnection("qbdb",conn);
            } catch (Exception ex) {
                System.out.println("  UserDAO ex " + ex);
            }
        } 
        
        return data;
    	
    }
    
	public ArrayList<UserData> getUsers () {
		
		ArrayList<UserData> al=new ArrayList<UserData>();
		final Connection conn = ConnectionPoolHelper.getConnection("qbdb");
		
        Statement stmt = null;
        ResultSet rs = null;   
        UserData obj = null;
        
        try {
            String qString = "SELECT userid, uname, ophone, hphone, mobile, password FROM member";            
            stmt =conn.createStatement();           
            rs=stmt.executeQuery(qString);
            
            while (rs.next()) {
            	obj = new UserData (rs.getString("userid"),
            						rs.getString("uname"),
            						rs.getString("ophone"),
            						rs.getString("hphone"),
            						rs.getString("mobile"),
            						rs.getString("password")
            						);
                al.add(obj);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                ConnectionPoolHelper.freeConnection("qbdb",conn);
            } catch (Exception ex) {
                System.out.println("  ProjectDso ex " + ex);
            }
        }
	
		return al;
	
	}
    

	
	// delete UsersData
	public boolean delete(String id) {

	    Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "DELETE FROM "+primTab+
		               " WHERE id=?";
		boolean results = false;


		try {
			connection =
				ConnectionPoolHelper.getConnection("qbdb");

			preparedStatement =
				connection.prepareStatement(query);

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id.trim());
			preparedStatement.executeUpdate();
			results = true;
			// Handle any SQL errors
		} catch (SQLException e) {

			throw new RuntimeException(
				"A database error occured. " + e.getMessage());

		} finally {

		    if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (connection != null) {
				try {
					ConnectionPoolHelper.freeConnection(
						"qbdb",connection);
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}

		} // t-c-f
		
		return results;
	}

} /* END */
