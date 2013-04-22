import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Strings {
	private static char STAR = '*';
	private static String UNIQUE = "unique";
	private static String BOOL_TRUE = "true";
	private static String STR_VAL_TRUE = "true";
	private static String STR_VAL_FALSE = "false";
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(UNIQUE, STR_VAL_TRUE);
		boolean run = true;
		char[] chars;
		
		while (run) {
			chars = sc.nextLine().toCharArray();
			chars = charString(chars).toCharArray();
			int len = chars.length;
			
			if (len > 0 && len <= 79) {
				if (chars[0] == STAR) {
					run = false;
				}
				else if (len == 1) {
					System.out.println(charString(chars)+" is surprising.");
				}
				else {
					map = new HashMap<String, String>();
					map.put(UNIQUE, STR_VAL_TRUE);
					
					int d = 1;
					for (int i = 0; i < len; i++) {
						System.out.println(chars+" "+d+" "+map);
						if (map.get(UNIQUE) == BOOL_TRUE) {
							map = dUnique(chars, d, map);
							d++;
						}
					}
				}
				if (map.get(UNIQUE) == BOOL_TRUE) {
					System.out.println(charString(chars)+" is surprising.");
				}
				else {
					System.out.println(charString(chars)+" is NOT surprising.");
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
	
	public static HashMap<String, String> dUnique(char[] cArray, int d, HashMap<String, String> map) {
		int len = cArray.length;
		for (int i = 0; i < len; i++) {
			if (i+d < len) {
				String newKey = Character.toString(cArray[i]) + cArray[i+d];
				if (!(map.containsKey(newKey))) {
					map.put(newKey, STR_VAL_TRUE);
				} else {
					map.put(UNIQUE,STR_VAL_FALSE);
				}
			}
		}
		return map;
	}
}