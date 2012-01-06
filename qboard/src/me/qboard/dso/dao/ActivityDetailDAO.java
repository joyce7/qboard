package me.qboard.dso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import me.qboard.dso.data.ActivityDetailData;
import me.qboard.system.ConnectionPoolHelper;

public class ActivityDetailDAO {


	public boolean add(int activityid, String memberid, int applicationadult,int applicationchildren) {
	
		boolean isSuccess = false;
		
	    Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "INSERT INTO activitydetail VALUES(?,?,?,?)";
		
		try {
			connection =
				ConnectionPoolHelper.getConnection("qbdb");

			preparedStatement =
				connection.prepareStatement(query);	
			preparedStatement.setInt(1, activityid);
			preparedStatement.setString(2, memberid);
			preparedStatement.setInt(3, applicationadult);
			preparedStatement.setInt(4, applicationchildren);
			
			preparedStatement.executeUpdate();
			
			isSuccess = true;
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
					ConnectionPoolHelper.freeConnection("qbdb",
						connection);
				} catch (Exception e) {
	                System.out.println(this.getClass().getName()+ " ex " + e);
				}
			}

		} // t-c-f

		
		return isSuccess;
		
	}

	public ActivityDetailData get(int actid, String memberid) {

		final Connection conn = ConnectionPoolHelper.getConnection("qbdb");
		
        Statement stmt = null;
        ResultSet rs = null;
        ActivityDetailData data = null;
        
        try {
            StringBuffer qString = new StringBuffer("SELECT activityid, memberid, applicationadult,applicationchildren ")
                                              .append("FROM activitydetail ")
                                              .append("WHERE activityid=").append(actid).append(" AND ")
                                              .append("memberid='").append(memberid).append("'");

        	
        	// System.out.println("qstring-->"+qString);
        	
            stmt =conn.createStatement();           
            rs=stmt.executeQuery(qString.toString());
                        
            while (rs.next()) {
            	
            	data = new ActivityDetailData (rs.getInt("activityid"),
            			                 rs.getString("memberid"),
            			                 rs.getInt("applicationadult"),
            			                 rs.getInt("applicationchildren")
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

	public ActivityDetailData getActivityTOT(int actid) {

		final Connection conn = ConnectionPoolHelper.getConnection("qbdb");
		
        Statement stmt = null;
        ResultSet rs = null;
        ActivityDetailData data = null;
        
        try {
            StringBuffer qString = new StringBuffer("SELECT SUM(applicationadult) adulttot,SUM(applicationchildren) childtot ")
                                              .append("FROM activitydetail ")
                                              .append("WHERE activityid=").append(actid);

        	
        	//System.out.println("qstring-->"+qString);
        	
            stmt =conn.createStatement();           
            rs=stmt.executeQuery(qString.toString());
                        
            while (rs.next()) {
            	
            	data = new ActivityDetailData (actid,
            			                 "0000",
            			                 rs.getInt("adulttot"),
            			                 rs.getInt("childtot")
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

	public int update (int activityid, String memberid, int applicationadult,int applicationchildren) {
		
		int rows = 0;
		
	    Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "UPDATE activitydetail " +
				       "SET applicationadult=?, applicationchildren=? " +
				       "WHERE activityid=" +activityid +
				       " AND memberid='"+memberid+"'";
		//System.out.println("q:"+query+">>"+activityid+"::"+memberid + "::" + applicationadult +"::"+applicationchildren+"<<"  );
		
		
		try {
			connection =
				ConnectionPoolHelper.getConnection("qbdb");

			preparedStatement =
				connection.prepareStatement(query);	
			preparedStatement.setInt(1, applicationadult);
			preparedStatement.setInt(2, applicationchildren);
			
			rows = preparedStatement.executeUpdate();
			
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
					ConnectionPoolHelper.freeConnection("qbdb",
						connection);
				} catch (Exception e) {
	                System.out.println(this.getClass().getName()+ " ex " + e);
				}
			}

		} // t-c-f

		
		return rows;
		
		
		
	}
	
	public boolean remove(int actid, String memberid) {
		
		boolean isSuccess = false;
		
	    Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "DELETE FROM activitydetail"+
		               " WHERE activityid=? AND memberid=?";
		
		System.out.println("query->"+query+"<<"+actid+">> <<"+memberid+">>");
		
		try {
			connection =
				ConnectionPoolHelper.getConnection("qbdb");

			preparedStatement =
				connection.prepareStatement(query);	
			preparedStatement.setInt(1, actid);
			preparedStatement.setString(2, memberid);
			
			preparedStatement.executeUpdate();
			
			isSuccess = true;
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
					ConnectionPoolHelper.freeConnection("qbdb",
						connection);
				} catch (Exception e) {
	                System.out.println(this.getClass().getName()+ " ex " + e);
				}
			}

		} // t-c-f
		
		return isSuccess;
		
	}

	

}
