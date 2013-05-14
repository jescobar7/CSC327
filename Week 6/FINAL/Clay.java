import java.io.*;
import java.util.Scanner;

public class Clay {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String[] line;
		int len;
		int numOfStudents;
		int length;
		int width;
		int height;
		String name;
		
		String nameBully = "";
		String nameVictim = "";
		int blockBully = 0;
		int blockVictim = 0;
		
		while (true) {
			line = sc.nextLine().split(" ");
			len = line.length;
			
			if (len == 1) {
				if (blockBully != 0 && blockVictim != 0) {
					System.out.println(nameBully+" took clay from "+nameVictim+".");
				}
				numOfStudents = Integer.parseInt(line[0]);
				nameBully = "";
				nameVictim = "";
				blockBully = 0;
				blockVictim = 0;
				if (numOfStudents == -1) {
					break;
				}
			}
			else if (len == 4) {
				length = Integer.parseInt(line[0]);
				width = Integer.parseInt(line[1]);
				height = Integer.parseInt(line[2]);
				name = line[3];	
				int block = length*width*height;
				
				if (blockBully == 0 && blockVictim == 0) {
					nameBully = name;
					blockBully = block;
					nameVictim = name;
					blockVictim = block;
				}
				else if (blockVictim > block) {
					blockVictim = block;
					nameVictim = name;
				}
				else if (blockBully < block) {
					blockBully = block;
					nameBully = name;
				}
			}
		}
	}
	
	
}