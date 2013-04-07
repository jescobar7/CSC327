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
						System.out.println(decode(pad(bString)));
						bString = "";
						break;
					default:
						if (spaces > 0) {
							if (bString.length() < 5) {
								if (spaces % 2 == 0) {
									bString += "1";
								}
								else if (spaces % 2 == 1) {
									bString += "0";
								}
							} else {
								System.out.print(decode(bString));
								bString = "";
								if (spaces % 2 == 0) {
									bString += "1";
								}
								else if (spaces % 2 == 1) {
									bString += "0";
								}
							}
						}
						spaces = 0;
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
	
	public static String decode(String m) {
		char ch = ' ';
		int value = Integer.parseInt(m, 2);
		String message;
		
		if ( (value >= 1) && ( value <= 26)) {
			ch = (char)(value+64);
		} else {
			switch (value) {
				case 0:
					ch = (char)(32);
					break;
				case 27:
					ch = (char)(39);
					break;
				case 28:
					ch = (char)(44);
					break;
				case 29:
					ch = (char)(45);
					break;
				case 30:
					ch = (char)(46);
					break;
				case 31:
					ch = (char)(63);
					break;
				default:
					break;
			}
		}
		message = Character.toString(ch);
		return message;
	}
}