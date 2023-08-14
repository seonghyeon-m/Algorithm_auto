import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		for (int T = 1; T <= 10; T++) {
			
			int ans = 0;
			int L = sc.nextInt();
			
			String[] arr = new String[8];
			for (int n = 0; n < 8; n++) {
				arr[n] = sc.next();
			}
			
			// 행
			for (int i = 0; i < 8; i++) {
				iter: for (int j = 0; j <= (8-L); j++) {
					int k = 0;
					while (arr[i].charAt(j+k) == arr[i].charAt(j+L-k-1)) {
						k++;
						if (k > (L-1)/2) {
							ans++;
							continue iter;
						}
					}
				}
			}
			
			// 열
			for (int j = 0; j < 8; j++) {
				iter: for (int i = 0; i <= (8-L); i++) {
					int k = 0;
					while (arr[i+k].charAt(j) == arr[i+L-k-1].charAt(j)) {
						k++;
						if (k > (L-1)/2) {
							ans++;
							continue iter;
						}
					}
				}
			}
			
			System.out.println("#"+T+" "+ans);
			
		}
		
		sc.close();
		
	}
}