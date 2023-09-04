import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] box = new int[N][M];
		int total = M*N; //tomato 총 개수
		int cnt = 0;//익은거 개수
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == -1) {//없는칸 total에서 제거
					total--;
				}
				
				if(box[i][j] == 1) {//있으면 count, visited변경, 큐에 추가
					cnt++;
					queue.add(i*M + j);
				}
			}
		}
		
		int day = 0;
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		Queue<Integer> temp = new LinkedList<>();
		while(cnt != total) {
			day++;
			//들어있던 것 모두 제거
			while(!queue.isEmpty()){
				int pos = queue.remove();
				int r = pos / M;
				int c = pos % M;
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(nr >= 0 && nr < N && nc >= 0 && nc < M && box[nr][nc] == 0) {
						box[nr][nc] = 1;
						temp.add(nr*M + nc);
						cnt++;
					}
				}
			}
			
			//temp가 비어있으면 더이상 불가능. break
			if(temp.isEmpty()) {
				break;
			}
			
			
			//temp에서 queue로 이전
			while(!temp.isEmpty()) {
				queue.add(temp.remove());
			}
		}
		
		if(cnt != total) day=-1;
		
		System.out.println(day);
		
		
		
	}//end of main method
}//end of class
