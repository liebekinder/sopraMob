package fr.sopraMob.api;


/**
 * This class manage to send a message to users via the good component
 * 
 * @author S�bastien
 * 
 */
public class SendMessage {
	
	public void sendMessage(String msg, String id) {
		// test if android device
		SendToGCM sGCM = new SendToGCM();
		sGCM.sendMessage(msg, id);
	}

}