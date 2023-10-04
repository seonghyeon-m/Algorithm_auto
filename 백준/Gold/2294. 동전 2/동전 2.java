import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N, K;
	static int[] coins, dp;
	static final int INF = 999999999;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // n가지 종류의 동전
		K = sc.nextInt(); // 만들어야 하는 금액
		
		// 동전 액면가
		coins = new int[N];
		for (int i = 0; i < N; i++)
			coins[i] = sc.nextInt();
		
		// 동전 오름차순 정렬
		Arrays.sort(coins);
		
		dp = new int[K+1];
		Arrays.fill(dp, INF);
		
		// dp 배열 초기값 채워주기
		for (int i = 0; i < N; i++) {
			if (i == 0 && coins[i] > K) {
				System.out.println(-1);
				System.exit(0);
			}
			
			if (coins[i] <= K) {				
				dp[coins[i]] = 1;
			}
		}

		if (make(K) >= INF) {
			System.out.println(-1);
		} else {
			System.out.println(make(K));
		}

		sc.close();
	}
	
	public static int make(int k) {
		if (dp[k] != INF)
			return dp[k];

		else {
			int min = INF;
			for (int i = 0; i < N; i++) {
				if (k - coins[i] > 0 && min > make(k - coins[i])) {
					min = make(k - coins[i]);
				}
			}
			dp[k] = min + 1;
			return dp[k];
		}
	}
}