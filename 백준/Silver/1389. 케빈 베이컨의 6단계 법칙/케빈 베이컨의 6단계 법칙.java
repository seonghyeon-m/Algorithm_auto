import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] fr = new int[N+1][N+1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			fr[a][b] = 1;
			fr[b][a] = 1;
		}
		
		int min = Integer.MAX_VALUE;
		int minidx = -1;
		for(int i = 1; i <= N; i++) {
			int sum = 0;
			int cnt = 0;
			
			int[] visited = new int[N+1];
			visited[i] = 1;
			
			Queue<Integer> queue = new LinkedList<>();
			queue.add(i);
			Queue<Integer> temp = new LinkedList<>();
			while(true) {
				cnt++;
				//현재 노드에서 이어진 것 조사
				while(!queue.isEmpty()) {
					int data = queue.remove();
					for(int j = 1; j <= N; j++) {
						if(fr[data][j] == 1 && visited[j] == 0) {
							sum+=cnt;
							visited[j] = 1;
							temp.add(j);
						}
					}
				}
				
				if(temp.isEmpty()) break;
				
				//현재 노드 갱신
				while(!temp.isEmpty()) {
					queue.add(temp.remove());
				}
			}
			
			if(sum < min) {
				min = sum;
				minidx = i;
			}
		}
		
		System.out.println(minidx);
	}
}
