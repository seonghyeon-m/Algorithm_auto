import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static class Node {
		int x, d;
		public Node(int x, int d) {
			this.x = x;
			this.d = d;
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int N, M, R;
	static List<List<Node>> list;
	static int[] dist; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 지역의 개수
		M = sc.nextInt(); // 수색범위
		R = sc.nextInt(); // 길의 개수
		
		// 마을에 있는 아이템 수
		int[] item = new int[N];
		for (int i = 0; i < N; i++) item[i] = sc.nextInt();
		
		// 인접리스트
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < R; i++) {
			int A = sc.nextInt()-1;
			int B = sc.nextInt()-1;
			int C = sc.nextInt();
			list.get(A).add(new Node(B, C));
			list.get(B).add(new Node(A, C));
		}
		
		// 거리 배열
		dist = new int[N];
		
		int answer = 0;
		for (int tc = 0; tc < N; tc++) {
			// 초기화
			Arrays.fill(dist, INF);
			int getItem = 0;

			// 거리 계산
			dijkstra(tc);
			
			// 아이템 줍기
			for (int i = 0; i < N; i++) {
				if (dist[i] <= M) {
					getItem +=item[i];
				}
			}

			// 최대 아이템 수 찾기
			if (getItem > answer)
				answer = getItem;
		}
		
		System.out.println(answer);
		
		sc.close();
	}
	
	public static void dijkstra(int start) {
		boolean[] visited = new boolean[N];
		
		dist[start] = 0;
		
		for (int i = 0; i < N-1; i++) {
			int min = INF;
			int idx = -1;
			
			for (int j = 0; j < N; j++) {
				if (!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			if (idx == -1) break;
			
			visited[idx] = true;

			for (int j = 0; j < list.get(idx).size(); j++) {
				Node now = list.get(idx).get(j);
				
				if (!visited[now.x] && dist[now.x] > dist[idx]+now.d) {
					dist[now.x] = dist[idx]+now.d; 
				}
			}
		}
	}
}