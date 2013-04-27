import java.io.*;
import java.util.Scanner;

public class Pachinko {
	private static boolean ROLLING = true;
	private static boolean DROPPED = false;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);	
		boolean run = true;
		int result = 0;
		int avg = 0;
		char ch = ' ';
		
		while (run) {
			String line = sc.nextLine();
			char[] cArray = line.toCharArray();
			avg = cArray.length;

			for (int i = 0; i < cArray.length; i++) {
				ch = cArray[0];
				if (cArray[0] == '#') {
					run = false;
					break;
				}
				switch (cArray[i]) {
					case '/':
						result = leftMountain(cArray, i, DROPPED);
						break;
					case '\\':
						result = rightMountain(cArray, i, DROPPED);
						break;
					case '.':
						result = hole(cArray, i);
						break;
					case '|':
						result = wall(cArray, i, DROPPED);
						break;
					case '_':
						result = floor(cArray, i, DROPPED);
						break;
					default:
						break;
				}
			}
			if (ch != '#') {
				System.out.println("RESULT: "+result+" | AVERAGE: "+avg);
				System.out.println(result/avg);
			}
			result = 0;
		}
	}
	
	public static int leftMountain(char[] cArray, int i, boolean action) {
		int prob = 0;
		if ((i-1) < 0) {
			return 100;
		}
		if (action) {
			return 0;
		}
		else {
			switch (cArray[i-1]) {
				case '.':
					return hole(cArray, i-1);
				case '_':
					return floor(cArray, i-1, ROLLING);
				default:
					break;
			}
		}
		return prob;
	}
	
	public static int rightMountain(char[] cArray, int i, boolean action) {
		int prob = 0;
		if ((i+1) > cArray.length) {
			return 100;
		}
		if (action) {
			return 0;
		}
		else {
			switch (cArray[i+1]) {
				case '.':
					return hole(cArray, i+1);
				case '_':
					return floor(cArray, i+1, ROLLING);
				default:
					break;
			}
		}
		return prob;
	}
	
	public static int hole(char[] cArray, int i) {
		return 100;
	}
	
	public static int wall(char[] cArray, int i, boolean action) {
		int prob = 0;
		if (action) {
			return 0;
		}
		else {
			if ((i-1) > 0) {
				switch (cArray[i-1]) {
					case '.':
						prob = hole(cArray, i-1);
					case '_':
						prob = floor(cArray, i-1, ROLLING)/2;
					default:
						break;
				}
			}
			if ((i+1) < cArray.length) {
				switch (cArray[i+1]) {
					case '.':
						prob = hole(cArray, i+1);
					case '_':
						prob = floor(cArray, i+1, ROLLING)/2;
					default:
						break;
				}
			}
		}
		return prob;
	}
	
	public static int floor(char[] cArray, int i, boolean action) {
		int prob = 0;
		if (action) {
			if (cArray[i-1] < 0) {
				return 100;
			}
			else if (cArray[i+1] > cArray.length) {
				return 100;
			}
			else if (cArray[i-1] >= 0){
				switch (cArray[i-1]) {
					case '.':
						prob =  hole(cArray, i-1);
						break;
					case '_':
						prob = floor(cArray, i-1, ROLLING);
						break;
					case '|':
						break;
					case '\\':
						break;
					case '/':
						break;
					default:
						break;
				}
			}
			else if (cArray[i+1] <= cArray.length){
				switch (cArray[i+1]) {
					case '.':
						prob = hole(cArray, i+1);
					case '_':
						prob = floor(cArray, i+1, ROLLING);
					case '|':
						break;
					case '\\':
						break;
					case '/':
						break;
					default:
						break;
				}
			}
			return prob;
		}
		else {
			return 0;
		}
	}
}