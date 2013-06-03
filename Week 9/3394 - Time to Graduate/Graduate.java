import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Graduate {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String[] line;
		ArrayList<String> required = new ArrayList<String>();
		ArrayList<String[]> prereqs = new ArrayList<String[]>();
		ArrayList<String> taken = new ArrayList<String>();
		boolean run = true;
		int semesters = 0;
		int lineNum = 0;
		int numOfClasses = 0;
		int maxClassSem = 0;
		int prereqNum = 0;
		
		while (run) {
			line = sc.nextLine().split(" ");
			
			if (line.length == 2) {
				if (numOfClasses!=0 && maxClassSem!=0) {
					//Run prereq check here!
					
					//**** START PRINT INFO
					System.out.print("\nRequired: ");
					for (int i=0; i < required.size(); i++) {
						System.out.print(required.get(i)+" ");
					}
					System.out.println();
					
					System.out.println("Class Info: ");
					for (int i=0; i < required.size(); i++) {
						String[] data = prereqs.get(i);
						System.out.println("\tClass   : "+data[0]);
						System.out.println("\tOffered : "+data[1]);
						prereqNum = Integer.parseInt(data[2]);
						System.out.print("\tPrereqs : "+prereqNum);
						if (prereqNum > 0) {
							System.out.print(" - ");
							for (int j=3; j < data.length; j++) {
								System.out.print(data[j]+" ");
							}
						}
						System.out.println();
					}
					
					System.out.print("Taken: ");
					for (int i=0; i < taken.size(); i++) {
						System.out.print(taken.get(i)+" ");
					}
					System.out.println("\n");
					//**** END PRINT INFO
					
					System.out.println("The minimum number of semesters required to graduate is "+semesters+".");
				}
				int first = Integer.parseInt(line[0]);
				int second = Integer.parseInt(line[1]);
				if (first==-1 && second==-1) {
					run = false;
				}
				else {
					required = new ArrayList<String>();
					prereqs = new ArrayList<String[]>();
					taken = new ArrayList<String>();
					numOfClasses = first;
					maxClassSem = second;
					lineNum = 2;
				}
			}
			else if (lineNum == 2) {
				for (int i=0; i < line.length; i++) {
					required.add(line[i]);
				}
				lineNum++;
			}
			else if (lineNum >= 3) {
				prereqs.add(line);
				lineNum++;
			}
		}
	}
}