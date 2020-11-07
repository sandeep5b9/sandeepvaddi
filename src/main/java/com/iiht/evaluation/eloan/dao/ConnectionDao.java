package com.iiht.evaluation.eloan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.iiht.evaluation.eloan.dto.LoanDto;
import com.iiht.evaluation.eloan.model.ApprovedLoan;
import com.iiht.evaluation.eloan.model.LoanInfo;
import com.iiht.evaluation.eloan.model.User;

public class ConnectionDao {
	private static final long serialVersionUID = 1L;
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public static final String GET_USER_DTL = "SELECT USERID,PASSWORD FROM REGISTER WHERE USERID=?";
	public static final String INST_USER_DTL = "INSERT INTO REGISTER(USERID,PASSWORD) VALUES(?,?)";

	public ConnectionDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}

	public Connection connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
		return jdbcConnection;
	}

	public void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}

	// put the relevant DAO methods here..

	public User getUserDetails(String userId) throws Exception {
		User user = null;
		try {
			this.connect();
			PreparedStatement ps = jdbcConnection.prepareStatement(GET_USER_DTL);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString(1), rs.getString(2));
			}
		} catch (Exception e) {
			throw new Exception("Failed to fetch user details");
		}
		return user;
	}

	public boolean addNewUser(String userId, String pwd) throws Exception {
		boolean result = false;
		try {
			this.connect();
			PreparedStatement ps = jdbcConnection.prepareStatement(INST_USER_DTL);
			ps.setString(1, userId);
			ps.setString(2, pwd);
			result = ps.executeUpdate() > 0;

		} catch (Exception e) {
			throw new Exception("Failed to add user details");
		}
		return result;
	}

}
