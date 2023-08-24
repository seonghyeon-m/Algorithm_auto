import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			
			int N = sc.nextInt();
			ArrayList<Integer> password = new ArrayList<>();
			for (int i = 0; i < N; i++) password.add(sc.nextInt());
			
			int M = sc.nextInt();
			int L = 0;
			while (L < M) {
				String dump = sc.next();
				L++;
				int X = sc.nextInt();
				int Y = sc.nextInt();
				int[] S = new int[Y];
				for (int nums = 0; nums < Y; nums++) S[nums] = sc.nextInt();
				
				for (int nums = Y-1; nums >= 0; nums--) {
					password.add(X, S[nums]);
				}
			}
			
			System.out.print("#"+testCase+" ");
			for (int i = 0; i < 10; i++) {
				System.out.print(password.get(i));
				if (i != 9) System.out.print(" ");
			}
			System.out.println();
			
		} //testCase
		
		sc.close();
	}
}