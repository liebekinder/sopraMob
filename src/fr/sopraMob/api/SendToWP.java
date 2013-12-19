package fr.sopraMob.api;

import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class SendToWP {

	public static void PushNotif(String titre, String contenu, String page,
			String uri) {

	}

	public void sendMessage(String msg, String id) {

//		MpnsService service =
//			    MPNS.newService()
//			    .build();
//
//			MpnsNotification notification = MPNS.newNotification()
//			    .tile().count(2).title("Tile message")
//			    .build();
//			String subscriptionUri = id;
//			service.push(subscriptionUri, notification);


		try {
            String channelUri = id;
            System.out.println(id);
          	URL url = new URL(channelUri);
        URLConnection uc = url.openConnection();

        String name="hello";
//        String body="from junit ";

//         String toastMessage = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
//                    "<wp:Notification xmlns:wp=\"WPNotification\">" +
//                       "<wp:Toast>" +
//                            "<wp:Text1>" + name + "</wp:Text1>" +
//                            "<wp:Text2>" + msg + "</wp:Text2>" +
//                            "<wp:Param>/Page2.xaml?NavigatedFrom=Toast Notification</wp:Param>" +
//                       "</wp:Toast> " +
//                    "</wp:Notification>";

//        byte[] mesg = toastMessage.getBytes("UTF-8");


        uc.setRequestProperty("ContentType", "text/xml");
        uc.setRequestProperty("X-WindowsPhone-Target", "toast");
        uc.setRequestProperty("X-NotificationClass", "2");

        String toastMessage = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<wp:Notification xmlns:wp=\"WPNotification\">" +
                   "<wp:Toast>" +
                        "<wp:Text1>" + name + "</wp:Text1>" +
                        "<wp:Text2>" + msg + "</wp:Text2>" +
                        "<wp:Param>/Page2.xaml?NavigatedFrom=Toast Notification</wp:Param>" +
                   "</wp:Toast> " +
                "</wp:Notification>";

    byte[] mesg = toastMessage.getBytes("UTF-8");

    uc.setDoOutput(true);
    uc.setDoInput(true);

    uc.getOutputStream().write(mesg, 0, mesg.length);
    uc.connect();

        Map<String, List<String>> map = uc.getHeaderFields();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() + 
                     " ,Value : " + entry.getValue());
        }

//        writer.flush();
//        writer.close();

//        String res = this.getURLOutput(uc);
//        System.out.print(res);

    } catch(Exception e) {
       System.out.println(e.getMessage());
//       Assert.fail();
   }
		
//		try {
//			URL url = new URL(id);
//			URLConnection uc = url.openConnection();
//
////			uc.setRequestProperty("ContentType", "text/xml");
////			uc.setRequestProperty("X-WindowsPhone-Target", "toast");
////			uc.setRequestProperty("X-NotificationClass", "2");
////
////			uc.setDoOutput(true);
//
//			String titre = "mon Titre";
//			String page = "page";
//
//			String toastMessage = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
//	                "<wp:Notification xmlns:wp=\"WPNotification\">" +
//	                   "<wp:Toast>" +
//	                        "<wp:Text1>" + "troll" + "</wp:Text1>" +
//	                        "<wp:Text2>" + msg + "</wp:Text2>" +
//	                        "<wp:Param>/Page2.xaml?NavigatedFrom=Toast Notification</wp:Param>" +
//	                   "</wp:Toast> " +
//	                "</wp:Notification>";
//
//	    // Do your stuff, initialize the headers, and so on... 
//			 uc.setRequestProperty("ContentType", "text/xml");
//		        uc.setRequestProperty("X-WindowsPhone-Target", "toast");
//		        uc.setRequestProperty("X-NotificationClass", "2");
//
//		        uc.setDoOutput(true);
//		        uc.setDoInput(true);
//
//
//	    OutputStreamWriter writer = new OutputStreamWriter(uc.getOutputStream(), "utf-8");
//	    writer.write(toastMessage, 0, toastMessage.length());
//	    uc.connect();
//	    
//	    
//	    //===
////
////			OutputStreamWriter writer = new OutputStreamWriter(
////					uc.getOutputStream());
////
////			writer.write(toastMessage);
////			uc.connect();
////			writer.flush();
////			uc.connect();
////			writer.close();
////			uc.connect();
//		} catch (MalformedURLException e) {
//			System.err.println("osef?");
////			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}
