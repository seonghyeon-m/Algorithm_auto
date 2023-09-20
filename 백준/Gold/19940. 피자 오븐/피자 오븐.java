import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();

		for (int testCase = 1; testCase <= T; testCase++) {
			
			int N = sc.nextInt();
			int make = 0;
			int[] push = new int[5];
			
			push[0] +=(N/60);
			make +=(push[0]*60);
			
			while (make != N) {
				
				if (N - make > 35) {
					push[0]++;
					make += 60;
				} else if (N - make > 5) {
					push[1]++;
					make += 10;
				} else if (make - N > 5) {
					push[2]++;
					make -= 10;
				} else if (N > make) {
					push[3]++;
					make++;
				} else if (make > N) {
					push[4]++;
					make--;
				}

			} // while
			
			for (int i = 0; i < 5; i++) {
				sb.append(push[i]);
				if (i == 4) sb.append("\n");
				else sb.append(" ");
			}
			
		} //testCase
		
		System.out.println(sb);

		sc.close();
	}
}