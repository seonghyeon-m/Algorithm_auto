import java.util.Scanner;

public class Main {
	static int[] price;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// input 받기
		int N = sc.nextInt();
		int[] dis = new int[N-1];
		for (int i = 0; i < dis.length; i++) {
			dis[i] = sc.nextInt();
		}
		price = new int[N];
		for (int i = 0; i < price.length; i++) {
			price[i] = sc.nextInt();
		}
		
		int point = N-2;
		int cheap = N-1;
		int charge = 0;
		while (cheap != 0) {
			cheap = findMinidx(point);
			for (int i = cheap; i <= point; i++) {
				charge +=price[cheap]*dis[i];
			}
			point = cheap-1;
		}
		
		System.out.println(charge);
		sc.close();
	}
	
	public static int findMinidx(int idx) {
		int min = 1000000000;
		int minidx = 0;
		for (int p = 0; p <= idx; p++) {
			if (price[p] < min) {
				min = price[p];
				minidx = p;
			}
		}
		return minidx;
	}
	
}