import java.io.*;
import java.util.Scanner;

class Parity {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		try {
			while (sc.hasNext()) {
				String line = sc.next();
				int parity = 0;
				String output = "";
				
				for (int i = 0; i < line.length() && i < 31; i++) {
					switch (line.charAt(i)) {
						case '0':
							output = output + "0";
							break;
						case '1':
							parity += 1;
							output = output + "1";
							break;
						case 'e':
							if (parity % 2 == 0) {
								output = output + "0";
							} else {
								output = output + "1";
							}
							parity = 0;
							break;
						case 'o':
							if (parity % 2 == 1) {
								output = output + "0";
							} else {
								output = output + "1";
							}
							parity = 0;
							break;
						case '#':
							break;
					}
				}
				System.out.println(output);
				output = "";
			}
		} 
		finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}