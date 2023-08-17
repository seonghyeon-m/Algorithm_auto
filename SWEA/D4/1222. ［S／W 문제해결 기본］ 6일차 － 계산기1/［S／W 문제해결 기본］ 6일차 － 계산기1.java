import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			int N = sc.nextInt();
			String str = sc.next();
			// 0은 48, 9는 57 / +는 43
			int ans = 0;
			for (int i = 0; i < N; i++) {
				if (str.charAt(i) != '+') ans+=(str.charAt(i)-48);
			}
			
			System.out.println("#"+testCase+" "+ans);

		}
		
		sc.close();
	}
}