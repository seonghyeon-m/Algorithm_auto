import java.util.Scanner;

public class Main {
	
	static int[] save;
	static int N, M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N: 총 싸움 시간, M: B 스킬의 시전 시간(A 스킬은 시전 시간이 1초)
		N = sc.nextInt();
		M = sc.nextInt();
		
		save = new int[N+1];
		System.out.println(combo(N));
		
		sc.close();
	}
	
	public static int combo(int n) {
		if (save[n] != 0) {
			return save[n];
		} else if (n == 1) {
			save[n] = 1;
			return save[n];
		} else if (n < M) {
			save[n] = 1;
			return save[n];
		} else {
			save[n] = combo(n-1) + combo(n-M);
			if (save[n] >= 1000000007) {
				save[n] %=1000000007;
			}
			return save[n];
		}
	}
}