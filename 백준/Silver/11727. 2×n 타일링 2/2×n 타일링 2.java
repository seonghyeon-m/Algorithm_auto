import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		int N = sc.nextInt();
		System.out.println(way(N));
		
		sc.close();
	}
	
	static int[] save = new int[1001];
	
	public static int way(int N) {
		if (N == 1) return 1;
		else if (N == 2) return 3;
		else {
			if (save[N] != 0) return save[N];
			else {
				save[N] = (way(N-1) + 2*way(N-2))%10007;
				return save[N];
			}
		}
	}
}