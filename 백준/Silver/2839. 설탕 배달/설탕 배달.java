import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int b3 = 0;
		
		while (N % 5 != 0 && N > 0) {
			N -=3;
			b3 +=1;
		}
		
		if (N < 0) {
			System.out.println("-1");
		} else {
			System.out.println(b3+(N/5));
		}
		
        sc.close();
	}
}