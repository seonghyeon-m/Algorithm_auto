import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int now = sc.nextInt();
		
		double[] prob = new double[4];
		for (int i = 0; i < prob.length; i++) {
			prob[i] = sc.nextDouble();
		}
		
		double[] ans = new double[2];
		if (now == 0) {
			ans[0] = 1;
			ans[1] = 0;
		} else {
			ans[0] = 0;
			ans[1] = 1;
		}
		
		int i = 0;
		while (i < N) {
			double a0 = ans[0];
			double a1 = ans[1];
			ans[0] = prob[0]*a0 + prob[2]*a1;
			ans[1] = prob[1]*a0 + prob[3]*a1;
			i++;
		}
		
		System.out.print((int)(ans[0]*1000)+" "+(int)(ans[1]*1000));
		
		sc.close();
	}
}