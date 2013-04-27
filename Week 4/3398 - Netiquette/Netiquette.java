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
				for (int i = 0; i < line.length; i++) {
					if (status != "suspicious") {
						int thisChar = (int)line[i];
						int nextChar = -1;
						try {nextChar = (int)line[i+1];}catch(Exception e){}
						int prevChar = -1;
						try {prevChar = (int)line[i-1];}catch(Exception e){}
						int nextNext = -1;
						try {nextNext = (int)line[i+2];}catch(Exception e){}
						
						if (prevChar==-1 && nextChar==-1) {
							if (thisChar!=65 && 
								thisChar!=73 && 
								thisChar!=97) {
								status = "suspicious";
								break;
							}
						}
						else if (prevChar==32 && nextChar==-1) {
							if (thisChar!=65 && 
								thisChar!=73 && 
								thisChar!=97) {
								status = "suspicious";
								break;
							}
						}
						else if (prevChar==-1 && nextChar==32) {
							if (thisChar!=65 && 
								thisChar!=73 && 
								thisChar!=97) {
								status = "suspicious";
								break;
							}
						}
						else if (thisChar == 32) {
							if (nextChar!=65 && 
								nextChar!=73 && 
								nextChar!=97) {
								if (nextNext == 32) {
									status = "suspicious";
									break;
								}
							}
						}
						else if ((thisChar==33) ||
								 (thisChar>=35 && thisChar<=47) || 
								 (thisChar>=58 && thisChar<=64) ||
								 (thisChar>=91 && thisChar<=96) ||
								 (thisChar>=123 && thisChar<=126)) {
							if ((nextChar==33) ||
								 (nextChar>=35 && nextChar<=47) || 
								 (nextChar>=58 && nextChar<=64) ||
								 (nextChar>=91 && nextChar<=96) ||
								 (nextChar>=123 && nextChar<=126)) {
								 status = "suspicious";
							}
						}
						else if (thisChar>=65 && thisChar<=90) {
							if (nextChar>=65 && nextChar<=90) {
								status = "suspicious";
							}
							else if (nextChar>=48 && nextChar<=57) {
								status = "suspicious";
								break;
							}
						}
						else if (thisChar>=48 && thisChar<=57) {
							if (nextChar>=65 && nextChar<=90) {
								status = "suspicious";
							}
							else if (nextChar>=97 && nextChar<=122) {
								status = "suspicious";
								break;
							}
						}
						else if (thisChar>=97 && thisChar<=122) {
							if (nextChar>=48 && nextChar<=57) {
								status = "suspicious";
								break;
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