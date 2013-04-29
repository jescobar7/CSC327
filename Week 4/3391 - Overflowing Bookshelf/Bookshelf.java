import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Bookshelf {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String[] tokens;
		ArrayList<String> shelf = new ArrayList<String>();
		int probNum = 1;
		int shelfSize = 0;
		int currentShelf = 0;
		
		while (true) {
			tokens = sc.nextLine().split(" ");
			char c = tokens[0].charAt(0);
			int len = tokens.length;
			int bookId;
			int bookSize;
			
			if (len == 1) {
				if (c == '-') {
					break;
				}
				else if (c == 'E') {
					System.out.print("PROBLEM "+probNum+":");
					if (shelf.size() > 0) {
						String[] tmp;
						for (int i = shelf.size()-1; i >= 0; i--) {
							tmp = shelf.get(i).split(" ");
							System.out.print(" "+tmp[0]);
						}
					}
					System.out.println();
					probNum++;
					shelf = new ArrayList<String>();
					shelfSize = 0;
					currentShelf = 0;
					bookId = 0;
					bookSize = 0;
				}
				else {
					shelfSize = Integer.parseInt(tokens[0]);
				}
			}
			else if (len == 2) {
				if (c == 'R') {
					bookId = Integer.parseInt(tokens[1]);
					if (!shelf.isEmpty()) {
						for (int i = 0; i < shelf.size(); i++) {
							String[] book = shelf.get(i).split(" ");
							int bId = Integer.parseInt(book[0]);
							int bSize = Integer.parseInt(book[1]);
							if (bId == bookId) {
								shelf.remove(i);
								currentShelf -= bSize;
							}
						}
					}
				}
			}
			else if (len == 3) {
				if (c == 'A') {
					bookId = Integer.parseInt(tokens[1]);
					bookSize = Integer.parseInt(tokens[2]);
					String book = bookId+" "+bookSize;
					shelf.add(book);
					currentShelf += bookSize;
					while (currentShelf > shelfSize) {
						String[] lastBook = shelf.get(0).split(" ");
						int lastBookId = Integer.parseInt(lastBook[0]);
						int lastBookSize = Integer.parseInt(lastBook[1]);
						shelf.remove(0);
						currentShelf-=lastBookSize;
					}
				}
			}
		}
	}
}