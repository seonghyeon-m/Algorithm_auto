import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] input;
	public static int[][] result;
	public static int N;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N][N];
		result = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i = 0; i < N; i++) {
			dfs(i, i);
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static void dfs(int search, int now) {
		for(int i = 0; i < N; i++) {
			if(input[now][i] == 1 && result[search][i] == 0) {
				result[search][i] = 1;
				dfs(search, i);
			}
		}
	}
	
}
