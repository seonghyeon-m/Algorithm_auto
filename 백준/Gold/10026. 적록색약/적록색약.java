import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력 받기
		int N = sc.nextInt();
		String[][] pic = new String[N][];
		for (int n = 0; n < N; n++)
			pic[n] = sc.next().split("");

		// BFS 준비
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		int general = 0;
		int color = 0;
		boolean[][] visitedG = new boolean[N][N];
		boolean[][] visitedC = new boolean[N][N];
		Queue<Point> queueG = new LinkedList<>();
		Queue<Point> queueC = new LinkedList<>();

		// 1. 정상
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!visitedG[r][c]) {

					String nowColor = pic[r][c];
					general++;
					queueG.add(new Point(r, c));

					while (!queueG.isEmpty()) {

						Point nowPoint = queueG.poll();
						int nowR = nowPoint.r;
						int nowC = nowPoint.c;

						for (int i = 0; i < 4; i++) {

							int nr = nowR + dr[i];
							int nc = nowC + dc[i];

							if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
								if (!visitedG[nr][nc] && pic[nr][nc].equals(nowColor)) {
									visitedG[nr][nc] = true;
									queueG.add(new Point(nr, nc));
								}
							}

						}

					} // while

				} // if
			} // for c
		} // for r

		// 2. 색약
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!visitedC[r][c]) {
					
					String nowColorAdd = "";
					String nowColor = pic[r][c];
					if (nowColor.equals("R")) {
						nowColorAdd = "G";
					} else if (nowColor.equals("G")) {
						nowColorAdd = "R";
					}
					
					color++;
					queueC.add(new Point(r, c));

					while (!queueC.isEmpty()) {

						Point nowPoint = queueC.poll();
						int nowR = nowPoint.r;
						int nowC = nowPoint.c;

						for (int i = 0; i < 4; i++) {

							int nr = nowR + dr[i];
							int nc = nowC + dc[i];

							if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
								if (!visitedC[nr][nc] && pic[nr][nc].equals(nowColor)) {
									visitedC[nr][nc] = true;
									queueC.add(new Point(nr, nc));
								} else if (!visitedC[nr][nc] && !nowColorAdd.equals("") && pic[nr][nc].equals(nowColorAdd)) {
									visitedC[nr][nc] = true;
									queueC.add(new Point(nr, nc));
								}
							}

						}

					} // while

				} // if
			} // for c
		} // for r

		System.out.println(general+" "+color);

		sc.close();
	}
}