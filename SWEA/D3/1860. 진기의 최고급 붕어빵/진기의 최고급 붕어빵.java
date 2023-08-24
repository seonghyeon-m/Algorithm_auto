import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		TC: for (int testCase = 1; testCase <= T; testCase++) {
			
			int N = sc.nextInt(); // N명의 사람이 먹으러 오고,
			int M = sc.nextInt(); // M초의 시간을 들이면
			int K = sc.nextInt(); // K개의 붕어빵을 만들 수 있다.
			
			int[] arrive = new int[N];
			for (int i = 0; i < N; i++) arrive[i] = sc.nextInt();
			
			/*
			 * 모든 손님들에게 기다리는 시간 없이 붕어빵을 제공하자!
			 */
			
			Arrays.sort(arrive);
			int[] timeLine = new int[arrive[arrive.length-1]+1];
			int people = 0;
			
			for (int i = 0; i <= arrive[arrive.length-1]; i++) {
				
				// 전날 값 받아오기
				if (i != 0) timeLine[i] = timeLine[i-1];
								
				// M초마다 K개의 붕어빵이 생긴다
				if (i % M == 0 && i != 0) {
					timeLine[i] = timeLine[i-1] + K;
				}
				// 사람이 온다
				while (arrive[people] == i) {
					timeLine[i]--;
					people++;
					if (people == N) break;
				}
				// 붕어빵 모자란가
				if (timeLine[i] < 0) {
					System.out.println("#"+testCase+" Impossible");
					continue TC;
				}
			}
			
			System.out.println("#"+testCase+" Possible");
			
		} //testCase
		
		sc.close();
	}
}