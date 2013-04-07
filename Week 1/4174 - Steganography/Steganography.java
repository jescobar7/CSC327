import java.io.*;
import java.util.Scanner;

public class Steganography {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		boolean checked = false;		
		boolean run = true;
		String bString = "";
		int spaces = 0;
		
		while (run) {
			String line = sc.nextLine();
			
			for (char c: line.toCharArray()) {
				switch (c) {
					case '#':
						run = false;
						break;
					case ' ':
						spaces += 1;
						break;
					case '*':
						break;
					default:
						if (checked == false) {
							if (spaces > 0) {
								//bString += "Z";
								if (spaces % 2 == 0) {
									bString += "1";
									//System.out.print("["+c+"]");
								}
								else if (spaces % 2 == 1) {
									bString += "0";
									//System.out.print("["+c+"]");
								}
							}
						}
						spaces = 0;
						checked = true;
						break;
				}
			}
		}
	}
	
	public static String pad(String s) {
		String padded = s;
		for (int i = s.length(); i < 5; i++) {
			padded += "0";
		}
		return padded;
	}
}