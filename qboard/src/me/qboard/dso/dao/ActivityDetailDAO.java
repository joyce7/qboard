package me.qboard.dso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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



}
