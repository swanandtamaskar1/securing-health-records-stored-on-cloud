package com.login.Servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;

import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bouncycastle.crypto.prng.RandomGenerator;

import com.fileFuntions.MyStringRandomGen;
import com.login.dao.ImageUploadImpl;
import com.login.dao.RegistrationImpl;

/**
 * Servlet implementation class EmailAdminMasterServlet
 */
public class SendKeyViaEmailServletFordataView extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		final String err = "Error.jsp";
		final String succ = "success.jsp";
		try {
			HttpSession session = request.getSession();
			ImageUploadImpl imageUploadImp = new ImageUploadImpl();
			// int id=Integer.parseInt(request.getParameter("id"));
			MyStringRandomGen msr = new MyStringRandomGen();

			String viewKey = msr.generateRandomString();
			if (session.getAttribute("viewKey") == null) {
				session.setAttribute("viewKey", viewKey);
				RegistrationImpl registrationImplemet = new RegistrationImpl();
				String toMailId = registrationImplemet.getEmailId((String) session.getAttribute("uname"));
//System.out.println("emailId"+emailId);
				String from = "fairactdemo@gmail.com";
				System.out.println("from" + from);
				String to = toMailId;
				System.out.println("To.." + to);

				String subject = "key to view cloud Files";
				System.out.println("subject..." + subject);
				String message = "key-" + viewKey;

				String login = "fairactdemo@gmail.com";
				System.out.println("login" + login);
				String password = "fairAct1";
				System.out.println("password" + password);

				Properties props = new Properties();
				props.setProperty("mail.host", "smtp.gmail.com");
//  props.setProperty("mail.host", "smtp.yahoo.com");
				props.setProperty("mail.smtp.port", "587");
				props.setProperty("mail.smtp.auth", "true");
				props.setProperty("mail.smtp.starttls.enable", "true");

				Authenticator auth = new SMTPAuthenticator(login, password);

				Session session1 = Session.getInstance(props, auth);

				MimeMessage msg = new MimeMessage(session1);

				msg.setText(message);
				msg.setSubject(subject);
				msg.setFrom(new InternetAddress(from));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				Transport.send(msg);
			}
		} catch (AuthenticationFailedException ex) {
			request.setAttribute("ErrorMessage", "Authentication failed");

			RequestDispatcher dispatcher = request.getRequestDispatcher(err);
			dispatcher.forward(request, response);

		} catch (AddressException ex) {
			request.setAttribute("ErrorMessage", "Wrong email address");

			RequestDispatcher dispatcher = request.getRequestDispatcher(err);
			dispatcher.forward(request, response);

		} catch (MessagingException ex) {
			request.setAttribute("ErrorMessage", ex.getMessage());

			RequestDispatcher dispatcher = request.getRequestDispatcher(err);
			dispatcher.forward(request, response);
		}
		System.out.println("MAILD");
		PrintWriter out = response.getWriter();

	}

	private class SMTPAuthenticator extends Authenticator {

		private PasswordAuthentication authentication;

		public SMTPAuthenticator(String login, String password) {
			authentication = new PasswordAuthentication(login, password);
		}

		protected PasswordAuthentication getPasswordAuthentication() {
			return authentication;
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);
		response.sendRedirect("uploadedFileList.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);
	}
}
