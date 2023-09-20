import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static class Room {
		int l, r, c, depth;

		public Room(int l, int r, int c, int depth) {
			this.l = l;
			this.r = r;
			this.c = c;
			this.depth = depth;
		}
	}

	static String[][][] building;
	static boolean[][][] visited;
	static int[] startPoint, endPoint;
	static Queue<Room> queue;
	static int L, R, C;

	// 상하좌우전후
	static int[] dl = { -1, 1, 0, 0, 0, 0 };
	static int[] dr = { 0, 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// input 받기
		// L, R, C는 모두 1 이상 30 이하
		L = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();

		// 입력이 종료될 때까지 (0 0 0이 입력되면 종료)
		while (L != 0 && R != 0 && C != 0) {

			// #는 지나갈 수 없고 .은 지나갈 수 있고 S는 시작점 E는 출구
			building = new String[L][R][];
			for (int l = 0; l < L; l++)
				for (int r = 0; r < R; r++)
					building[l][r] = sc.next().split("");

			startPoint = new int[3];
			endPoint = new int[3];

			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					for (int k = 0; k < C; k++) {
						if (building[i][j][k].equals("S")) {
							startPoint[0] = i;
							startPoint[1] = j;
							startPoint[2] = k;
						} else if (building[i][j][k].equals("E")) {
							endPoint[0] = i;
							endPoint[1] = j;
							endPoint[2] = k;
						}
					}
				}
			}

			visited = new boolean[L][R][C];
			queue = new LinkedList<>();

			BFS(startPoint);

			L = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();

		} // while

		sc.close();
	}

	public static void BFS(int[] start) {

		visited[start[0]][start[1]][start[2]] = true;
		queue.add(new Room(start[0], start[1], start[2], 0));

		while (!queue.isEmpty()) {

			Room nowRoom = queue.poll();

			for (int i = 0; i < 6; i++) {

				int nl = nowRoom.l + dl[i];
				int nr = nowRoom.r + dr[i];
				int nc = nowRoom.c + dc[i];

				// 건물 밖으로 나가지 않으며
				if (nl >= 0 && nl < L && nr >= 0 && nr < R && nc >= 0 && nc < C) {
					// 이미 방문하지도 않았으며
					if (!visited[nl][nr][nc]) {
						// 길이 있으면
						if (building[nl][nr][nc].equals(".")) {
							visited[nl][nr][nc] = true;
							queue.add(new Room(nl, nr, nc, nowRoom.depth + 1));
							// 혹은 도착했다면
						} else if (building[nl][nr][nc].equals("E")) {
							System.out.println("Escaped in " + (nowRoom.depth + 1) + " minute(s).");
							return;
						}
					}
				}

			} // for

		} // while

		// 만약 경로가 없으면
		System.out.println("Trapped!");
		return;

	}
}