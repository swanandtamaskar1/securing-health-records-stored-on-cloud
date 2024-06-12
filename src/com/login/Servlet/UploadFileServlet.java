package com.login.Servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.taglibs.standard.tag.common.core.CatchTag;

import com.fileFuntions.SplittFile;
import com.login.dao.ImageUploadImpl;
import com.login.dao.ImageUploadInterface;
import com.login.dao.PatientMasterDaoImpl;
import com.login.dao.PatientMasterInterface;
import com.login.dao.PatientReportDaoImpl;
import com.login.dao.PatientReportIntf;
import com.login.pojo.ImageUplaod;
import com.login.pojo.Login;
import com.login.pojo.PatientMaster;
import com.login.pojo.PatientReport;
import com.project.task.Constants;

/**
 * Servlet implementation class UploadFileServlet
 */
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadFileServlet() {
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

	public void createFolder() {
		String folderPath = "C:/uploads";
		File path = new File(folderPath);
		if (!path.exists()) {
			boolean status = path.mkdirs();
		}

		for (int i = 1; i <= 3; i++) {
			String folder = "C:/uploads/" + Constants.bucketbasename + i;

			File server = new File(folder);
			if (!server.exists()) {
				boolean status = server.mkdirs();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ImageUploadInterface ImageUploadInf = new ImageUploadImpl();
		HttpSession session = request.getSession();
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (session.getAttribute("user") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/LogoutServletMaster");
			rd.forward(request, response);
		}

		Login login = (Login) session.getAttribute("user");
		PatientMasterInterface patientMasterIntf = new PatientMasterDaoImpl();
		PatientMaster patient = patientMasterIntf.getElementByUserId((int) login.getId());
		String relativeWebPath = getServletContext().getInitParameter("uploadBasePath");
		
		createFolder();

		String role[] = new String[] { "admin" };

		if (isMultipart) {
			// Create a factory for disk-based file items
			FileItemFactory factory = new DiskFileItemFactory();

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			try {
				String fileName = "";
				String report = "";
				// Parse the request
				List /* FileItem */ items = upload.parseRequest(request);
				Iterator iterator = items.iterator();
				File uploadedFile = null;
				while (iterator.hasNext()) {
					FileItem item = (FileItem) iterator.next();
					if (item.isFormField()) {
						report = item.getString();
					}

					if (!item.isFormField()) {
						fileName = item.getName();
						uploadedFile = new File(relativeWebPath + "/" + fileName);
						item.write(uploadedFile);

					}
				}

				PatientReport patientReport = new PatientReport();
				patientReport.setPatient_id(patient.getId());
				patientReport.setReport(report);
				patientReport.setReportDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
				patientReport.setReportFileName(fileName);
				PatientReportIntf patientReportIntf = new PatientReportDaoImpl();
				patientReportIntf.addReport(patientReport);
				int reportId = patientReportIntf.getLastAddedReportId(patient.getId());
				System.out.println("File yet to be split");
				
				System.out.println(relativeWebPath + "  " + fileName + "  " + login.getUsername() + "  " + reportId);
				
				SplittFile.splitFile(relativeWebPath, fileName, login.getUsername(), reportId);
				
				uploadedFile.delete();
				
				RequestDispatcher rd = request.getRequestDispatcher(
						"/PatientHistoryAndReportsServlet?action=viewReports&patientId=" + patient.getId());
				rd.forward(request, response);
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}

	}

}
