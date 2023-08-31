import java.util.Scanner;

public class Solution {
	
	static int kcalMax;
	static int likeMax;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			
			kcalMax = 0;
			likeMax = 0;
			
			// input 받기
			int N = sc.nextInt(); // 재료 수 N
			int limit = sc.nextInt(); // 칼로리 제한
			int[] like = new int[N]; // 각 재료의 만족도 -> 최대 만족도를 구해주세요
			int[] kcal = new int[N]; // 각 재료의 칼로리
			for (int i = 0; i < N; i++) {
				like[i] = sc.nextInt();
				kcal[i] = sc.nextInt();
			}
			
			find: for (int i = 0; i < Math.pow(2, N); i++) { // 재료 조합
				
				int likeNow = 0;
				int kcalNow = 0;
				int check = 1;
				int idx = 0;
				
				while (check != Math.pow(2, N)) {
					if ((i & check) == check) {						
						likeNow +=like[idx];
						kcalNow +=kcal[idx];
					}
					check = check << 1;
					idx++;
					if (kcalNow > limit) continue find;
				}
				
				if (likeNow > likeMax) {
					likeMax = likeNow;
				}
				
			} //for i
			
			System.out.println("#"+testCase+" "+likeMax);
			
		} //testCase
		
		sc.close();
	}
}