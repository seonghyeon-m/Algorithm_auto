import java.util.Scanner;

public class Main {

	static class Shark {
		int r, c;

		public Shark(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static class Dir {
		int dr, dc;

		public Dir(int dr, int dc) {
			this.dr = dr;
			this.dc = dc;
		}
	}

	// 상 좌 하 우는 1, 3, 5, 7번째 index
	// 0번째 index는 움직이지 않음
	static Dir[] dir = { new Dir(0, 0), new Dir(0, -1), new Dir(-1, -1), new Dir(-1, 0), new Dir(-1, 1), new Dir(0, 1),
			new Dir(1, 1), new Dir(1, 0), new Dir(1, -1) };
	
	static Dir[] sharkdir = { new Dir(0, 0), new Dir(-1, 0), new Dir(0, -1), new Dir(1, 0), new Dir(0, 1) };

	static int M, S, maxEat, maxIdx, ifNoFish;
	static Shark shark;
	static int[][][] sea = new int[5][5][9];
	static int[][] sharkMove = new int[65][3];
	static int[][] smell = new int[5][5];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt(); // 물고기의 수
		S = sc.nextInt(); // 상어가 마법을 연습한 횟수

		// 물고기 받아오기
		for (int i = 0; i < M; i++)
			sea[sc.nextInt()][sc.nextInt()][sc.nextInt()]++;

		// 상어 위치 받아오기
		shark = new Shark(sc.nextInt(), sc.nextInt());

		// 상어 이동방향 만들어주기
		makeSharkMove();

		// 복제마법 쓰기
		for (int i = 0; i < S; i++) {
			Magic();
		}

		// 물고기 몇마리 남아있는지 확인하기
		int cnt = 0;
		for (int r = 1; r <= 4; r++) {
			for (int c = 1; c <= 4; c++) {
				for (int d = 1; d <= 8; d++) {
					cnt += sea[r][c][d];
				}
			}
		}

		// 출력
		System.out.println(cnt);

		sc.close();
	}

	public static void Magic() {

		// 1. 상어가 모든 물고기에게 복제 마법을 시전한다.
		int[][][] magic = sea;

		// 2. 모든 물고기가 한 칸 이동한다.
		int[][][] move = new int[5][5][9];
		for (int r = 1; r <= 4; r++) {
			for (int c = 1; c <= 4; c++) {
				for (int d = 1; d <= 8; d++) {
					if (sea[r][c][d] != 0) {
						// 물고기가 있으면 이동해준다
						int nd = d;
						int nr = r + dir[nd].dr;
						int nc = c + dir[nd].dc;
						int temp = 0;
						while (!fishRange(nr, nc) && temp < 8) {
							nd = FishTurn(nd);
							nr = r + dir[nd].dr;
							nc = c + dir[nd].dc;
							temp++;
						}
						if (temp != 8) {
							move[nr][nc][nd] += sea[r][c][d];
						} else {
							move[r][c][d] += sea[r][c][d];
						}
					}
				}
			}
		}

		// 3. 상어가 연속해서 3칸 이동한다.
		maxEat = 0;
		maxIdx = -1;
		ifNoFish = -1;
		for (int i = 1; i <= 64; i++) {
			// 초기화
			int eat = 0;
			int nr = shark.r;
			int nc = shark.c;
			boolean[][] visited = new boolean[5][5];
			// 계산
			for (int j = 0; j < 3; j++) {
				nr = nr + sharkdir[sharkMove[i][j]].dr;
				nc = nc + sharkdir[sharkMove[i][j]].dc;
				if (!sharkRange(nr, nc)) {
					eat = 0;
					break;
				}
				if (!visited[nr][nc]) {
					for (int k = 1; k <= 8; k++) {
						eat += move[nr][nc][k];
					}
					visited[nr][nc] = true;						
				}
				if (j == 2 && ifNoFish == -1) {
					ifNoFish = i;
				}
			}
			if (eat > maxEat) {
				maxEat = eat;
				maxIdx = i;
			}
		}
		if (maxIdx == -1) {
			for (int i = 0; i < 3; i++) {
				shark = new Shark(shark.r + sharkdir[sharkMove[ifNoFish][i]].dr, shark.c + sharkdir[sharkMove[ifNoFish][i]].dc);
			}
		} else {
			for (int i = 0; i < 3; i++) {
				// 만약 먹이를 먹을 수 있는 방법이 없을 때에는 그냥 사전 순으로 가장 앞선 방향으로 움직인다.
				shark = new Shark(shark.r + sharkdir[sharkMove[maxIdx][i]].dr, shark.c + sharkdir[sharkMove[maxIdx][i]].dc);
				int fish = 0;
				for (int j = 1; j <= 8; j++) {
					fish +=move[shark.r][shark.c][j];
				}
				if (fish != 0) {
					for (int j = 1; j <= 8; j++) {
						move[shark.r][shark.c][j] = 0;
					}
					smell[shark.r][shark.c] = 3; 
				}
			}
		}

		// 4. 두 번 전 연습에서 생긴 물고기의 냄새가 격자에서 사라진다.
		for (int r = 1; r <= 4; r++) {
			for (int c = 1; c <= 4; c++) {
				if (smell[r][c] > 0) {
					smell[r][c]--;
				}
			}
		}

		// 5. 1에서 사용한 복제 마법이 완료된다.
		for (int r = 1; r <= 4; r++) {
			for (int c = 1; c <= 4; c++) {
				for (int d = 1; d <= 8; d++) {
					sea[r][c][d] = move[r][c][d] + magic[r][c][d];
				}
			}
		}
		
	}

	public static void makeSharkMove() {
		int idx = 1;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				for (int k = 1; k <= 4; k++) {
					sharkMove[idx][0] = i;
					sharkMove[idx][1] = j;
					sharkMove[idx][2] = k;
					idx++;
				}
			}
		}
	}

	public static boolean fishRange(int r, int c) {
		if (r > 0 && r <= 4 && c > 0 && c <= 4) {
			if (r != shark.r || c != shark.c) {
				if (smell[r][c] == 0) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean sharkRange(int r, int c) {
		if (r > 0 && r <= 4 && c > 0 && c <= 4) {
			return true;
		}
		return false;
	}

	public static int FishTurn(int d) {
		d--;
		if (d == 0)
			return 8;
		return d;
	}
}