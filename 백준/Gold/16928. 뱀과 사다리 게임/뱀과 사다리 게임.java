import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		//input, 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int pos = 1;
		
		int[][] change = new int[N+M][2];
		for(int i = 0; i < (N+M); i++) {
			st = new StringTokenizer(br.readLine());
			change[i][0] = Integer.parseInt(st.nextToken());
			change[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//사다리, 뱀마다 분기
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> temp = new LinkedList<>();
		queue.add(1);
		int cnt = 0;
		outer : while(true) {
			cnt++;
			while(!queue.isEmpty()) {
				int data = queue.remove();
				int[] cango = new int[7]; //사다리, 뱀 없는 최대 칸 분석
				for(int i = 1; i <= 6; i++) {
					int newpos = data + i;
					if(newpos >= 100) {//종료
						break outer;
					} else {
						//뱀, 사다리 탐색, 다음칸 저장.
						for(int j = 0; j < (N+M); j++) {
							if(change[j][0] == newpos) {
								temp.add(change[j][1]);
								cango[i] = 1;//사다리 없이 갈 수 없다.
							}
						}
					}
				}
				
				//사다리 없이 도달 가능한 최대 칸
				for(int i = 6; i >= 1; i--) {
					if(cango[i] == 0) {
						temp.add(data + i);
						break;
					}
				}
			}
			
			//분기 완료
			while(!temp.isEmpty()) {
				queue.add(temp.remove());
			}
		}
		
		System.out.println(cnt);
		
		
	}//end of main method

}//end of class
