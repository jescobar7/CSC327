import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PersistentBits {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int a; int b; int c; int seed; int x;
		String[] tokens;
		ArrayList<String> strArray = new ArrayList<String>(0);
		
		while (run) {
			tokens = sc.nextLine().split(" ");
			strArray = new ArrayList<String>();
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
				strArray.add(pad(x));
				System.out.println(pad(x));
				x = calc(a,b,c,x);
				while (x != seed) {
					strArray.add(pad(x));
					System.out.println(pad(x));
					x = calc(a,b,c,x);
				}
			}
		}
		// for (int i = 0; i < strArray.size(); i++) {
			// System.out.println(strArray.get(i));
		// }
	}
	
	public static int calc(int a, int b, int c, int x) {
		return ((a*x)+ b)%c;
	}
	
	public static String check(String s) {
		String result = "";
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