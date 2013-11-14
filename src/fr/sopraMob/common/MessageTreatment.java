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
				&& !request.getParameter("Message").isEmpty()) {
			//only if we have a message to send
			String Message = request.getParameter("Message");
			System.out.println(Message);
			SendMessage sendmsg = new SendMessage();
			//Google
			sendmsg.sendMessage(
					Message,
					"APA91bFwtJld24GqiaYxNkcHZri4oQQ4tbTuR7Q-DluP8sU6ELl76EN6CAi361o4DuEWaBVY_adS5LTjHHZBnAaAkV3_pEl4PZCxC0w4WTh_s2GJ4PRyDYnKite3O_wzj5q5sMFCCburhGfH-5jTcNU-8i7QejlYyvTH17ExuY4bg4cqmy8yG-U",ServeurType.GOOGLE);
			//WP
			sendmsg.sendMessage(Message, "xxx", ServeurType.WP);
		}
		else{
			System.out.println(Data.register("ihfafaf_gazgfaz_g_gaezaeg_aegaze_gzegazeg_"));
			for(String s: Data.getIdList()){
				System.out.println(s);
			}
			System.out.println(Data.nbIds());
			request.setAttribute("liste_id", Data.getIdList2());
		}
		this.getServletContext().getRequestDispatcher(VUE_UTILISATEUR)
				.forward(request, response);
	}
}
