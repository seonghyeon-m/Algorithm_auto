import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int pnum = sc.nextInt();
		while (pnum != 0) {
			if (pnum <10) {
				// 한자리
				System.out.println("yes");
			} else if (pnum >= 10 && pnum < 100) {
				// 두자리
				if (pnum%10 == pnum/10) {
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
			} else if (pnum >= 100 && pnum < 1000) {
				// 세자리
				if (pnum%10 == pnum/100) {
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
			} else if (pnum >= 1000 && pnum < 10000) {
				// 네자리
				if (pnum%10 == pnum/1000) {
					if ((pnum/10)%10 == (pnum/100)%10) {
						System.out.println("yes");
					} else {
						System.out.println("no");
					}
				} else {
					System.out.println("no");
				}
			} else if (pnum >= 10000 && pnum < 100000) {
				// 다섯자리
				if (pnum%10 == pnum/10000) {
					if ((pnum/10)%10 == (pnum/1000)%10) {
						System.out.println("yes");
					} else {
						System.out.println("no");
					}
				} else {
					System.out.println("no");
				}
			} else {
				System.out.println("no");
			}
			pnum = sc.nextInt();
		}
		
        sc.close();
	}
}