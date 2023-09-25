import java.util.Scanner;

public class Main {
	
	static int[][] knapsack;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 물품의 수
		int K = sc.nextInt(); // 가방이 버틸 수 있는 무게
		
		int[] W = new int[N]; // 각 물건의 무게
		int[] V = new int[N]; // 각 물건의 가치
		for (int i = 0; i < N; i++) {
			W[i] = sc.nextInt();
			V[i] = sc.nextInt();
		}
		
		// 행: 가방이 버틸 수 있는 무게
		// 열: 물품 종류
		knapsack = new int[K+1][N];

		// 맨 왼쪽 줄 채우기
		for (int i = 0; i < K+1; i++) {
			if (i < W[0]) knapsack[i][0] = 0;
			else knapsack[i][0] = V[0];
		}
		
		// 나머지 채우기
		for (int j = 1; j < N; j++) {
			for (int i = 0; i < K+1; i++) {
				// 일단 그 줄 가방만 있다고 생각하고 넣기
				if (i >= W[j]) {
					knapsack[i][j] = V[j];
				}
				// 옆줄 가방도 넣어도 되는 경우
				if (knapsack[i][j-1] > knapsack[i][j]) {
					knapsack[i][j] = knapsack[i][j-1];
				}
				// 내가방 빼고 넣는 경우
				if (i-W[j] >= 0 && knapsack[i-W[j]][j-1] + V[j] > knapsack[i][j]) {
					knapsack[i][j] = knapsack[i-W[j]][j-1] + V[j];
				}
			}
		}
		
		System.out.println(knapsack[K][N-1]);
		
		sc.close();
	}
}