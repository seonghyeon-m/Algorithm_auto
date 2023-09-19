import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] sortedArr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			sortedArr[i] = arr[i];
		}
		
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		
		for (int i = 0; i < N; i++)
			hashmap.put(arr[i], 0);
		
		Arrays.sort(sortedArr);
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (i == 0 || sortedArr[i-1] == sortedArr[i])
				// cnt 증가 없이
				hashmap.put(sortedArr[i], cnt);
			else
				hashmap.put(sortedArr[i], ++cnt);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int num : arr) {
			sb.append(hashmap.get(num)+" ");
		}
		System.out.println(sb);
		
		sc.close();
	}
}