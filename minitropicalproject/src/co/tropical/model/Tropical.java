package co.tropical.model;

public class Tropical {
	
	String id;
	int pw;
	String guest_id;
	int guest_pw;
	String guest_name;
	String checkin;
	String checkout;
	int room;
	int number;
	String price;
	String name;
	
	public Tropical(){}
	
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

	public String getGuest_id() {
		return guest_id;
	}

	public void setGuest_id(String guest_id) {
		this.guest_id = guest_id;
	}

	public int getGuest_pw() {
		return guest_pw;
	}

	
	public void setGuest_pw(int guest_pw) {
		this.guest_pw = guest_pw;
	}

	public String getGuest_name() {
		return guest_name;
	}

	public void setGuest_name(String guest_name) {
		this.guest_name = guest_name;
	}

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String viewName() {
		return guest_name;
	}
	
	@Override
	public String toString() {
		return "Tropical [id=" + id + ", pw=" + pw + ", guest_id=" + guest_id + ", guest_pw=" + guest_pw
				+ ", guest_name=" + guest_name + ", checkin=" + checkin + ", checkout=" + checkout + ", room=" + room
				+ ", number=" + number + ", price=" + price + ", name=" + name + "]";
	}
	
	public String selectBook() {
		return "Check-in: " + checkin + "Check-out:" + checkout + "Room Number: " + room + "Person: " + number;
	}
	
	public Tropical(String guest_id, String checkin, String checkout, int room, int number) {
		super();
		this.guest_id = guest_id;
		this.checkin = checkin;
		this.checkout = checkout;
		this.room = room;
		this.number = number;
	}

	
	public Tropical(String id, int pw, String guest_id, int guest_pw, String checkin, String checkout, int room,
			int number, String price, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.guest_id = guest_id;
		this.guest_pw = guest_pw;
		this.checkin = checkin;
		this.checkout = checkout;
		this.room = room;
		this.number = number;
		this.price = price;
		this.name = name;
	}
	public Tropical(String checkin, String checkout, int room, int number) {
		super();
		this.checkin = checkin;
		this.checkout = checkout;
		this.room = room;
		this.number = number;
	}
	public Tropical(String checkin, String checkout, int room, int number, String price) {
		super();
		this.checkin = checkin;
		this.checkout = checkout;
		this.room = room;
		this.number = number;
		this.price = price;
	}
//	public Tropical(String name, String checkin, String checkout, int room, int number) {
//		super();
//		this.name = name;
//		this.checkin = checkin;
//		this.checkout = checkout;
//		this.room = room;
//		this.number = number;
//	}
	public Tropical(String guest_id, String checkin, String checkout, int room, int number, String price) {
		super();
		this.guest_id = guest_id;
		this.checkin = checkin;
		this.checkout = checkout;
		this.room = room;
		this.number = number;
		this.price = price;
	}
	public Tropical(String id, int pw) {
		super();
		this.id = id;
		this.pw = pw;
		
	}
	public Tropical(int guest_pw, String guest_id) {
		super();
		this.guest_id = guest_id;
		this.guest_pw = guest_pw;
	}
	public Tropical(String guest_id) {
		super();
		this.guest_id = guest_id;
	}

	public Tropical(String guest_id, int guest_pw, String guest_name) {
		super();
		this.guest_id = guest_id;
		this.guest_pw = guest_pw;
		this.guest_name = guest_name;
	}
	
}
