import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		TT: for (int testCase = 1; testCase <= T; testCase++) {
			
			// input 받기
			int[][] nums = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					nums[i][j] = sc.nextInt();
				}
			}
			
			// 행	
			for (int i = 0; i < 9; i++) {
				int[] cnt = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
				
				for (int j = 0; j < 9; j++) {
					cnt[nums[i][j]-1] = 0;
				}
				
				for (int n = 0; n < 9; n++) {
					if (cnt[n] != 0) {
						System.out.println("#"+testCase+" "+0);
						continue TT;
					}
				}
			}
			
			// 열
			for (int j = 0; j < 9; j++) {
				int[] cnt = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
				
				for (int i = 0; i < 9; i++) {
					cnt[nums[i][j]-1] = 0;
				}
				
				for (int n = 0; n < 9; n++) {
					if (cnt[n] != 0) {
						System.out.println("#"+testCase+" "+0);
						continue TT;
					}
				}
			}
			
			// 3 * 3
			for (int p = 0; p < 3; p++) {
				for (int q = 0; q < 3; q++) {
					
					int[] cnt = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							cnt[nums[3*p+i][3*q+j]-1] = 0;
						}
					}
					
					for (int n = 0; n < 9; n++) {
						if (cnt[n] != 0) {
							System.out.println("#"+testCase+" "+0);
							continue TT;
						}
					}
					
				}
			}
			
			System.out.println("#"+testCase+" "+1);
			
		}
		
		sc.close();
		
	}
}