import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int[] sel;
	public static int N, M;
	public static StringBuilder str = new StringBuilder();
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//input
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sel = new int[M];
		comb(0,0);
		bw.write(str.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void comb(int idx, int visited) {
		if(idx == M) {
			for(int i: sel) {
				str.append(i + " ");
			}
			str.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if((visited & (1<<i)) == 0) {
				sel[idx] = i;
				comb(idx+1, visited | (1<<i));
			}
		}
	}
	
}
