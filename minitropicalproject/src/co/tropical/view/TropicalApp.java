package co.tropical.view;

import java.util.List;
import java.util.Scanner;

import co.tropical.access.TropicalAccess;
import co.tropical.access.TropicalDAO;
import co.tropical.model.Tropical;

public class TropicalApp {
	
	static String ad_id;
	static int ad_pw;
	static String guest_id;
	static int guest_pw;
	
	TropicalAccess access = new TropicalDAO();
	static Scanner scanner1 = new Scanner(System.in);
	static Scanner scanner2 = new Scanner(System.in);
	
	public void mainScreen() {
		int num;
		System.out.println("┌───────── W E L C O M E      T O      O U R ─────────┐");			
		System.out.println("│                                                     │");
		System.out.println("│    1 RESERVATION       2 MANAGEMENT       0 EXIT    │");
		System.out.println("│                                                     │");			
		System.out.println("└────────────────── T R O P I C A L ──────────────────┘");
		do {
			System.out.print("> ");
			num = scanner1.nextInt();
			switch (num) {
			case 1: gstMenu();
				break;
			case 2: adMenu();
				break;
			}
		} while (num != 0);
		System.out.println("~ S E E   Y O U   L A T E R ~");			
	}
	
	public void gstMenu() {
		int menuNum;
		do {
			gstMenuTitle();
			System.out.print("Select your number > ");
			menuNum = scanner1.nextInt();
			switch(menuNum) {
			case 1:
				signUp();
				break;
			case 2:
				gstLogin();
				break;
			case 3:	
				book();
				break;
			case 4:
				selectYours();
				break;
			case 5:
				gstChange();
				break;
			case 6:
				gstCancel();
				break;
			}
		} while (menuNum != 0);
		System.out.println("~ S E E   Y O U   L A T E R ~");
	}
	
	
	public void adMenu() {
		int menuNum;
		do {
			adMenuTitle();
			System.out.print("Select your number > ");
			menuNum = scanner2.nextInt();
			switch(menuNum) {
			case 1: 
				adLogin();
				break;
			case 2:	
				selectAll();
				break;
			case 3: 
				selectYours();
				break;
			case 4:
				book();
				break;
			case 5:
				adChange();
				break;
			case 6:
				adCancel();
				break;
			}
		} while (menuNum != 0);
		System.out.println("~ S E E   Y O U   L A T E R ~");
	}

	
	private void gstLogin() {
		System.out.print("Enter your Id > ");
		guest_id = scanner1.next();
		System.out.print("Enter your password > ");
		int guest_pw = scanner2.nextInt();
		boolean b = access.gstLogin(guest_id, guest_pw);
		if (b = true) {
			System.out.printf("Welcome %s!", access.printName(guest_id).viewName());
			System.out.println(); // menu shape fixer
		} else {
			System.out.println("Please check your Id and password.");
			mainScreen();	
		} 	
	}
	
	private void adLogin() {
		System.out.print("Enter your Id > ");
		String ad_id = scanner1.next();
		System.out.print("Enter your password > ");
		int ad_pw = scanner2.nextInt();
		boolean b = access.adLogin(ad_id, ad_pw);
		if (b = true) {
			System.out.println("Welcome Boss!");
		} else {
			System.out.println("You don't have access.");
		}
	}
	
	private void signUp() {
		System.out.println("Please join out Tropical!");
		System.out.print("Enter your Id > ");
		String guest_id = scanner1.next();
		System.out.print("Enter your Password > ");
		int guest_pw = scanner2.nextInt();
		System.out.print("Enter your Name > ");
		String guest_name = scanner1.next();
		Tropical tropical = new Tropical(guest_id, guest_pw, guest_name);
		access.signUp(tropical);
	}
	
	public void book() {
		System.out.println("Make a reservation");
		System.out.print("check-in (DD/MM/YYYY) > ");
		String checkin = scanner1.next();
		System.out.print("check-out (DD/MM/YYYY) > ");
		String checkout = scanner2.next();
		System.out.print("Room Number > ");
		int room = scanner1.nextInt();
		System.out.print("Person > ");
		int number = scanner2.nextInt();
		Tropical tropical = new Tropical(guest_id, checkin, checkout, room, number);
		access.book(tropical);
	}
	
	public void selectYours() {
		System.out.print("Enter Id > ");
		String guest_id = scanner1.next();
		List<Tropical> tlist = access.selectYours(guest_id);
		for (Tropical tropical : tlist) {
			System.out.println(tropical.selectBook());			
		}
	}
	
	public void gstChange() {
		Tropical tropical = new Tropical();
		System.out.print("Enter your Id > ");
		tropical.setGuest_id(scanner1.next());
		
		System.out.print("Check-in > ");
		tropical.setCheckin(scanner1.next());
		
		System.out.print("Check-out > ");
		tropical.setCheckout(scanner2.next());
		
		System.out.print("Room Number > ");
		tropical.setRoom(scanner1.nextInt());
		
		System.out.print("Person > ");
		tropical.setNumber(scanner2.nextInt());
		
		access.gstChange(tropical);
		
		}
	
	public void gstCancel() {
		System.out.print("Enter your Id > ");
		String setGuest_id = scanner1.next();
		access.gstCancel(setGuest_id);
	}
	
	public void selectAll() {
		List <Tropical> tlist = access.selectAll();
		for (Tropical tropical : tlist) {
			System.out.println(tropical);
		}
	}
	
	public void selectBook(String guest_id) {
		System.out.print("Enter Id > ");
		guest_id = scanner2.next();
		List<Tropical> tlist = access.selectBook(guest_id);
		for (Tropical tropical : tlist) {
			System.out.println(tropical.selectBook());			
		}
	}
	
	public void adChange() {
		Tropical tropical = new Tropical();
		System.out.print("Enter Guest Id > ");
		tropical.setGuest_id(scanner1.next());
		
		System.out.print("Check-in > ");
		tropical.setCheckin(scanner1.next());
		
		System.out.print("Check-out > ");
		tropical.setCheckout(scanner2.next());
		
		System.out.print("Room Number > ");
		tropical.setRoom(scanner1.nextInt());
		
		System.out.print("Person > ");
		tropical.setNumber(scanner2.nextInt());
		
		access.adChange(tropical);
	}
	
	public void adCancel() {
		System.out.print("Enter Id > ");
		String setGuest_id = scanner2.next();
		access.adCancel(setGuest_id);
	}
	
	private void gstMenuTitle() {
		System.out.println("┌────────────────── T R O P I C A L ──────────────────┐");		
		System.out.println("│              1. Join the Tropical                   │");		
		System.out.println("│              2. Log in                              │");
		System.out.println("│              3. Make a reservation                  │");
		System.out.println("│              4. Check your reservation              │");
		System.out.println("│              5. Change your reservation             │");
		System.out.println("│              6. Cancel your reservation             │");
		System.out.println("└─────────────────────────────────────────────────────┘");
	}
	
	private void adMenuTitle() {
		System.out.println("┌────────────────── T R O P I C A L ──────────────────┐");
		System.out.println("│              1. Admin Log in                        │");		
		System.out.println("│              2. Check all reservations              │");		
		System.out.println("│              3. Check a reservation                 │");
		System.out.println("│              4. Make a reservation                  │");
		System.out.println("│              5. Change a reservation                │");
		System.out.println("│              6. Cancel a reservation                │");
		System.out.println("└─────────────────────────────────────────────────────┘");
	}
	

	
}
