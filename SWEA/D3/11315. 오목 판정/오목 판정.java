import java.util.Scanner;

public class Solution {	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		TT: for (int testCase = 1; testCase <= T; testCase++) {
			
			int N = sc.nextInt();
			String[][] str = new String[N][];
			for (int i = 0; i < N; i++) {
				str[i] = sc.next().split("");
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {					
					if (str[i][j].equals("o")) {
						
						// 오른쪽 확인
						int right = 0;
						WW: while (str[i][j+right].equals("o")) {
							right++;
							if (right == 5) {
								System.out.println("#"+testCase+" YES");
								continue TT;
							}
							if (j+right >= N) {
								break WW;
							}
						}
						
						// 아래 확인
						int down = 0;
						WW: while (str[i+down][j].equals("o")) {
							down++;
							if (down == 5) {
								System.out.println("#"+testCase+" YES");
								continue TT;
							}
							if (i+down >= N) {
								break WW;
							}
						}
						
						// 왼쪽 아래 대각선 확인
						int leftdown = 0;
						WW: while (str[i+leftdown][j-leftdown].equals("o")) {
							leftdown++;							
							if (leftdown == 5) {
								System.out.println("#"+testCase+" YES");
								continue TT;
							}
							if (i+leftdown >= N || j-leftdown < 0) {
								break WW;
							}
						}
						
						// 오른쪽 아래 대각선 확인
						int rightdown = 0;
						WW: while (str[i+rightdown][j+rightdown].equals("o")) {
							rightdown++;							
							if (rightdown == 5) {
								System.out.println("#"+testCase+" YES");
								continue TT;
							}
							if (i+rightdown >= N || j+rightdown >= N) {
								break WW;
							}
						}
						
					}
				}
			}
			
			System.out.println("#"+testCase+" NO");
			
		}
		
		sc.close();
	}
}