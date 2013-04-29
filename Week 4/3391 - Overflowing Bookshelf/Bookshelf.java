import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Bookshelf {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String[] tokens;
		ArrayList<String> shelf;
		
		while (true) {
			tokens = sc.nextLine().split(" ");
			char c = tokens[0].charAt(0);
			int len = tokens.length;
			int shelfSize = 0;
			int currentShelfSize = 0;
			int bookId;
			int bookSize;
			int probNum = 1;
			
			if (len == 1) {
				if (c == '-') {
					break;
				}
				else if (c == 'E') {
					System.out.print("PROBLEM "+probNum+": ");
					// for () {	
						// System.out.print();
					// }
					System.out.print("\n");
					probNum++;
					shelf = new ArrayList<String>();
				}
				else {
					shelfSize = Integer.parseInt(tokens[0]);
				}
			}
			else if (len == 2) {
				if (c == 'R') {
					bookId = Integer.parseInt(tokens[1]);
				}
			}
			else if (len == 3) {
				if (c == 'A') {
					bookId = Integer.parseInt(tokens[1]);
					bookSize = Integer.parseInt(tokens[2]);
				}
			}
		}
	}
}