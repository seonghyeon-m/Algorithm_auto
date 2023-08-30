import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// input 받기
		int N = sc.nextInt();
		String[][] parrots = new String[N][];
		String dump = sc.nextLine(); // 왜 이렇게 되지
		for (int i = 0; i < N; i++) {
			parrots[i] = sc.nextLine().split(" ");
		}
		int[] peek = new int[N];
		String[] sentence = sc.nextLine().split(" ");
		
		// 풀이
		Sol: for (String word : sentence) {
			for (int i = 0; i < N; i++) {
				if (peek[i] >= parrots[i].length) continue;
				if (parrots[i][peek[i]].equals(word)) {
					peek[i]++;
					continue Sol;
				}
				
				if (i == N-1) {
					break Sol;
				}
			}
			
		}
		
		int cnt = 0;
		int cnt2 = 0;
		for (int i = 0; i < N; i++) {
			if (peek[i] == parrots[i].length) {
				cnt++;
				cnt2 +=peek[i];
			}
		}
		if (cnt == N && cnt2 == sentence.length) System.out.println("Possible");
		else System.out.println("Impossible");
		
		sc.close();
	}
}