import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static boolean[] visited;
	static ArrayList<Integer>[] link;
	static Queue<Integer> queue = new LinkedList<>();
	static int cnt = 1;
	static int deep = 0;
	static int[] order;
	static int[] depth;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 정점의 수
		int M = sc.nextInt(); // 간선의 수
		int R = sc.nextInt()-1; // 시작 정점
		
		link = new ArrayList[N];
		for (int i = 0; i < N; i++) link[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			link[a].add(b);
			link[b].add(a);
		}
		for (int i = 0; i < N; i++) Collections.sort(link[i]);
		
		visited = new boolean[N];
		order = new int[N];
		depth = new int[N];
		BFS(R);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) sb.append(order[i]).append("\n");
		System.out.println(sb);
		
		sc.close();
	}
	
	public static void BFS(int now) {
		queue.add(now);
		
		while (queue.size() != 0) {
			
			int queueSize = queue.size();
			for (int i = 0; i < queueSize; i++) {
				int curr = queue.poll();
				if (visited[curr]) continue;
				visited[curr] = true;
				
				order[curr] = cnt++;
				depth[curr] = deep;
				
				for (int near : link[curr])
					queue.add(near);
			}
			
			deep ++;
		}
			
	}
}