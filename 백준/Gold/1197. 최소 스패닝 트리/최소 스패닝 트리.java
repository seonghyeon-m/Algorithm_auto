import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Node implements Comparable<Node> {
	int a, b, c;

	Node(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public int compareTo(Node o) {
		return c - o.c;
	}
}

public class Main {

	static ArrayList<Node> list = new ArrayList<>();
	static int[] parents;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt(); // 정점의 개수
		int E = sc.nextInt(); // 간선의 개수

		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			list.add(new Node(a, b, c));
		}
		
		Collections.sort(list);
		
		parents = new int[V+1];
		for (int i = 0; i <= V; i++)
			parents[i] = i;
		
		int ans = 0;		
		for (int i = 0; i < list.size(); i++) {
			Node now = list.get(i);
			
			if (find(now.a) != find(now.b)) {
				ans +=now.c;
				union(now.a, now.b);
			}
		}
		
		System.out.println(ans);

		sc.close();
	}
	
	public static int find(int a) {
		if (parents[a] == a)
			return a;
		else return find(parents[a]);
	}
	
	public static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		parents[pb] = pa;
	}
}