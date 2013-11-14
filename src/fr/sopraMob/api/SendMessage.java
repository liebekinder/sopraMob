package fr.sopraMob.api;

import fr.sopraMob.common.ServeurType;



/**
 * This class manage to send a message to users via the good component
 * 
 * @author Sébastien
 * 
 */
public class SendMessage {
	/**
	 * 
	 * @param msg
	 * @param id
	 */
	public void sendMessage(String msg, String id, ServeurType type) {
		// test if android device
		if(type == ServeurType.GOOGLE){
			SendToGCM sGCM = new SendToGCM();
			sGCM.sendMessage(msg, id);			
		}
		else if (type == ServeurType.WP){
			SendToWP sWP = new SendToWP();
			sWP.sendMessage(msg, id);
		}
		else{
			System.err.println("this OS is not implemented yet");
		}
	}

}
