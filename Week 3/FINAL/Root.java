import java.io.*;
import java.lang.Math.*;
import java.util.Scanner;

public class Root {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		String[] tokens;
		int ZERO = 0;
		
		while (run) {
			tokens = sc.nextLine().split(" ");
			if (Integer.parseInt(tokens[0]) == ZERO && Integer.parseInt(tokens[1]) == ZERO) {
				run = false;
				break;
			}
			int expected = Integer.parseInt(tokens[0]);
			int base = 0;
			int exponent = Integer.parseInt(tokens[1]);
			int result = 0;
			int oldResult = 0;
			int newResult = 0;
			
			while (result < expected) {
				oldResult = result;
				result = (int)Math.pow(base, exponent);
				newResult = result;
				base++;
			}
			if (expected-oldResult <= newResult-expected) {
				System.out.println(base-2);
			}
			else {
				System.out.println(base-1);
			}
		}
	}
}