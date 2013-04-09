import java.io.*;
import java.util.Scanner;

public class Seven {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);	
		boolean run = true;
		String result = "";
		
		while (run) {
			String line = sc.nextLine();
			
			for (char c: line.toCharArray()) {
				switch (c) {
					case '#':
						run = false;
						break;
					case ' ':
						result = result + "%20";
						break;
					case '!':
						result = result + "%21";
						break;
					case '$':
						result = result + "%24";
						break;
					case '%':
						result = result + "%25";
						break;
					case '(':
						result = result + "%28";
						break;
					case ')':
						result = result + "%29";
						break;
					case '*':
						result = result + "%2a";
						break;
					default:
						result = result + Character.toString(c);
						break;
				}
			}
			System.out.println(result);
			result = "";
		}
	}
}