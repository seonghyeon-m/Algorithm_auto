import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int Nf = 1;
		int Kf = 1;
		int Kif = 1;
		
		for (int i = N; i > 0; i--) {
			Nf *=i;
		}
		
		for (int i = K; i > 0; i--) {
			Kf *=i;
		}
		
		for (int i = N-K; i > 0; i--) {
			Kif *=i;
		}
		
		System.out.println(Nf/(Kf*Kif));

        sc.close();
	}
}