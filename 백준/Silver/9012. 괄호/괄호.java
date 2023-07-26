import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			String test = sc.next();
			String[] t = test.split("");
			
			int num = 0;
			
			AA: for (int j = 0; j < t.length; j++) {
				if (t[j].equals("(")) {
					num++;
				} else if (t[j].equals(")")) {
					num--;
					if (num < 0) {
						System.out.println("NO");
						break AA;
					}
				}
			}
			
			if (num == 0) {
				System.out.println("YES");
			} else if (num > 0) {
				System.out.println("NO");
			}
			
			
		}
        sc.close();
	}
}