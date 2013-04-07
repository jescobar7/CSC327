import java.io.*;
import java.util.Scanner;

public class Firefly {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);	
		boolean run = true;
		
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			System.out.println(line);
		}
	}
}