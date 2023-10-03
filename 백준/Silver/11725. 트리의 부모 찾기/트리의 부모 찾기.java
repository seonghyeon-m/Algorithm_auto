import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static int N;
	static int[] parents;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static Stack<Integer> stack = new Stack<>();
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// input 받기
		N = sc.nextInt();
		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++)
			list[i] = new ArrayList<>();
		
		for (int i = 1; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		
		visited = new boolean[N+1];
		
		// 루트노드 방문
		stack.push(1);
		visited[1] = true;
		
		// DFS
		DFS();
		
		// 출력
		for (int i = 2; i <= N; i++) {
			System.out.println(parents[i]);
		}
		
		sc.close();
	}
	
	public static void DFS() {
		while (!stack.isEmpty()) {
			int now = stack.pop();
			for (int i = 0; i < list[now].size(); i++) {
				if (!visited[list[now].get(i)]) {
					stack.push(list[now].get(i));
					visited[list[now].get(i)] = true;
					parents[list[now].get(i)] = now;
				}
			}
		}
	}
}