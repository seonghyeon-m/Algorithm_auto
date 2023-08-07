//import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
//		File file = new File("src/SWEA_1206_View/input.txt");
		Scanner sc = new Scanner(System.in);
		
		for (int t = 0; t < 10; t++) {
			// input 받기
			int N = sc.nextInt();
			int[] bld = new int[N];
			
			for (int i = 0; i < bld.length; i++) {
				bld[i] = sc.nextInt();
			}
			
			// 코드
			int p = 2;
			int ans = 0;
			
			while (p < bld.length-2) {
				if (bld[p] > bld[p-2] && bld[p] > bld[p-1] && bld[p] > bld[p+1] && bld[p] > bld[p+2]) {
					// 주변 네 개의 건물이 모두 해당 건물보다 높이가 낮을 때,
					int[] temp = {bld[p-2], bld[p-1], bld[p+1], bld[p+2]};
					Arrays.sort(temp);
					ans += (bld[p] - temp[3]);
					// 그 중 제일 높은 건물의 높이를 빼서 출력할 값에 계속 더해주면 된다.
				}
				p++;
			}
			
			System.out.println("#"+(t+1)+" "+ans); // 출력
			
		}
		
		sc.close();
		
	}
}