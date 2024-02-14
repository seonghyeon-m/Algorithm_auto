import java.util.Scanner;

public class Main {

	// 0~5번째 면은 각각 위, 뒤, 왼, 앞, 오, 아래를 나타낸다.
	static String[][][] cube = new String[6][3][3];

	// 전개도 종류, 각 배열의 첫번째 원소가 윗면일 때
	static int[][] planar = { { 0, 1, 2, 3, 4, 5 }, { 1, 5, 2, 0, 4, 3 }, { 2, 5, 3, 0, 1, 4 }, { 3, 0, 2, 5, 4, 1 },
			{ 4, 1, 0, 3, 5, 2 }, { 5, 1, 4, 3, 2, 0 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 큐브 기본세팅
		String[] colors = { "w", "o", "g", "r", "b", "y" };

		// testCase 시작
		int T = sc.nextInt(); // testCase 수
		for (int testCase = 1; testCase <= T; testCase++) {
			// 원래대로
			for (int i = 0; i < 6; i++)
				for (int r = 0; r < 3; r++)
					for (int c = 0; c < 3; c++)
						cube[i][r][c] = colors[i];
			// 돌리자
			int N = sc.nextInt(); // 회전 수
			for (int turn = 0; turn < N; turn++) {
				String[] order = sc.next().split("");
				switch (order[0]) {
				case "U":
					if (order[1].equals("+")) {
						U(1);
						break;
					} else {
						U(-1);
						break;
					}
				case "B":
					if (order[1].equals("+")) {
						B(1);
						break;
					} else {
						B(-1);
						break;
					}
				case "L":
					if (order[1].equals("+")) {
						L(1);
						break;
					} else {
						L(-1);
						break;
					}
				case "F":
					if (order[1].equals("+")) {
						F(1);
						break;
					} else {
						F(-1);
						break;
					}
				case "R":
					if (order[1].equals("+")) {
						R(1);
						break;
					} else {
						R(-1);
						break;
					}
				case "D":
					if (order[1].equals("+")) {
						D(1);
						break;
					} else {
						D(-1);
						break;
					}
				}
			}

			// 출력
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					System.out.print(cube[0][r][c]);
				}
				System.out.println();
			}
		}

