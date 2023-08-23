import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			ArrayList<Integer> sum = new ArrayList<>();
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					sum.add(i+j);
				}
			}
			
			int[] cnt = new int[41]; // index 0, 1은 항상 비어있을 것, 2~40만 사용
			for (int i = 0; i < sum.size(); i++) {
				cnt[sum.get(i)]++;
			}
			
			ArrayList<Integer> max = new ArrayList<>();
			int maxcnt = 0;
			for (int i = 0; i < cnt.length; i++) {
				if (cnt[i] > maxcnt) {
					// 새로운 최대값을 발견했을 때
					maxcnt = cnt[i];
					max = new ArrayList<>();
					max.add(i);
				} else if (cnt[i] == maxcnt) {
					// 기존 최대값과 같은 값을 발견했을 때
					max.add(i);
				} // 더 작은건 아무것도 할 필요가 없다.
			}
			
			System.out.print("#"+testCase+" ");
			for (int i = 0; i < max.size(); i++) {
				System.out.print(max.get(i));
				if (i != max.size()-1) System.out.print(" ");
			}
			System.out.println();
			
		} //testCase
		
		sc.close();
	}
	
}