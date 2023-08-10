import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void Cantor(int n) {
		if (n == 0) {
			sb.append("-");
		} else {
			Cantor(n-1);
			for (int i = 0; i < Math.pow(3, n-1); i++) {
				sb.append(" ");
			}
			Cantor(n-1);
		}
	}
	
	public static void main(String[] args) {
		/*
		 * 4779 칸토어 집합
		 */
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNextInt()) {
            int N = sc.nextInt();
			Cantor(N);
			String str = sb.toString();
//			System.out.println(sb);
			System.out.println(str);
			sb.setLength(0);
		}

//		sc.close();
	}
}