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
	
	static int[] parents;
	static ArrayList<Node> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt(); // 집의 수
		int N = sc.nextInt(); // 길의 수
		
		while (M != 0 && N != 00) {
			
			parents = new int[M];
			for (int i = 0; i < M; i++)
				parents[i] = i;
			list = new ArrayList<>();
			
			int before = 0;
			
			for (int n = 0; n < N; n++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int cost = sc.nextInt();
				
				before +=cost;
				
				list.add(new Node(a, b, cost));
			}
			
			Collections.sort(list);
			
			int ans = 0;
			for (int i = 0; i < list.size(); i++) {
				
				Node node = list.get(i);
				
				if (find(node.a) != find(node.b)) {
					ans +=node.cost;
					union(node.a, node.b);
				}
				
			}
			
			System.out.println(before-ans);

			// 다음 숫자 받아서 확인하기
			M = sc.nextInt();
			N = sc.nextInt();
			
		} // testCase 반복
		
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