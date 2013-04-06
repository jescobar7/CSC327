import java.io.*;
import java.util.Scanner;

public class Steganography {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		while (flag) {
			String line = sc.nextLine();
			char[] cArray = line.toCharArray();
			
			int spaces = 0;
			for (int i = 0; i < cArray.length; i++) {
				if (cArray[i] == '#') {
					flag = false;
				}
				switch (cArray[i]) {
					case ' ':
						//System.out.print("Space");
						spaces += 1;
						break;
					case '*':
						//System.out.print("---");
						break;
				}
				System.out.print(cArray[i]);
			}
			System.out.println("[Space Count = " + spaces + "]");
			spaces = 0;
			//System.out.println();
		}
	}
}