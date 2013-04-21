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
				HashMap<String, String> oneMap = new HashMap<String, String>();
				HashMap<String, String> twoMap = new HashMap<String, String>();
				HashMap<String, String> threeMap = new HashMap<String, String>();
				boolean oneUnique = true;
				boolean twoUnique = true;
				boolean threeUnique = true;
				
				for (int i = 0; i < 79; i++) {
					if (oneUnique) {
						if (i+1 < chars.length) {
							String newKey = "";
							newKey = newKey + chars[i];
							newKey = newKey + chars[i+1];
							if (!oneMap.containsKey(newKey)) {
								oneMap.put(newKey, newKey);
							} else {
								oneUnique = false;
							}
						}
					}
					if (twoUnique) {
						if (i+2 < chars.length) {
							String newKey = "";
							newKey = newKey + chars[i];
							newKey = newKey + chars[i+2];
							if (!twoMap.containsKey(newKey)) {
								twoMap.put(newKey, newKey);
							} else {
								twoUnique = false;
							}
						}
					}
					if (threeUnique) {
						if (i+3 < chars.length) {
							String newKey = "";
							newKey = newKey + chars[i];
							newKey = newKey + chars[i+3];
							if (!threeMap.containsKey(newKey)) {
								threeMap.put(newKey, newKey);
							} else {
								threeUnique = false;
							}
						}
					}
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