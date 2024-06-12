package com.login.Servlet;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fileFuntions.MergerFiles;

import com.login.dao.ImageUploadImpl;
import com.login.dao.PatientMasterDaoImpl;
import com.login.dao.PatientReportDaoImpl;
import com.login.pojo.ImageUplaod;
import com.login.pojo.PatientMaster;
import com.login.pojo.PatientReport;

public class DownloadFile extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;
	private static final int BUFSIZE = 4096;
	String filePath;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("user") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/LogoutServletMaster");
			rd.forward(request, response);
		}

		session.removeAttribute("key");
		// String fileSize=request.getParameter("fileSize");
		int reportId = Integer.parseInt(request.getParameter("id"));
		PatientReport patientReport = new PatientReportDaoImpl().getReportById(reportId);
		/*
		 * PatientMaster paMaster = new PatientMaster();
		 * paMaster.setId(patientReport.getPatient_id()); String patientEmailId = new
		 * PatientMasterDaoImpl().getElementById(paMaster).getEmail();
		 */

		String relativeWebPath = getServletContext().getInitParameter("uploadBasePath");
		String fileP = relativeWebPath;
		String filePath = MergerFiles.mergedFile(patientReport.getId(), relativeWebPath,
				patientReport.getReportFileName());

		File file = new File(filePath);
		int length = 0;
		ServletOutputStream outStream = response.getOutputStream();
		response.setContentType("text/html");
		response.setContentLength((int) file.length());
		String fileName = file.getName();
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

		byte[] byteBuffer = new byte[BUFSIZE];
		DataInputStream in = new DataInputStream(new FileInputStream(file));

		while ((in != null) && ((length = in.read(byteBuffer)) != -1)) {
			outStream.write(byteBuffer, 0, length);
		}

		in.close();
		outStream.close();

		file.delete();

	}

}
