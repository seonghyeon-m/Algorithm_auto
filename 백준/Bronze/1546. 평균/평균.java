import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		float[] score = new float[N];
		
		for (int i = 0; i < N; i++) {
			score[i] = sc.nextFloat();
		}
		
		int idx = 0;
		float max = 0;
		
		for (int i = 0; i < N; i++) {
			if (score[i] >= score[idx]) {
				idx = i;
			}
		}

		max = score[idx];
		
		float sum = 0;
		for (int i = 0; i < N; i++) {
			score[i] = 100 * score[i] / max;
			sum += score[i];
		}
		
		System.out.println(sum/N);
		sc.close();
	}
}