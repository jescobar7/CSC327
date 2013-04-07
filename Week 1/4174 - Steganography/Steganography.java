import java.io.*;
import java.util.Scanner;

public class Steganography {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		while (flag) {
			String line = sc.nextLine();
			
			int spaces = 0;
			boolean checked = false;
			String bString = "";
			
			for (char c: line.toCharArray()) {
				if (c == '#') {
					flag = false;
				}
				switch (c) {
					case ' ':
						checked = false;
						spaces += 1;
						//System.out.print("[SPACE]");
						break;
					case '*':
						//System.out.print("[*]");
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
			//int value = Integer.parseInt(bString, 2);
			//System.out.println(Integer.parseInt(bString, 2));
			System.out.println(bString);
		}
	}
}