import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(bf.readLine());
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(bf.readLine());
		}
		
		nums = countSort(nums);

		for (int i = 0; i < nums.length; i++) {
			sb.append(nums[i]);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static int[] countSort(int[] arr) {
		int[] count = new int[2000001];
		int[] temp = new int[arr.length];
		
		for (int i : arr) {
			if (i >= 0) count[i]++;
			else count[1000000-i]++;
		}
		
		int point = 0;
		for (int i = count.length-1; i > 1000000; i--) {
			while (count[i] != 0) {
				temp[point] = 1000000-i;
				point++;
				count[i]--;
			}
		}
		for (int i = 0; i <= 1000000; i++) {
			while (count[i] != 0) {
				temp[point] = i;
				point++;
				count[i]--;
			}
		}
		
		return temp;
		
	}

}