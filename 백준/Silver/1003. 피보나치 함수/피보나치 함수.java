import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			
			int N = sc.nextInt(); // 0~40 자연수
			System.out.println(fib0(N)+" "+fib1(N));
			
		} //testCase
		
		sc.close();
	}
	
	static int[][] save = new int[41][2];
	
	public static int fib0(int N) {
		if (N == 0) return 1;
		else if (N == 1) return 0;
		else {
			if (save[N][0] == 0) {
				save[N][0] = fib0(N-1) + fib0(N-2);
				return save[N][0];
			} else {
				return save[N][0];
			}
		}
	} //fib0
	
	public static int fib1(int N) {
		if (N == 0) return 0;
		else if (N == 1) return 1;
		else {
			if (save[N][1] == 0) {
				save[N][1] = fib1(N-1) + fib1(N-2);
				return save[N][1];
			} else {
				return save[N][1];
			}
		}
	} //fib1
}