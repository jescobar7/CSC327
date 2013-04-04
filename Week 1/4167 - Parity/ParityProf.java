import java.util.Scanner;

public class ParityProf {
	
	public static void main (String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		
		while (true) {
			String line = s.nextLine();
			if(line.equals("#"))
				break;
			int parity = 0;
			for (char c: line.toCharArray()) {
				switch (c) {
					case '1':
						parity = 1-parity;
					case '0':
						System.out.print(c);
						break;
					case 'e':
						System.out.println(parity);
						break;
					case 'o':
						System.out.println(1-parity);
						break;
				}
			}
		}
	}
}