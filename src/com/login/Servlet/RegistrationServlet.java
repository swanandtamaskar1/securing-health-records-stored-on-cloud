package com.login.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.PatientMasterDaoImpl;
import com.login.dao.RegistrationImpl;
import com.login.dao.RegistrationInterface;
import com.login.pojo.Login;
import com.login.pojo.PatientMaster;
import com.login.utility.EmailUtility;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public RegistrationServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");
		HttpSession session = request.getSession();

		if (action.equals("signUp")) {
			Login l = new Login();
			String fname = request.getParameter("fname");
			String email = request.getParameter("email");
			String state = request.getParameter("state");
			String city = request.getParameter("city");
			int PINCODE = Integer.parseInt(request.getParameter("pincode"));

			String ADDRESS = request.getParameter("address");
			String role = "Doctor";// request.getParameter("role");

			String PASSWORD = EmailUtility.sendEmail(email);
			RegistrationInterface inf = new RegistrationImpl();

			l.setUsername(fname);
			l.setEMAIL_ID(email);
			l.setSTATE(state);
			l.setCITY(city);
			l.setPINCODE(PINCODE);
			l.setPassword(PASSWORD);
			l.setADDRESS(ADDRESS);
			l.setRole(role);

			inf.signup(l);
			RequestDispatcher rd = request.getRequestDispatcher("RegistrationServlet?action=getAllDoctors");
			rd.forward(request, response);

		} else if (action.equals("getAllDoctors")) {

			RegistrationInterface inf = new RegistrationImpl();
			List<Login> doctorList = inf.getAllDoctors();
			RequestDispatcher rd = request.getRequestDispatcher("doctorList.jsp");
			request.setAttribute("doctorList", doctorList);
			rd.forward(request, response);
		} else if (action.equals("deleteById")) {

			RegistrationInterface inf = new RegistrationImpl();
			int userId = Integer.parseInt(request.getParameter("userId"));
			inf.updateApprovalStatus(userId, "deleted");

			List<Login> doctorList = inf.getAllDoctors();
			RequestDispatcher rd = request.getRequestDispatcher("doctorList.jsp");
			request.setAttribute("doctorList", doctorList);
			rd.forward(request, response);
		} else if (action.equals("login")) {
			System.out.println("login button clicked and servlet triggered");
			String uname = request.getParameter("uname");
			String Password = request.getParameter("password");
			String role = request.getParameter("role");

			Login userLogin = new Login();
			RegistrationInterface inf = new RegistrationImpl();

			userLogin.setEMAIL_ID(uname);
			userLogin.setPassword(Password);
			userLogin.setRole(role);

			Login login = inf.login(userLogin);

			if (login != null) {
				if (login.getStatus().equals("active")) {
					System.out.println("Login Status is active");
					// List<Login> requestList=inf.getAllNewUersListForApproval(role);
					// request.removeAttribute("requestList");
					// request.setAttribute("requestList", requestList);

					// List<Login> blockedList=inf.getBlockedList(role);
					// session.removeAttribute("blockedList");
					// session.setAttribute("blockedList", blockedList);
					// session.removeAttribute("id");

					if (login.getRole().equals("Patient")) {
						PatientMaster patientMaster = new PatientMasterDaoImpl()
								.getElementByUserId((int) login.getId());
						login.setPatientId(patientMaster.getId());
					}
					session.setAttribute("user", login);

					System.out.println("Checking the Role...");
					String redirectPage = login.getRole().equals("Admin") ? "adminHome.jsp"
							: login.getRole().equals("Doctor") ? "doctorHome.jsp" : "patientHome.jsp";
					response.sendRedirect(redirectPage);

				} else {
					System.out.println("Status is blocked");
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/loginRegistration.jsp");
					request.setAttribute("message", "Invalid user!");
					rd.forward(request, response);
				}

			}

			else if (login == null) {
				System.out.println("Login is null");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/loginRegistration.jsp");
				request.setAttribute("message", "Invalid user!");
				rd.forward(request, response);
			}

		}

	}

}
