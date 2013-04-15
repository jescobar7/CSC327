import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PersistentBits {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int a; int b; int c; int seed; int x; int xOld;
		String[] tokens;
		String strOld = "";
		String strNew = "";
		
		while (run) {
			tokens = sc.nextLine().split(" ");
			int tLen = tokens.length;
			if (tLen == 1) {
				if (Integer.parseInt(tokens[0]) == 0) {
					run = false;
					break;
				}
			}
			else if (tLen == 4) {
				a = Integer.parseInt(tokens[0]);
				b = Integer.parseInt(tokens[1]);
				c = Integer.parseInt(tokens[2]);
				seed = Integer.parseInt(tokens[3]);
				
				x = seed;
				//x2 = seed;
				strOld = pad(x);
				
				x = calc(a,b,c,x);
				//x2 = x;
				strNew = pad(x);		
				strOld = check(strOld, strNew);
				
				while (x != seed) {
					//System.out.println(x);
					x = calc(a,b,c,x);
					strNew = pad(x);				
					strOld = check(strOld, strNew);
				}
			}
			System.out.println(strOld);
		}
	}
	
	public static int calc(int a, int b, int c, int x) {
		return ((a*x)+ b)%c;
	}
	
	public static String check(String strOld, String strNew) {
		String result = "";
		for (int i = 0; i < strOld.length(); i++) {
			if (strOld.charAt(i) == '?') {
				result = result + "?";
			}
			else if (strOld.charAt(i) == strNew.charAt(i)) {
				result = result + strOld.charAt(i);
			}
			else {
				result = result + "?";
			}
		}
		return result;
	}
	
	public static String pad(int b) {
		String padded = "";
		String s = Integer.toBinaryString(b);
		for (int i = s.length(); i < 16; i++) {
			padded += "0";
		}
		padded = padded + s;
		return padded;
	}
}