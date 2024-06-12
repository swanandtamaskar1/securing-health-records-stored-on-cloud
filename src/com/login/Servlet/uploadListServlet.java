package com.login.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.ImageUploadImpl;
import com.login.dao.ImageUploadInterface;
import com.login.pojo.ImageUplaod;
import com.login.pojo.Login;

/**
 * Servlet implementation class uploadListServlet
 */
public class uploadListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public uploadListServlet() {
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

		doPost(request, response);
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
		if (session.getAttribute("user") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/LogoutServletMaster");
			rd.forward(request, response);
		} else if (action.equals("view")) {

			ImageUploadInterface ImageUploadInf = new ImageUploadImpl();
			List<ImageUplaod> uploadedList = ImageUploadInf.getAllFiles();
			RequestDispatcher rd = request.getRequestDispatcher("/files.jsp");
			request.setAttribute("uploadedList", uploadedList);
			rd.forward(request, response);
		}

	}

}
