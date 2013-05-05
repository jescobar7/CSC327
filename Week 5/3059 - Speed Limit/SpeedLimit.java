import java.io.*;
import java.util.Scanner;

public class SpeedLimit {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int rows = 0;
		int totalMiles = 0;
		int mph = 0;
		int timeOld = 0;
		int timeNew = 0;
		
		while (true) {
			String[] line = sc.nextLine().split(" ");
			
			if (line.length == 1) {
				if (totalMiles != 0) {
					System.out.println(totalMiles+" miles");
					totalMiles = 0;
					mph = 0;
					timeOld = 0;
					timeNew = 0;
				}
				rows = Integer.parseInt(line[0]);
				if (rows == -1) {
					break;
				}
			}
			else if (line.length == 2) {
				mph = Integer.parseInt(line[0]);
				timeNew = Integer.parseInt(line[1]);
				totalMiles += (timeNew-timeOld)*mph;
				timeOld = timeNew;
			}
		}
	}
}