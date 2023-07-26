import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		AA: while (true) {
			int[] tri = new int[3];
			
			for (int i = 0; i < 3; i++) {
				tri[i] = sc.nextInt();
			}
			
			if (tri[0] == 0 && tri[1] == 0 && tri[2] == 0) {
				break AA;
			}
			
			int max = 0;
			int maxidx = 0;
			
			for (int i = 0; i < 3; i++) {
				if (tri[i] >= max) {
					maxidx = i;
					max = tri[i];
				}
			}
			
			int a;
			int b;
			
			if (maxidx == 0) {
				a = 1;
				b = 2;
			} else if (maxidx == 1) {
				a = 0;
				b = 2;
			} else {
				a = 0;
				b = 1;
			}
			
			if (max*max == tri[a]*tri[a] + tri[b]*tri[b]) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}

        sc.close();
	}
}