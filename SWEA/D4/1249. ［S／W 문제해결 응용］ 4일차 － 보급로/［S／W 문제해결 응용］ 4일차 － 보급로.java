import java.util.Scanner;

public class Solution {

	static class Node {
		int ed, w;

		public Node(int v, int w) {
			this.ed = v;
			this.ed = w;
		}
	}

	static final int INF = Integer.MAX_VALUE;
	static int N; // 지도의 크기
	static int[][] depth, time; // depth는 구덩이 깊이, time은 거기까지 걸린 시간
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {

			// input받기
			N = sc.nextInt();
			String[][] temp = new String[N][];
			depth = new int[N][N];
			for (int i = 0; i < N; i++)
				temp[i] = sc.next().split("");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					depth[i][j] = Integer.parseInt(temp[i][j]);
				}
			}

			// 걸리는 시간 저장할 배열
			time = new int[N][N];
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					time[i][j] = INF;

			dijkstra();
			System.out.println("#" + testCase + " " + time[N - 1][N - 1]);

		}

		sc.close();
	}

	static void dijkstra() {
		boolean[][] visited = new boolean[N][N];

		time[0][0] = 0;

		for (int i = 0; i < N * N; i++) {
			int min = INF;
			int xIdx = -1;
			int yIdx = -1;

			for (int p = 0; p < N; p++) {
				for (int q = 0; q < N; q++) {
					if (!visited[p][q] && min > time[p][q]) {
						min = time[p][q];
						xIdx = p;
						yIdx = q;
					}
				}
			}

			if (xIdx == -1)
				break;

			visited[xIdx][yIdx] = true;

			for (int d = 0; d < 4; d++) {
				int nx = xIdx + dr[d];
				int ny = yIdx + dc[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (!visited[nx][ny] && time[nx][ny] > time[xIdx][yIdx] + depth[nx][ny]) {
						time[nx][ny] = time[xIdx][yIdx] + depth[nx][ny];
					}
				}
			}

		}

	}
}