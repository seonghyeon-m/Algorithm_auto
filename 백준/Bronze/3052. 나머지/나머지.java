import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] num = new int[10];
		int[] remain = new int[10];
		
		for (int i = 0; i < 10; i++) {
			num[i] = sc.nextInt();
			remain[i] = num[i] % 42;
		}
		
		Set<String> set = new HashSet<>();

		for (int i = 0; i < 10; i++) {
			set.add(Integer.toString(remain[i]));
		}
		
		System.out.println(set.size());
		
        sc.close();
	}
}