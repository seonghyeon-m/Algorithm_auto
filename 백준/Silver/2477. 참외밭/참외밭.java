import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		
		int[] dir = new int[12];
		int[] len = new int[12];
		
		for (int i = 0; i < 6; i++) {
			dir[i] = sc.nextInt();
			dir[i+6] = dir[i];
			len[i] = sc.nextInt();
			len[i+6] = len[i];
		}
		
		int j = 0;
		while (dir[j] != dir[j+2] || dir[j+1] != dir[j+3]) {
			j++;
		}
		
		int[] cal = {j-2, j-1, j+1, j+2};
		for (int l = 0; l < cal.length; l++) {
			if (cal[l] >= 6) {
				cal[l] -=6;
			} else if (cal[l] < 0) {
				cal[l] +=6;
			}
		}
		
		int area = (len[cal[0]]*len[cal[1]]) - (len[cal[2]]*len[cal[3]]);
		System.out.println(K*area);
		
		sc.close();
	}
}