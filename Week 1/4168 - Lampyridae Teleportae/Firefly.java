import java.io.*;
import java.util.Scanner;

public class Firefly {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);	
		boolean run = true;
		int firefly = 1;
		int fX = 0;
		int fY = 0;
		int sT = 0;
		int sX = 0;
		int sY = 0;
				
		while (run) {
			String line = sc.nextLine();
			String[] split = line.split("\\s+");
			
			int splitLen = split.length;
			if ((splitLen == 3) && (Integer.parseInt(split[0]) == 0)) {
				run = false;
			} else {
				if (splitLen == 3) {
					sT = Integer.parseInt(split[0]);
					sX = Integer.parseInt(split[1]);
					sY = Integer.parseInt(split[2]);
					System.out.println(sT + " " + sX + " " + sY);
				} else if (splitLen == 2) {
					fX = Integer.parseInt(split[0]);
					fY = Integer.parseInt(split[1]);
					System.out.println(fX + " " + fY);
				}
				
				// if ((fX == -1) && (fY == -1)) {
					// System.out.println("Firefly " + firefly + " not caught");
					// firefly++;
				// }
			}
		}
	}
}