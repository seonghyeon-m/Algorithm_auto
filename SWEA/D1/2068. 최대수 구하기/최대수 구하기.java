import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) { // test case 개수만큼 반복
			int[] nums = new int[10];
			
			for (int j = 0; j < 10; j++) {
				nums[j] = sc.nextInt(); // input 값을 가져오는 중
			}
			
			for (int j = 0; j < (10-1); j++) {
				for (int k = 1; k < (10-j); k++) {
					if (nums[k-1] > nums[k]) {
						int temp = nums[k];
						nums[k] = nums[k-1];
						nums[k-1] = temp;
					}
				}
			} // 버블 정렬
			
			System.out.println("#"+(i+1)+" "+nums[nums.length-1]);
			
		}
		
		sc.close();
	}
}