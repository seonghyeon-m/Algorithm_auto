import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			int T = sc.nextInt();
			
			int[] nums = new int[8];
			for (int i = 0; i < nums.length; i++) {
				nums[i] = sc.nextInt();
			}
			
			int p = 0;
			int minus = 1;
			while (true) {
				nums[p] -=minus; // 해당 index에서 줄어들어야 하는 만큼 뺌
				minus = decreaseMore(minus); // 빼야하는 수 증가
				if (nums[p] <= 0) break;
				if (p == nums.length-1) p = 0;
				else p++; // 다음 index로 넘어감
			}
			nums[p] = 0;
			
			System.out.print("#"+T+" ");
			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[(i+p+1)%8]);
				if (i != 7) System.out.print(" ");
			}
			System.out.println();
			

		}
		
		sc.close();
	}
	
	public static int decreaseMore(int n) {
		if (n == 5) return 1;
		else return n+1;
	}
	
}