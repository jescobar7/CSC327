import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Robots {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<String> file = new ArrayList<String>();
	static int[][] field = null;
	static String line;
	static String[] strArray;
	
	public static void main(String[] args) throws IOException {
		int xMax = 0;
		int yMax = 0;
		int robots = 0;
		
		while (true) {
			line = sc.nextLine();
			strArray = line.split(" ");
			int x = Integer.parseInt(strArray[0]);
			int y = Integer.parseInt(strArray[1]);			
			if (x > xMax) {
				xMax = x;
			}
			if (y > yMax) {
				yMax = y;
			}
			if (x==-1 && y==-1) {
				break;
			}
			else if (x==0 && y==0) {
				int garbage = file.size();
				System.out.println("==TOTAL GARBAGE==: "+garbage);
				while (garbage > 0) {
					garbage = garbage - robot(xMax, yMax);
					robots++;
				}
				System.out.println("TOTAL ROBOTS: "+robots);
				xMax = 0;
				yMax = 0;
				robots = 0;
				file = new ArrayList<String>();
				field = null;
			}
			else {
				file.add(line);
			}
		}
	}
	
	public static int robot(int x, int y) {
		if (field == null) {
			field = new int[x][y];
			System.out.println("NEW FIELD!!!!");
		}
		int xMax = -1;
		int yMax = -1;
		int garbage = 0;
		
		for (int i = 0; i < file.size(); i++) {
			String[] tmp = file.get(i).split(" ");
			int x1 = Integer.parseInt(tmp[0]);
			int x2 = Integer.parseInt(tmp[1]);
			field[x1-1][x2-1] = 1;
		}
		
		System.out.println("PRINT FIELD");
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print(field[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println("ROBOT CLEANUP...");
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (field[i][j] == 1) {
					if (i>=xMax && j>=yMax) {
						xMax = i;
						yMax = j;
						field[i][j] = 0;
						garbage++;
					}
				}
			}
			System.out.println("("+xMax+","+yMax+")");
		}
		System.out.println();
		System.out.println("GARBAGE COLLECTED: "+garbage);
		
		return garbage;
	}
}