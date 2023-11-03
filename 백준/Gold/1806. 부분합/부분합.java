import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 자연수로 이루어진 수열의 길이 N
		int S = sc.nextInt(); // 만들어야 하는 부분합의 최소값 S
		int[] num = new int[N]; // 자연수로 이루어진 수열
		int[] sum = new int[N+1]; // 부분합
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
			if (i > 0) {
				sum[i+1] = sum[i] + num[i];
			} else {
				sum[1] = num[0];
			}
		}

		// two pointer
		int p1 = 0;
		int p2 = 1;
		
		int leastLength = N+1;
		
		while (p2 != N+1) {
			// 최소길이 갱신
			if (sum[p2] - sum[p1] >= S && leastLength > p2-p1) {
				leastLength = p2-p1;
			}
			// 포인터 이동
			if (sum[p2] - sum[p1] < S || p1+1 == p2) {
				p2++;
			} else {
				p1++;
			}
		}
		
		// 출력
		if (leastLength == N+1) {
			System.out.println(0);
		} else {
			System.out.println(leastLength);
		}
		
		sc.close();
	}
}