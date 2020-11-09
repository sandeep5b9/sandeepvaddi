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

	public static final String GET_Loan_Status = "SELECT status FROM loaninfo where loanid=?";
	public static final String GET_AllLoanApplicant_DTL = "SELECT * FROM loaninfo";
	public static final String MAX_CustLoanID_QRY = "SELECT MAX(loanid) FROM loaninfo;";
	public static final String INST_UserLoan_DTL = "INSERT INTO loaninfo(loanpurpose, loanid, loanamt, doa, bsstructure,biindicator,status,address, email, mobile)"
			+ " VALUES(?,?,?,?,?,?,?,?,?,?)";
	public static final String UPDT_UserLoan_DTL = "UPDATE loaninfo set loanamt=? where loanid=?";

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

	// to generate unique loan id to a customer
	public Integer getNextCustLoanId() throws Exception {
		int nextLoanId = 1;
		try {
			this.connect();
			PreparedStatement ps = jdbcConnection.prepareStatement(MAX_CustLoanID_QRY);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				nextLoanId = rs.getInt(1) + 1;
			}
		} catch (SQLException e) {
			this.disconnect();
			throw new Exception("Failure in fetching next CustLoan Id");
		}
		return nextLoanId;
	}

	// adding customer loan details to the data base
	public boolean addLoanDetails(LoanInfo loanInfo) throws Exception {
		boolean isAdded = false;
		try {
			this.connect();
			PreparedStatement ps = jdbcConnection.prepareStatement(INST_UserLoan_DTL);
			ps.setString(1, loanInfo.getPurpose());
			ps.setInt(2, loanInfo.getApplno());
			ps.setDouble(3, loanInfo.getAmtrequest());
			ps.setString(4, loanInfo.getDoa());
			ps.setString(5, loanInfo.getBstructure());
			ps.setString(6, loanInfo.getBindicator());
			ps.setString(7, "Active");
			ps.setString(8, loanInfo.getAddress());
			ps.setString(9, loanInfo.getEmail());
			ps.setString(10, loanInfo.getMobile());
			
			isAdded = ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Failure in adding customer loan details");
		}

		return isAdded;
	}
	
	public String loanstatus(String loanid) throws Exception {
		String loanstatus=null;
		try {
			this.connect();
			PreparedStatement ps = jdbcConnection.prepareStatement(GET_Loan_Status);
			ps.setString(1, loanid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				loanstatus = rs.getString(1);
			}
		} catch (Exception e) {
			throw new Exception("Failed to fetch user details");
		}
		
		return loanstatus;
		
	}
	
	public boolean UpdateAmount(String loanid, String amount) throws Exception {
		boolean isAdded = false;
		try {
			this.connect();
			PreparedStatement ps = jdbcConnection.prepareStatement(UPDT_UserLoan_DTL);
			ps.setString(1, amount);
			ps.setString(2, loanid);
			isAdded = ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Failure in adding customer loan details");
		}

		return isAdded;
	}

}
