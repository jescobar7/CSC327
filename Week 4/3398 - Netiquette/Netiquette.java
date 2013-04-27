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
					if (line[i] == ' ' ){
						
					}
					else if ((int)line[i] >= 65 && (int)line[i] <= 90) {
						if ((int)line[i+1] >= 65 && (int)line[i+1] <= 90) {
							status = "suspicious";
						}
					}
				}
				System.out.println(status);
				status = "OK";
			}
		}
	}
}