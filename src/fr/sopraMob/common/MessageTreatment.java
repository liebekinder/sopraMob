package fr.sopraMob.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageTreatment extends HttpServlet {

	public static final String VUE_UTILISATEUR = "/WEB-INF/SendMessage.jsp";
	
	public MessageTreatment(){
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Message= request.getParameter("Message");
		System.out.println(Message);
		this.getServletContext().getRequestDispatcher( VUE_UTILISATEUR ).forward( request, response );
	}
}
