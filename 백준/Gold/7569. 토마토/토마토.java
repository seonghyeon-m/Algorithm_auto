import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*알고리즘 설명
 * 1. 그래프 탐색
 * 2. DFS 이용
 * 3. 인자로 탐색 시작한 정점 번호와 현재 DFS 탐색 중인 정점 번호 입력
 * 4. 연결된 노드 있으면 재귀식으로 호출, 탐색 시작점 기준 미방문 노드일 경우만 재귀호출
 * 5. 결과 출력
 * */

public class Main {

	
	public static void main(String[] args) throws IOException {
		//input, 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[][][] box = new int[N][M][H];
		int total = N*M*H;
		int now = 0;
		//위치 정보 (현재높이*(N*M) + 현재행*(M) + 현재 열)
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < M; k++) {
					box[j][k][i] = Integer.parseInt(st.nextToken());
					if(box[j][k][i] == -1) {//토마토 총 개수 구하기
						total--;
					}
					if(box[j][k][i] == 1) {
						stack.add(i*(N*M) + j*M + k);
						now++;
					}
				}
			}
		}
		//delta
		int[] dr = {-1, 1, 0, 0, 0, 0};
		int[] dc = {0, 0, -1, 1, 0, 0};
		int[] dh = {0, 0, 0, 0, -1, 1};
		int day = 0;
		Stack<Integer> temp = new Stack<>();
		while(now != total) {
			day++;
			while(!stack.isEmpty()) {
				int pos = stack.pop();
				int height = pos / (N*M);
				pos -= (N*M)*height;
				int row = pos / M;
				int col = pos % M;
				
				for(int d = 0; d < 6; d++) {
					int nr = row + dr[d];
					int nc = col + dc[d];
					int nh = height + dh[d];
					if(nr >= 0 && nr < N && nc >= 0 && nc < M && nh >= 0 && nh < H && box[nr][nc][nh] == 0) {
						box[nr][nc][nh] = 1;
						now++;
						temp.add(nh*(N*M) + nr*M + nc);
					}
				}
			}	
			if(temp.isEmpty()) {
				break;
			}
				
			while(!temp.isEmpty()) {
				stack.add(temp.pop());
			}
		}
		
		if(now != total) {
			System.out.println(-1);
		} else {
			System.out.println(day);
		}
	}

}
