import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			
			// 규영이 카드 받기
			int[] kyu = new int[9];
			for (int i = 0; i < 9; i++) kyu[i] = sc.nextInt();
			
			// 인영이 카드 찾기
			int[] in = new int[9];
			int idx = 0;
			find: for (int i = 1; i <= 18; i++) {
				for (int j = 0; j < 9; j++) {
					if (i == kyu[j]) {
						continue find;
					}
				}
				in[idx] = i;
				idx++;
			}
			
			// 경우의 수 찾기
			visited = new boolean[9];
			order = new int[9];
			kyuWin = 0;
			kyuLose = 0;

			permu(kyu, in, 0);
			
			System.out.println("#"+testCase+" "+kyuWin+" "+kyuLose);
			
		}//testCase
		
		sc.close();
	}
	
	static boolean[] visited;
	static int[] order;
	static int kyuWin, kyuLose;
	static int kyuScore, inScore;
	
	public static void permu(int[] kyu, int[] in, int depth) {
		// 규영이랑 인영이 점수 계산해보기
		if (depth == 9) {
			
			kyuScore = 0;
			inScore = 0;
			
			for (int i = 0; i < 9; i++) {
				if (kyu[i] > order[i]) {
					kyuScore +=(kyu[i]+order[i]);
				} else if (kyu[i] < order[i]) {
					inScore +=(kyu[i]+order[i]);
				}
			}
			
			if (kyuScore > inScore) kyuWin++;
			else if (kyuScore < inScore) kyuLose++;

		}
		
		// 인영이 카드 내는 순서 만들기
		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				order[depth] = in[i];
				permu(kyu, in, depth+1);
				visited[i] = false;
			}
		}
		
	} //permu
}