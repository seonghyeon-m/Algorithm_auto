import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static class Node {
		int r, c, depth;
		public Node(int r, int c, int depth) {
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
		
		int[][] tomato = new int[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				tomato[r][c] = sc.nextInt();
			}
		}
		
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		
		Queue<Node> queue = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];
		int ripe = 0;
		int empty = 0;
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (tomato[r][c] == 1) {
					queue.add(new Node(r, c, 0));
					visited[r][c] = true;
					ripe++;
				} else if (tomato[r][c] == -1) {
					empty++;
				}
			}
		}

		while (!queue.isEmpty()) {
			// BFS
			
			Node nowNode = queue.poll();
			int nowR = nowNode.r;
			int nowC = nowNode.c;
			nowDepth = nowNode.depth;
			
			for (int i = 0; i < 4; i++) {
				
				int nr = nowR + dr[i];
				int nc = nowC + dc[i];
				
				if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
					if (!visited[nr][nc]) {
						if (tomato[nr][nc] == 0) {
							queue.add(new Node(nr, nc, nowDepth+1));
							visited[nr][nc] = true;
							ripe++;
						}
					}
				}
				
				
			} //for delta탐색

		} //while
		
		if (ripe == R*C-empty)
			System.out.println(nowDepth);
		else
			System.out.println(-1);

		sc.close();
	}
}