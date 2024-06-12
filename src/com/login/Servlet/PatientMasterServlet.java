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

import com.login.dao.PatientHistoryDaoImpl;
import com.login.dao.PatientMasterDaoImpl;
import com.login.dao.PatientMasterInterface;
import com.login.dao.RegistrationImpl;
import com.login.dao.RegistrationInterface;
import com.login.pojo.Login;
import com.login.pojo.PatientHistory;
import com.login.pojo.PatientMaster;
import com.login.utility.EmailUtility;

/**
 * Servlet implementation class PatientMasterServlet
 */
public class PatientMasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PatientMasterServlet() {
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
		if (session.getAttribute("user") == null)
			response.sendRedirect("loginRegistration.jsp");

		String action = request.getParameter("action");
		PatientMaster patientMaster = new PatientMaster();
		PatientMasterInterface patientMasterInterface = new PatientMasterDaoImpl();

		if (action != null && action.equals("Save")) {

			String FIRST_NAME = request.getParameter("FIRST_NAME");
			String LAST_NAME = request.getParameter("LAST_NAME");
			String CITY = request.getParameter("CITY");
			String STATE = request.getParameter("STATE");
			String PINCODE = request.getParameter("PINCODE");
			String CONTACT_NO = request.getParameter("CONTACT_NO");
			String EMAIL = request.getParameter("EMAIL");
			String AGE = request.getParameter("AGE");
			String WEIGHT = request.getParameter("WEIGHT");
			String HEIGHT = request.getParameter("HEIGHT");
			String BLOOD_GROUP = request.getParameter("BLOOD_GROUP");

			patientMaster.setFirst_name(FIRST_NAME);
			patientMaster.setLast_name(LAST_NAME);
			patientMaster.setCity(CITY);
			patientMaster.setState(STATE);
			patientMaster.setPincode(PINCODE);
			patientMaster.setContact_no(CONTACT_NO);
			patientMaster.setEmail(EMAIL);
			patientMaster.setAge(AGE);
			patientMaster.setWeight(WEIGHT);
			patientMaster.setHeight(HEIGHT);
			patientMaster.setBlood_group(BLOOD_GROUP);

			Login l = new Login();

			RegistrationInterface inf = new RegistrationImpl();

			l.setUsername(FIRST_NAME);
			l.setEMAIL_ID(EMAIL);
			l.setSTATE(STATE);
			l.setCITY(CITY);
			l.setPINCODE(Integer.parseInt(PINCODE));
			String password = EmailUtility.sendEmail(EMAIL);
			l.setPassword(password);
			l.setADDRESS("");
			l.setRole("Patient");
			inf.signup(l);

			Login login = inf.login(l);
			patientMaster.setUSER_ID(new Long(login.getId()).intValue());
			patientMasterInterface.save(patientMaster);

			List<PatientMaster> patientMaterList = getAllPatientList(response, session, patientMasterInterface);
			RequestDispatcher rd = request.getRequestDispatcher("patientList.jsp");
			request.setAttribute("patientMaterList", patientMaterList);
			rd.include(request, response);

		}

