import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static class Shark implements Comparable<Shark> {
		int s, d, z;

		public Shark(int s, int d, int z) {
			this.s = s; // speed
			this.d = d; // direction
			this.z = z; // size
		}

		@Override
		public int compareTo(Shark o) {
			return o.z - z;
		}
	}

	// 위, 아래, 오른쪽, 왼쪽
	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, 1, -1 };
	static Shark[][] sea;
	static ArrayList<Shark>[][] list;
	static int R, C, fisher, answer;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt(); // 행
		C = sc.nextInt(); // 열, 시간
		int M = sc.nextInt(); // 상어의 수

		fisher = 0;

		// 상어를 넣어주자
		sea = new Shark[R + 1][C + 1];
		for (int i = 0; i < M; i++) {
			sea[sc.nextInt()][sc.nextInt()] = new Shark(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}

		answer = 0;
		for (int t = 1; t <= C; t++) {

			// 1. 낚시왕이 오른쪽으로 한 칸 이동한다.
			fisher++;

			// 2. 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다.
			for (int i = 1; i <= R; i++) {
				if (sea[i][t] != null) {
					answer +=sea[i][t].z;
					sea[i][t] = null;
					break;
				}
			}

			// 3. 상어가 이동한다.
			Shark[][] newSea = new Shark[R + 1][C + 1];
			list = new ArrayList[R + 1][C + 1];

			for (int r = 1; r <= R; r++) {
				for (int c = 1; c <= C; c++) {
					if (sea[r][c] != null) {
						// 상어가 있으면
						Shark shark = sea[r][c];
						if (shark.d > 2) {
							// 좌우 방향으로 이동하는 상어
							int move = shark.s % (2 * C - 2);
							int nc = c + dc[shark.d] * move;
							if (Range(r, nc)) {
								// 안삐져나갔으면 채택
								if (newSea[r][nc] == null) {
									// 다른 상어 없으면 배열에 넣어주고
									newSea[r][nc] = new Shark(shark.s, shark.d, shark.z);
								} else {
									// 다른 상어가 있으면 이제 잡아먹어야겠지?
									if (list[r][nc] == null) {
										list[r][nc] = new ArrayList<>();
										list[r][nc].add(newSea[r][nc]);
									}
									list[r][nc].add(new Shark(shark.s, shark.d, shark.z));
								}
							} else {
								// 아니면 상어 돌려주고 다시 범위 안으로 넣어준다
								int nd = shark.d;
								while (nc <= 0 || nc > C) {
									if (nc <= 0) {
										nc = -nc + 2;
										nd = Turn(nd);
									} else {
										nc = -nc + 2*C;
										nd = Turn(nd);
									}
								}
								if (newSea[r][nc] == null) {
									// 다른 상어 없으면 배열에 넣어주고
									newSea[r][nc] = new Shark(shark.s, nd, shark.z);
								} else {
									// 다른 상어가 있으면 이제 잡아먹어야겠지?
									if (list[r][nc] == null) {
										list[r][nc] = new ArrayList<>();
										list[r][nc].add(newSea[r][nc]);
									}
									list[r][nc].add(new Shark(shark.s, nd, shark.z));
								}
							}
						} else {
							// 상하 방향으로 이동하는 상어
							int move = shark.s % (2 * R - 2);
							int nr = r + dr[shark.d] * move;
							if (Range(nr, c)) {
								// 안삐져나갔으면 채택
								if (newSea[nr][c] == null) {
									// 다른 상어 없으면 배열에 넣어주고
									newSea[nr][c] = new Shark(shark.s, shark.d, shark.z);
								} else {
									// 다른 상어가 있으면 이제 잡아먹어야겠지?
									if (list[nr][c] == null) {
										list[nr][c] = new ArrayList<>();
										list[nr][c].add(newSea[nr][c]);
									}
									list[nr][c].add(new Shark(shark.s, shark.d, shark.z));
								}
							} else {
								// 아니면 상어 돌려주고 다시 범위 안으로 넣어준다
								int nd = shark.d;
								while (nr <= 0 || nr > R) {
									if (nr <= 0) {
										nr = -nr + 2;
										nd = Turn(nd);
									} else {
										nr = -nr + 2*R;
										nd = Turn(nd);
									}
								}
								if (newSea[nr][c] == null) {
									// 다른 상어 없으면 배열에 넣어주고
									newSea[nr][c] = new Shark(shark.s, nd, shark.z);
								} else {
									// 다른 상어가 있으면 이제 잡아먹어야겠지?
									if (list[nr][c] == null) {
										list[nr][c] = new ArrayList<>();
										list[nr][c].add(newSea[nr][c]);
									}
									list[nr][c].add(new Shark(shark.s, nd, shark.z));
								}
							}
						} // 좌우 or 상하
					} // if 상어가 있으면
				}
			} // 진짜 상어이동 끝

			// 겹치는거 처리해주고 누가 승리했는지 newSea에 다시 넣어준다.
			for (int r = 1; r <= R; r++) {
				for (int c = 1; c <= C; c++) {
					if (list[r][c] != null) {
						Collections.sort(list[r][c]);
						newSea[r][c] = list[r][c].get(0);
					}
				}
			}

			// newSea에 받아놓은것을 sea에 업데이트한다.
			sea = newSea;
		}
		
		System.out.println(answer);
		
		sc.close();
	} // main

	public static boolean Range(int r, int c) {
		if (r > 0 && r <= R && c > 0 && c <= C) {
			return true;
		}
		return false;
	}

	public static int Turn(int d) {
		if (d == 1)
			return 2;
		else if (d == 2)
			return 1;
		else if (d == 3)
			return 4;
		else if (d == 4)
			return 3;
		return 0;
	}
}