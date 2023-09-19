import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static class Node {
		int h, r, c, depth;

		public Node(int h, int r, int c, int depth) {
			this.h = h;
			this.r = r;
			this.c = c;
			this.depth = depth;
		}
	}

	static int nowDepth;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int C = sc.nextInt();
		int R = sc.nextInt();
		int H = sc.nextInt();

		int[][][] tomato = new int[H][R][C];
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					tomato[h][r][c] = sc.nextInt();
				}
			}
		}

		int[] dh = { -1, 1, 0, 0, 0, 0 };
		int[] dr = { 0, 0, -1, 1, 0, 0 };
		int[] dc = { 0, 0, 0, 0, -1, 1 };

		Queue<Node> queue = new LinkedList<>();
		boolean[][][] visited = new boolean[H][R][C];
		int ripe = 0;
		int empty = 0;
		
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (tomato[h][r][c] == 1) {
						queue.add(new Node(h, r, c, 0));
						visited[h][r][c] = true;
						ripe++;
					} else if (tomato[h][r][c] == -1) {
						empty++;
					}
				}
			}
		}
		

		while (!queue.isEmpty()) {
			// BFS

			Node nowNode = queue.poll();
			int nowH = nowNode.h;
			int nowR = nowNode.r;
			int nowC = nowNode.c;
			nowDepth = nowNode.depth;

			for (int i = 0; i < 6; i++) {
				
				int nh = nowH + dh[i];
				int nr = nowR + dr[i];
				int nc = nowC + dc[i];

				if (nh >= 0 && nh < H && nr >= 0 && nr < R && nc >= 0 && nc < C) {
					if (!visited[nh][nr][nc]) {
						if (tomato[nh][nr][nc] == 0) {
							queue.add(new Node(nh, nr, nc, nowDepth + 1));
							visited[nh][nr][nc] = true;
							ripe++;
						}
					}
				}

			} // for delta탐색

		} // while

		if (ripe == H * R * C - empty)
			System.out.println(nowDepth);
		else
			System.out.println(-1);

		sc.close();
	}
}