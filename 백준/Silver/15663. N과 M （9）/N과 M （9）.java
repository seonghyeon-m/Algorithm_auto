import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 1~N 숫자를 사용
		int M = sc.nextInt(); // 길이
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = 0; i < N; i++) nums.add(sc.nextInt());
		Collections.sort(nums);
		
		numbers = new int[M];
		
		combination(nums, M, 0);
		System.out.println(sb);
		
		sc.close();
	}
	
	public static void combination(ArrayList<Integer> nums, int M, int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]);
				if (i != M-1) sb.append(" ");
			}
			sb.append('\n');
			
			return;
		} else {
			for (int i = 0; i < nums.size(); i++) {
				if (i == 0 || nums.get(i-1) != nums.get(i)) {
					if (nums.get(i) != 0) {
						numbers[depth] = nums.get(i);
						nums.set(i, 0);
						combination(nums, M, depth+1);
						nums.set(i, numbers[depth]);
					}
				}
			}
			return;
		}
	}
}