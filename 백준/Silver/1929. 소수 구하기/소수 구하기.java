import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int[] prime = new int[N+1];
		
		for (int i = 0; i <= N; i++) {
			prime[i] = i;
		}
		prime[1] = 0;
		
		int p = 0;
		while (p <= N) {
			if (prime[p] == 0) {
				p++;
				continue;
			} else {
				int q = p;
				int r = prime[p];
				while (true) {
					q +=r;
					if (q > N) {
						break;
					}
					prime[q] = 0;
				}
				p++;
			}
		}
		
		for (int i = M; i <= N; i++) {
			if (prime[i] != 0) {
				System.out.println(prime[i]);
			}
		}
		
		sc.close();
	}
}