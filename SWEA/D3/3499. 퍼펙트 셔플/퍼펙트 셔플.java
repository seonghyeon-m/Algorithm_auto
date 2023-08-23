import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			
			// input 받기
			int N = sc.nextInt();
			ArrayList<String> cards = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				cards.add(sc.next());
			}

			// 풀이
			int idx = 1;
			if (N % 2 == 0) {
				for (int i = N/2; i < N; i++) {
					String temp = cards.get(i);
					cards.remove(i);
					cards.add(idx, temp);
					idx +=2;
				}
			} else {
				for (int i = N/2+1; i < N; i++) {
					String temp = cards.get(i);
					cards.remove(i);
					cards.add(idx, temp);
					idx +=2;
				}
			}
			
			// 출력
			System.out.print("#"+testCase+" ");
			for (int i = 0; i < N; i++) {
				System.out.print(cards.get(i));
				if (i != N-1) System.out.print(" ");
			}
			System.out.println();
			
		} // testCase
		
		sc.close();
	}
}