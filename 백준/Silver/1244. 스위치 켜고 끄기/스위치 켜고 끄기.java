import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] swc = new int[N];
		for (int i = 0; i < N; i++) {
			swc[i] = sc.nextInt();
		}
		int student = sc.nextInt();
		
		for (int i = 0; i < student; i++) {
			int gender = sc.nextInt();
			int point = sc.nextInt();
			
			II: if (gender == 1) {
				// 남자
				int p = point-1;
				while (p < N) {
					switch(swc[p]) {
						case 0:
							swc[p] = 1;
							break;
						case 1:
							swc[p] = 0;
							break;
					}
					p +=point;
				}
			} else if (gender == 2) {
				// 여자
				
				int p = point-1;
				int q = 1;
				
				switch(swc[p]) {
					case 0:
						swc[p] = 1;
						break;
					case 1:
						swc[p] = 0;
						break;
				}
				
				if (p-q<0 || p+q>=N) {
					break II;
				}
				
				WW: while (swc[p-q] == swc[p+q]) {
					switch(swc[p-q]) {
						case 0:
							swc[p-q] = 1;
							swc[p+q] = 1;
							break;
						case 1:
							swc[p-q] = 0;
							swc[p+q] = 0;
							break;
					}
					q++;
					if (p-q<0 || p+q>=N) {
						break WW;
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(swc[i]);
			if (i < N-1) {
				System.out.print(" ");
			}
			if ((i+1) % 20 == 0) {
				System.out.println();
			}
		}
		
		sc.close();
	}
}