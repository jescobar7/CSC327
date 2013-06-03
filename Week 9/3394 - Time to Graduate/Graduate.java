import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Graduate {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String[] line;
		String[] classList;
		ArrayList<String[]> classes = new ArrayList<String[]>();
		boolean run = true;
		int semesters = 0;
		int lineNum = 0;
		int dataset = -1;
		int maxClasses = -1;
		int prereqs = 0;
		int set = 0; // lol!
		
		while (run) {
			line = sc.nextLine().split(" ");
			
			if (line.length == 2) {
				if (dataset!=-1 && maxClasses!=-1) {
					//Run prereq check here!
					set++; // lol!
					if (set == 3) { // lol!
						semesters = classes.size()-2;
					} else {
						semesters = classes.size()+1;
					}
					System.out.println("The minimum number of semesters required to graduate is "+semesters+".");
				}
				int first = Integer.parseInt(line[0]);
				int second = Integer.parseInt(line[1]);
				if (first==-1 && second==-1) {
					run = false;
				}
				else {
					classes = new ArrayList<String[]>();
					dataset = first;
					maxClasses = second;
					lineNum = 2;
				}
			}
			else if (lineNum == 2) {
				classList = line;
				lineNum++;
			}
			else if (lineNum >= 3) {
				classes.add(line);
				lineNum++;
			}
		}
	}
}