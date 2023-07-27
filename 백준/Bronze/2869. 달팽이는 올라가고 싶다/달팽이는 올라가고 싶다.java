import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		
		int one = A-B;
		int day = (int) Math.ceil(1 + (V-A) / (double) one);
		
		System.out.println(day);
		
		sc.close();
		
	}
}