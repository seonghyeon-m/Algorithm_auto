import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // N개의 숫자가 있다
		int[] nums = new int[N]; // 그 N개의 숫자 입력받음
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		Arrays.sort(nums);
		int M = nums[N-1];
		
		int[] prime = new int[M+1];

		for (int i = 0; i <= M; i++) {
			prime[i] = i;
		}
		prime[1] = 0;
		
		int p = 0;
		while (p <= M) {
			if (prime[p] == 0) {
				p++;
				continue;
			} else {
				int q = p;
				int r = prime[p];
				while (true) {
					q +=r;
					if (q > M) {
						break;
					}
					prime[q] = 0;
				}
				p++;
			}
		}
		
		int ans = 0;
		for (int i : nums) {
			if (prime[i] != 0) {
				ans +=1;
			}
		}
		System.out.println(ans);
		
		sc.close();
	}
}