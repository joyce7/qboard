package me.qboard.dso.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import me.qboard.dso.data.MessageData;
import me.qboard.system.ConnectionPoolHelper;

public class MessageDAO {
	
	
	public ArrayList<MessageData> getMessages () {
		
		ArrayList<MessageData> al = new ArrayList<MessageData>();
		final Connection conn = ConnectionPoolHelper.getConnection("qbdb");
		
        Statement stmt = null;
        ResultSet rs = null;
        MessageData data = null;
        
        try {
            String qString = "SELECT id, title, body, created_at, author FROM messages ORDER BY id DESC";            
            stmt =conn.createStatement();           
            rs=stmt.executeQuery(qString);
            
            while (rs.next()) {
            	data = new MessageData (rs.getInt("id"),
            							rs.getString("title"),
            							rs.getString("body"),
            							rs.getDate("created_at"),
            							rs.getString("author")
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
	
	public boolean add(String title, String body, Date createdAt, String author) {
		
		boolean isSuccess = false;
		
	    Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "INSERT INTO messages"+
		               " VALUES(seq_messages.NEXTVAL,?,?,?,?)";

		
		try {
			connection =
				ConnectionPoolHelper.getConnection("qbdb");

			preparedStatement =
				connection.prepareStatement(query);	
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, body);
			preparedStatement.setDate(3, createdAt);
			preparedStatement.setString(4, author);

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