		sc.close();
	}

	// U
	public static void U(int rotate) {
		if (rotate == 1) {
			// 시계방향
			// 윗면 돌리기
			String[][] face = new String[3][3];
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					face[r][c] = cube[0][2 - c][r];
				}
			}
			cube[0] = face;
			// 옆면 돌리기
			String[] side = new String[12];
			for (int i = 0; i < 3; i++) {
				side[i] = cube[1][2][2 - i];
				side[3 + i] = cube[2][i][2];
				side[6 + i] = cube[3][0][i];
				side[9 + i] = cube[4][2 - i][0];
			}
			for (int i = 0; i < 3; i++) {
				cube[1][2][2 - i] = side[3 + i];
				cube[2][i][2] = side[6 + i];
				cube[3][0][i] = side[9 + i];
				cube[4][2 - i][0] = side[i];
			}
		} else {
			// 반시계방향
			// 윗면 돌리기
			String[][] face = new String[3][3];
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					face[r][c] = cube[0][c][2 - r];
				}
			}
			cube[0] = face;
			// 옆면 돌리기
			String[] side = new String[12];
			for (int i = 0; i < 3; i++) {
				side[i] = cube[1][2][2 - i];
				side[3 + i] = cube[2][i][2];
				side[6 + i] = cube[3][0][i];
				side[9 + i] = cube[4][2 - i][0];
			}
			for (int i = 0; i < 3; i++) {
				cube[1][2][2 - i] = side[9 + i];
				cube[2][i][2] = side[i];
				cube[3][0][i] = side[3 + i];
				cube[4][2 - i][0] = side[6 + i];
			}
		}
	}

	// B
	public static void B(int rotate) {
		if (rotate == 1) {
			// 시계방향
			// 왼쪽면 돌리기
			String[][] face = new String[3][3];
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					face[r][c] = cube[1][2 - c][r];
				}
			}
			cube[1] = face;
			// 옆면 돌리기
			String[] side = new String[12];
			for (int i = 0; i < 3; i++) {
				side[i] = cube[5][0][i];
				side[3 + i] = cube[2][0][i];
				side[6 + i] = cube[0][0][i];
				side[9 + i] = cube[4][0][i];
			}
			for (int i = 0; i < 3; i++) {
				cube[5][0][i] = side[3 + i];
				cube[2][0][i] = side[6 + i];
				cube[0][0][i] = side[9 + i];
				cube[4][0][i] = side[i];
			}
		} else {
			// 반시계방향
			// 윗면 돌리기
			String[][] face = new String[3][3];
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					face[r][c] = cube[1][c][2 - r];
				}
			}
			cube[1] = face;
			// 옆면 돌리기
			String[] side = new String[12];
			for (int i = 0; i < 3; i++) {
				side[i] = cube[5][0][i];
				side[3 + i] = cube[2][0][i];
				side[6 + i] = cube[0][0][i];
				side[9 + i] = cube[4][0][i];
			}
			for (int i = 0; i < 3; i++) {
				cube[5][0][i] = side[9 + i];
				cube[2][0][i] = side[i];
				cube[0][0][i] = side[3 + i];
				cube[4][0][i] = side[6 + i];
			}
		}
	}

	// L
	public static void L(int rotate) {
		if (rotate == 1) {
			// 시계방향
			// 윗면 돌리기
			String[][] face = new String[3][3];
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					face[r][c] = cube[2][2 - c][r];
				}
			}
			cube[2] = face;
			// 옆면 돌리기
			String[] side = new String[12];
			for (int i = 0; i < 3; i++) {
				side[i] = cube[1][2 - i][0];
				side[3 + i] = cube[5][i][2];
				side[6 + i] = cube[3][2 - i][0];
				side[9 + i] = cube[0][2 - i][0];
			}
			for (int i = 0; i < 3; i++) {
				cube[1][2 - i][0] = side[3 + i];
				cube[5][i][2] = side[6 + i];
				cube[3][2 - i][0] = side[9 + i];
				cube[0][2 - i][0] = side[i];
			}
		} else {
			// 반시계방향
			// 윗면 돌리기
			String[][] face = new String[3][3];
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					face[r][c] = cube[2][c][2 - r];
				}
			}
			cube[2] = face;
			// 옆면 돌리기
			String[] side = new String[12];
			for (int i = 0; i < 3; i++) {
				side[i] = cube[1][2 - i][0];
				side[3 + i] = cube[5][i][2];
				side[6 + i] = cube[3][2 - i][0];
				side[9 + i] = cube[0][2 - i][0];
			}
			for (int i = 0; i < 3; i++) {
				cube[1][2 - i][0] = side[9 + i];
				cube[5][i][2] = side[i];
				cube[3][2 - i][0] = side[3 + i];
				cube[0][2 - i][0] = side[6 + i];
			}
		}
	}

	// F
	public static void F(int rotate) {
		if (rotate == 1) {
			// 시계방향
			// 윗면 돌리기
			String[][] face = new String[3][3];
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					face[r][c] = cube[3][2 - c][r];
				}
			}
			cube[3] = face;
			// 옆면 돌리기
			String[] side = new String[12];
			for (int i = 0; i < 3; i++) {
				side[i] = cube[0][2][2 - i];
				side[3 + i] = cube[2][2][2 - i];
				side[6 + i] = cube[5][2][2 - i];
				side[9 + i] = cube[4][2][2 - i];
			}
			for (int i = 0; i < 3; i++) {
				cube[0][2][2 - i] = side[3 + i];
				cube[2][2][2 - i] = side[6 + i];
				cube[5][2][2 - i] = side[9 + i];
				cube[4][2][2 - i] = side[i];
			}
		} else {
			// 반시계방향
			// 윗면 돌리기
			String[][] face = new String[3][3];
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					face[r][c] = cube[3][c][2 - r];
				}
			}
			cube[3] = face;
			// 옆면 돌리기
			String[] side = new String[12];
			for (int i = 0; i < 3; i++) {
				side[i] = cube[0][2][2 - i];
				side[3 + i] = cube[2][2][2 - i];
				side[6 + i] = cube[5][2][2 - i];
				side[9 + i] = cube[4][2][2 - i];
			}
			for (int i = 0; i < 3; i++) {
				cube[0][2][2 - i] = side[9 + i];
				cube[2][2][2 - i] = side[i];
				cube[5][2][2 - i] = side[3 + i];
				cube[4][2][2 - i] = side[6 + i];
			}
		}
	}

	// R
	public static void R(int rotate) {
		if (rotate == 1) {
			// 시계방향
			// 윗면 돌리기
			String[][] face = new String[3][3];
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					face[r][c] = cube[4][2 - c][r];
				}
			}
			cube[4] = face;
			// 옆면 돌리기
			String[] side = new String[12];
			for (int i = 0; i < 3; i++) {
				side[i] = cube[1][i][2];
				side[3 + i] = cube[0][i][2];
				side[6 + i] = cube[3][i][2];
				side[9 + i] = cube[5][2 - i][0];
			}
			for (int i = 0; i < 3; i++) {
				cube[1][i][2] = side[3 + i];
				cube[0][i][2] = side[6 + i];
				cube[3][i][2] = side[9 + i];
				cube[5][2 - i][0] = side[i];
			}
		} else {
			// 반시계방향
			// 윗면 돌리기
			String[][] face = new String[3][3];
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					face[r][c] = cube[4][c][2 - r];
				}
			}
			cube[4] = face;
			// 옆면 돌리기
			String[] side = new String[12];
			for (int i = 0; i < 3; i++) {
				side[i] = cube[1][i][2];
				side[3 + i] = cube[0][i][2];
				side[6 + i] = cube[3][i][2];
				side[9 + i] = cube[5][2 - i][0];
			}
			for (int i = 0; i < 3; i++) {
				cube[1][i][2] = side[9 + i];
				cube[0][i][2] = side[i];
				cube[3][i][2] = side[3 + i];
				cube[5][2 - i][0] = side[6 + i];
			}
		}
	}

	// D
	public static void D(int rotate) {
		if (rotate == 1) {
			// 시계방향
			// 윗면 돌리기
			String[][] face = new String[3][3];
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					face[r][c] = cube[5][2 - c][r];
				}
			}
			cube[5] = face;
			// 옆면 돌리기
			String[] side = new String[12];
			for (int i = 0; i < 3; i++) {
				side[i] = cube[1][0][i];
				side[3 + i] = cube[4][i][2];
				side[6 + i] = cube[3][2][2 - i];
				side[9 + i] = cube[2][2 - i][0];
			}
			for (int i = 0; i < 3; i++) {
				cube[1][0][i] = side[3 + i];
				cube[4][i][2] = side[6 + i];
				cube[3][2][2 - i] = side[9 + i];
				cube[2][2 - i][0] = side[i];
			}
		} else {
			// 반시계방향
			// 윗면 돌리기
			String[][] face = new String[3][3];
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					face[r][c] = cube[5][c][2 - r];
				}
			}
			cube[5] = face;
			// 옆면 돌리기
			String[] side = new String[12];
			for (int i = 0; i < 3; i++) {
				side[i] = cube[1][0][i];
				side[3 + i] = cube[4][i][2];
				side[6 + i] = cube[3][2][2 - i];
				side[9 + i] = cube[2][2 - i][0];
			}
			for (int i = 0; i < 3; i++) {
				cube[1][0][i] = side[9 + i];
				cube[4][i][2] = side[i];
				cube[3][2][2 - i] = side[3 + i];
				cube[2][2 - i][0] = side[6 + i];
			}
		}
	}

}