import java.util.Scanner;

public class Main {
	
	static int[][] chess;
	static int ans, nth;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		chess = new int[N][N];
		
		ans = 0;
		nth = 1;
		queen(N, 0);
		
		System.out.println(ans);
		
		sc.close();
	}
	
	public static void queen(int n, int depth) {
		if (depth == n) {
			ans++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (chess[i][j] == 0 && i == depth) {
					// 방문처리
					chess[i][j] = nth;
					// 세로줄 제외
					for (int r = 0; r < n; r++)
						if (chess[r][j] == 0)
							chess[r][j] = nth;
					// 가로줄 제외
					for (int c = 0; c < n; c++)
						if (chess[i][c] == 0)
							chess[i][c] = nth;
					// 대각선 제외
					// 1. 왼쪽 위로
					int dx = 0;
					int dy = 0;
					while (i-dx >= 0 && j-dy >= 0) {
						if (chess[i-dx][j-dy] == 0)
							chess[i-dx][j-dy] = nth;
						dx++;
						dy++;
					}
					// 2. 왼쪽 아래로
					dx = 0;
					dy = 0;
					while (i+dx < n && j-dy >= 0) {
						if (chess[i+dx][j-dy] == 0)
							chess[i+dx][j-dy] = nth;
						dx++;
						dy++;
					}
					// 3. 오른쪽 위로
					dx = 0;
					dy = 0;
					while (i-dx >= 0 && j+dy < n) {
						if (chess[i-dx][j+dy] == 0)
							chess[i-dx][j+dy] = nth;
						dx++;
						dy++;
					}
					// 4. 오른쪽 아래로
					dx = 0;
					dy = 0;
					while (i+dx < n && j+dy < n) {
						if (chess[i+dx][j+dy] == 0)
							chess[i+dx][j+dy] = nth;
						dx++;
						dy++;
					}
					// 제외 끝 다음 재귀 시작 준비
					nth++;
					queen(n, depth+1);
					nth--;
					// 제외한 칸 풀어주기
					for (int r = 0; r < n; r++)
						for (int c = 0; c < n; c++)
							if (chess[r][c] == nth)
								chess[r][c] = 0;
				}
			}
		}
	}
}