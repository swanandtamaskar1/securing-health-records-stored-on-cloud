package com.login.Servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.dao.PatientReportDaoImpl;
import com.login.dao.PatientReportIntf;
import com.login.dao.SplitFilesImpl;
import com.login.dao.SplitFilesInterface;
import com.login.pojo.PatientReport;
import com.project.task.AmazonUpload;

/**
 * Servlet implementation class PatientReportServlet
 */
public class PatientReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PatientReportServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	private void deleteFiles(List<String> files) {
		// String relativeWebPath =
		// getServletContext().getInitParameter("uploadBasePath");

		for (String file : files) {
			try {
				// File uploadedFile = new File(file);
				// uploadedFile.delete();
				String arr[] = file.split("/");
				AmazonUpload.deleteFileFromBucket(arr[0], arr[1]);
			} catch (Exception e) {
			}

		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int reportId = Integer.parseInt(request.getParameter("reportId"));
		PatientReportIntf patientReportIntf = new PatientReportDaoImpl();
		SplitFilesInterface splitFilesInterface = new SplitFilesImpl();
		PatientReport patientReport = patientReportIntf.getReportById(reportId);
		patientReportIntf.deleteReport(reportId);

		List<String> files = splitFilesInterface.getAllsplitFiles(reportId);
		deleteFiles(files);
		splitFilesInterface.deleteFiles(reportId);

		RequestDispatcher rd = request.getRequestDispatcher(
				"PatientHistoryAndReportsServlet?action=viewReports&patientId=" + patientReport.getPatient_id());
		rd.forward(request, response);

		// response.sendRedirect("PatientHistoryAndReportsServlet?action=viewReports&patientId="+patientReport.getPatient_id());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
