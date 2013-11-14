package fr.sopraMob.api;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SendToWP {

	public static void PushNotif(String titre, String contenu, String page,
			String uri) {

	}

	public void sendMessage(String msg, String id) {

		try {
			URL url = new URL(id);
			URLConnection uc = url.openConnection();

			uc.setRequestProperty("ContentType", "text/xml");
			uc.setRequestProperty("X-WindowsPhone-Target", "toast");
			uc.setRequestProperty("X-NotificationClass", "2");

			uc.setDoOutput(true);

			String titre = "mon Titre";
			String page = "page";

			String toastMessage = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
					+ "<wp:Notification xmlns:wp=\"WPNotification\">"
					+ "<wp:Toast>" + "<wp:Text1>" + titre + "</wp:Text1>"
					+ "<wp:Text2>" + msg + "</wp:Text2>" + "<wp:Param>" + page
					+ "</wp:Param>" + "</wp:Toast> " + "</wp:Notification>";

			OutputStreamWriter writer = new OutputStreamWriter(
					uc.getOutputStream());
			writer.write(toastMessage);
			writer.flush();
			writer.close();

		} catch (MalformedURLException e) {
			System.err.println("osef?");
//			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
