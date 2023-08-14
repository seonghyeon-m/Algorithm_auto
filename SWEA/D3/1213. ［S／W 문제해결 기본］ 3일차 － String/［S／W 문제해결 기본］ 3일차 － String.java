import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			int T = sc.nextInt();
			String find = sc.next();
			String str = sc.next();
			
			int ans = 0;
			FF: for (int i = 0; i < str.length(); i++) {
				if (find.charAt(0) == str.charAt(i)) {
					for (int j = 0; j < find.length(); j++) {
						if (i+j > str.length()-1) {
							continue FF;
						}
						if (find.charAt(j) != str.charAt(i+j)) {
							continue FF;
						}
					}
					ans++;
				}
			}
			
			System.out.println("#"+T+" "+ans);
		}
		
		sc.close();
	}
}