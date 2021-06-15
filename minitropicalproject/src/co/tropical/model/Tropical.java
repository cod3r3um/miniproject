package co.tropical.model;

public class Tropical {
	
	static String id;
	static int pw;
	static String guest_id;
	static int guest_pw;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPw() {
		return pw;
	}
	public void setPw(int pw) {
		this.pw = pw;
	}
	public static String getGuest_id() {
		return guest_id;
	}
	public static void setGuest_id(String guest_id) {
		Tropical.guest_id = guest_id;
	}
	public static int getGuest_pw() {
		return guest_pw;
	}
	public static void setGuest_pw(int guest_pw) {
		Tropical.guest_pw = guest_pw;
	}
	
	
	

}
