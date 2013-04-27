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
						//System.out.println("\nPrevChar:"+prevChar);
						//System.out.println("ThisChar:"+thisChar);
						//System.out.println("nextChar:"+nextChar);
						//System.out.println("NextNext:"+nextNext);
						
						if (prevChar==-1 && nextChar==-1) {			//Single Character
							if (thisChar!=65 && 						//Single Letter no 'a', 'A', 'I'
								thisChar!=73 && 
								thisChar!=97) {
								status = "suspicious";
								break;
							}
						}
						else if (prevChar==32 && nextChar==-1) {	//Last character
							if (thisChar!=65 && 						//Single Letter no 'a', 'A', 'I'
								thisChar!=73 && 
								thisChar!=97) {
								status = "suspicious";
								break;
							}
						}
						else if (prevChar==-1 && nextChar==32) {	//First character
							if (thisChar!=65 && 						//Single Letter no 'a', 'A', 'I'
								thisChar!=73 && 
								thisChar!=97) {
								status = "suspicious";
								break;
							}
						}
						else if (thisChar == 32) {					//Space
							if (nextChar!=65 && 						//Single Letter no 'a', 'A', 'I'
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
								 (thisChar>=123 && thisChar<=126)) {	//Punctuation
							if ((nextChar==33) ||
								 (nextChar>=35 && nextChar<=47) || 
								 (nextChar>=58 && nextChar<=64) ||
								 (nextChar>=91 && nextChar<=96) ||
								 (nextChar>=123 && nextChar<=126)) {
								 status = "suspicious";
							}
						}
						else if (thisChar>=65 && thisChar<=90) {	//Uppercase
							if (nextChar>=65 && nextChar<=90) {			//Uppercase
								status = "suspicious";
							}
							else if (nextChar>=48 && nextChar<=57) {	//Digit
								status = "suspicious";
								break;
							}
						}
						else if (thisChar>=48 && thisChar<=57) {	//Digit
							if (nextChar>=65 && nextChar<=90) {			//Uppercase
								status = "suspicious";
							}
							else if (nextChar>=97 && nextChar<=122) {	//Lowercase
								status = "suspicious";
								break;
							}
						}
						else if (thisChar>=97 && thisChar<=122) {	//Lowercase
							if (nextChar>=48 && nextChar<=57) {			//Digit
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