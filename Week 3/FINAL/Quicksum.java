import java.io.*;
import java.util.Scanner;

public class Quicksum {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);	
		boolean run = true;
		
		while (run) {
			String line = sc.nextLine();
			char[] cArray = line.toCharArray();
			
			if (cArray[0] == '#') {
				run = false;
				break;
			}
			int i = 1;
			int result = 0;
			for (char c: cArray) {
				if (c != ' ') {
					result = result + (i *((int)c-64));
				}
				i++;
			}
			System.out.println(result);
		}
	}
}