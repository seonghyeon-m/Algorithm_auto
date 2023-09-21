import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	static class Node {
		int ed, w;

		public Node(int ed, int w) {
			this.ed = ed;
			this.w = w;
		}
	}

	static final long INF = Long.MAX_VALUE;
	static int N, M;
	static List<Node>[] list;
	static long[] price;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		
		int S = sc.nextInt() - 1;

		list = new ArrayList[N];
		for (int n = 0; n < N; n++) {
			list[n] = new ArrayList<>();
		}
		price = new long[N];
		Arrays.fill(price, INF);

		// 간선 정보 입력 (인접 리스트)
		for (int m = 0; m < M; m++) {
			int A = sc.nextInt() - 1;
			int B = sc.nextInt() - 1;
			int W = sc.nextInt();

			list[A].add(new Node(B, W));
		}

		dijkstra(S);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if (price[i] == INF) sb.append("INF"+"\n");
			else sb.append(price[i]+"\n");
		}
		System.out.println(sb);

		sc.close();
	}

	static void dijkstra(int start) {
		boolean[] visited = new boolean[N];

		price[start] = 0;

		for (int i = 0; i < N; i++) {
			long min = INF;
			int idx = -1;

			for (int j = 0; j < N; j++) {
				if (!visited[j] && min > price[j]) {
					min = price[j];
					idx = j;
				}
			}
			if (idx == -1)
				break;

			visited[idx] = true;
			
			for (int j = 0; j < list[idx].size(); j++) {
				Node curr = list[idx].get(j);

				if (!visited[curr.ed] && price[curr.ed] > price[idx] + curr.w) {
					price[curr.ed] = price[idx] + curr.w;
				}
			}

		} // for i
	}
}