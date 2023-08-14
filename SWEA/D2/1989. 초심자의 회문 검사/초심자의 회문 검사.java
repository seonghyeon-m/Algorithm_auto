import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		tc: for (int testCase = 1; testCase <= T; testCase++) {
			
			String str = sc.next();
			int L = str.length();
			for (int i = 0; i <= L/2; i++) {
				if (str.charAt(i) != str.charAt(L-1-i)) {
					System.out.println("#"+testCase+" "+0);
					continue tc;
				}
			}
			System.out.println("#"+testCase+" "+1);
		}
		
		sc.close();
	}
}