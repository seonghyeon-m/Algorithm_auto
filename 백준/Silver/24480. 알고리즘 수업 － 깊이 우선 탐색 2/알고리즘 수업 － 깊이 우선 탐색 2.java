import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static int N, M, V;
	static ArrayList<Integer>[] link;
	static boolean[] visited;
	static Stack<Integer> stack;
	static int now;
	static int[] order;
	
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
		
		// 정점 연결 정보 오름차순으로 정렬
		for (int i = 0; i < N; i++) Collections.sort(link[i]);
		
		visited = new boolean[N];
		stack = new Stack<>();
		stack.push(V);
		order = new int[N];
		DFS(link, stack, 0);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(order[i]+"\n");
		}
		System.out.println(sb);
		
		sc.close();
	}
	
	public static void DFS(ArrayList<Integer>[] link, Stack<Integer> stack, int cnt) {
		if (!stack.isEmpty()) now = stack.pop();
		else return;
		if (!visited[now-1]) {
			visited[now-1] = true;
			order[now-1] = ++cnt;
			for (int i = 0; i < link[now-1].size(); i++) {
				// 현재 정점의 인접 노드 중 방문하지 않은 노드를 stack에 모두 추가
				if (!visited[link[now-1].get(i)-1]) {
					stack.push(link[now-1].get(i));
				}
			}
		}
		DFS(link, stack, cnt);
	}
}