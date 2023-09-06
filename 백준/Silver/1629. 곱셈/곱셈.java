import java.util.Scanner;

public class Main {
	
	static long A, B, C;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		A = sc.nextLong();
		B = sc.nextLong();
		C = sc.nextLong();
		
		A %=C;
		
		System.out.println(cal(A, B, C));
		
		sc.close();
	}
	
	public static long cal(long A, long B, long C) {
		if (C == 1) return 0;
		
		if (B == 0) return 1;
		if (B == 1) return A % C;
		
		long save = cal(A, B/2, C) % C;
		if (B % 2 == 0) return (save * save) % C;
		else return (((save * save)%C) * (A%C)) % C;

	}
	
}