import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Strings {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		char[] chars;
		char EMPTY = ' ';
		char STAR = '*';
		
		while (run) {
			chars = sc.nextLine().toCharArray();
			
			if (chars[0] == STAR) {
				run = false;
			}
			else if (chars[1] == EMPTY) {
				System.out.println(chars[0]+" is surprising.");
			}
			else {
				HashMap one = new HashMap();
				HashMap two = new HashMap();
				HashMap three = new HashMap();
				boolean oneUnique = false;
				boolean twoUnique = false;
				boolean threeUnique = false;
				
				for (int i = 0; i < 79; i++) {
					
				}
				
				if (oneUnique == true && twoUnique == true && threeUnique == true) {
					for (char c: chars) {
						System.out.print(c);
					}
					System.out.print("is surprising.\n");
				}
				else {
					for (char c: chars) {
						System.out.print(c);
					}
					System.out.print("is NOT surprising.\n");
				}
			}
		}
	}
}