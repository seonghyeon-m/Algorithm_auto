import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] tree = new int[N];
		int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			
			if(max < tree[i]) {
				max = tree[i];
			}
		}
		
		//이진탐색
		int answer = 0;
		int start = 0;
		int end = max;
		int cut = (start+end)/2;
		while(start <= end) {
			long cut_res = 0;
			for(int i = 0; i < N; i++) {
				if(tree[i] > cut) {
					cut_res += (tree[i]-cut);
				}
			}
			
			if(cut_res >= M) {
				start = cut+1;
				answer = Math.max(cut, answer);
			} else {
				end = cut-1;
			}
			
			cut = (start+end)/2;
		}
		System.out.println(answer);
		br.close();

	}
	
}
