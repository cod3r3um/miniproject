package co.tropical.view;

public class TropicalApp {
	
	
	static String id;
	static int pw;
	static String guest_id;
	static int guest_pw;
	
	public void mainscrn() {
		int num;
		System.out.println("Welcome to our tropical!");
		do {
			System.out.println("────────── W E L C O M E ──────────");
			System.out.println(" 1 RESERVATION       2 MANAGEMENT");
			System.out.println("───────── T R O P I C A L ─────────");
			num = scn.nextInt();
			switch (num) {
			case 1: gststart();
				break;
			case 2: adstart();
				break;
			}
		} while (num == 0);
		System.out.println("───────── S E E   Y O U ─────────");
	}
	
	public void gststart() {
		guest_id = ScannerUtil.readStr("아이디를 입력하세요.");
		guest_pw = ScannerUtil.readInt("비밀번호를 입력하세요.");
		
	}

	public void adstart() {
		
		id = ScannerUtil.readStr("아이디를 입력하세요.");
		pw = ScannerUtil.readInt("비밀번호를 입력하세요.");
		
	}
	
	

}
