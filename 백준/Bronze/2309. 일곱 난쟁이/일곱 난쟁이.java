import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] h = new int[9];
		
		int total = 0;
		for (int i = 0; i < 9; i++) {
			h[i] = sc.nextInt();
			total +=h[i];
		}
		
		Arrays.sort(h);
		
		int p1 = 0;
		int p2 = 1;
		
		AA: while (true) {
			if (total - h[p1] -h[p2] == 100) {
				break AA;
			} else {
				if (p1 == 7 && p2 == 8) {
					break AA;
				} else if (p2 == 8) {
					p1 +=1;
					p2 = p1+1;
				} else {
					p2++;
				}
			}
			
		}
		
		for (int i = 0; i < 9; i++) {
			if (i != p1 && i != p2) {
				System.out.println(h[i]);
			}
		}
		
		sc.close();
	}
}