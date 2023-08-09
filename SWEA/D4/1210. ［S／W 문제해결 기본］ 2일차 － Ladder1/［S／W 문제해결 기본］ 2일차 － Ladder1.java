import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			// input 받기
			int N = sc.nextInt();
			int[][] ladder = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = sc.nextInt();
				}
			}
			
			// 어떻게 짤까
			int startPoint = 0;
			for (int i = 0; i < 100; i++) {
				if (ladder[99][i] == 2) {
					startPoint = i;
				}
			}
			
			int p = 99; // 행
			int q = startPoint; // 열
			
			while (p > 0) {
				if (q == 0) { // 왼쪽 끝
					if (ladder[p][q+1] == 1) {
						q++;
						while (ladder[p-1][q] != 1) {
							q++;
						}
						p--;
					} else {
						p--;
					}
				} else if (q == 99) { // 오른쪽 끝
					if (ladder[p][q-1] == 1) {
						q--;
						while (ladder[p-1][q] != 1) {
							q--;
						}
						p--;
					} else {
						p--;
					}
				} else { // 나머지
					if (ladder[p][q+1] == 1) {
						q++;
						while (ladder[p-1][q] != 1) {
							q++;
						}
						p--;
					} else if (ladder[p][q-1] == 1) {
						q--;
						while (ladder[p-1][q] != 1) {
							q--;
						}
						p--;
					} else {
						p--;
					}
				}
			}
			System.out.println("#"+testCase+" "+q);
		}

		sc.close();
	}
}