import java.util.ArrayList;
import java.util.Scanner;

class Node {
	int a, c;

	Node(int a, int c) {
		this.a = a;
		this.c = c;
	}
}

public class Main {

	static final int INF = 1999999999;
	static boolean[] visited;
	static int[] dist, answer;
	static int N, M, X;
	static ArrayList<Node>[] list;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 학생 수(=마을 수)
		M = sc.nextInt(); // 도로 수
		X = sc.nextInt(); // X번 마을에 모여서 파티를 벌이기로 했다

		// 인접 리스트 생성
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt(); // 출발
			int b = sc.nextInt(); // 도착
			int c = sc.nextInt();

			list[a].add(new Node(b, c));
		}
		
		answer = new int[N+1];
		// 다익스트라
		for (int i = 1; i <= N; i++) {
			if (i == X) {
				dijkstra(i);
				for (int j = 0; j < answer.length; j++) {
					answer[j] +=dist[j];
				}
			} else {
				dijkstra(i);
				answer[i] +=dist[X];
			}
		}
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			if (answer[i] > max)
				max = answer[i];
		}
		System.out.println(max);

		sc.close();
	}

	public static void dijkstra(int start) {

		dist = new int[N + 1];
		for (int i = 0; i < dist.length; i++) {
			dist[i] = INF;
		}

		dist[start] = 0;
		visited = new boolean[N + 1];

		for (int x = 1; x <= N; x++) {

			int min = INF;
			int minIdx = -1;

			for (int i = 1; i <= N; i++) {
				if (!visited[i] && min > dist[i]) {
					min = dist[i];
					minIdx = i;
				}
			}

			if (minIdx == -1)
				break;

			visited[minIdx] = true;

			for (int i = 0; i < list[minIdx].size(); i++) {
				Node node = list[minIdx].get(i);

				if (dist[node.a] > dist[minIdx] + node.c) {
					dist[node.a] = dist[minIdx] + node.c;
				}
			}

		}

	}
}