import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	/*
	 * 1209 Sum
	 * 5시15분~20분
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			
			int T = sc.nextInt();
			
			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int max = 0;
			
			// 행 탐색
			for (int i = 0; i < 100; i++) {
				int add = 0;
				for (int j = 0; j < 100; j++) {
					add +=arr[i][j];
				}
				if (add > max) {
					max = add;
				}
			}
			
			// 열 탐색
			for (int j = 0; j < 100; j++) {
				int add = 0;
				for (int i = 0; i < 100; i++) {
					add +=arr[i][j];
				}
				if (add > max) {
					max = add;
				}
			}
			
			// 대각선 왼쪽
			int add = 0;
			int p = 0;
			int q = 0;
			while (p < 100) {
				add +=arr[p][q];
				p++;
				q++;
			}
			if (add > max) {
				max = add;
			}
			
			// 대각선 왼쪽
			add = 0;
			p = 0;
			q = 99;
			while (p < 100) {
				add +=arr[p][q];
				p++;
				q--;
			}
			if (add > max) {
				max = add;
			}
			
			System.out.println("#"+T+" "+max);
			
		}
		
		sc.close();
	}
}