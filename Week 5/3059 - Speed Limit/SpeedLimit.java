import java.io.*;
import java.util.Scanner;

public class SpeedLimit {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			String[] line = sc.nextLine().split(" ");
			int miles = -1;
			int rows = -1;
			int mphOld = -1;
			int timeOld = -1;
			int mphNew = -1;
			int timeNew = -1;
			
			if (line.length == 1) {
				rows = Integer.parseInt(line[0]);
				if (rows == -1) {
					break;
				}
			}
			else if (line.length == 2) {
				if (mphOld == 0) {
				}
			}
			
			if (miles != -1)
				System.out.println(miles+" miles");
		}
	}
}