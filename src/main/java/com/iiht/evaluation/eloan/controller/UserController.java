package com.iiht.evaluation.eloan.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iiht.evaluation.eloan.dao.ConnectionDao;
import com.iiht.evaluation.eloan.model.ApprovedLoan;
import com.iiht.evaluation.eloan.model.LoanInfo;
import com.iiht.evaluation.eloan.model.User;
import com.mysql.cj.xdevapi.Statement;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConnectionDao connDao;
	private LoanInfo LoanInfo;

	public void setConnDao(ConnectionDao connDao) {
		this.connDao = connDao;
	}

	public void init(ServletConfig config) {
		String jdbcURL = config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = config.getServletContext().getInitParameter("jdbcPassword");
		System.out.println(jdbcURL + jdbcUsername + jdbcPassword);
		this.connDao = new ConnectionDao(jdbcURL, jdbcUsername, jdbcPassword);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		String viewName = "";
		try {
			switch (action) {
			case "registernewuser":
				viewName = registernewuser(request, response);
				break;
			case "validate":
				viewName = validate(request, response);
				break;
			case "placeloan":
				viewName = placeloan(request, response);
				break;
			case "application1":
				viewName = application1(request, response);
				break;
			case "editLoanProcess":
				viewName = editLoanProcess(request, response);
				break;
			case "registeruser":
				viewName = registerUser(request, response);
				break;
			case "register":
				viewName = register(request, response);
				break;
			case "application":
				viewName = application(request, response);
				break;
			case "trackloan":
				viewName = trackloan(request, response);
				break;
			case "editloan":
				viewName = editloan(request, response);
				break;
			case "displaystatus":
				viewName = displaystatus(request, response);
				break;
			default:
				viewName = "notfound.jsp";
				break;
			}
		} catch (Exception ex) {

			throw new ServletException(ex.getMessage());
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(viewName);
		dispatch.forward(request, response);
	}

	private String validate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/* write the code to validate the user */
		String view = "index.jsp";
		String logid = request.getParameter("loginid");
		String password = request.getParameter("password");

		if (logid.contentEquals("admin")) {
			if (password.equals("admin")) {
				view = "adminhome1.jsp";
			} else {
				request.setAttribute("failMsg", "Invalid username/password.");
			}
		} else {
			User user = connDao.getUserDetails(logid);
			if (null == user || !user.getPassword().contentEquals(password)) {
				request.setAttribute("failMsg", "Invalid username/password.");
			} else {
				view = "userhome1.jsp";
			}
		}

		return view;
	}

	private String placeloan(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		/* write the code to place the loan information */
		
		String view = "application.jsp";
		int loanid = connDao.getNextCustLoanId();
		String loantype = request.getParameter("LoanType");
		String loanamount = request.getParameter("LoanAmount");
		int loanamount1 = Integer.parseInt(loanamount);
		String ApplDate = request.getParameter("doa");
		String BusinessStructure = request.getParameter("Business Structure");
		String BillingIndi = request.getParameter("Billing Indicator");
		String Address = request.getParameter("Address");
		String Mobile = request.getParameter("Mobile");
		String Email = request.getParameter("EmailId");
		LoanInfo loaninfo = new LoanInfo(connDao.getNextCustLoanId(), loantype, loanamount1, ApplDate, BusinessStructure, BillingIndi, "Active",Address, Email, Mobile);
		
		
		try {
			
			if (connDao.addLoanDetails(loaninfo)) {
				request.setAttribute("sucsMsg", "Loan Application details submitted successfully with loan id: "+loanid);	
				view = "userhome1.jsp";
			}
			else {
				throw new Exception("Failed to register new user");
			}
			
		} catch (Exception exception) {
			request.setAttribute("exception", exception);
			view = "errorPage.jsp";
		}
		
		return view;

	}

	private String application1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write the code to display the loan application page */

		return null;
	}

	private String editLoanProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/* write the code to edit the loan info */

		String view = "editloanui.jsp";
		String str_amount = request.getParameter("EnterAmount");
		String str_loanappnumber = request.getParameter("LoanApplicationNumber");
		
		try {
			if(!(str_amount==null)) {
			connDao.UpdateAmount(str_loanappnumber,str_amount);
			request.setAttribute("sucsMsg", "Loan updated with the changes");	
			view = "loanDetails.jsp";
			}
		else {
			throw new Exception("Failed to fetch status for the given loan id");
			}
		}
		
		catch (Exception exception) {
			request.setAttribute("exception", exception);
			view = "errorPage.jsp";}
		
		return view;
	}

	private String registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/* write the code to redirect page to read the user details */
		return "newuserui.jsp";
	}

	private String registernewuser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String view = "newuserui.jsp";
		String logid = request.getParameter("loginid");
		String password = request.getParameter("password");

		if (logid.contentEquals("admin")) {
			request.setAttribute("failMsg", "Invalid username - admin.");
		} else {
			try {
				User user = connDao.getUserDetails(logid);
				if (null != user) {
					request.setAttribute("failMsg", "Username already exist");
				} else {
					if (connDao.addNewUser(logid, password)) {
						request.setAttribute("sucsMsg", "Registration successfull. Try login now");	
						view = "index.jsp";
					}
					else {
						throw new Exception("Failed to register new user");
					}
				}
			} catch (Exception exception) {
				request.setAttribute("exception", exception);
				view = "errorPage.jsp";
			}
		}
		return view;

	}

	private String register(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write the code to redirect to register page */

		return null;
	}

	private String displaystatus(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/*
		 * write the code the display the loan status based on the given application
		 * number
		 */

		String view = "trackloan.jsp";
		String str_loanappnumber = request.getParameter("LoanApplicationNumber");
		
		try {
			if(!(str_loanappnumber==null)) {
			String loanstatus = connDao.loanstatus(str_loanappnumber);
			request.setAttribute("sucsMsg", "Loan Application status with loan id : "+str_loanappnumber+" is "+loanstatus);	
			view = "loanDetails.jsp";
			}
		else {
			throw new Exception("Failed to fetch status for the given loan id");
			}
		}
		
		catch (Exception exception) {
			request.setAttribute("exception", exception);
			view = "errorPage.jsp";}
		
		return view;
	}

	private String editloan(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write a code to return to editloan page */
		String view = "editloan.jsp";
		String str_loanappnumber = request.getParameter("LoanApplicationNumber");
		
		try {
			if(!(str_loanappnumber==null)) {
			String loanstatus = connDao.loanstatus(str_loanappnumber);
				if(loanstatus.equalsIgnoreCase("Active")) {
					request.setAttribute("sucsMsg", "Loan Application status with loan id: "+str_loanappnumber+" is "+loanstatus);
					request.setAttribute("loanId", str_loanappnumber);
					view = "editloanui.jsp";
				}
			
			}
			else {
				throw new Exception("Failed to fetch status for the given loan id");
				}
		}
		
		catch (Exception exception) {
			request.setAttribute("exception", exception);
			view = "errorPage.jsp";}
		
		return view;
	}

	private String trackloan(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write a code to return to trackloan page */

		return null;
	}

	private String application(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write a code to return to trackloan page */
		return null;
	}
}
	