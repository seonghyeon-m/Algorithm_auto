import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static class Place {
		int r, c;
		public Place(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int R = sc.nextInt();
		int C = sc.nextInt();

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		
		String[][] school = new String[R][];
		for (int r = 0; r < R; r++)
			school[r] = sc.next().split("");
		
		Queue<Place> queue = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (school[r][c].equals("I")) {
					queue.add(new Place(r, c));
					visited[r][c] = true;
				}
			}
		}
		
		int cnt = 0; // 만나는 사람 수
		
		while (!queue.isEmpty()) {
			
			Place nowPlace = queue.poll();
			int nowR = nowPlace.r;
			int nowC = nowPlace.c;
			
			for (int i = 0; i < 4; i++) {
				
				int nr = nowR + dr[i];
				int nc = nowC + dc[i];
				
				if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
					if (!visited[nr][nc]) {
						if (school[nr][nc].equals("O") || school[nr][nc].equals("P")) {
							queue.add(new Place(nr, nc));
							visited[nr][nc] = true;
							if (school[nr][nc].equals("P")) {
								cnt++;
							}
						}
					}
				}
				
			}
			
		} //while
		
		if (cnt == 0)
			System.out.println("TT");
		else
			System.out.println(cnt);

		sc.close();
	}
}