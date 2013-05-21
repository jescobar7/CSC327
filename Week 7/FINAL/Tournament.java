import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Tournament {
	static ArrayList<String> brackets = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String[] line;
		boolean number = false;
		int tournaments = 0;
		int tournament = 0;
		int len;
		
		while (true) {
			line = sc.nextLine().split(" ");
			
			try{
				tournaments = Integer.parseInt(line[0]);
				number = true;
				if (brackets.size() > 0) {
					tournament++;
					System.out.println("Tournament "+tournament);
					bTree(tournaments);
				}
			}
			catch (Exception e) {
			}
			if (tournaments == -1) {
				break;
			} else {
				len = line.length;
				if (len == 1) {
					if (number) {
						brackets = new ArrayList<String>(tournaments);
					} else {
						brackets.add(line[0]);
					}
				}
				else if (len == 2) {
					String game = line[0]+" "+line[1];
					brackets.add(game);
				}
			}
			number = false;
		}
	}
	
	public static void bTree(int tournaments) {
		Node root = null;
		Node tmpRoot = root;
		int id = 0;
		
		for (int i = 0; i < brackets.size(); i++) {
			System.out.println(t);
			int tmp = brackets.size()-(i+1);
			id++;
			String[] line = brackets.get(tmp).split(" ");
			
			if (line.length == 1) {
				root = new Node(id,line[0]);
			}
			else if (line.length == 2) {
				tmpRoot = new Node(id, line[0]);
				root.setLeftChild(tmpRoot);
				id++;
				tmpRoot = new Node(id, line[1]);
				root.setRightChild(tmpRoot);
				
				// while (!(root.getLeftChild() == null)) {
					
				// }
				// while (!(root.getRightChild() == null)) {
					
				// }
			}
		}
		printTree(root);
	}
	
	public static void printTree(Node root) {
		Node parent = root;
		Node child;
		
		//while ()
		System.out.println("Root ID: "+root.getId());
		System.out.println("Root Data: "+root.getData());
		System.out.println("Root Data Length: "+root.getLength());
		System.out.println("Root Left Child: "+root.getLeftChild().getData());
		System.out.println("Root Left Child ID: "+root.getLeftChild().getId());
		System.out.println("Root Right Child: "+root.getRightChild().getData());
		System.out.println("Root Right Child ID: "+root.getRightChild().getId());
	}
	
	public static class Node {
		int id;
		int length;
		Node left;
		Node right;
		String data;
		
		public Node() {
			id = 0;
			length = 0;
			left = null;
			right = null;
			data = null;
		}
		
		public Node(int id, String data) {
			this.id = id;
			length = data.length();
			left = null;
			right = null;
			this.data = data;
		}
		
		public int getId() {
			return id;
		}
		
		public int getLength() {
			return length;
		}
		
		public void setLeftChild(Node node) {
			left = node;
		}
		
		public void setRightChild(Node node) {
			right = node;
		}
		
		public Node getLeftChild() {
			return left;
		}
		
		public Node getRightChild() {
			return right;
		}
		
		public String getData() {
			return data;
		}
	}
}