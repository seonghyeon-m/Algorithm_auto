import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static int N, M, V;
	static ArrayList<Integer>[] link;
	static boolean[] visited;
	static Stack<Integer> stack;
	static Queue<Integer> queue;
	static int[] push;
	static int[] add;
	static int now;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 정점의 수
		M = sc.nextInt(); // 간선의 수
		V = sc.nextInt(); // 시작 정점
		
		link = new ArrayList[N];
		for (int i = 0; i < N; i++) link[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			link[a-1].add(b);
			link[b-1].add(a);
		}
		
		// 정점 연결 정보 내림차순으로 정렬
		for (int i = 0; i < N; i++) Collections.sort(link[i], Collections.reverseOrder());
		
		visited = new boolean[N];
		stack = new Stack<>();
		push = new int[N];
		stack.push(V);
		push[V-1] = -1;
		DFS(link, stack, 0);
		
		System.out.println();
		
		// 정점 연결 정보 오름차순으로 정렬
		for (int i = 0; i < N; i++) Collections.sort(link[i]);
		
		
		visited = new boolean[N];
		queue = new LinkedList<>();
		add = new int[N];
		queue.add(V);
		add[V-1] = -1;
		BFS(link, queue, 0);
		
		sc.close();
	}
	
	public static void DFS(ArrayList<Integer>[] link, Stack<Integer> stack, int cnt) {
		if (!stack.isEmpty()) now = stack.pop();
		else return;
		if (!visited[now-1]) {
			visited[now-1] = true;
			System.out.print(now);
			cnt++;
			if (cnt == N) return;
			System.out.print(" ");
			for (int i = 0; i < link[now-1].size(); i++) {
				// 현재 정점의 인접 노드 중 방문하지 않은 노드를 stack에 모두 추가
				if (!visited[link[now-1].get(i)-1]) {
					stack.push(link[now-1].get(i));
				}
			}
		}
		DFS(link, stack, cnt);
	}
	
	public static void BFS(ArrayList<Integer>[] link, Queue<Integer> queue, int cnt) {
		while (!queue.isEmpty()) {
			now = queue.poll();
			visited[now-1] = true;
			System.out.print(now);
			cnt++;
			if (cnt == N) return;
			System.out.print(" ");
			for (int i = 0; i < link[now-1].size(); i++) {
				// 현재 정점의 인접 노드 중 방문하지 않은 노드를 queue에 모두 추가
				if (!visited[link[now-1].get(i)-1] && add[link[now-1].get(i)-1] == 0) {
					queue.add(link[now-1].get(i));
					add[link[now-1].get(i)-1] = -1;
				}
			}
		}
	}
}