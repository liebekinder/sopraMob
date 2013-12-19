package fr.sopraMob.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Data {
	
	public static final String API_KEY = "AIzaSyBHUc_V8YIxUsol1abJGo-qlkLvsBTQVcA";
	private static Map<String,Infos> listOfRegisteredId;
	//association owner / id list
	private static Map<String,HashSet<String>> listOfOwners;
	private static final String PROJECTID="968947276795";
	private static final String bddPath = "bdd";
	private static final String separator = "JaimeLeCamembertEspeceDeTrollDesNeigesEnFurie";
	
	/**
	 * use to register an id. All method are static for now
	 * @param id
	 * @param phoneType 
	 * @param phoneOwner 
	 * @return true if ok, false else
	 */
	public static synchronized boolean register(String id, ServeurType phoneType, String phoneOwner){
		System.out.println(phoneOwner);
		loadDatabase();
		if(listOfRegisteredId.containsKey(id)){
			return false;
		}
		else{
			listOfRegisteredId.put(id, new Infos(phoneType, phoneOwner));
			addPhoneToOwner(phoneOwner, id);
			saveDataBase();
			return true;
		}
	}
	
	private static void addPhoneToOwner(String phoneOwner, String id) {
		if(listOfOwners.containsKey(phoneOwner)) {
			listOfOwners.get(phoneOwner).add(id);
		}
		else {
			listOfOwners.put(phoneOwner, new HashSet<String>(Arrays.asList(id)));
		}
	}

	/**
	 * use to unregister an id. 
	 * @param id
	 * @return true if ok, false else
	 */
	public static synchronized boolean unregister(String id){
		loadDatabase();
		if(listOfRegisteredId.containsKey(id)){
			listOfRegisteredId.remove(id);
			for(String owner : listOfOwners.keySet()) {
				if(listOfOwners.get(owner).contains(id)) {
					listOfOwners.get(owner).remove(id);
				}
			}
			saveDataBase();
			return true;
		}
		else{
			return false;
		}
	}
	
	private static void saveDataBase() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(bddPath, "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if(writer==null) return;
		
		for(String id : listOfRegisteredId.keySet()) {
			Infos info = listOfRegisteredId.get(id);
			writer.println(id+separator+info.getPhoneType()+separator+info.getPhoneOwner());
			System.out.println("save:"+id+separator+info.getPhoneType()+separator+info.getPhoneOwner());
		}
		writer.close();
	}

	private static void loadDatabase() {
		System.out.println("Loading bdd...");
		
		//TODO load file
		Data.listOfRegisteredId = new HashMap<String,Infos>();
		Data.listOfOwners = new HashMap<String, HashSet<String>>();
		
		File bdd = new File(bddPath);
		if(!bdd.exists()) {
			System.out.println("Bdd not existing, creating file...");
			try {
				bdd.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return;
		}
		
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(bddPath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    try {
	        String line = null;
			try {
				line = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

	        while (line != null) {
	            try {
					addNewEntry(line);
					line = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	    } finally {
	        try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	}

	private static void addNewEntry(String line) {
		if(line==null || line.equals("")) return;
		String[] splitEntry = line.split(separator);
		listOfRegisteredId.put(splitEntry[0], new Infos(ServeurType.getFromText(splitEntry[1]), splitEntry[2]));
		addPhoneToOwner(splitEntry[2], splitEntry[0]);
	}

	public static String getProjectId(){
		return PROJECTID;		
	}
	
	public static int nbIds(){
		return listOfRegisteredId.size();
	}
	
	public static Set<String> getOwnersList(){
		loadDatabase();
		return listOfOwners.keySet();
	}
	
//	public static HashSet<String> getIdList(){
//		loadDatabase();
//		return (HashSet<String>) listOfRegisteredId.keySet();
//	}

	public static Set<String> getIdList(){
		loadDatabase();
		return listOfRegisteredId.keySet();
	}

	public static ServeurType getPhoneType(String id) {
		loadDatabase();
		if(listOfRegisteredId.containsKey(id)) {
			System.out.println("PhoneType:"+listOfRegisteredId.get(id).getPhoneType());
			return listOfRegisteredId.get(id).getPhoneType();
		}
		return null;
	}

	public static HashSet<String> getPhonesByOwner(String phoneOwner) {
		if(listOfOwners.containsKey(phoneOwner)) return listOfOwners.get(phoneOwner);
		return null;
	}
	
}
