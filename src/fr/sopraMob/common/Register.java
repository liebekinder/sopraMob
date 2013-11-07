package fr.sopraMob.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Sébastien
 *Servlet for client registering
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Client registers via POST. We are supposed to know which platform is used.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @author Sébastien
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
	      if (id == null || id.trim().length() == 0) {
	         throw new ServletException("Parameter id not found");
	      }

	      Data.register(id);
	      response.setStatus(HttpServletResponse.SC_OK);
	}

}
