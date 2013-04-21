import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Strings {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		char[] chars;
		char STAR = '*';
		
		while (run) {
			chars = sc.nextLine().toCharArray();
			chars = charString(chars).toCharArray();
			
			if (chars.length > 0 && chars.length <= 79) {
				if (chars[0] == STAR) {
					run = false;
				}
				else if (chars.length == 1) {
					System.out.println(charString(chars)+" is surprising.");
				}
				else {
					HashMap<String, String> zeroMap = new HashMap<String, String>();
					HashMap<String, String> oneMap = new HashMap<String, String>();
					HashMap<String, String> twoMap = new HashMap<String, String>();
					boolean zeroUnique = true;
					boolean oneUnique = true;
					boolean twoUnique = true;
					int len = chars.length;
					
					for (int i = 0; i < len; i++) {
						if (zeroUnique) {
							if (i+1 < len) {
								String newKey = Character.toString(chars[i]) + chars[i+1];
								if (!(zeroMap.containsKey(newKey))) {
									zeroMap.put(newKey, newKey);
								} else {
									zeroUnique = false;
								}
							}
						}
						if (oneUnique) {
							if (i+2 < len) {
								String newKey = Character.toString(chars[i]) + chars[i+2];
								if (!(oneMap.containsKey(newKey))) {
									oneMap.put(newKey, newKey);
								} else {
									oneUnique = false;
								}
							}
						}
						if (twoUnique) {
							if (i+3 < len) {
								String newKey = Character.toString(chars[i]) + chars[i+3];
								if (!(twoMap.containsKey(newKey))) {
									twoMap.put(newKey, newKey);
								} else {
									twoUnique = false;
								}
							}
						}
					}
					
					if (zeroUnique && oneUnique && twoUnique) {
						System.out.println(charString(chars)+" is surprising.");
					}
					else {
						System.out.println(charString(chars)+" is NOT surprising.");
					}
				}
			}
		}
	}
	
	public static String charString(char[] cArray) {
		String cString = "";
		for (char c: cArray) {
			if (c != ' ') {
				cString = cString + c;
			}
		}
		return cString;
	}
}