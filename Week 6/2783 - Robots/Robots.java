import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Robots {
	static Scanner sc = new Scanner(System.in);
	static int[][] field;// = new int[23][23];
	static int x;
	static int y;
	static String[] line;
	static boolean check = true;
	static ArrayList<String> tmpArray = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException {
		int xMax = 0;
		int yMax = 0;
		
		while (true) {
			line = sc.nextLine().split(" ");
			x = Integer.parseInt(line[0]);
			y = Integer.parseInt(line[1]);
			if (x > xMax) {
				x = xMax;
			}
			if (y > yMax) {
				y = yMax;
			}
			if (x==-1 && y==-1) {
				break;
			}
			else if (x==0 && y==0) {
				run();
				System.out.println("===");
				tmpArray = new ArrayList<String>();
				xMax = 0;
				yMax = 0;
			}
			else {
				String coordinate = line[0]+" "+line[1];
				tmpArray.add(coordinate); 
			}
		}
	}
	
	public static void run(int xMax, int yMax) {
		for (int i = 0; i < tmpArray.size(); i++) {
			String cord = tmpArray.get(i);
			
		}
		System.out.println(xMax+" "+yMax);
	}
	
	// public static void grid() {
		// line = sc.nextLine().split(" ");
		// x = Integer.parseInt(line[0]);
		// y = Integer.parseInt(line[1]);
		// if (x==-1 && y==-1) {
			// break;
		// }
		// else if (x==0 && y==0) {
			// for (int i = 0; i < field.length; i++) {
				// for (int j = 0; j < field.length; j++) {
					// System.out.print(field[i][j]+" ");
				// }
				// System.out.println();
			// }
			// field = new int[23][23];
		// }
		// else {
			// field[x][y] = 9;
		// }		
	// }
}