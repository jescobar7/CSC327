import java.io.*;
import java.util.Scanner;

class Parity {
	public static void main(String[] args) throws IOException {
		Scanner sc = null;
		
		try {
			sc = new Scanner(new BufferedReader(new FileReader("input.in")));
			while (sc.hasNext()) {
				System.out.println(sc.next());
			}
		} 
		finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}