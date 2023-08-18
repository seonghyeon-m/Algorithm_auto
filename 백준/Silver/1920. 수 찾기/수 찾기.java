import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		int M = sc.nextInt();
		int[] nums = new int[M];
		for (int i = 0; i < M; i++) {
			nums[i] = sc.nextInt();
		}
		
		Arrays.sort(A);
		
		for (int i : nums) {
			System.out.println(binarySearch(A, i));
		}
		
		sc.close();
	}
	
	public static int binarySearch(int[] arr, int target) {
		int p = 0;
		int r = arr.length-1;
		int q = (p+r)/2;
		
		while (p <= r) {
			if (target > arr[q]) {
				p = q+1;
				q = (p+r)/2;
			} else if (target < arr[q]) {
				r = q-1;
				q = (p+r)/2;
			} else {
				return 1;
			}
		}
		return 0;
	}
}