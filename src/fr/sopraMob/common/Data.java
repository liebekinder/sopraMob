package fr.sopraMob.common;

import java.util.HashSet;
import java.util.Set;

public class Data {

	public static final String API_KEY = "AIzaSyD1ok0fUhwPNjwGXLiBquadqSI0uv3KXDs";
	private static Set<String> listOfRegisteredId;

	public Data() {
		super();
		Data.listOfRegisteredId = new HashSet<>();
	}
	/**
	 * use to register an id. All method are static for now
	 * @param id
	 * @return true if ok, false else
	 */
	public static synchronized boolean register(String id){
		if(listOfRegisteredId == null){
			Data.listOfRegisteredId = new HashSet<>();
		}
		if(listOfRegisteredId.contains(id)){
			return false;
		}
		else{
			listOfRegisteredId.add(id);
			return true;
		}
	}
	
	/**
	 * use to unregister an id. 
	 * @param id
	 * @return true if ok, false else
	 */
	public static synchronized boolean unregister(String id){
		if(listOfRegisteredId == null){
			Data.listOfRegisteredId = new HashSet<>();
		}
		if(listOfRegisteredId.contains(id)){
			listOfRegisteredId.remove(id);
			return true;
		}
		else{
			return false;
		}
	}
	
	
}
