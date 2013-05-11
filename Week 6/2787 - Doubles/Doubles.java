import java.io.*;
import java.util.Scanner;

public class Doubles {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String[] line;
		int count = 0;
		
		while (true) {
			count = 0;
			line = sc.nextLine().split(" ");
			
			if (line.length == 1) {
				if (Integer.parseInt(line[0]) == -1) {
					break;
				}
			}
			else {
				for (int i = 0; i < line.length; i++) {
					double ii = Integer.parseInt(line[i]);
					for (int j = 0; j < line.length; j++) {
						double jj = Integer.parseInt(line[j]);
						if (ii > 0) {
							if ((jj/ii)==2) {
								count++;
							}
						}
					}
				}
			}
			System.out.println(count);
		}
	}
}