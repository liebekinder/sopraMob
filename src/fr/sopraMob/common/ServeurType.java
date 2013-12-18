package fr.sopraMob.common;

public enum ServeurType {

	GOOGLE, WP, IOS, ALL;

	public static ServeurType getFromText(String phoneTypeTxt) {
		if(phoneTypeTxt.equals("GOOGLE")) return GOOGLE;
		if(phoneTypeTxt.equals("WP")) return WP;
		if(phoneTypeTxt.equals("IOS")) return IOS;
		if(phoneTypeTxt.equals("ALL")) return ALL;
		return null;
	}
	
	@Override
	public String toString() {
		if(this.equals(GOOGLE)) return "GOOGLE";
		if(this.equals(WP)) return "WP";
		if(this.equals(IOS)) return "IOS";
		if(this.equals(ALL)) return "ALL";
		return "";
	}
}
