import java.util.Scanner;

public class Main {
	
	static int[] f = new int[31];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		f[2] = 3;
		f[4] = 11;
		
		int N = sc.nextInt();
		
		System.out.println(fill(N));
		
		sc.close();
	}
	
	public static int fill(int n) {
		if (f[n] != 0)
			return f[n];
		else if (n % 2 == 1 || n == 0) {
			return 0;
		} else {
			f[n] = 4*fill(n-2) - fill(n-4);
			return f[n];
		}
	}
}