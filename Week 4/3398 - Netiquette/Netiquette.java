import java.io.*;
import java.util.Scanner;

public class Netiquette {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String status = "OK";
		
		while (true) {
			char[] line = sc.nextLine().toCharArray();
			if (line[0] == '#') {
				break;
			}
			else {
				for (int i = 0; i < line.length-1; i++) {
					if (status != "suspicious") {
						// if ((int)line[i] == 32) {									//Space
							// if ((int)line[i+1] == ) {									//Single Letter
							// }
						// }
						if ((int)line[i] >= 65 && (int)line[i] <= 90) {				//Uppercase
							if ((int)line[i+1] >= 65 && (int)line[i+1] <= 90) {			//Uppercase
								status = "suspicious";
							}
							else if ((int)line[i+1] >= 48 && (int)line[i+1] <= 57) {	//Digit
								status = "suspicious";
							}
						}
						if ((int)line[i] >= 48 && (int)line[i] <= 57) {				//Digit
							if ((int)line[i+1] >= 65 && (int)line[i+1] <= 90) {			//Uppercase
								status = "suspicious";
							}
							else if ((int)line[i+1] >= 97 && (int)line[i+1] <= 122) {	//Lowercase
								status = "suspicious";
							}
						}
						if ((int)line[i] >= 97 && (int)line[i] <= 122) {			//Lowercase
							if ((int)line[i+1] >= 48 && (int)line[i+1] <= 57) {			//Digit
								status = "suspicious";
							}
						}
					}
				}
				System.out.println(status);
				status = "OK";
			}
		}
	}
}