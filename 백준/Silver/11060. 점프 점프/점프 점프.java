import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] maze = new int[N];
		for (int i = 0; i < N; i++) maze[i] = sc.nextInt();
		
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) dp[i] = Integer.MAX_VALUE/10;
		
		dp[0] = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= maze[i]; j++) {
				if (i+j < N && i+j > 0) {
					if (dp[i+j] > dp[i]+1)
						dp[i+j] = dp[i]+1;
				}
			}
		}
		
		if (dp[N-1] == Integer.MAX_VALUE/10)
			System.out.println(-1);
		else
			System.out.println(dp[N-1]);
		
		sc.close();
	}
}