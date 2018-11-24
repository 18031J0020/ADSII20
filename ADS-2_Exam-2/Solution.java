import java.util.Scanner;

class GraphAmazon {

	static AmazonLinkedList al[];
	static int N;

	public GraphAmazon(int N) {

		al = new AmazonLinkedList[N];
		for (int i = 0; i < N; i++) {

			al[i] = new AmazonLinkedList();

		}

	}

	public void connection(int city1, int city2, int distance) {

		al[city1].add(city2, distance);
		//al[city1].display();

	}

	static void printGraph(int N, int k) {

		System.out.println(N +" "+"Vertices" + " " + k + "edges");
		Node n = al[0].head;
		while (n.next != null) {
			n = n.next;
			System.out.println("dest is :" + n.dest + "distance is :" + n.distance);
		}
	}

}

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// N is number of cities
		int N = sc.nextInt();

		// k is number of road lines
		int k = sc.nextInt();
		sc.nextLine();
		GraphAmazon g = new GraphAmazon(N);
		// connections between city A and B and the distance d
		int A = 0, B = 0, D = 0;
		String input;
		for (int i = 0; i < k; i++) {
			/*
			 * A = sc.nextInt(); B = sc.nextInt(); D = sc.nextInt();
			 */

			input = sc.nextLine();
			String[] token = input.split(" ");
			A = Integer.parseInt(token[0]);
			B = Integer.parseInt(token[1]);
			D = Integer.parseInt(token[2]);
			// sc.nextLine();

			g.connection(A, B, D);

		}
		String graphType = sc.next();

		switch (graphType) {

		case "Graph":

			g.printGraph(N, k);
			break;

		}

	}
}


 class AmazonLinkedList {

	Node head;

	public void add(int data, int distance) {

		Node n = new Node(data, distance);

		if (head == null) {
			head = n;
		} else {
			Node n1 = head;
			while (n1.next != null) {
				n1 = n1.next;

			}
			n1.next = n;
		}
	}

	public void display() {

		Node n2 = head;
		System.out.println("dest is :" + head.dest + " " + "distance is :" + head.distance);
		while (n2.next != null) {
			n2 = n2.next;
			System.out.println("dest is: " + n2.dest + " " + "distance is :" + n2.distance);
		}

	}

}


class Node {

	int dest;
	int distance;
	Node next;

	public Node(int dest, int distance2) {
		this.dest=dest;
		distance =distance2;
		next=null;
	}

}