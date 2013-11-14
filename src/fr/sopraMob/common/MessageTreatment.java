package fr.sopraMob.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.sopraMob.api.SendMessage;

public class MessageTreatment extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String VUE_UTILISATEUR = "/WEB-INF/SendMessage.jsp";

	public MessageTreatment() {

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("Message") != null
				&& !request.getParameter("Message").isEmpty() && request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
			//only if we have a message to send
			String Message = request.getParameter("Message");
			String id = request.getParameter("id");
			System.out.println(Message);
			SendMessage sendmsg = new SendMessage();
			//Google
			sendmsg.sendMessage(
					Message,
					id,ServeurType.GOOGLE);
			//WP
			sendmsg.sendMessage(Message, "xxx", ServeurType.WP);
		}
		else{
		}
		request.setAttribute("liste_id", Data.getIdList());
		this.getServletContext().getRequestDispatcher(VUE_UTILISATEUR)
				.forward(request, response);
	}
}
