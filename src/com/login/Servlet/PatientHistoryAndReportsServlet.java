package com.login.Servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.PatientHistoryDaoImpl;
import com.login.dao.PatientMasterDaoImpl;
import com.login.dao.PatientReportDaoImpl;
import com.login.dao.PatientReportIntf;
import com.login.dao.SplitFilesImpl;
import com.login.dao.SplitFilesInterface;
import com.login.pojo.Login;
import com.login.pojo.PatientHistory;
import com.login.pojo.PatientMaster;
import com.login.pojo.PatientReport;
import com.login.utility.DateUtil;
import com.login.utility.EmailUtility;

/**
 * Servlet implementation class PatientHistoryAndReportsServlet
 */
public class PatientHistoryAndReportsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PatientHistoryAndReportsServlet() {
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
		if (session.getAttribute("user") == null || action == null || action.equals(""))
			response.sendRedirect("loginRegistration.jsp");

		Login loginUser = (Login) session.getAttribute("user");

		if (action.equals("addPrescription")) {

			int patientId = Integer.parseInt(request.getParameter("patientId"));
			String symptoms = request.getParameter("symptoms");
			String prescription = request.getParameter("prescription");

			PatientHistory patientHistory = new PatientHistory();
			patientHistory.setPatient_id(patientId);
			patientHistory.setSymptoms(symptoms);
			patientHistory.setPrescribedByDoctor(new Long(loginUser.getId()).intValue());
			patientHistory.setPrescription(prescription);
			patientHistory.setPrescribedByName(loginUser.getUsername());
			patientHistory.setPrescribedDate(DateUtil.convertCurrentUtilDateTimetoSqlDate());

			new PatientHistoryDaoImpl().savePatientHistory(patientHistory);
			RequestDispatcher rd = request.getRequestDispatcher("PatientMasterServlet?action=View&id=" + patientId);
			rd.forward(request, response);
		} else if (action.equals("viewReports")) {

			int patientId = Integer.parseInt(request.getParameter("patientId"));

			List<PatientReport> patientReportList = new PatientReportDaoImpl().getAllReportByPatientId(patientId);
			request.setAttribute("PatientReportList", patientReportList);
			RequestDispatcher rd = request.getRequestDispatcher("reportList.jsp");
			rd.forward(request, response);

		}

		else if (action.equals("sendOtp")) {

			int reportId = Integer.parseInt(request.getParameter("reportId"));
			PatientReport patientReport = new PatientReportDaoImpl().getReportById(reportId);
			PatientMaster paMaster = new PatientMaster();
			paMaster.setId(patientReport.getPatient_id());
			String patientEmailId = new PatientMasterDaoImpl().getElementById(paMaster).getEmail();
			String otp = EmailUtility.sendOtp(patientEmailId);
			System.out.println("OTP -" + otp);
			PrintWriter outPrintWriter = response.getWriter();
			outPrintWriter.print(otp);

		}

	}

}
