import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node {
		int num, cnt;
		public Node(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		boolean[] visited = new boolean[1000000001];
		Queue<Node> queue = new LinkedList<>();
		
		visited[A] = true;
		queue.add(new Node(A, 1));
		
		while (!queue.isEmpty()) {
			
			Node nowNode = queue.poll();
			
			int newInt2 = 2*nowNode.num;
			if (newInt2 < B && !visited[newInt2]) {
				visited[newInt2] = true;
				queue.add(new Node(newInt2, nowNode.cnt+1));
			} else if (newInt2 == B) {
				System.out.println(nowNode.cnt+1);
				System.exit(0);
			}
			
			if (nowNode.num < Integer.MAX_VALUE/10) {
				int newInt1 = Integer.parseInt(nowNode.num+"1");
				if (newInt1 < B && !visited[newInt1]) {
					visited[newInt1] = true;
					queue.add(new Node(newInt1, nowNode.cnt+1));
				} else if (newInt1 == B) {
					System.out.println(nowNode.cnt+1);
					System.exit(0);
				}
			}
			
		}
		
		System.out.println(-1);
		
		sc.close();
	}
}