		else if (action != null && action.equals("GetAllList")) {
			List<PatientMaster> patientMaterList = getAllPatientList(response, session, patientMasterInterface);
			RequestDispatcher rd = request.getRequestDispatcher("patientList.jsp");
			request.setAttribute("patientMaterList", patientMaterList);
			rd.include(request, response);
		} else if (action != null && action.equals("Update")) {

			int ID = Integer.parseInt(request.getParameter("USER_ID"));
			String FIRST_NAME = request.getParameter("FIRST_NAME");
			String LAST_NAME = request.getParameter("LAST_NAME");
			String CITY = request.getParameter("CITY");
			String STATE = request.getParameter("STATE");
			String PINCODE = request.getParameter("PINCODE");
			String CONTACT_NO = request.getParameter("CONTACT_NO");
			String EMAIL = request.getParameter("EMAIL");
			String AGE = request.getParameter("AGE");
			String WEIGHT = request.getParameter("WEIGHT");
			String HEIGHT = request.getParameter("HEIGHT");
			String BLOOD_GROUP = request.getParameter("BLOOD_GROUP");

			patientMaster.setId(ID);
			patientMaster.setFirst_name(FIRST_NAME);
			patientMaster.setLast_name(LAST_NAME);
			patientMaster.setCity(CITY);
			patientMaster.setState(STATE);
			patientMaster.setPincode(PINCODE);
			patientMaster.setContact_no(CONTACT_NO);
			patientMaster.setEmail(EMAIL);
			patientMaster.setAge(AGE);
			patientMaster.setWeight(WEIGHT);
			patientMaster.setHeight(HEIGHT);
			patientMaster.setBlood_group(BLOOD_GROUP);

			patientMasterInterface.updatePatientMaster(patientMaster);
			List<PatientMaster> patientMaterList = getAllPatientList(response, session, patientMasterInterface);
			RequestDispatcher rd = request.getRequestDispatcher("patientList.jsp");
			request.setAttribute("patientMaterList", patientMaterList);
			rd.include(request, response);
		} else if (action != null && action.equals("Delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			patientMaster.setId(id);
			patientMaster = patientMasterInterface.getElementById(patientMaster);
			patientMasterInterface.deletePatientMaster(patientMaster);

			int userId = patientMaster.getUSER_ID();
			new RegistrationImpl().updateApprovalStatus(userId, "deleted");

			List<PatientMaster> patientMaterList = getAllPatientList(response, session, patientMasterInterface);
			RequestDispatcher rd = request.getRequestDispatcher("patientList.jsp");
			request.setAttribute("patientMaterList", patientMaterList);
			rd.include(request, response);
		}

		else if (action != null && action.equals("Edit")) {
			patientMaster = getElementById(request, session, patientMaster, patientMasterInterface);

			RequestDispatcher rd = request.getRequestDispatcher("patientEdit.jsp");
			request.setAttribute("patientMaster", patientMaster);
			rd.include(request, response);

		}

		else if (action != null && action.equals("View")) {
			patientMaster = getElementById(request, session, patientMaster, patientMasterInterface);
			int patientId = Integer.parseInt(request.getParameter("id"));
			List<PatientHistory> patientHistories = new PatientHistoryDaoImpl().getAllbyPatientId(patientId);

			RequestDispatcher rd = request.getRequestDispatcher("patientPrescription.jsp");
			request.setAttribute("patientHistories", patientHistories);
			request.setAttribute("patientMaster", patientMaster);
			rd.include(request, response);
		} else if (action != null && action.equals("viewMyHistory")) {
			int userId = Integer.parseInt(request.getParameter("id"));
			patientMaster = new PatientMasterDaoImpl().getElementByUserId(userId);

			List<PatientHistory> patientHistories = new PatientHistoryDaoImpl()
					.getAllbyPatientId(patientMaster.getId());

			RequestDispatcher rd = request.getRequestDispatcher("myDetails.jsp");
			request.setAttribute("patientHistories", patientHistories);
			request.setAttribute("patientMaster", patientMaster);
			rd.include(request, response);
		}

		else {
			response.sendRedirect("#");
		}

	}

	private PatientMaster getElementById(HttpServletRequest request, HttpSession session, PatientMaster patientMaster,
			PatientMasterInterface patientMasterInterface) {
		int id = Integer.parseInt(request.getParameter("id"));
		patientMaster.setId(id);
		patientMaster = patientMasterInterface.getElementById(patientMaster);
		return patientMaster;

	}

	/**
	 * @param response
	 * @param session
	 * @param PatientMasterInterface
	 * @throws IOException
	 */
	private List<PatientMaster> getAllPatientList(HttpServletResponse response, HttpSession session,
			PatientMasterInterface patientMasterInterface) throws IOException {
		List<PatientMaster> patientMasterList = new ArrayList<PatientMaster>();
		patientMasterList = patientMasterInterface.PatientMasterList();
		return patientMasterList;

	}

}
