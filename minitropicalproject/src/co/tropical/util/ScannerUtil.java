package co.tropical.util;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import co.tropical.model.Tropical;

public class ScannerUtil {
	static Scanner scanner = new Scanner(System.in);
	
	public static int readInt() {
		int result = 0;
		while (true) {
			try {
				String temp = scanner.next();
				result = Integer.parseInt(temp);
				break;
			} catch (Exception e) {
				System.out.println("~ WRONG FORMAT ~");
			}
		}
		return result;
	}
	
	// 한 줄 입력
	public static int readInt(String prompt) {
		System.out.println(prompt + "> ");
		return readInt();
	}
	
	public static String readStr(String prompt) {
		System.out.println(prompt + "> ");
		return readStr();
	}
	
	public static String readStr () {
		String result = "> ";
		try {
			result = scanner.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 입력
	public static String readDate () {
		String result = "";
		SimpleDateFormat df = new SimpleDateFormat("DD/MM/YYYY");
		do {
			try {
				result = scanner.next();
				df.parse(result.trim());
				break;
			} catch (Exception e) {
				System.out.println("~ WRONG FORMAT ~");
			}
			
		} while (true);
		return result;
	}
	
	// 입력
	public static Tropical readTropical () {
		System.out.println("Check-in DD/MM/YYYY\t"
				+ "Check-out DD/MM/YYYY\t"
				+ "Room Number XXX\t"
				+ "Person XX");
		String result = scanner.next();
		String[] arr = result.split(" ");
		Tropical tropical = new Tropical(arr[0], arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]));
		return tropical;
	}
	
}
