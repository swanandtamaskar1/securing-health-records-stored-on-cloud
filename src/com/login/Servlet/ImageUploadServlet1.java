package com.login.Servlet;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
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

import com.fileFuntions.SplittFile;
import com.login.dao.ImageUploadImpl;
import com.login.dao.ImageUploadInterface;
import com.login.pojo.ImageUplaod;

/**
 * Servlet implementation class ImageUploadServlet1
 */
public class ImageUploadServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImageUploadServlet1() {
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

		String action = request.getParameter("action");
		//// String fileNumSessionValueForStallDesign =
		//// request.getParameter("fileNumSessionValueForStallDesign");
		// System.out.println("fileNumSessionValueForStallDesign in get ::::::::::
		//// "+fileNumSessionValueForStallDesign);

		System.out.println("Action......." + action);
		if (action != null && action.equals("search")) {
			System.out.println("fileName=" + request.getParameter("fileName"));

			String relativeWebPath = "/uploads/" + request.getParameter("fileName");
			String absoluteFilePath = getServletContext().getRealPath(relativeWebPath);
			// String root = getServletContext().getRealPath("/");
			File path = new File(absoluteFilePath);
			System.out.println("-------------------------------" + absoluteFilePath);
			System.out.println("#################################################" + relativeWebPath);
			File file = new File(absoluteFilePath);
			BufferedImage bimg = ImageIO.read(file);
			response.setHeader("Content-Type", getServletContext().getMimeType(file.getAbsolutePath()));
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\"" + file.getAbsolutePath() + "\"");

			BufferedInputStream input = null;
			BufferedOutputStream output = null;

			try {
				input = new BufferedInputStream(new FileInputStream(file));
				output = new BufferedOutputStream(response.getOutputStream());
				byte[] buffer = new byte[6902149];
				for (int length = 0; (length = input.read(buffer)) > 0;) {
					output.write(buffer, 0, length);
				}
			} finally {
				if (output != null)
					try {
						output.close();
					} catch (IOException logOrIgnore) {
					}
				if (input != null)
					try {
						input.close();
					} catch (IOException logOrIgnore) {
					}
			}

		} else {
			doPost(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();

		String name = request.getParameter("name");

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		System.out.println("ams" + isMultipart);
		if (isMultipart) {
			// Create a factory for disk-based file items
			FileItemFactory factory = new DiskFileItemFactory();

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			try {
				// Parse the request
				List /* FileItem */ items = upload.parseRequest(request);
				Iterator iterator = items.iterator();
				while (iterator.hasNext()) {
					FileItem item = (FileItem) iterator.next();
					if (!item.isFormField()) {
						String fileName = item.getName();

						String relativeWebPath = "/uploads";
						String absoluteFilePath = "C:" + relativeWebPath;
						// String root = getServletContext().getRealPath("/");
						File path = new File(absoluteFilePath);
						System.out.println("-------------------------------" + absoluteFilePath);

						if (!path.exists()) {
							boolean status = path.mkdirs();
						}

						File uploadedFile = new File(path + "/" + fileName);
						System.out.println(uploadedFile.getAbsolutePath());
						System.out.println("file" + fileName);
						item.write(uploadedFile);

						/*
						 * ImageUploadInterface ImageUploadInf=new ImageUploadImpl();
						 * 
						 * 
						 * 
						 * ImageUplaod imageUploadObj=new ImageUplaod();
						 * imageUploadObj.setUSERNAME((String)session.getAttribute("uname"));
						 * imageUploadObj.setPATH(fileName);
						 * imageUploadObj.setFileSize((int)uploadedFile.length());
						 * 
						 * imageUploadObj.setType(name);
						 * 
						 * System.out.println("IMAGEUPLOADDD"); //long
						 * file_id=ImageUploadInf.savepath(imageUploadObj,);
						 * 
						 * String originalFilePath=absoluteFilePath+"\\"+fileName; File checkFile=new
						 * File(originalFilePath); String savedFiles=""; long
						 * fileSize=checkFile.length();
						 * 
						 * 
						 * 
						 * 
						 * 
						 * 
						 * 
						 * if(fileName.endsWith("txt") || fileName.endsWith("TXT")) { BufferedReader
						 * reader = new BufferedReader(new FileReader(uploadedFile)); int lines = 0;
						 * while (reader.readLine() != null) lines++; reader.close();
						 * 
						 * System.out.println("lines"+lines);
						 * 
						 * if(lines<=5) { savedFiles=absoluteFilePath+"\\Folder1"; }else{
						 * savedFiles=absoluteFilePath+"\\Folder2"; }
						 * 
						 * 
						 * String uname=(String)session.getAttribute("uname");
						 * 
						 * 
						 * SplittFile.splitFile(absoluteFilePath,originalFilePath,savedFiles,uname,
						 * file_id);
						 */
					}

				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
