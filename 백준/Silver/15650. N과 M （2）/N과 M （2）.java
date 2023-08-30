import java.util.Scanner;

public class Main {
	static int[] numbers;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 1~N 숫자를 사용
		int M = sc.nextInt(); // 길이
		
		numbers = new int[M];
		visited = new boolean[N];
		
		combination(N, M, 0);
		System.out.println(sb);
		
		sc.close();
	}
	
	public static void combination(int N, int M, int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]);
				if (i != M-1) sb.append(" ");
			}
			sb.append('\n');
			
			return;
		} else {
			for (int i = 0; i < N; i++) {
				if (visited[i] == false) {
					if (depth == 0 || numbers[depth-1] < i+1) {
						visited[i] = true;
						numbers[depth] = i+1;
						combination(N, M, depth+1);
						visited[i] = false;
					}
				}
			}
			return;
		}
	}
}