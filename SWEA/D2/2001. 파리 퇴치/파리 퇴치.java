import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int testCase = 0; testCase < T; testCase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] fly = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					fly[i][j] = sc.nextInt();
				}
			}
			
			int max = 0;
			for (int i = 0; i < N-M+1; i++) {
				for (int j = 0; j < N-M+1; j++) {
					
					int flies = 0;
					
					for (int p = 0; p < M; p++) {
						for (int q = 0; q < M; q++) {
							flies +=fly[i+p][j+q];
						}
					}
					
					if (flies > max) {
						max = flies;
					}
				}
			}
			
			System.out.println("#"+(testCase+1)+" "+max);
			
		}
		
		sc.close();
	}
}