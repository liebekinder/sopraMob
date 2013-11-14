package fr.sopraMob.api;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.android.gcm.server.Constants;
import com.google.android.gcm.server.InvalidRequestException;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

import fr.sopraMob.common.Data;
//import org.apache.log4j.Logger;

/**
 * Send message to user via GCM
 * @author Sébastien
 *
 */
public class SendToGCM {
	//private static final Logger logger = Logger.getLogger(SendToGCM.class);
	private final Sender sender = new Sender(Data.API_KEY);
	protected final Logger logger = Logger.getLogger(getClass().getName());

	public SendToGCM(){}
	
	public void sendMessage(String msg, String id){
		//construction d'un message
		Message message = new Message.Builder().addData("title", msg).addData("message", msg).build();
		Result result = null;
	      try {
	         result = sender.send(message, id, 2);
	      }catch(InvalidRequestException e){
	          logger.log(Level.SEVERE, "Error posting messages",e);
	      }catch(IllegalArgumentException e){
	          logger.log(Level.SEVERE, "Error posting messages",e);  
	      } catch (IOException e) {
	          logger.log(Level.SEVERE, "Error posting messages",e);	   
	      }

	      if (result != null && result.getErrorCodeName() != null) {
	         if (result.getErrorCodeName().equals(Constants.ERROR_NOT_REGISTERED)) {
	            Data.unregister(id);
	         }

	          logger.log(Level.SEVERE, "");	   
	      }
	}
}
