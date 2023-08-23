import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			
			// input 받기
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[][] words = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					words[i][j] = sc.nextInt();
				}
			}
			
			// 풀이
			int ans = 0;
			int cnt;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (words[i][j] == 1) {

						// 가로
						cnt = 0;
						while (words[i][j+cnt] == 1) {
							
							// 잡았는데 그 전에 칸도 1이면 안되지 그럼 육목issue
							if (j-1 >= 0 && words[i][j-1] == 1) break;
							cnt++; // cnt개 만큼 1이 연속
							
							// K개 모았으면 다음칸에도 1인지 검사해보자 (육목검사처럼)
							if (cnt == K) {
								if (j+cnt < N && words[i][j+cnt] == 0) {
									// 다음 칸이 있는데 0이면 ans++
									ans++;
									break;
								} else if (j+cnt >= N) {
									// 다음 칸이 없으면 ans++
									ans++;
									break;
								} else {
									break;
								}
							}
							
							if (j+cnt >= N) break;
							
						} // while
						
						// 세로
						cnt = 0;
						while (words[i+cnt][j] == 1) {
							
							// 잡았는데 그 전에 칸도 1이면 안되지 그럼 육목issue
							if (i-1 >= 0 && words[i-1][j] == 1) break;
							cnt++; // cnt개 만큼 1이 연속
							
							// K개 모았으면 다음칸에도 1인지 검사해보자 (육목검사처럼)
							if (cnt == K) {
								if (i+cnt < N && words[i+cnt][j] == 0) {
									// 다음 칸이 있는데 0이면 ans++
									ans++;
									break;
								} else if (i+cnt >= N) {
									// 다음 칸이 없으면 ans++
									ans++;
									break;
								} else {
									break;
								}
							}
							
							if (i+cnt >= N) break;
							
						} // while
						
					} // if
				} // for j
			} // for i
			
			
			System.out.println("#"+testCase+" "+ans);
		}
		
		sc.close();
	}
}