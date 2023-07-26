import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] card = new int[N];
		
		for (int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
		}
		
		Arrays.sort(card); //오름차순 정리
		
		int p1 = N-1; //가장 큰 수
		int p2 = N-2; //중간 큰 수
		int p3 = N-3; //가장 작은 수
		int max = 0;
		
		
		
		AA: while (true) {
			
			if (card[p1]+card[p2]+card[p3] > max && card[p1]+card[p2]+card[p3] <= M) {
				max = card[p1]+card[p2]+card[p3];
			}
			
			if (max == M) {
				break AA;
			}
			
			//pointer 위치 바꿔주기
			if (p1 == 2) {
				break AA;
			}
			
			if (p3 == 0) {
				if (p2 == 1) {
					p1 -=1;
					p2 = p1-1;
					p3 = p2-1;
				} else {
					p2 -=1;
					p3 = p2-1;
				}
			} else {
				p3 -=1;
			}
			
		}
		
		System.out.println(max);
		
        sc.close();
	}
}