package com.login.Servlet;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.RegistrationImpl;
import com.login.dao.RegistrationInterface;
import com.login.utility.EmailUtility;

/**
 * Servlet implementation class UpdateStatusServlet
 */
public class UpdateStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateStatusServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if (action != null && action.equals("UpdateApprovalStatus")) {
			String status = request.getParameter("status");

			System.out.println("status " + status);

			// long id=(Long)session.getAttribute("id");

			long id = Long.parseLong(request.getParameter("id"));
			String role = (String) session.getAttribute("role");
			System.out.println("id" + id);
			RegistrationInterface registrationInterface = new RegistrationImpl();
			registrationInterface.updateApprovalStatus(id, status);
			response.getWriter().print("success");

		} else if (action != null && action.equals("UpdateBlockUserStatus")) {

			RegistrationImpl registrationImplemet = new RegistrationImpl();
			String toMailId = registrationImplemet.getEmailId((String) session.getAttribute("uname"));
			RegistrationInterface registrationInterface = new RegistrationImpl();

			long id = (Long) session.getAttribute("id");
			registrationInterface.updateBlockUserStatus(id, "inactive");

			InetAddress ip = InetAddress.getLocalHost();
			System.out.println("Current IP address : " + ip.getHostAddress());
			NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			byte[] mac = network.getHardwareAddress();
			System.out.println("Current MAC address : " + network.getHardwareAddress());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
			}
			System.out.println("------------------------" + sb.toString());

			// EmailUtility.sendEmail(toMailId, ip.getHostAddress(), sb.toString());

		}

	}
}
