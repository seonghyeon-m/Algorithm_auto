import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] data = new int[N][4];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int endDay = i + T - 1;
			data[i][0] = T;
			data[i][1] = P;
			data[i][2] = endDay;
		}
		
		
		int[] dP = new int[N];//dP[i]는 i일까지 벌 수 있는 최대 금액(0부터 시작)
		//index는 0부터
		for(int i = 0; i < N; i++) {//dP
			if(i != 0) dP[i] = dP[i-1];//default는 어제까지의 최대값
			for(int j = 0; j < N; j++) {//시작일
				int temp = 0;
				if(j == 0) {//0일에 시작
					if(data[j][2] == i) {//종료일이 i일
						dP[i] = Math.max(dP[i], data[j][1]);//기존값 하고만 비교
					}
				} else {
					if(data[j][2] == i) {
						int moneytemp = dP[j-1] + data[j][1]; //j-1일까지 벌 수 있는 금액 + 
						dP[i] = Math.max(dP[i], moneytemp);
					}
				}
			}
		}
		
		System.out.println(dP[N-1]);
	}
}
