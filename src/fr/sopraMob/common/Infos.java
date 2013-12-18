package fr.sopraMob.common;

public class Infos {

	private ServeurType phoneType;
	public ServeurType getPhoneType() {
		return phoneType;
	}

	public String getPhoneOwner() {
		return phoneOwner;
	}

	private String phoneOwner;

	public Infos(ServeurType phoneType, String phoneOwner) {
		this.phoneType = phoneType;
		this.phoneOwner = phoneOwner;
	}

}
