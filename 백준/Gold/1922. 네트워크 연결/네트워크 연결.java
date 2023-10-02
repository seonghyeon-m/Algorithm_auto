import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Node implements Comparable<Node> {
	int a, b, cost;
	
	Node(int a, int b, int cost) {
		this.a = a;
		this.b = b;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node o) {
		return cost - o.cost;
	}
}

public class Main {

	static int N, M;
	static int[] parents;
	static ArrayList<Node> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 컴퓨터의 수
		M = sc.nextInt(); // 연결할 수 있는 선의 수
		list = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt(); // a 컴퓨터와
			int b = sc.nextInt(); // b 컴퓨터를
			int cost = sc.nextInt(); // 연결하는데 드는 비용

			list.add(new Node(a, b, cost));
		}
		
		parents = new int[N+1];
		for (int i = 1; i <= N; i++)
			parents[i] = i;
		
		Collections.sort(list);
		
		int ans = 0;
		for (int i = 0; i < list.size(); i++) {
			Node node = list.get(i);
			
			if (find(node.a) != find(node.b)) {
				ans += node.cost;
				union(node.a, node.b);
			}
		}
		
		System.out.println(ans);

		sc.close();
	}
	
	public static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}
	
	public static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		parents[pb] = pa;
	}
}