import java.util.Scanner;

public class Solution {
	
	static int answer;
	static int[] ticket, plan;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			
			// 이용권 가격 (1일, 1달, 3달, 1년)
			ticket = new int[4];
			for (int i = 0; i < 4; i++)
				ticket[i] = sc.nextInt();
			
			// 12개월 이용 계획
			plan = new int[12];
			for (int i = 0; i < 12; i++)
				plan[i] = sc.nextInt();
			
			// 풀이			
			answer = ticket[3];
			swim(0,0);
			
			System.out.println("#"+testCase+" "+answer);
			
		} //testCase
		
		sc.close();
	}
	
	public static void swim(int month, int price) {
		// 일년을 다 채웠을 때 가격 갱신
		if (month >= 12) {
			if (answer > price) {
				answer = price;			
			}
			return;
		}
		
		// 현재까지의 최소값보다 비싸지면 다음 경우의 수 확인하러
		if (price > answer) {
			return;
		}
		
		// 계산
		if (plan[month] == 0) {
			swim(month+1, price);
		}
		
		// 1.
		swim(month+1, price+(plan[month] * ticket[0]));
		
		// 2.
		swim(month+1, price+ticket[1]);
		
		// 3.
		swim(month+3, price+ticket[2]);
		
	}
}