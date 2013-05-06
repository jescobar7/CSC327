import java.io.*;
import java.util.Scanner;

public class Flow {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int maxWidth = 0;
		int currentWidth = 0;
		int currentHeight = 0;
		int oldWidth = 0;
		int oldHeight = 0;
			
		while (true) {
			String[] line = sc.nextLine().split(" ");
			int len = line.length;
			if (len == 1) {
				maxWidth = Integer.parseInt(line[0]);
				System.out.println();
				System.out.println("MAX_WIDTH: "+maxWidth); // PRINT STATEMENT
				if (maxWidth == 0) {
					break;
				}
			}
			else if (len == 2) {
				int width = Integer.parseInt(line[0]);
				int height = Integer.parseInt(line[1]);
				System.out.println("WIDTH: "+width+" | HEIGHT: "+height); // PRINT STATEMENT
				
				if (width == -1 && height == -1) {
					System.out.println(currentWidth+" x "+currentHeight); // PRINT STATEMENT
					maxWidth = 0;
					currentWidth = 0;
					currentHeight = 0;
					oldWidth = 0;
					oldHeight = 0;
				}
				else if ((currentWidth + width) <= maxWidth) {
					currentWidth += width;
					if (currentHeight < height) {
						currentHeight = height;
					}
					System.out.println("NEW_WIDTH: "+currentWidth+" | NEW_HEIGHT: "+currentHeight); // PRINT STATEMENT
					System.out.println("--OLD_HEIGHT: "+oldHeight);
				}
				else if((currentWidth + width) > maxWidth) {
					oldWidth = currentWidth;
					oldHeight = currentHeight;
					//currentHeight = 0;
					if (currentWidth < width) {
						currentWidth = width;
					}
					if (currentHeight < height) {
						currentHeight += height;
					} else {
						System.out.println("C: "+currentHeight);
						System.out.println("O: "+oldHeight);
						System.out.println("H: "+height);
						//oldHeight = height;
					}
					System.out.println("NEW_WIDTH: "+currentWidth+" | NEW_HEIGHT: "+oldHeight); // PRINT STATEMENT
					System.out.println("--OLD_HEIGHT: "+oldHeight);
				}
			}
		}
	}
}