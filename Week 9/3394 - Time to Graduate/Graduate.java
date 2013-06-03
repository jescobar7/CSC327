import java.io.*;
import java.util.Scanner;

public class Graduate {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String[] line;
		boolean run = true;
		int lineNum = 0;
		int dataset = 0;
		int maxClasses = 0;
		int prereqs = 0;
		
		while (run) {
			line = sc.nextLine().split(" ");
			
			if (line.length == 2) {
				System.out.println("Data Numbers");
				int first = Integer.parseInt(line[0]);
				int second = Integer.parseInt(line[1]);
				if (first==-1 && second==-1) {
					System.out.println("END");
					run = false;
				}
				else {
					dataset = first;
					maxClasses = second;
					lineNum = 2;
				}
			}
			else if (lineNum == 2) {
				System.out.println("Class List");
				lineNum++;
			}
			else if (lineNum >= 3) {
				System.out.println("Class "+(lineNum-2));
				lineNum++;
			}
		}
	}
}

/**
	4 6
	cs123 mt42 cs456 cs789
	mt42 F 0
	cs123 S 0
	cs456 S 2 cs123 mt42
	cs789 B 1 cs456
	
	3 6
	math1 comp2 comp3
	comp3 S 1 comp2
	math1 S 0
	comp2 F 1 math1
	
	4 3
	m10 m20 c33 c44
	m10 B 0
	m20 B 0
	c33 B 0
	c44 B 0
	
	-1 -1
*/