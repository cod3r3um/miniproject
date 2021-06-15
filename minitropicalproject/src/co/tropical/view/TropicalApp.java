package co.tropical.view;

import java.util.Scanner;

import co.tropical.access.TropicalAccess;
import co.tropical.access.TropicalDAO;

public class TropicalApp {
	
	static String ad_id;
	static int ad_pw;
	static String gst_id;
	static int gst_pw;
	
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
			case 1: gstMenuTitle();
				break;
			case 2: adMenuTitle();
				break;
			}
		} while (num != 0);
		System.out.println("~ S E E   Y O U   L A T E R ~");			
	}
	
	private void gstLogin() {
		int num;
		System.out.println("Enter your Id > ");
		gst_id = scanner1.next();
		System.out.println("Enter your password > ");
		gst_pw = scanner2.nextInt();
		boolean b = access.gstLogin(gst_id, gst_pw);
		if (b = true) {
			System.out.println("Welcome %s!", access.printName(gst_id).viewName());
			gstMenu();
		} else {
			System.out.println("Please check your Id and password.");
		} mainScreen();		
	}
	
	private void gstMenu() {
		
	}
	
	
	
	private void gstMenuTitle() {
		System.out.println("┌────────────────── T R O P I C A L ──────────────────┐");		
		System.out.println("│               1. Join the Tropical                  │");
		System.out.println("│               2. Make a reservation                 │");
		System.out.println("│               3. Check your reservation             │");
		System.out.println("│               4. Change your reservation            │");
		System.out.println("│               5. Cancel your reservation            │");
		System.out.println("└─────────────────────────────────────────────────────┘");
	}
	
	private void adMenuTitle() {
		System.out.println("┌────────────────── T R O P I C A L ──────────────────┐");
		System.out.println("│               1. Check all reservations             │");
		System.out.println("│               2. Make a reservation                 │");
		System.out.println("│               3. Change a reservation               │");
		System.out.println("│               4. Cancel a reservation               │");
		System.out.println("└─────────────────────────────────────────────────────┘");
	}
	

	
}
