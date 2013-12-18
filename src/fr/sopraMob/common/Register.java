package fr.sopraMob.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author S�bastien Servlet for client registering
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
	}

	/**
	 * Client registers via POST. We are supposed to know which platform is
	 * used.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * @author S�bastien
	 * 
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Camembert");
		String id =  testAndGetParamFromMessage(request, "id");
		String phoneTypeTxt = testAndGetParamFromMessage(request, "phoneType");
		String phoneOwner = testAndGetParamFromMessage(request, "phoneOwner");

		Data.register(id, ServeurType.getFromText(phoneTypeTxt), phoneOwner);
		response.setStatus(HttpServletResponse.SC_OK);
	}

	private String testAndGetParamFromMessage(HttpServletRequest request, String paramName) throws ServletException {
		String param = request.getParameter(paramName);
		if (param == null || param.trim().length() == 0) {
			throw new ServletException("Parameter "+paramName+" not found");
		}
		return param;
	}

}
