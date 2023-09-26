import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static class Node {
		int x, time;
		public Node(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}
	
	static Queue<Node> queue = new LinkedList<>();
	static int N, K;
	static boolean[] visited;
	static int[] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 출발
		K = sc.nextInt(); // 도착
		
		if (N > K) {			
			visited = new boolean[2*N];
			map = new int[2*N];
		}
		else {
			visited = new boolean[4*K];
			map = new int[4*K];
		}
		
		System.out.println(move(new Node(N, 0)));
		
		sc.close();
	}
	
	public static int move(Node node) {

		queue.add(new Node(N, 0));
		visited[N] = true;
		int temp = N;
		while (temp <= K && temp != 0) {
			temp *=2;
			queue.add(new Node(temp, 0));
			visited[temp] = true;
		}
		
		while (!queue.isEmpty()) {
			Node nowNode = queue.poll();
			
			if (nowNode.x == K) return nowNode.time;

			int plus = nowNode.x + 1;
			int minus = nowNode.x - 1;
			
			if (plus <= K) {
				if (!visited[plus]) {
					queue.add(new Node(plus, nowNode.time+1));
					visited[plus] = true;
				}
				while (plus < K) {
					plus *=2;
					queue.add(new Node(plus, nowNode.time+1));
					visited[plus] = true;
				}
			}
			
			if (minus >= 0) {
				if (!visited[minus]) {
					queue.add(new Node(minus, nowNode.time+1));
					visited[minus] = true;
				}
				while (minus < K && minus != 0) {
					minus *=2;
					queue.add(new Node(minus, nowNode.time+1));
					visited[minus] = true;
				}
			}
			
		}
		
		return 0;
		
	}
}