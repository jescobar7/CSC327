import java.io.*;
import java.util.Scanner;

public class Parity {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
			
		while (true) {
			int parity = 0;
			String line = sc.nextLine();
			
			if(line.equals("#")) {
				break;
			}
			for (char c: line.toCharArray()) {
				switch (c) {
					case '0':
						System.out.print(c);
						break;
					case '1':
						parity += 1;
						System.out.print(c);
						break;
					case 'e':
						if (parity % 2 == 0) {
							System.out.println('0');
						} else {
							System.out.println('1');
						}
						break;
					case 'o':
						if (parity % 2 == 1) {
							System.out.println('0');
						} else {
							System.out.println('1');
						}
						break;
				}
			}
		}
	}
}