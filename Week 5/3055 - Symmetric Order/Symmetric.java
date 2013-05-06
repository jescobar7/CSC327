import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Symmetric {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int set = 0;
		int numberOfNames = 0;
		int index = 0;
		ArrayList<String> names = new ArrayList<String>();
		
		while (true) {
			String line = sc.nextLine();
			try {
				numberOfNames = Integer.parseInt(line);
				if (numberOfNames == 0) {
					System.out.println("SET "+set);
					for (int i = 0; i < names.size(); i++) {
						System.out.println(names.get(i));
					}
					break;
				}
				else {
					if (set != 0) {
						System.out.println("SET "+set);
						for (int i = 0; i < names.size(); i++) {
							System.out.println(names.get(i));
						}
					}
					set++;
					index = 0;
					names = new ArrayList<String>();
				}
			} catch (NumberFormatException e) {
				index = names.size();
				if (index == 0) {
					names.add(index, line);
				}
				else if (index == 1) {
					names.add(index, line);
				}
				else {
					double tmpIndex = names.size();
					tmpIndex = tmpIndex/2;
					tmpIndex = Math.ceil(tmpIndex);
					index = (int)tmpIndex;
					names.add(index,line);
				}
			}
		}
	}
}