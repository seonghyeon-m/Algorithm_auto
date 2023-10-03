import java.util.Scanner;

public class Main {
	
	static long[][] answers = new long[31][31];
	/*
	 * answers[i][j]
	 * i개의 완전한 알약, j개의 반쪽 알약이 남아있을 때 조합의 수
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 기본 정보 입력
		for (int j = 1; j <= 30; j++) {
			answers[0][j] = 1;
		}
		
		// 채워넣기
		for (int i = 1; i <= 30; i++) {
			for (int j = 0; j < 30; j++) {
				if (j == 0)
					answers[i][j] = answers[i-1][j+1];
				else
					answers[i][j] = answers[i][j-1] + answers[i-1][j+1];
			}
		}
		
		// 답 출력
		int N = sc.nextInt();
		while (N != 0) {
			
			System.out.println(answers[N][0]);
			
			// 다음 숫자 받기
			N = sc.nextInt();
		}
		
		sc.close();
	}
}