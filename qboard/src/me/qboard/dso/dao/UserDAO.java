package me.qboard.dso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import me.qboard.dso.data.UserData;
import me.qboard.system.ConnectionPoolHelper;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class UserDAO {

	String primTab  = "qms_users";
	String primView = "vw_qms_users";	 
	String dossTab  = "dcs_user";
	    
    public UserDAO() {
	}
	
	
	public boolean add(String empId, String sEmp) {

//	    ChtEmployee emp = null;
//		try {
//			emp = ChtEmployeeDir.getInstance().getEmployee(empId);
//		} catch (ChtLdapException e1) {
//			System.out.println("LDAP����:" + e1);
//		} catch (Exception e) {
//			System.out.println("LDAP��~" + e);
//		}

		// Database variables
	    Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "INSERT INTO "+primTab+
		               " VALUES(?,?,?,?,?,?)";
		boolean results = false;

		try {
			connection =
				ConnectionPoolHelper.getQmsConnection();

			preparedStatement =
				connection.prepareStatement(query);

//			preparedStatement.setString(1, empId);
//			preparedStatement.setString(2, sEmp);
//			preparedStatement.setString(3, emp.getEmpNum());
//			preparedStatement.setString(4, emp.getEmpName());
//			preparedStatement.setString(5, emp.getEmpDept());
//			preparedStatement.setString(6, emp.getEmpMobile());
//			preparedStatement.executeUpdate();
			
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
					ConnectionPoolHelper.freeQmsConnection(
						connection);
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}

		} // t-c-f
		
		return results;
	}
	


	// add UsersData
	public boolean add(UserData user) {

		// Database variables
	    Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "INSERT INTO "+primTab+
		               " VALUES(?,?,?,?,?,?)";
		boolean results = false;

		try {
			connection =
				ConnectionPoolHelper.getQmsConnection();

			preparedStatement =
				connection.prepareStatement(query);

//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setString(1, user.getId());
//			preparedStatement.setString(2, user.getSupervisor());
//			preparedStatement.setString(3, user.getEmp_num());
//			preparedStatement.setString(4, user.getCname());
//			preparedStatement.setString(5, user.getDept());
//			preparedStatement.setString(6, user.getMobile());
//			preparedStatement.executeUpdate();
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
					ConnectionPoolHelper.freeQmsConnection(
						connection);
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}

		} // t-c-f
		
		return results;
	}

//	// update DCS UsersData
//	public int update(String uid, String item, String value) {
//
//		String uno = null;
//		UsersData ud = this.getData(uid);
//		if  (ud == null)
//			return 0;
//		else 
//		;//	uno = ud.getEmpNum();
//		
//		// Database variables
//	    Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		int rows = 0;
//		
//		String query = "UPDATE "+dossTab+
//		               " SET "+item+" =?"+
//					   " WHERE userno=?";	
//		try {
//			connection =
//				ConnectionPoolHelper.getDossConnection();
//
//			preparedStatement =
//				connection.prepareStatement(query);
//
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setString(1, value);
//			preparedStatement.setString(2, uno);
//
//			rows = preparedStatement.executeUpdate();
//
//
//			// Handle any SQL errors
//		} catch (SQLException e) {
//
//			throw new RuntimeException(
//				"A database error occured. " + e.getMessage());
//
//		} finally {
//
//		    if (preparedStatement != null) {
//				try {
//					preparedStatement.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (connection != null) {
//				try {
//					ConnectionPoolHelper.freeDossConnection(
//						connection);
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//
//		} // t-c-f
//		
//		return rows;
//	}

	
	// delete UsersData
	public boolean delete(String id) {

	    Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "DELETE FROM "+primTab+
		               " WHERE id=?";
		boolean results = false;


		try {
			connection =
				ConnectionPoolHelper.getQmsConnection();

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
					ConnectionPoolHelper.freeQmsConnection(
						connection);
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}

		} // t-c-f
		
		return results;
	}

} /* END */