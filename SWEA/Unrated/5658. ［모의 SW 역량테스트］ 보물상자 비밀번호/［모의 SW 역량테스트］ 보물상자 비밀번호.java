import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			
			System.out.print("#"+testCase+" ");
			
			int N = sc.nextInt(); // 숫자의 개수
			int K = sc.nextInt(); // 크기 순서
			
			String str = sc.next();
			str = str+str;
			
			int[] nums = new int[N];
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(str.substring(i, i+(N/4)), 16);
			}
			
			Arrays.sort(nums);
			
			int i = N-1;
			int cnt = N-1;
			
			while (cnt != N-K) {
				
				if (i == 0) {
					i--;
					cnt--;
				} else if (nums[i] != nums[i-1]) {
					i--;
					cnt--;
				} else {
					i--;
				}
				
			}
			
			System.out.println(nums[i]);
			
		}
		
		sc.close();
	}
}