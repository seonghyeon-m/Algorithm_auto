import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			
			// input 받기
			int N = sc.nextInt();
			int[] A = new int[N]; // Ai 이상
			int[] B = new int[N]; // Bi 이하의 정류소만 다닌다			
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
				B[i] = sc.nextInt();
			}
			int P = sc.nextInt(); // 정류소 번호
			int[] C = new int[P];
			for (int i = 0; i < P; i++) {
				C[i] = sc.nextInt();
			}
			
			// 풀이
			int[] busStop = new int[5001]; // 편의상 5001개로 설정하고 busStop[0]은 사용하지 않는다.
			for (int i = 0; i < N; i++) {
				for (int j = A[i]; j <= B[i]; j++) {
					busStop[j]++;
				}
			}
			
			// 출력
			System.out.print("#"+testCase+" ");
			for (int i = 0; i < P; i++) {
				System.out.print(busStop[C[i]]);
				if (i != P-1) System.out.print(" ");
			}
            System.out.println();
			
		}
		
		sc.close();
	}
}