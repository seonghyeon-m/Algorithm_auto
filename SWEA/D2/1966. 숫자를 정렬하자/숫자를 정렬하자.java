import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			
			int N = sc.nextInt();
			int[] nums = new int[N];
			for (int i = 0; i < N; i++) nums[i] = sc.nextInt();
			
			Arrays.sort(nums);
			
			System.out.print("#"+testCase+" ");
			for (int i = 0; i < N; i++) {
				System.out.print(nums[i]);
				if (i != N-1) System.out.print(" ");
			}
			System.out.println();
			
		}
		
		sc.close();
	}
}