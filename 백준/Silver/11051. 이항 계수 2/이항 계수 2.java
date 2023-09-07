import java.util.Scanner;

public class Main {
	
	static long[][] save;
	static int N, K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		if (K == 0) {
			System.out.println(1);
			System.exit(0);
		}
		
		save = new long[N+1][K+1];
		for (int i = 0; i <= N; i++) {
			save[i][1] = i;
		}
		
		for (int i = 0; i <= K; i++) {
			save[i][i] = 1;
		}
		
		System.out.println(C(N, K)%10007);
		
		sc.close();
	}
	
	public static long C(int N, int K) {
		if (K == 1) return save[N][K];
		if (N == K) return save[N][K];
		if (save[N][K] == 0) {
			save[N][K] = (C(N-1, K) + C(N-1, K-1))%10007;
		}
		return save[N][K];
	}
}