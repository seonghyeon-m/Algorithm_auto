import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] numbers;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // N개의 숫자를 사용
		int M = sc.nextInt(); // 만들 수열의 길이
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) nums[i] = sc.nextInt();
		Arrays.sort(nums);
		
		numbers = new int[M];
		visited = new boolean[N];
		
		combination(nums, M, 0);
		System.out.println(sb);
		
		sc.close();
	}
	
	public static void combination(int[] nums, int M, int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]);
				if (i != M-1) sb.append(" ");
			}
			sb.append('\n');
			
			return;
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (visited[i] == false) {
					if (depth == 0 || numbers[depth-1] < nums[i]) {
						visited[i] = true;
						numbers[depth] = nums[i];
						combination(nums, M, depth+1);
						visited[i] = false;
					}
				}
			}
			return;
		}
	}
}