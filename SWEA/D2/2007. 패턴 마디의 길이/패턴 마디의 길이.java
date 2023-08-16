import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		tc: for (int testCase = 1; testCase <= T; testCase++) {
			String str = sc.next();
			int start = str.charAt(0);
			for (int i = 1; i < str.length()-1; i++) { // 반복 길이 i
				if (start == str.charAt(i)) {
					int j = 0;
					while (str.charAt(j) == str.charAt(i+j)) {
						j++;
						if (j == i) {
							System.out.println("#"+testCase+" "+i);
							continue tc;
						} // while-if
					} // while
				} // for-if
			} // for i
			
			
			
			
		} //testCase
		
		sc.close();
	}

}