import java.io.*;
import java.util.Scanner;

public class Firefly {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);	
		boolean run = true;
		int firefly = 1;
				
		while (run) {
			String line = sc.nextLine();
			String[] split = line.split("\\s+");
			
			if ((split.length == 3) && (Integer.parseInt(split[0]) == 0)) {
				run = false;
			} else {
				
			}
		}
	}
}