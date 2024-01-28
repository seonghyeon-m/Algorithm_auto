import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 수의 개수
		int M = sc.nextInt(); // 합을 구해야 하는 횟수
		
		int[] nums = new int[N]; // 숫자들
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		int[] sums = new int[N]; // 합을 구해놓자
		sums[0] = nums[0];
		for (int i = 1; i < N; i++) {
			sums[i] = sums[i-1] + nums[i];
		}
		
		// 계산해보자
		for (int tc = 0; tc < M; tc++) {
			int start = sc.nextInt()-2;
			int end = sc.nextInt()-1;
			
			if (start == -1) {
				System.out.println(sums[end]);
			} else {
				System.out.println(sums[end] - sums[start]);				
			}		
		}
		
		sc.close();
	}
}