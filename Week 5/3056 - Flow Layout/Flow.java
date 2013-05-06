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
		boolean add = false;
			
		while (true) {
			String[] line = sc.nextLine().split(" ");
			int len = line.length;
			if (len == 1) {
				maxWidth = Integer.parseInt(line[0]);
				if (maxWidth == 0) {
					break;
				}
			}
			else if (len == 2) {
				int width = Integer.parseInt(line[0]);
				int height = Integer.parseInt(line[1]);
				
				if (width == -1 && height == -1) {
					if (add) {
						currentHeight+=oldHeight;
						add = false;
					}
					System.out.println(currentWidth+" x "+currentHeight);
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
				}
				else if((currentWidth + width) > maxWidth) {
					oldWidth = currentWidth;
					oldHeight = currentHeight;
					if (currentWidth < width) {
						currentWidth = width;
					}
					if (currentHeight < height) {
						currentHeight += height;
					} else {
						add = true;
						oldHeight = height;
					}
				}
			}
		}
	}
}