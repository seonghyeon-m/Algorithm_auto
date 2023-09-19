import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt();
		int C = sc.nextInt();
		
		String[][] str = new String[R][];
		for (int r = 0; r < R; r++)
			str[r] = sc.next().split("");
		
		int[][] route = new int[R][C];
		for (int r = 0; r < R; r++)
			for (int c = 0; c < C; c++)
				route[r][c] = Integer.parseInt(str[r][c]);
		
		boolean[][] visited = new boolean[R][C];
		Queue<Integer> qR = new LinkedList<>();
		Queue<Integer> qC = new LinkedList<>();
		Queue<Integer> qDepth = new LinkedList<>();
		
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		
		int startR = 0;
		int startC = 0;
		visited[startR][startC] = true;
		qR.add(startR);
		qC.add(startC);
		qDepth.add(1);
		
		if (R ==1 && C == 1) {
			System.out.println(1);
			System.exit(0);
		}
		
		BFS: while (!qR.isEmpty()) {
			
			int nowR = qR.poll();
			int nowC = qC.poll();
			int depth = qDepth.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = nowR + dr[i];
				int nc = nowC + dc[i];
				
				if (nr == R-1 && nc == C-1) {
					System.out.println(depth+1);
					break BFS;
				}
				
				if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
					if (!visited[nr][nc]) {
						if (route[nr][nc] == 1) {
							qR.add(nr);
							qC.add(nc);
							qDepth.add(depth+1);
							visited[nr][nc] = true;
						}
					}
				}
				
			} //for
			
		} //while
		
		sc.close();
	}
}