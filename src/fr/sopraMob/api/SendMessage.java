package fr.sopraMob.api;

import java.util.HashSet;

import fr.sopraMob.common.Data;
import fr.sopraMob.common.ServeurType;



/**
 * This class manage to send a message to users via the good component
 * 
 * @author S�bastien
 * 
 */
public class SendMessage {
	/**
	 * 
	 * @param msg
	 * @param id
	 */
	public void sendMessage(String msg, String phoneOwner) {
		// test if android device
		
		
		HashSet<String> phones = Data.getPhonesByOwner(phoneOwner);
		if(phones==null) {
			System.out.println("No phones found");
			return;
		}
		
		for(String phoneId : phones) {
			ServeurType type = Data.getPhoneType(phoneId);
			
			if(type == ServeurType.GOOGLE){
				SendToGCM sGCM = new SendToGCM();
				sGCM.sendMessage(msg, phoneId);			
			}
			else if (type == ServeurType.WP){
				SendToWP sWP = new SendToWP();
				sWP.sendMessage(msg, phoneId);
			}
			else{
				System.err.println("this OS is not implemented yet");
			}
		}
		
	}

}
