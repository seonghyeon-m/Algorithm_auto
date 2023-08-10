import java.util.Scanner;

public class Main {
	
	static int N, M;
	static String path;
	static int ans;
	static int[] scores = new int[6];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// input 받기
		N = sc.nextInt(); // 며칠동안
		M = sc.nextInt(); // 최소 기여도
		
		for (int i = 0; i < 6; i++) {
			scores[i] = sc.nextInt();
		}
		
		ans = 0;
		Spy(""); // 재귀

		System.out.println(ans);
		sc.close();
	}

	public static void Spy(String path) {

		// 만든 경우의 수에 대해 점수 계산
		if (path.length() == N) {
			int score = 0;
			score += scores[path.charAt(0) - '0'];
			for (int i = 1; i < path.length(); i++) {
				int yesterday = (path.charAt(i-1) - '0')%3;
				if ((path.charAt(i) - '0')%3 == yesterday) {
					score += scores[(path.charAt(i) - '0')] / 2;
				} else {
					score += scores[path.charAt(i) - '0'];
				}
			}
			
			if (score >= M) {
				ans++;
			}
			
			return;
			
		}
		
		// 가능한 경우의 수 모두 생성
		for (int today = 0; today < 6; today++) {
			Spy(path + today);
		}
		
	}
}