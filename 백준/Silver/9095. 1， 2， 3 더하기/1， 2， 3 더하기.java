import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			
			int N = sc.nextInt();
			System.out.println(add(N));
			
		}
		
		sc.close();
	}
	
	static int[] save = new int[11];
	
	public static int add(int N) {
		if (N == 1) return 1;
		else if (N == 2) return 2;
		else if (N == 3) return 4;
		else {
			return add(N-1)+add(N-2)+add(N-3);
		}
	}
}