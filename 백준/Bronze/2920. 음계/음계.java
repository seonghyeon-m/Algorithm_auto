import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] sound = new int[8];
		for (int i = 0; i < 8; i++) {
			sound[i] = sc.nextInt();
		}
		
		int n = 0;
		
		CHECK: if (sound[0] == 1) {
			// ascending 인지 확인
			for (int i = 0; i < 8; i++) {
				if (sound[i] == i+1) {
					n++;
				} else {
					System.out.println("mixed");
					break CHECK;
				}
				if (n == 7) {
					System.out.println("ascending");
				}
			}
		} else if (sound[0] == 8) {
			// descending 인지 확인
			for (int i = 0; i < 8; i++) {
				if (sound[i] == 8-i) {
					n++;
				} else {
					System.out.println("mixed");
					break CHECK;
				}
				if (n == 7) {
					System.out.println("descending");
				}
			}
		} else {
			System.out.println("mixed");
		}
		
        sc.close();
	}
}