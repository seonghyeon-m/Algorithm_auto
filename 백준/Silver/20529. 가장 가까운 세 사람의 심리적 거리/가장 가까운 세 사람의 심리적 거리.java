import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static String[] mbti;
	public static boolean[] visited;
	public static int min = 0;
	public static String[] sel = new String[3];
	public static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			mbti = new String[N];
			for(int i = 0; i < N; i++) {
				mbti[i] = st.nextToken();
			}
			
			visited = new boolean[N];
			min = Integer.MAX_VALUE;
			if(N >= 33) {
				min = 0;
			} else {
				comb(0, 0);
			}
			System.out.println(min);
		}
	}
	
	public static void comb(int idx, int sidx) {
		if(sidx == 3) {
			int temp = 0;
			for(int i = 0; i < 4; i++) {
				if(sel[0].charAt(i)  != sel[1].charAt(i)) {
					temp++;
				}
				if(sel[1].charAt(i)  != sel[2].charAt(i)) {
					temp++;
				}
				if(sel[0].charAt(i)  != sel[2].charAt(i)) {
					temp++;
				}
			}
			if(min > temp) {
				min = temp;
			}
			return;
		}
		
		for(int i = idx; i < N-2+sidx; i++) {
			sel[sidx] = mbti[i];
			comb(i+1, sidx+1);
		}
	}
}
