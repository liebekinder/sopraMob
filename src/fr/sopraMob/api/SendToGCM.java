package fr.sopraMob.api;

import java.io.IOException;

import com.google.android.gcm.server.Constants;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

import fr.sopraMob.common.Data;

/**
 * Send message to user via GCM
 * @author Sébastien
 *
 */
public class SendToGCM {
	private final Sender sender = new Sender(Data.API_KEY);

	public SendToGCM(){}
	
	public void sendMessage(String msg, String id){
		//construction d'un message
		Message message = new Message.Builder().addData("message", msg).build();
		Result result = null;
	      try {
	         result = sender.sendNoRetry(message, id);
	      } catch (IOException e) {
	    	  
	      }

	      if (result != null) {
	         if (result.getErrorCodeName().equals(Constants.ERROR_NOT_REGISTERED)) {
	            Data.unregister(id);
	         }
	      }
	}
}
