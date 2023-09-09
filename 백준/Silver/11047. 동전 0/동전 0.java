import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] coin = new int[N];
		for (int i = 0; i < N; i++) coin[i] = sc.nextInt();
		
		int which = N-1;
		int money = 0;
		int coins = 0;
		while (money != K) {
			if (money + coin[which] <= K) {
				money +=coin[which];
				coins++;
			}
			else which--;
		}
		
		System.out.println(coins);
		
		sc.close();
	}
}