package fr.sopraMob.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Data {

	public enum TYPE{
		GOOGLE,	WP, IOS;		
	}
	
	public static final String API_KEY = "AIzaSyBHUc_V8YIxUsol1abJGo-qlkLvsBTQVcA";
	private static Set<String> listOfRegisteredId;
	private static final String PROJECTID="968947276795";

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
	
	public static String getProjectId(){
		return PROJECTID;		
	}
	
	public static int nbIds(){
		return listOfRegisteredId.size();
	}
	
	public static HashSet<String> getIdList(){
		return (HashSet<String>) listOfRegisteredId;
	}

	public static List<String> getIdList2(){
		return new ArrayList<String>(listOfRegisteredId);
	}
	
}
